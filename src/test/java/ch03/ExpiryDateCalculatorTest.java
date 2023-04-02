package ch03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpiryDateCalculatorTest {

    @Test
    void 납부일자_납부금액_전달받아서_만료일자반환(){
        // 10_000 당 한달 연장
        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(LocalDate.of(2019, 4, 1), expiryDate);

        // 다른 납부일자 case 추가
        LocalDate billingDate2 = LocalDate.of(2019, 5, 5);
        int payAmount2 = 10_000;

        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);

        assertEquals(LocalDate.of(2019, 6, 5), expiryDate2);

    }
}