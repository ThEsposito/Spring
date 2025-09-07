package com.thesposito.imc_calculator.dto;

public record ImcResponse(
        double imc,
        String interpretacaom,
        double pesoIdeal,
        double alturaCM) {
}