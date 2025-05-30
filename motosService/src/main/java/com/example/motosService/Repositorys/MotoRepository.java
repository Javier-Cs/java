package com.example.motosService.Repositorys;

import com.example.motosService.Entity.MotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<MotoEntity, Integer> {
    List<MotoEntity> idUser(int id);

}
