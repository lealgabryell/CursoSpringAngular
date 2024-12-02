package com.calculos.calculos.controller;

import com.calculos.calculos.entity.Entrada;
import com.calculos.calculos.entity.Resultado;
import com.calculos.calculos.service.CalculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@RestController
//Define Endpoint
@RequestMapping("/calculos")
public class CalculosController {

    //Essa annotation serve para evitar que mais memoria seja alocada, constroi apenas um objeto para a aplicacao inteira
    @Autowired
    private CalculosService calculosService;

    //Essa forma de retorno ajuda a aplicacao a ser Restful, retornando nao so o resultado esperado, mas a resposta HTTP.
    //Essa annotation faz com que a aplicacao direcione para esse metodo toda requisicao que entra no endpoint indicado.
    @GetMapping("/calcular")
    public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada) {
        try {

            Resultado resultado = this.calculosService.calcular(entrada);

            //Retorna o resultado e o status HTTP: 200
            return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);

        } catch (Exception e) {

            //HTTP status: 400
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}

