package com.example.motosService.Controllers;

import com.example.motosService.Entity.MotoEntity;
import com.example.motosService.Services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping("/AllMotos")
    public ResponseEntity<List<MotoEntity>> getAllMotos() {
        List<MotoEntity> motos = motoService.getAllMotos();
        if (motos== null || motos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(motos);
    }


    @GetMapping("/GetByIdmotos/{id}")
    public ResponseEntity<MotoEntity> getByIdmotos(@PathVariable("id") int id) {
        MotoEntity motoEntity = motoService.getMotoById(id);
        if (motoEntity == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(motoEntity);
    }


    @PostMapping("/savemoto")
    public ResponseEntity<MotoEntity> saveMoto(@RequestBody MotoEntity moto) {
        try{
            MotoEntity moto1 = motoService.createMoto(moto);
            return  ResponseEntity.status(HttpStatus.CREATED).body(moto1);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deletemoto/{id}")
    public ResponseEntity<Void> deleteMotoId(@PathVariable("id") int id){
        try{
            boolean deleted = motoService.deleteMoto(id);
            if (deleted){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
