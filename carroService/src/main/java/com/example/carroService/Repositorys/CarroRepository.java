package com.example.carroService.Repositorys;

import com.example.carroService.Entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Integer> {
}
