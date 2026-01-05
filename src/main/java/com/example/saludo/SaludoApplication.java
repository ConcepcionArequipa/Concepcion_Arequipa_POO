package com.example.saludo; //Dominio

import org.springframework.boot.SpringApplication; // .com .org
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaludoApplication {

    //Solo se llama a la aplicacion a usar
    public static void main(String[] args) {
        SpringApplication.run(SaludoApplication.class, args); //No cambia

    }

}
