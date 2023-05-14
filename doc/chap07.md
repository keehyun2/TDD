
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

