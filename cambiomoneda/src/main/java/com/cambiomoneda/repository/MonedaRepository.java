package com.cambiomoneda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cambiomoneda.model.Moneda;

public interface MonedaRepository extends JpaRepository <Moneda, Long> {

}
