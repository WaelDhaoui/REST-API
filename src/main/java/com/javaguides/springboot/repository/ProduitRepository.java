package com.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.springboot.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}