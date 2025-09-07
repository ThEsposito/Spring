package com.thesposito.imc_calculator.dto;

public record ImcResponse(
        double imc,
        String interpretacao,
        double pesoIdeal,
        double alturaCm) {
}