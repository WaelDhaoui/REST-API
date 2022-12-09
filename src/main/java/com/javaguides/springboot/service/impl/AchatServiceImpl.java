package com.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides.springboot.exception.ResourceNotFoundException;
import com.javaguides.springboot.model.Gestion;
import com.javaguides.springboot.model.Produit;
import com.javaguides.springboot.repository.GestionRepository;
import com.javaguides.springboot.repository.ProduitRepository;
import com.javaguides.springboot.repository.UserRepository;
import com.javaguides.springboot.services.GestionService;

@Service
public class AchatServiceImpl implements GestionService {

	@Autowired
	private GestionRepository gestionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	public AchatServiceImpl(GestionRepository gestionRepository) {
		super();
		this.gestionRepository = gestionRepository;
	}
	
	@Override
	public Gestion saveAchat(long id,long ref,Gestion gestion) {
		userRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", id));
		Produit produit = produitRepository.findById(ref).orElseThrow(() -> 
		new ResourceNotFoundException("Produit", "ref", ref));
		
		produit.setQuantite(produit.getQuantite() - gestion.getQuantite());
		return gestionRepository.save(gestion);
	}

	@Override
	public List<Gestion> getAllAchat() {
		return gestionRepository.findAll();
	}

	@Override
	public Gestion getAchatByNum(long nb) {
		return gestionRepository.findById(nb).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", nb));
	}

	@Override
	public Gestion updateAchat(Gestion gestion, long nb, long ref) {
		// we need to check whether service with given id is exist in DB or not
		com.javaguides.springboot.model.Gestion existingAchat = gestionRepository.findById(nb).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", nb)); 
		
		Produit produit = produitRepository.findById(ref).orElseThrow(() -> 
		new ResourceNotFoundException("Produit", "ref", ref));
		
		existingAchat.setRef(gestion.getRef());
		existingAchat.setQuantite(produit.getQuantite() - gestion.getQuantite());
		// save existing service to DB
		gestionRepository.save(existingAchat);
		return existingAchat;
	}

	@Override
	public void deleteAchat(long nb) {
		// check whether a buy exist in a DB or not
		gestionRepository.findById(nb).orElseThrow(() -> 
								new ResourceNotFoundException("Gestion", "Id", nb));
		gestionRepository.deleteById(nb);
	}

}
