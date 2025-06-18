package com.br.plurismidia.easymonitor.dto;

public record EmailDTO(String recipient, String subject, String messageContent, String link, String operation) {
    @Override
    public String toString() {
        return "EmailDTO{" + "recipient='" + recipient + ", subject='" + subject + ", messageContent='" + messageContent + ", link='" + link + ", operation='" + operation + '}';
    }
}
