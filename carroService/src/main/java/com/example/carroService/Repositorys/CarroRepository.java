package com.example.carroService.Repositorys;

import com.example.carroService.Entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Integer> {
    List<CarroEntity> idUser(int id);
}
