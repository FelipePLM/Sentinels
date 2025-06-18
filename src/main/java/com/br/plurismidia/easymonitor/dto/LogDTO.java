package com.br.plurismidia.easymonitor.dto;

public record LogDTO(String error, String message, String operation) {
    @Override
    public String toString() {
        return "LogDTO{" + "error='" + error + ", message='" + message + ", operation='" + operation + '}';
    }
}

