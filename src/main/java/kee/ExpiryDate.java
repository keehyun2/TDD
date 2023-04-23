package kee;

import java.time.LocalDate;

public class ExpiryDate {

    /**
     * 첫 납부일자, 납부일자, 납부금액을 받아서 만료일자를 계산하여 반환합니다.
     * 1. 1만원에 만료일자 1개월 연장
     * 2. 10만원을 납부하면 12개월 연장
     *  새로 규칙 추가
     *  1. 이전 만료일자 < 납부일자 경우 return 납부일자 + 연장 개월
     *  2. 이전 만료일자 > 납부일자 (만료일자가 남은 경우) 경우 return 이전만료일자 + 연장 개월
     * @param lastExpiryDAte 이전 만료일자
     * @param billDate 납부일자
     * @param amount 납부금액
     * @return 만료일자
     */
    public LocalDate calc(LocalDate lastExpiryDAte, LocalDate billDate, int amount){
        LocalDate base; // 기준일자
        if(lastExpiryDAte.isAfter(billDate)){ // 만료일자가 납부일자 뒤인 경우
            base = lastExpiryDAte;  // 기준일자를 지난 만료일자를 사용
        } else {
            base = billDate; // 기준일자를 납부일자를 사용
        }

        int extendedMonths;
        extendedMonths = amount / 10_000; // 만원당 1개월
        extendedMonths += (amount / 100_000) * 2; // 추가 개월 (납부금액 / 10만원) * 2
        return base.plusMonths(extendedMonths);
    }
}
