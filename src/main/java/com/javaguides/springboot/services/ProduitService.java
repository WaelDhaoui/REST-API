package com.javaguides.springboot.services;

import java.util.List;

import com.javaguides.springboot.model.Produit;

public interface ProduitService {
	Produit saveProduit(Produit produit);
	List<Produit> getAllProduit();
	Produit getProduitById(long ref);
	Produit updateProduit(Produit user, long ref);
	void deleteProduit(long ref);
}

