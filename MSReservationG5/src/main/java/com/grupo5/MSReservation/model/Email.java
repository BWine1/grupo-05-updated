package com.grupo5.MSReservation.model;

public class Email implements Notification {
    private String providerName;

    public Email(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public void sendMessage(String message) {
        // Simulação de envio de e-mail
        System.out.println("Email enviado via " + providerName + ": " + message);
    }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
} 