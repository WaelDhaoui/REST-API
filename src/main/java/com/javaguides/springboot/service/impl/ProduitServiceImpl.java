package com.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides.springboot.exception.ResourceNotFoundException;
import com.javaguides.springboot.model.Produit;
import com.javaguides.springboot.repository.ProduitRepository;
import com.javaguides.springboot.services.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	public ProduitServiceImpl(ProduitRepository produitRepository) {
		super();
		this.produitRepository = produitRepository;
	}
	
	@Override
	public Produit saveProduit(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public List<Produit> getAllProduit() {
		return produitRepository.findAll();
	}

	@Override
	public Produit getProduitById(long ref) {
		return produitRepository.findById(ref).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", ref));
	}

	@Override
	public Produit updateProduit(Produit produit, long ref) {
		// we need to check whether product with given id is exist in DB or not
		com.javaguides.springboot.model.Produit existingProduit = produitRepository.findById(ref).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", ref)); 
		
		existingProduit.setPrix(produit.getPrix());
		existingProduit.setQuantite(produit.getQuantite());
		// save existing product to DB
		produitRepository.save(existingProduit);
		return existingProduit;
	}

	@Override
	public void deleteProduit(long ref) {
		// check whether a product exist in a DB or not
		produitRepository.findById(ref).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", ref));
		produitRepository.deleteById(ref);
	}

}
