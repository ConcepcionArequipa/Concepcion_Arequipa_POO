package com.example.saludo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Tiene que ir obligatoriamente para saber que desde aqui inicia
public class SaludoController {
    //Endpoint
    @GetMapping("/saludos") //La ruta para navegar  http://localhost:8080/saludos
    public String saludo() {
        String mensaje = "Saludo a todos";
        return mensaje;
    }

    //2 Endpoint
    @GetMapping("/adios") //Siempre va arriba de un metodo, solo se enfoca en un metodo
    public String adios() {
        String mensaje = "Lalalalala, Adioooossss";
        return mensaje;
    }

    //2 Endpoint
    @GetMapping("/informacion")
    public String informacion() {
        return """
        <html>
            <body style="font-family: Arial; padding: 20px;">
                <h2>Información personal</h2>
                <p>Mi nombre es Conce</p>
                <p>Mi apellido es Arequipa</p>
            </body>
        </html>
        """;
    }

    //2 Endpoint
    @GetMapping("/personal") //Siempre va arriba de un metodo, solo se enfoca en un metodo
    public void carrera() {

    }
}
