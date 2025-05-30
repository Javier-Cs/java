package com.prueba.ServicioDeUsuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicioDeUsuarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioDeUsuarioApplication.class, args);
    }

}
