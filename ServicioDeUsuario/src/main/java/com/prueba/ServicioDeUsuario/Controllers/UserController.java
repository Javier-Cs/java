package com.prueba.ServicioDeUsuario.Controllers;

import com.prueba.ServicioDeUsuario.Entity.User01;
import com.prueba.ServicioDeUsuario.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User01>> listarUsuarios() {
        List<User01> usuarios = userService.getAllUsers();
        if (usuarios == null || usuarios.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("userById/{idU}")
    public ResponseEntity<User01> obtenerUnUsuario(@PathVariable("idU") int idU){
        User01 user = userService.getUserById(idU);
        if (user == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User01> guardarUsuario(@RequestBody User01 usuario){
        try{
            User01 usuar = userService.saveUser(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuar);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
