package com.prueba.ServicioDeUsuario.Services;

import com.prueba.ServicioDeUsuario.ClientsFeignClients.CarroFeignClient;
import com.prueba.ServicioDeUsuario.Entity.User01;
import com.prueba.ServicioDeUsuario.Models.CarroModel;
import com.prueba.ServicioDeUsuario.Models.MotoModel;
import com.prueba.ServicioDeUsuario.Repositoris.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarroFeignClient carroFeignClient;

    public CarroModel saveCarro(int idUser, CarroModel carro) {
        carro.setIdUser(idUser);
        return carroFeignClient.save(carro);

    }







    public List<CarroModel> listaDeCarros(int userId) {
        return restTemplate.getForObject("http://localhost:8081/carros/carroByIdUser/" + userId, List.class);
    }

    public List<MotoModel> listaDeMotos(int userId) {
        return restTemplate.getForObject("http://localhost:8083/motos/motoByIdUser/" + userId, List.class);

    }

    /**/
    public List<User01> getAllUsers() {
        return userRepository.findAll();
    }

    public User01 getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User01 saveUser(User01 user) {
        return userRepository.save(user);
    }


}
