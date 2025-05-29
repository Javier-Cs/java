package com.prueba.ServicioDeUsuario.Services;

import com.prueba.ServicioDeUsuario.Entity.User01;
import com.prueba.ServicioDeUsuario.Repositoris.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User01> getAllUsers() {
        return  userRepository.findAll();
    }

    public User01 getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User01 saveUser(User01 user) {
        return userRepository.save(user);
    }


}
