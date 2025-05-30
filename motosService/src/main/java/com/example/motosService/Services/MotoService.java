package com.example.motosService.Services;

import com.example.motosService.Entity.MotoEntity;
import com.example.motosService.Repositorys.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepository;

    public List<MotoEntity> getAllMotos() {
        return motoRepository.findAll();
    }

    public MotoEntity getMotoById(int id) {
        return motoRepository.findById(id).orElse(null);
    }

    public MotoEntity createMoto(MotoEntity moto) {
        return motoRepository.save(moto);
    }

    public boolean deleteMoto(int id) {
        if (motoRepository.existsById(id)) {
            motoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<MotoEntity> MotoByUserId(int userId) {
        return motoRepository.idUser(userId);
    }

}
