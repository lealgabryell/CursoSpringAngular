package com.calculos.calculos.service;

import com.calculos.calculos.entity.Entrada;
import com.calculos.calculos.entity.Resultado;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CalculosService {

    //Calcula a soma e a media de uma lista de numeros enviadas por parametro
    public Resultado calcular(@RequestBody Entrada entrada) {
        Resultado resultado = new Resultado();
        Integer soma = 0;
        Integer maior = entrada.getLista().get(0);
        Integer menor = entrada.getLista().get(0);

        //Itera a lista caso ela nao seja vazia
        if (entrada.getLista() != null) {
            for (int i = 0; i < entrada.getLista().size(); i++) {
                soma += entrada.getLista().get(i);
                if (entrada.getLista().get(i) > maior) {
                    maior = entrada.getLista().get(i);
                } else if (entrada.getLista().get(i) < menor) {
                    menor = entrada.getLista().get(i);
                }
            }
        } else {
            return null;
        }

        Double media = (double) (soma / entrada.getLista().size());

        resultado.setMedia(media);
        resultado.setSoma(soma);
        resultado.setTotal(entrada.getLista().size());
        resultado.setMenor(menor);
        resultado.setMaior(maior);

        return resultado;
    }

}
