# 테스트코드의 구성 
상황(given), 실행(when), 결과확인(then)

# 상황의 예
파일 사용(new File), DBMS 사용, 숫자야구(BaseballGame.class)에서 정답, 테스트할 대상 외의 모든 것들

#상황에 따른 예외상황 줄이기
- 파일을 다룰때 상황별로 처리를 하는 함수를 생성하는 것을 추천함(givenDataFile(), givenNoFile())
- 디비 입력 테스트시에 transation rollback 기능을 사용하기.
- 테스트 함수를 만들때 외부 api 호출해야하면 대역(mock등)을 사용 - 외부 api 는 고려해야할 예외상황이 엄청 많음.




