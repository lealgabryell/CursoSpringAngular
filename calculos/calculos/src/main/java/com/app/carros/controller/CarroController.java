package com.app.carros.controller;

import com.app.carros.entity.Carro;
import com.app.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//Define EndPoint
@RequestMapping("/carro")
public class CarroController {

    //Define instancia do Service, que consome os dados
    //Annotation AutoWired evita que varias instancias sejam criadas
    @Autowired
    private CarroService carroService;


    //Esse tipo de retorno permite que alem da resposta desejaada, um status http
    // seja retornado junto
    @PostMapping("/save")
    //Annotation RequestBody indica que o parametro mencionado, sera buscado no corpo da requisicao
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try{

            String mensagem = this.carroService.save(carro);

            return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>("Deu algo errado", HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findById/{id}")
    //Annotation Pathvariable indica que o parametro mencionado, sera buscado no recurso da URI
    public ResponseEntity<Carro> findbyId(@PathVariable int id){
        try{

            Carro carro = this.carroService.findById(id);

            return new ResponseEntity<Carro>(carro, HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
