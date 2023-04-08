package ch03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpiryDateCalculatorTest {

    @DisplayName("납부일자_납부금액_전달받아서_만료일자반환")
    @Test
    void test(){
        // 10_000 당 한달 연장

        assertExpiryDate(new PayData.Builder()
                .setBillingDate(LocalDate.of(2019,3,1))
                .setPayAmount(10_000)
                .createPayData(), LocalDate.of(2019,4,1));

        // 다른 납부일자 case 추가
        assertExpiryDate(new PayData.Builder()
                .setBillingDate(LocalDate.of(2019,5,5))
                .setPayAmount(10_000)
                .createPayData(), LocalDate.of(2019,6,5));
    }

    @Test
    void 특이한_case(){
        // 31일 끝나는게 아니라 30이나 28로 달이 끝나는 경우
        assertExpiryDate(new PayData.Builder()
                .setBillingDate(LocalDate.of(2019,1,31))
                .setPayAmount(10_000)
                .createPayData(), LocalDate.of(2019,2,28));

        assertExpiryDate(new PayData.Builder()
                .setBillingDate(LocalDate.of(2019,5,31))
                .setPayAmount(10_000)
                .createPayData(), LocalDate.of(2019,6,30));

        assertExpiryDate(new PayData.Builder()
                .setBillingDate(LocalDate.of(2020,1,31))
                .setPayAmount(10_000)
                .createPayData(), LocalDate.of(2020,2,29));
    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate){
        ExpiryDateCalculator expiryDateCalculator = new ExpiryDateCalculator();
        LocalDate realExpiryDate = expiryDateCalculator.calculateExpiryDate(payData);
        assertEquals(realExpiryDate, expectedExpiryDate);
    }
}