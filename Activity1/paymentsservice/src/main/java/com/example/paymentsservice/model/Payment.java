package com.example.paymentsservice.model;

public class Payment {

    private String mode;
    private Double total;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "mode='" + mode + '\'' +
                ", total=" + total +
                '}';
    }
}
