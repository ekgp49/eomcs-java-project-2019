# eomcs-java-project-2019

[엄진영의 코딩스쿨]에서 강의하는 "자바 프로젝트 실습" 교육 과정의 소스를 보관하는 저장소이다.
자바 프로그래밍 기술을 단계별로 익힐 수 있도록 프로젝트를 버전으로 구분해 놓았다.
각 버전 별로 자바의 주요 기술을 어떻게 활용하는 지 그 방법을 배울 수 있다.
또한 버전을 따라 공부하다 보면 과거에서 최근까지 애플리케이션 아키텍처가
어떻게 변화해 왔는지 간접적으로 경험할 수 있다.
이는 오래전에 구축된 시스템에서 최근에 구축된 시스템까지 유지보수 해야하는 개발자에게
특히 도움이 될 것이다.


## 대상자

- 자바 기본 문법을 공부중인 분
- 서블릿/JSP를 학습하였거나 학습하려는 분
- C/C++, Python 등 다른 프로그래밍 언어를 알고 있는 데, 자바 프로그래밍을 빠르게 배우고 싶은 분
- 자바 기본 문법을 공부하였는데 어떻게 응용해야 할 지 모르겠는 분
- 다양한 오픈 소스를 자바 애플리케이션에 개발에 적용하는 방법을 배우고 싶은 분
- 스프링 프레임워크 기반 프로젝트에 참여중이거나 참여할 예정인 분
- 자바 웹 애플리케이션 프로젝트의 유지보수를 맡고 있거나 맡을 예정인 분


## 학습 목표

이 교육과정을 통해 다음을 배울 수 있다.  

- 자바 언어에서 제공하는 각종 문법의 목적을 이해하고 활용하는 방법
- 애플리케이션 개발에 디자인 패턴을 적용하는 방법
- 스프링 프레임워크, 마이바티스 등 오픈 소스 프레임워크를 프로젝트에 적용하는 방법
- 웹 애플리케이션의 아키텍처의 발전 과정을 이해

## 프로젝트 버전 및 학습 목표

### 개발 도구 준비하기

- OpenJDK 11 설치 및 환경 설정
- Eclipse 2018-09 설치 및 환경 설정
- Visual Studio Code 설치 및 환경 설정
- Scoop(Win)/Homebrew(macOS) 패키지 관리자 설치
- Gradle 빌드 도구 설치
- Git 형상관리 도구 설치
- MariaDB 데이터베이스 설치

### 강의 자료 가져오기

- github.com 사이트에 가입하기
- github.com 의 저장소를 로컬(개발 PC)로 복제하기

### 개인 저장소 만들기

- github.com 에 개인 저장소 만들기
- github.com 의 개인 저장소를 로컬로 복제하기

### 01 - 자바 애플리케이션 프로젝트 만들기

- `그레이들`을 이용하여 프로젝트 디렉토리를 구성할 수 있다.
- `그레이들`로 프로젝트를 빌드하고 실행할 수 있다.
- `아파치 메이븐` 프로젝트의 디렉토리 구조를 이해한다.

### 02 - `이클립스 IDE`로 프로젝트 다루기

- `그레이들`을 이용하여 `이클립스 IDE`용 프로젝트로 전환할 수 있다.
- `이클립스` 워크스페이스로 프로젝트를 가져올 수 있다.
- `이클립스`에서 빌드하고 실행할 수 있다.

### 03 - `GitHub.com`에 프로젝트 공유하기

- `.gitignore` 파일의 용도를 이해하고 작성할 수 있다.
- `github.com`의 저장소에 프로젝트를 공유할 수 있다.

### 04 - 리터럴과 콘솔 출력 다루기

- 다양한 유형의 값을 콘솔로 출력할 수 있다.

### 05 - 변수와 키보드 입력 다루기

-	키보드로 입력한 값을 읽을 수 있다.
- 값을 보관하기 위해 변수를 사용할 수 있다.

### 06 - 배열과 흐름 제어문 활용하기

- 배열을 활용하여 여러 개의 데이터를 저장할 수 있다.
- 조건문과 반복문을 활용하여 프로그램의 실행 흐름을 제어할 수 있다.

### 07 - 클래스로 데이터 타입 정의하기

- 클래스를 활용하여 여러 개의 데이터를 한 단위로 묶을 수 있다.
- 클래스와 인스턴스의 관계를 이해한다.
- 인스턴스와 레퍼런스의 관계를 이해한다.
- 레퍼런스 배열을 이해한다.

### 08 - 기본 문법의 활용

- 변수, 상수, 연산자, 조건문, 반복문, 블록, 배열 등의 문법을 활용할 수 있다.

### 09 - 메서드의 존재 이유

- 메서드를 활용하여 코드를 기능 단위로 분리할 수 있다.
- 리팩토링의 개념을 이해한다.
- 리팩토링 기법 중에서 '메서드 추출(Extract Method)'이라는 것을 수행할 수 있다.

### 10 - 클래스로 메서드를 분류하기

- 클래스를 이용하여 관련 메서드를 묶어 관리할 수 있다.
- 리팩토링 기법 중에서 '클래스 추출(Extract Class)'을 수행할 수 있다.

### 11 - 패키지로 클래스를 분류하기

- 패키지를 이용하여 역할에 따라 클래스를 분류할 수 있다.

### 12 - 클래스 필드와 클래스 메서드의 한계

- 클래스 필드와 클래스 메서드의 한계를 이해한다.

### 13 - 인스턴스 필드와 인스턴스 메서드가 필요한 이유

- 인스턴스 필드와 인스턴스 메서드를 사용할 수 있다.
- 스태틱 필드와 인스턴스 필드의 차이점과 용도를 설명할 수 있다.
- 스태틱 메서드와 인스턴스 메서드의 차이점과 용도를 설명할 수 있다.

### 14 - 생성자가 필요한 이유

- 생성자의 용도 이해한다.
- 생성자를 이용하여 인스턴스를 사용하기 전에 필요한 값들을 준비할 수 있다.

### 15 - 인스턴스 연산자와 메서드

- 메서드를 활용하여 인스턴스 값을 다루는 연산자를 정의할 수 있다.
- 캡슐화의 의미를 이해하고, 셋터/겟터를 만들 수 있다.

### 16 - UI 코드와 데이터 처리 코드를 분리하기

- 캡슐화 기법을 이용하여 데이터 처리 코드를 별개의 클래스로 분리할 수 있다.
- 배열 복제를 통해 배열의 크기를 늘릴 수 있다.
- 역할에 따라 클래스를 분리하는 방법과 이점을 이해한다.  

### 17 - 다형성과 형변환 응용

- 다형적 변수를 활용하여 다양한 타입의 데이터를 다룰 수 있다.
- 형변환을 이해하고 다룰 수 있다.

### 18 - 제네릭을 사용하는 방법과 이점

- 제네릭 문법을 이용하여 타입 정보를 파라미터로 주고 받을 수 있다.
- 제네릭 문법으로 특정 타입의 값만 다루도록 제한할 수 있다.

### 19 - CRUD 기능 완성

- 데이터를 등록/조회/수정/삭제하는 기능(CRUD)을 구현할 수 있다.

### 20 - 배열 대신 연결 리스트 자료구조 사용하기

- 연결 리스트(linked list) 자료구조를 구현할 수 있다.
- 연결 리스트의 구동 원리를 이해한다.
- 배열 방식과 연결 리스트의 장단점을 안다.
- 중첩 클래스의 활용할 수 있다.

### 21 - 스택 자료구조 구현과 활용

- 스택(stack) 자료구조를 구현할 수 있다.
- 스택의 구동 원리를 이해하고 활용할 수 있다.
- 인스턴스를 복제할 수 있다.

### 22 - 큐 자료구조 구현과 활용

- 큐(queue) 자료구조를 구현할 수 있다.
- 큐의 구동원리를 이해하고 활용할 수 있다.

### 23 - 인터페이스를 활용한 사용 규칙 정의

- 인터페이스의 용도와 이점을 이해한다.
- 객체 간의 사용 규칙을 정의할 때 인터페이스를 활용할 수 있다.

### 24 - `Iterator` 디자인 패턴의 활용

- `Iterator` 디자인 패턴의 용도를 이해하고 활용할 수 있다.
- 자료구조와 상관없이 일관된 방법으로 데이터를 조회할 수 있다.

### 25 - 자바 컬렉션 API 사용하기

- 자바에서 제공하는 자료구조 구현체를 활용할 수 있다.

### 26 - 커맨드 디자인 패턴을 적용하기

- `커맨드(command) 디자인 패턴`의 개념과 용도를 이해한다.
- `커맨드(command) 디자인 패턴`을 활용할 수 있다.

### 27 - 예외가 발생했을 때 시스템을 멈추지 않게 하는 방법

### 28 - 파일 입출력 API를 활용하기

### 29 - 바이너리 형식으로 입출력하는 방법

### 30 - 직렬화와 역직렬화를 이용하여 객체를 통째로 읽고 쓰기

### 31 - `Observer` 디자인 패턴을 적용하기

### 32 - 네트워크 API를 활용하여 애플리케이션 사이에 데이터 주고 받기

### 33 - 동일한 자원으로 더 많은 클라이언트의 요청을 처리하는 방법

### 34 - 여러 클라이언트의 요청을 동시에 처리하는 방법

### 35 - 스레드풀을 이용하여 스레드를 재사용하기

### 36 - 데이터 관리를 전문 프로그램인 DBMS에게 맡기기

### 37 - 애플리케이션 서버가 등장한 이유!

### 38 - 트랜잭션이 필요한 이유!

### 39 - 여러 스레드가 동시에 같은 커넥션을 사용했을 때 발생되는 문제와 해결책

### 40 - 스레드 로컬 변수를 활용하여 작업 간에 DB 커넥션 공유하기

### 41 - 커넥션 재사용을 위해 커넥션풀 적용하기

### 42 - SQL 삽입 공격과 자바 시큐어 코딩

### 43 - DB 프로그래밍 더 쉽고 간단히 하는 방법

### 44 - MyBatis의 다양한 기능 활용법

### 45 - DAO 구현체를 자동으로 만들기

### 46 - 객체 생성을 자동화하는 IoC 컨테이너 만들기

### 47 - IoC 컨테이너 개선 : 애노테이션을 이용한 객체 관리

### 48 - 인터페이스 대신 애노테이션으로 메서드 구분하기

### 49 - CRUD 메서드를 묶어 한 클래스로 분류하기

### 50 - Spring IoC 컨테이너 도입하기

### 51 - Spring IoC 컨테이너와 MyBatis 연동하기

### 52 - 애노테이션을 이용하여 트랜잭션 제어하기

### 53 - Log4j를 사용하여 애플리케이션 로그 처리하기

### 54 - Web 기술 도입하기
