package com.thesposito.imc_calculator.controller;

import com.thesposito.imc_calculator.dto.ImcRequest;
import com.thesposito.imc_calculator.dto.ImcResponse;
import com.thesposito.imc_calculator.service.ImcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {
    private final ImcService imcService;

    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<ImcResponse> calcular(@RequestBody ImcRequest request){
        return ResponseEntity.ok(imcService.calcularImc(request));
    }

    @PostMapping("/ultimoResultado")
    public ResponseEntity<ImcResponse> obterUltimoResultado() {
        ImcResponse ultimoResultado = imcService.obterUltimoResultado();

        if(ultimoResultado == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ultimoResultado);
    }
}

/*
O @RequestMapping mapeia a url para as requisições que nossa API vai receber.
Por padrão no Spring, é ideal a gente retornar um ResponseEntity, recebendo como generic o
nosso objeto (dto) de resposta.
O @RequestBody indica que estamos passando um corpo de requisição como parâmetro.

O @PostMapping mapeia a url para o métdos HTTP POST.
O POST é parecido com o GET, no sentido em que, em ambos os casos, vamos enviar uma resposta.
No entanto, os parâmetros do GET são passados no cabeçalho da requisição HTTP (portanto,
podem ser vistos na URI). Já os parâmetros do POST são passados no corpo (escondendo eles
da URI).

O @Component é usada para marcar uma calsse java como um componente que vai ser gerenciado
pelo Spring (o que chamamos de Bean). Dessa forma, o spring vai gerenciar o ciclo de vida
de um objeto dessa classe e injetar as dependências.
*/