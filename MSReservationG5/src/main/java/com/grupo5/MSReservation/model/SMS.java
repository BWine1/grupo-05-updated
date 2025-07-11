package com.grupo5.MSReservation.model;

public class SMS implements Notification {
    private String operatorName;

    public SMS(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public void sendMessage(String message) {
        // Simulação de envio de SMS
        System.out.println("SMS enviado via " + operatorName + ": " + message);
    }

    public String getOperatorName() { return operatorName; }
    public void setOperatorName(String operatorName) { this.operatorName = operatorName; }
} 