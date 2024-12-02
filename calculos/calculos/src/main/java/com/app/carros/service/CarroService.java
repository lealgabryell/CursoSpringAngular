package com.app.carros.service;

import com.app.carros.entity.Carro;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CarroService {

    public String save(@RequestBody Carro carro) {
        //IMPLEMENTAR
        return "Carro salvo com sucesso!";
    }

    public Carro findById(int id) {
        if (id == 1) {
            Carro carro1 = new Carro("Uno", "Fiat", "Mile", 2009);
            return carro1;
        } else return null;
    }
}
