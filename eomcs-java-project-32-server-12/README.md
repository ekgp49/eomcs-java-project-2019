# eomcs-java-project-4.1-server

네트워크 API를 활용하여 애플리케이션 사이에 데이터 주고 받기

- 데이터 관리를 별도의 프로그램으로 분리하기
- 네트워크 API 사용법
- 클라이언트/서버 애플리케이션 아키텍처의 이해
- `Stateful` 통신 방식의 특징과 장단점 이해하기
- 상속의 일반화(generalization) 기법과 추상 클래스 활용법
   
## 프로젝트 - 수업관리 시스템  

### 과제: 데이터 관리 기능을 별도의 프로그램으로 분리하여 서버로 만든다.

`App.java`에서 데이터 관리 기능을 별도의 프로젝트로 분리한다.

#### ver 4.1.0
서버 애플리케이션 프로그래밍을 위한 프로젝트 `eomcs-java-project`를 생성한다. 프로젝트를 만들고 초기화시키는 것은 **1.0 자바 애플리케이션 프로젝트 만들기**를 참조하라.

#### ver 4.1.1
간단한 통신을 수행할 서버 프로그램과 서버 프로그램을 테스트할 클라이언트 프로그램을 만든다.

- ServerApp.java
    - `ServerSocket`을 이용하여 클라이언트 연결 요청을 승인한다.
- ServerTest.java
    - 서버와의 연결을 테스트한다.

#### ver 4.1.2
클라이언트, 서버 사이에 간단한 인사말을 주고 받는다.

- ServerApp.java
    - `Socket`의 입출력 스트림을 통해 데이터를 읽고 쓴다.
- ServerTest.java
    - `Socket`의 출력 스트림으로 먼저 데이터를 보내고, 입력 스트림으로 들어 온 데이터를 출력한다.

#### ver 4.1.3
클라이언트/서버 사이에 클래스의 인스턴스를 주고 받는다.

- com.eomcs.domain 패키지 복사
    - `eomcs-java-project`의 도메인 클래스를 모두 복사해온다.
    - 테스트할 때 객체의 필드 값을 확인하기 쉽게 toString()을 오버라이딩한다.
- ServerApp.java
    - ObjectInputStream/ObjectOutputStream 을 사용하여 객체를 주고 받는다.
- ServerTest.java
    - `Socket`의 출력 스트림으로 먼저 데이터를 보내고, 입력 스트림으로 들어 온 데이터를 출력한다.

#### ver 4.1.4
클라이언트가 보낸 객체를 보내면 서버에서 받아 컬렉션에 저장하고, 클라이언트가 객체를 요청하면 서버에서 컬렉션에서 객체를 꺼내 보내주게 한다.

- ServerApp.java
    - 명령어에 따라 컬렉션에 객체를 저장하거나 꺼낸다.
- ServerTest.java
    - 명령어를 객체를 저장, 조회를 요청한다.

#### ver 4.1.5
Member 객체를 저장하고, 꺼내고, 변경하고, 삭제하는 기능을 구현한다.

- ServerApp.java
    - 명령어에 따라 저장, 조회, 변경, 삭제를 구분하여 Member 데이터를 관리한다.
- ServerTest.java
    - 서버의 Member 객체 관리 기능을 테스트한다.

#### ver 4.1.6
Lesson과 Board 객체를 저장하고, 꺼내고, 변경하고, 삭제하는 기능을 추가한다.

- ServerApp.java
    - 명령어에 따라 저장, 조회, 변경, 삭제를 구분하여 Lesson이나 Board 데이터를 관리한다.
- ServerTest.java
    - 서버의 Lesson, Board 객체 관리 기능을 테스트한다.

#### ver 4.1.7 - 클래스 문법을 사용하여 메서드와 필드 분류하기
Lesson, Member, Board 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다.

- LessonDao.java
    - `ServerApp`에서 `Lesson` 데이터 처리와 관련된 코드를 이 클래스로 옮긴다.
- MemberDao.java
    - `ServerApp`에서 `Member` 데이터 처리와 관련된 코드를 이 클래스로 옮긴다.
- BoardDao.java
    - `ServerApp`에서 `Board` 데이터 처리와 관련된 코드를 이 클래스로 옮긴다.
- ServerApp.java
    - LessonDao, MemberDao, BoardDao 클래스를 사용한다.
- ServerTest.java
    - 변경사항 없음

#### ver 4.1.8 - 패키지를 사용하여 클래스 분류하기
DAO 클래스를 별도의 패키지로 분류한다.

- com.eomcs.lms.dao 패키지
    - 이 패키지를 생성한 후 DAO 클래스를 이 패키지로 옮긴다.
- LessonDao.java
    - com.eomcs.lms.dao 패키지로 이동한다.
- MemberDao.java
    - com.eomcs.lms.dao 패키지로 이동한다.
- BoardDao.java
    - com.eomcs.lms.dao 패키지로 이동한다.
- ServerApp.java
    - LessonDao, MemberDao, BoardDao 클래스의 패키지 추가한다.
- ServerTest.java
    - 변경사항 없음

#### ver 4.1.9 - 스태틱 멤버를 인스턴스 멤버로 전환하기
같은 객체에 대해 여러 목록을 유지할 수 있도록 DAO의 스태틱 멤버를 인스턴스 멤버로 전환한다. 즉 게시판을 여러 개 만들 수 있도록 BoardDao의 필드와 멤버를 인스턴스로 전환한다.

- LessonDao.java
    - 스태틱 멤버를 인스턴스 멤버로 전환한다.
- MemberDao.java
    - 스태틱 멤버를 인스턴스 멤버로 전환한다.
- BoardDao.java
    - 스태틱 멤버를 인스턴스 멤버로 전환한다.        
- ServerApp.java
    - LessonDao, MemberDao, BoardDao 클래스의 인스턴스를 생성하여 메서드를 호출한다.
- ServerTest.java
    - 변경사항 없음

#### ver 4.1.10 - 데이터를 파일에 저장하고 로딩하기

DAO 객체를 생성할 때 파일에서 데이터를 로딩하고, 클라이언트와의 연결을 끊을 때 데이터를 파일에 저장한다.

- LessonDao.java
    - `eomcs-java-project`의 DataLoaderListner에서 `Lesson` 데이터를 로딩하고 저장하는 메서드를 가져와서 편집한다.
- MemberDao.java
    - `eomcs-java-project`의 DataLoaderListner에서 `Member` 데이터를 로딩하고 저장하는 메서드를 가져와서 편집한다.
- BoardDao.java
    - `eomcs-java-project`의 DataLoaderListner에서 `Board` 데이터를 로딩하고 저장하는 메서드를 가져와서 편집한다.
- ServerApp.java
    - 클라이언트가 연결을 끊을 때 DAO 객체의 saveData()를 호출하여 데이터를 저장한다.
    - 클라이언트 요청 처리 코드에 예외 처리를 적용한다.
- ServerTest.java
    - 데이터를 추가하고 조회한다. 
    - shutdown() 메서드를 추가한다.

#### ver 4.1.11 - 코드를 유지보수 하기 쉽게 리팩토링 하기 

- ServerApp.java
    - `main()`에 있는 코드를 메서드로 묶어 분류하기
    - 생성자에서 DAO 객체를 준비한다.
    - 요청 처리 코드는 `service()` 메서드로 묶는다.
    - DAO 데이터를 저장하는 코드는 `close()` 메서드로 묶는다.
- AbstractDao.java
    - `LessonDao`, `MemberDao`, `BoardDao` 클래스에 대해 일반화(generalization) 기법을 적용한다. 즉 세 클래스의 공통 분모를 추출하여 수퍼 클래스를 정의한다.
    - 이 클래스는 서브 클래스에게 공통 분모를 상속해주는 용도로 사용된다.
    - 따라서 직접 사용하지 못하게 추상클래스로 정의한다.
- LessonDao.java
    - `AbstractDao`를 상속 받는다.
    - 서버에서 상속 받은 메서드를 사용한다.
- MemberDao.java
    - `AbstractDao`를 상속 받는다.
    - 서버에서 상속 받은 메서드를 사용한다.
- BoardDao.java
    - `AbstractDao`를 상속 받는다.
    - 서버에서 상속 받은 메서드를 사용한다.


#### 실행 결과

먼저 `ServerApp`을 실행한다.
```
이전과 실행 결과는 같다.
```

`ServerTest`을 실행한다.
```
이전과 실행 결과는 같다.
```

## 실습 소스

- src/main/java/com/eomcs/lms/dao/AbstractDao.java 추가
- src/main/java/com/eomcs/lms/dao/LessonDao.java 변경
- src/main/java/com/eomcs/lms/dao/MemberDao.java 변경
- src/main/java/com/eomcs/lms/dao/BoardDao.java 변경
- src/main/java/com/eomcs/lms/ServerApp.java 변경