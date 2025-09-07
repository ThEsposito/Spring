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
        double
    }
}
