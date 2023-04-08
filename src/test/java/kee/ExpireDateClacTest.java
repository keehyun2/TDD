package kee;

import ch03.PayData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExpireDateClacTest {
    
    @Test
    @DisplayName("만료일자 계산 테스트")
    void exTest(){
        // 20190301 에 만원 납입시 20190401 이 만료일자
        LocalDate case01 = wrapCalc("2019-03-01", "2019-03-01",10_000);
        assertEquals(LocalDate.parse("2019-04-01"), case01);

        // 2019,5,5 에 1만원 입금시 2019,6,5 가 만료일자
        LocalDate case02 = wrapCalc("2019-05-05", "2019-05-05",10_000);
        assertEquals(LocalDate.parse("2019-06-05"), case02);

        // 2019,5,5 에 10만원 입금시 2020,5,5 가 만료일자 (10만원 납입시 2개월 보너스)
        LocalDate case03 = wrapCalc("2019-05-05", "2019-05-05",100_000);
        assertEquals(LocalDate.parse("2020-05-05"), case03);
    }

    private LocalDate wrapCalc(String firstDate, String billDate, int amount){
        ExpireDateCalc expireDateCalc = new ExpireDateCalc();
        return expireDateCalc.calc(LocalDate.parse(firstDate), LocalDate.parse(billDate), amount);
    }
}
