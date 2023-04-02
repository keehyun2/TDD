package ch03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpiryDateCalculatorTest {

    @Test
    void 납부일자_납부금액_전달받아서_만료일자반환(){
        // 10_000 당 한달 연장
        assertExpiryDate(LocalDate.of(2019,3,1), 10_000, LocalDate.of(2019,4,1));

        // 다른 납부일자 case 추가
        assertExpiryDate(LocalDate.of(2019,5,5), 10_000, LocalDate.of(2019,6,5));
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate){
        ExpiryDateCalculator expiryDateCalculator = new ExpiryDateCalculator();
        LocalDate realExpiryDate = expiryDateCalculator.calculateExpiryDate(billingDate, payAmount);
        assertEquals(realExpiryDate, expectedExpiryDate);
    }
}