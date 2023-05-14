
## Example - 자동이체등록 (AutoDebitRegister)
AutoDebitRegister(자동이체등록기) 에 대한 테스트 클래스 예시다. 

### 상황 
1. CardNumberValidator 에 의존하고 이것이 외부 API 호출한다  
2. AutoDebitInfoRepository 에 의존하고, 이것이 DBMS 를 사용한다

### 대역
CardNumberValidator 대역으로 StubCardNumberValidator 생성하였고, AutoDebitInfoRepository 대역 MemoryAutoDebitInfoRepository 생성하였다. 

## 대역의 종류
1. 스텁(stub) - 구현을 단순화한 것으로 대체
2. 가짜(fake) - 제품에는 적합하지 않지만 실제 동작하는 구현을 제공
3. 스파이(spy) - 호출된 내역을 기록
4. 모의(mock) - 기대한대로 상호작용하는지 행위를 검증

## Example - 회원가입 (UserRegister)

### 상황
1. WeakPasswordChecker 의존하여, 암호강도가 약하면 exception 발생
2. UserRepository 에 의존하여, DBMS 사용
3. EmailNotifier 에 의존하여, 이메일 기능 사용

### 대역
WeakPasswordChecker 대역으로 StubWeakPasswordChecker 생성하였고,
EmailNotifier 대역으로 SpyEmailNotifier 생성하였고,
UserRepository 대역 MemoryUserRepository 생성하였다.

## Example(개선) - stub, spy 를 Mockito 로 변경

UserRegisterMockTest

1. 대역클래스를 만들지 않아도 되는 장점이 있다.

## 모의 객체의 과사용

UserRegisterMockOvercaseTest

1. 모의객체의 기본기능은 메서드 호출 여부 검증이기 때문에 기타검증시 복잡도 배로 증가
2. dao 나 repository 는 메모리를 이용한 가짜구현(fake)이 더 유리하다. 

# 부록 c - Mockito

- 모의 객체 생성

```java
Mockito.mock(WeakPasswordChecker.class);
```
Mockito.mock() 메서드는 클래스, 인터페이스, 추상클래스등의 모의 객체 생성가능하다.

- 모의 객체에 스텁 설정

```java
WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);
```
BDDMockito.given().willReturn() 메서드는 호출된 함수에 대한 리턴값을 정의 할수있다.

- 호출 함수의 파라미터 체크(인자 매칭 처리)

```java
BDDMockito.given(genMock.generate(any())).willReturn("456");
```

- 행위검증
```java
BDDMockito.then(genMock).should(only()).generate(GameLevel.EASY);
```
1. 모의 객체의 특정 메서드가 불렷는지 확인
2. 호출 횟수도 체크 가능 

- 인자 캡쳐

호출 함수에 대한 파라미터 검증

