package com.paypal.transaction_services.dto;

public class TransferRequest {

    private String senderName;

    private String receiverName;

    private Double amount;

    public TransferRequest(){

    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransferRequest(String senderName, String receiverName, Double amount) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.amount = amount;
    }
}
