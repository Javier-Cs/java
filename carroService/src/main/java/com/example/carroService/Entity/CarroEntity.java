package com.example.carroService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carros_Tbl")
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idCar;
    @Column(name="MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ID_USER")
    private int idUser;
}
