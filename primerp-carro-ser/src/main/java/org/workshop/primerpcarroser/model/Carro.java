package org.workshop.primerpcarroser.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Carro {
    @Id
    @GeneratedValue
private long id;
private String marca;
private String modelo;
private int usuarioId;
}
