package com.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.springboot.model.Gestion;

public interface GestionRepository extends JpaRepository<Gestion, Long>{

}