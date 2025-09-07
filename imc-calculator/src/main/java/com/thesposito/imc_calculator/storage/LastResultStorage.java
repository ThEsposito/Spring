package com.thesposito.imc_calculator.storage;

import com.thesposito.imc_calculator.dto.ImcResponse;
import org.springframework.stereotype.Component;

// Indica
@Component
public class LastResultStorage {
    private ImcResponse lastResult;

    public void salvarResultado(ImcResponse response){
        this.lastResult = response;
    }

    public ImcResponse obterUltimoResultado(){
        return lastResult;
    }
}
