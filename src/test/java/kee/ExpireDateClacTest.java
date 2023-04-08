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
        LocalDate result = wrapCalc("2019-03-01", "2019-03-01",10_000);
        assertEquals(LocalDate.parse("2019-04-01"), result);

//        assertExpiryDate(new PayData.Builder()
//                .setBillingDate(LocalDate.of(2019,5,5))
//                .setPayAmount(10_000)
//                .createPayData(), LocalDate.of(2019,6,5));
    }

    private LocalDate wrapCalc(String firstDate, String billDate, int amount){
        ExpireDateCalc expireDateCalc = new ExpireDateCalc();
        return expireDateCalc.calc(LocalDate.parse(firstDate), LocalDate.parse(billDate), amount);
    }
}
