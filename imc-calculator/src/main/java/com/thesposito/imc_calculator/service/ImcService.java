package com.thesposito.imc_calculator.service;

import com.thesposito.imc_calculator.dto.ImcRequest;
import com.thesposito.imc_calculator.dto.ImcResponse;
import com.thesposito.imc_calculator.storage.LastResultStorage;
import com.thesposito.imc_calculator.util.ImcCalculator;

public class ImcService {
    private final LastResultStorage lastResultStorage;

    public ImcService(LastResultStorage lastResultStorage) {
        this.lastResultStorage = lastResultStorage;
    }

    public ImcResponse calcularImc(ImcRequest request) {
        double alturaCm = ImcCalculator.calcularAlturaCm(request.altura());
        double imc = ImcCalculator.calcularImc(request.altura(), request.pesoKg());
        String interpretacao = ImcCalculator.interpretarImc(imc);
        double pesoIdeal = ImcCalculator.calcularPesoIdeal(alturaCm, request.pesoKg());
        ImcResponse response = new ImcResponse(imc, interpretacao, pesoIdeal, alturaCm);
        lastResultStorage.salvarResultado(response);
        return response;
    }
}
