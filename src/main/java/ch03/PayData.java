package ch03;

import java.time.LocalDate;

public class PayData {
    private LocalDate billingDate;
    private LocalDate firstBillingDate;
    private int payAmount;

    public PayData(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public static class Builder {
        private LocalDate firstBillingDate;
        private LocalDate billingDate;
        private int payAmount;

        public Builder setFirstBillingDate(LocalDate firstBillingDate) {
            this.firstBillingDate = firstBillingDate;
            return this;
        }

        public Builder setBillingDate(LocalDate billingDate) {
            this.billingDate = billingDate;
            return this;
        }

        public Builder setPayAmount(int payAmount) {
            this.payAmount = payAmount;
            return this;
        }

        public PayData createPayData() {
            return new PayData(firstBillingDate, billingDate, payAmount);
        }
    }

}
