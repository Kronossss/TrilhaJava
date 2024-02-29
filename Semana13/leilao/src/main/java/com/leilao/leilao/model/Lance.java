package com.leilao.leilao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
