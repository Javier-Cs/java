package com.example.carroService.Controllers;

import com.example.carroService.Entity.CarroEntity;
import com.example.carroService.Services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/allCarrs")
    public ResponseEntity<List<CarroEntity>> findAll() {
        List<CarroEntity> listaCarros = carroService.traerAllCarros();
        if (listaCarros==null || listaCarros.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(listaCarros);
    }

    @GetMapping("/ByIdCarr/{id}")
    public ResponseEntity<CarroEntity> findById(@PathVariable("id") int id) {
        CarroEntity carro = carroService.carroById(id);
        if (carro==null ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(carro);
    }

    @PostMapping("/saveCarr")
    public ResponseEntity<CarroEntity> save(@RequestBody CarroEntity carro) {
        try{
            CarroEntity carro01 = carroService.saveCarro(carro);
            return ResponseEntity.status(HttpStatus.CREATED).body(carro01);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteByIdCarr/{id}")
    public ResponseEntity<Void> deleteByIdCarr(@PathVariable("id") int id){
        try{
            boolean result = carroService.deleteCarro(id);
            if (result){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
