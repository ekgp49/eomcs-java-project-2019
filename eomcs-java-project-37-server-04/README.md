# eomcs-java-project-4.6-server

애플리케이션 서버가 등장한 이유!

- 애플리케이션 기능 변경 후 사용자 PC에 프로그램을 재설치 하지 않고 배포하는 방법
- 애플리케이션 서버 아키텍처를 이해하기

## 프로젝트 - 수업관리 시스템  

현재의 애플리케이션 구조는 기능을 추가할 때 마다 사용자 PC에 재설치해야 하는 문제가 있다. 이를 해결하기 위해 사용자 PC에서 프로그램을 실행하지 않고 서버에서 실행하게 한다. 사용자 PC는 단지 사용자가 입력한 값을 서버에 전달하고, 서버가 보내 준 실행 결과를 출력하는 일만 한다. 이런 애플리케이션 구조에서는 기능을 추가하거나 변경할 때 서버 쪽에서만 처리하면 되고, 서버에 적용하는 즉시 사용자 PC에서 바로 사용할 수 있다는 이점이 있다.

### ver 4.6.0 - 클라이언트 요청에 대해 응답하는 서버 프로그램으로 전환하라.

기존 프로젝트를 복사하여 `eomcs-java-project-server` 프로젝트를 생성한다.

#### 1단계) 클라이언트와 서버 사이의 통신 규칙을 정한다

요청과 응답은 `Stateful` 방식으로 처리한다. 클라이언트와 서버가 한 번 연결되면 클라이언트가 종료를 요청할 때까지 계속 연결된 상태를 유지한다.

규칙1) 단순한 명령어 전송과 실행 결과 수신
```
[클라이언트]                                        [서버]
서버에 연결 요청        -------------->           연결 승인
명령(CRLF)              -------------->           명령처리
화면 출력               <--------------           응답(CRLF)
화면 출력               <--------------           응답(CRLF)
명령어 실행 완료        <--------------           !end!(CRLF)
.
.
.
quit(CRLF)              -------------->           연결 끊기
```
규칙2) 사용자 입력을 포함하는 경우 
```
[클라이언트]                                        [서버]
서버에 연결 요청        -------------->           연결 승인
명령(CRLF)              -------------->           명령처리
화면 출력               <--------------           응답(CRLF)
사용자 입력 요구        <--------------           !{}!(CRLF)
입력값(CRLF)            -------------->           입력 값 처리
화면 출력               <--------------           응답(CRLF)
사용자 입력 요구        <--------------           !{}!(CRLF)
입력값(CRLF)            -------------->           입력 값 처리
명령어 실행 완료        <--------------           !end!(CRLF)
.
.
.
quit(CRLF)              -------------->           연결 끊기
```

#### 2단계) `규칙1`을 적용하여 수업 목록 출력을 처리하라.

- Command.java
    - 이제 명령어는 서버에서 처리하기 때문에 규칙을 변경해야 한다.
    - 명령어를 처리하려면 클라이언트의 데이터를 읽는 `입력 스트림`과 `출력 스트림` 있어야 한다. 
    - execute()의 파라미터로 입출력 스트림을 받는 파라미터를 추가한다.
- LessonListCommand.java
    - 사용자가 입력한 값을 키보드에서 읽는 것이 아니라 클라이언트가 보낸 값을 읽어 처리하도록 변경해야 하기 때문에 생성자에서 `키보드 입력 스트림`을 받는 파라미터를 제거한다.
    - `Command`의 변경된 규칙에 따라 구현을 변경한다.
    - **규칙1**에 맞춰 통신하도록 코드를 변경한다. 
- App.java
    - 생성자를 추가하여 서버 포트 번호를 받는다.
    - service() : 서버 소켓을 통하여 클라이언트와 연결한다.
    - 키보드에서 입력 받는 부분을 제거하고 클라이언트가 보낸 데이터를 입력 받도록 변경한다.
    - `LessonListCommand` 객체를 활성화하고 나머지 `Command`들은 주석으로 막아 비활성화한다.

##### 실행 결과

`eomcs-java-project-server` 프로젝트의 `App` 클래스를 실행한다.
```
DataLoaderListener.contextInitialized() 실행!
MariaDB에 연결했습니다.
서버 실행!
.
.
.
클라이언트와 연결됨.
클라이언트와 요청 처리 중...
클라이언트와 요청 처리 중...
클라이언트와 요청 처리 중...
클라이언트와 연결 종료!
```

`eomcs-java-project-client`프로젝트의 `ClientApp`을 실행한다.
```
명령> /lesson/list
  1, 자바 기초 프로그래밍    , 2019-01-02 ~ 2019-01-15,   80
  2, 자바 고급 프로그래밍    , 2019-01-14 ~ 2019-01-25,   80
  3, 자바 웹 프로그래밍     , 2019-01-21 ~ 2019-02-01,   80
  4, IoT 프로그래밍      , 2019-02-04 ~ 2019-03-04,   80
  5, C# 프로그래밍       , 2019-02-04 ~ 2019-02-15,   40
명령> /lesson/delete
실행할 수 없는 명령입니다.
명령> quit
```

#### 3단계) `규칙2`를 적용하여 수업 등록을 처리하라.

- LessonAddCommand.java
    - 사용자가 입력한 값을 키보드에서 읽는 것이 아니라 클라이언트가 보낸 값을 읽어 처리하도록 변경해야 하기 때문에 생성자에서 `키보드 입력 스트림`을 받는 파라미터를 제거한다.
    - `Command`의 변경된 규칙에 따라 구현을 변경한다.
    - **규칙2**에 맞춰 통신하도록 코드를 변경한다. 
- App.java
    - `LessonAddCommand` 객체를 활성화한다.

##### 실행 결과

`eomcs-java-project-server` 프로젝트의 `App` 클래스를 실행한다.

```
DataLoaderListener.contextInitialized() 실행!
MariaDB에 연결했습니다.
서버 실행!
.
.
.
클라이언트와 연결됨.
클라이언트와 요청 처리 중...
클라이언트와 요청 처리 중...
클라이언트와 요청 처리 중...
클라이언트와 요청 처리 중...
클라이언트와 연결 종료!
```

`eomcs-java-project-client`프로젝트의 `ClientApp`을 실행한다.

```
명령> /lesson/list
  1, 자바 기초 프로그래밍    , 2019-01-02 ~ 2019-01-15,   80
  2, 자바 고급 프로그래밍    , 2019-01-14 ~ 2019-01-25,   80
  3, 자바 웹 프로그래밍     , 2019-01-21 ~ 2019-02-01,   80
  4, IoT 프로그래밍      , 2019-02-04 ~ 2019-03-04,   80
  5, C# 프로그래밍       , 2019-02-04 ~ 2019-02-15,   40

명령> /lesson/add
수업명?
테스트
설명?
테스트 과정입니다
시작일?
2019-1-1
종료일?
2019-2-2
총수업시간?
40
일수업시간?
2
강사?
2
수업을 저장했습니다.

명령> /lesson/list
  1, 자바 기초 프로그래밍    , 2019-01-02 ~ 2019-01-15,   80
  2, 자바 고급 프로그래밍    , 2019-01-14 ~ 2019-01-25,   80
  3, 자바 웹 프로그래밍     , 2019-01-21 ~ 2019-02-01,   80
  4, IoT 프로그래밍      , 2019-02-04 ~ 2019-03-04,   80
  5, C# 프로그래밍       , 2019-02-04 ~ 2019-02-15,   40
  6, 테스트            , 2019-01-01 ~ 2019-02-02,   40

명령> quit
```

#### 4단계) `규칙2`를 적용하여 수업 상세조회/변경/삭제를 처리하라.

- LessonDetailCommand.java
    - 사용자가 입력한 값을 키보드에서 읽는 것이 아니라 클라이언트가 보낸 값을 읽어 처리하도록 변경해야 하기 때문에 생성자에서 `키보드 입력 스트림`을 받는 파라미터를 제거한다.
    - `Command`의 변경된 규칙에 따라 구현을 변경한다.
    - **규칙2**에 맞춰 통신하도록 코드를 변경한다. 
- LessonUpdateCommand.java
    - 사용자가 입력한 값을 키보드에서 읽는 것이 아니라 클라이언트가 보낸 값을 읽어 처리하도록 변경해야 하기 때문에 생성자에서 `키보드 입력 스트림`을 받는 파라미터를 제거한다.
    - `Command`의 변경된 규칙에 따라 구현을 변경한다.
    - **규칙2**에 맞춰 통신하도록 코드를 변경한다. 
- LessonDeleteCommand.java
    - 사용자가 입력한 값을 키보드에서 읽는 것이 아니라 클라이언트가 보낸 값을 읽어 처리하도록 변경해야 하기 때문에 생성자에서 `키보드 입력 스트림`을 받는 파라미터를 제거한다.
    - `Command`의 변경된 규칙에 따라 구현을 변경한다.
    - **규칙2**에 맞춰 통신하도록 코드를 변경한다.     
- App.java
    - `LessonDetailCommand` 객체를 활성화한다.
    - `LessonUpdateCommand` 객체를 활성화한다.
    - `LessonDeleteCommand` 객체를 활성화한다.

##### 실행 결과

이전 버전과 같다.

#### 5단계) 나머지 `Command`들도 수업 커맨드처럼 변경하라.

- XxxCommand.java 변경 
- App.java 변경

#### 6단계) 회원 검색 기능을 추가하라.

서버에서 애플리케이션을 실행하는 방식의 이점은 새 기능을 추가하더라도 사용자 PC에 클라이언트 프로그램을 재설치 할 필요가 없다는 것이다. 검색 기능을 추가한 후 이를 확인한다.

- MemberDao.java
    - 회원 검색 결과를 DB에서 가져오는 메서드 `search()`를 추가한다.
- MemberSearchCommand.java
    - 회원 검색 처리를 수행하는 클래스를 추가한다.

### ver 4.6.1 - `Stateful` 통신 방식을 `Stateless` 통신 방식으로 변경하라.

클라이언트가 서버에 한 번 연결되면 클라이언트가 연결을 끊을 때까지 서버와의 연결이 계속 유지된다. 클라이언트가 서버를 이용하지 않아도 계속 연결되어 있기 때문에 서버쪽 자원이 낭비되는 문제가 있다. 그래서 클라이언트가 서버에 작업을 요청할 때만 잠시 연결되고 작업 끝난 후에는 연결을 끊는 방식으로 전환한다.

- App.java
    - 클라이언트가 연결되면 요청한 작업을 처리한 후 즉시 연결을 끊는다.

##### 실행 결과

`eomcs-java-project-server` 프로젝트의 `App` 클래스를 실행한다.
```
DataLoaderListener.contextInitialized() 실행!
MariaDB에 연결했습니다.
서버 실행!
클라이언트와 연결됨.
클라이언트와 요청 처리 중...
클라이언트와 연결 종료!
클라이언트와 연결됨.
클라이언트와 요청 처리 중...
클라이언트와 연결 종료!
클라이언트와 연결됨.
클라이언트와 요청 처리 중...
클라이언트와 연결 종료
```

`eomcs-java-project-client`프로젝트의 `ClientApp`을 실행한다.
```
명령> /lesson/list
  1, 자바 기초 프로그래밍    , 2019-01-02 ~ 2019-01-15,   80
  2, 자바 고급 프로그래밍    , 2019-01-14 ~ 2019-01-25,   80
  3, 자바 웹 프로그래밍     , 2019-01-21 ~ 2019-02-01,   80
  4, IoT 프로그래밍      , 2019-02-04 ~ 2019-03-04,   80
  5, C# 프로그래밍       , 2019-02-04 ~ 2019-02-15,   40

명령> /board/add
내용?
test..ok
작성자?
1
수업?
1
게시글을 저장했습니다.

명령> /board/list
  1, 반갑습니다.              , 2018-11-14, 0, 3, 1
  2, 과제하셨나요?             , 2018-11-14, 0, 5, 1
  3, MT 가실 분 신청받아요.      , 2018-11-14, 0, 7, 1
  4, 오늘 수업 너무 좋아요.       , 2018-11-14, 0, 8, 1
  5, 개발 아르바이트 구합니다.      , 2018-11-14, 0, 4, 2
  6, 반가워요.               , 2018-11-14, 0, 9, 2
  7, 기말 고사 준비하실분?        , 2018-11-14, 0, 10, 2
  8, C#이 자바랑 많이 다른가요?    , 2018-11-14, 0, 7, 3
  9, 어제 강의 자료 보여주실분?     , 2018-11-14, 0, 9, 3
 10, test..ok            , 2018-11-15, 0, 1, 1
 11, 1                   , 2018-11-15, 0, 1, 1
 12, test..ok            , 2018-11-15, 0, 1, 1

명령> 

```

### ver 4.6.2 - 멀티 스레드 적용하라.

클라이언트의 요청이 들어 왔을 때 `main` 스레드에서 처리하지 않고 별도의 자식 스레드를 만들어 요청 처리 업무를 맡긴다. 이 방식은 동시에 여러 클라이언트 요청을 처리할 수 있다. 

- App.RequestHandler 중첩 클래스 정의
    - 클라이언트가 연결되면 요청한 작업을 처리한 후 즉시 연결을 끊는다.
- App.java
    - 클라이언트 연결이 들어오면 스레드를 만들어 RequestHandler에게 위임한다.
    - 명령 처리 객체 맵을 인스턴스 멤버로 옮긴다.

##### 실행 결과

`eomcs-java-project-server` 프로젝트의 `App` 클래스를 실행한다.
```
MariaDB에 연결했습니다.
서버 실행!
클라이언트와 연결되었음.
스레드 생성됨!
스레드 실행...
클라이언트와 연결 종료!
스레드 종료!
클라이언트와 연결되었음.
스레드 생성됨!
스레드 실행...
클라이언트와 연결 종료!
스레드 종료!
```

`eomcs-java-project-client`프로젝트의 `ClientApp`을 실행한다.
```
명령> /lesson/list
  1, 자바 기초 프로그래밍    , 2019-01-02 ~ 2019-01-15,   80
  2, 자바 고급 프로그래밍    , 2019-01-14 ~ 2019-01-25,   80
  3, 자바 웹 프로그래밍     , 2019-01-21 ~ 2019-02-01,   80
  4, IoT 프로그래밍      , 2019-02-04 ~ 2019-03-04,   80
  5, C# 프로그래밍       , 2019-02-04 ~ 2019-02-15,   40

명령> /board/list
  1, 반갑습니다.              , 2018-11-14, 0, 3, 1
  2, 과제하셨나요?             , 2018-11-14, 0, 5, 1
  3, MT 가실 분 신청받아요.      , 2018-11-14, 0, 7, 1
  4, 오늘 수업 너무 좋아요.       , 2018-11-14, 0, 8, 1
  5, 개발 아르바이트 구합니다.      , 2018-11-14, 0, 4, 2
  6, 반가워요.               , 2018-11-14, 0, 9, 2
  7, 기말 고사 준비하실분?        , 2018-11-14, 0, 10, 2
  8, C#이 자바랑 많이 다른가요?    , 2018-11-14, 0, 7, 3
  9, 어제 강의 자료 보여주실분?     , 2018-11-14, 0, 9, 3
 10, test..ok            , 2018-11-15, 0, 1, 1
 11, 1                   , 2018-11-15, 0, 1, 1
 12, test..ok            , 2018-11-15, 0, 1, 1

명령> 

```

### ver 4.6.3 - 스레드풀을 적용하라.

클라이언트의 요청이 들어올 때마다 서버는 스레드를 생성하고, 사용 후 버린다. 요청 때마다 매번 스레드를 생성하는 시간이 소요되고, 사용 후 버려지는 탓에 일정시간 동안 메모리를 차지하는 문제가 발생한다. 이를 해결하기 위해 한 번 생성한 스레드를 재사용하는 기법이 등장하게 되었다. 즉 `스레드풀`이라는 것을 통해 스레드를 관리하면 이러한 문제를 줄일 수 있다. 

- App.java
    - 자바에서 제공하는 스레드풀을 이용하여 스레드를 관리한다.

##### 실행 결과

실행 결과는 이전과 같다.

### 과제: 스레드풀을 적용하라.

## 실습 소스

- src/main/java/com/eomcs/lms/App.java 변경
