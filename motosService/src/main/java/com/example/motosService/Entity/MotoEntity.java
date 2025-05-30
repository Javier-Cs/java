package com.example.motosService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;
@Data
@Entity
@Table(name = "motos_Tbl")
public class MotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ID_USER")
    private int idUser;
}
