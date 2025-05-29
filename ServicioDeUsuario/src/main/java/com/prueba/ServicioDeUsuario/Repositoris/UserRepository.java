package com.prueba.ServicioDeUsuario.Repositoris;

import com.prueba.ServicioDeUsuario.Entity.User01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User01, Integer> {

}
