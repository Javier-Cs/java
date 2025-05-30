package com.example.carroService.Services;

import com.example.carroService.Entity.CarroEntity;
import com.example.carroService.Repositorys.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<CarroEntity> traerAllCarros(){
        return carroRepository.findAll();
    }

    public CarroEntity carroById(int id){
        return  carroRepository.findById(id).orElse(null);
    }

    public CarroEntity saveCarro(CarroEntity carro){
        return carroRepository.save(carro);
    }
    public boolean deleteCarro(int id){
        if(carroRepository.existsById(id)){
             carroRepository.deleteById(id);
             return true;
        }
        return false;
    }

    public List<CarroEntity> carroByUserId(int id){
        return carroRepository.carroByIdUser(id);
    }

}
