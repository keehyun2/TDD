package ch03;

import java.time.LocalDate;

public class PayData {
    private LocalDate billingDate;
    private int payAmount;

    public PayData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public static class Builder {

        private LocalDate billingDate;
        private int payAmount;

        public Builder setBillingDate(LocalDate billingDate) {
            this.billingDate = billingDate;
            return this;
        }

        public Builder setPayAmount(int payAmount) {
            this.payAmount = payAmount;
            return this;
        }

        public PayData createPayData() {
            return new PayData(billingDate, payAmount);
        }
    }

}
