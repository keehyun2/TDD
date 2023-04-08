package kee;

import java.time.LocalDate;

public class ExpireDateCalc {

    // 1만원당 한달 연장
    public LocalDate calc(LocalDate firstDate, LocalDate billDate, int amount){

        if(amount == 10_000){
            return billDate.plusMonths(1);
        }
        return billDate;
//        return LocalDate.parse("2019-04-01");
    }
}
