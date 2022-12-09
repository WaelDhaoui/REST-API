package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springboot.model.Gestion;
import com.javaguides.springboot.service.impl.AchatServiceImpl;

@RestController
@RequestMapping("/api/gestion")
public class GestionController {
	
	private AchatServiceImpl gestionService;

	public GestionController(AchatServiceImpl produitService) {
		super();
		this.gestionService = produitService;
	}
	
	// build create buyer REST API
	@PostMapping("/{id}/{ref}")
	public ResponseEntity<Gestion> saveAchat(@PathVariable("id") long id,@PathVariable("ref") long ref,@RequestBody Gestion gestion){
		return new ResponseEntity<Gestion>(gestionService.saveAchat(id,ref,gestion), HttpStatus.CREATED);
	}
	
	// build get all buyers REST API
	@GetMapping
	public List<Gestion> getAllGestion(){
		return gestionService.getAllAchat();
	}
	
	// build get buyer by id REST API
	// http://localhost:8080/api/gestion/1
	@GetMapping("{ref}")
	public ResponseEntity<Gestion> getAchatById(@PathVariable("ref") long ProduitRef){
		return new ResponseEntity<Gestion>(gestionService.getAchatByNum(ProduitRef), HttpStatus.OK);
	}
	
	// build update buyer REST API
	// http://localhost:8080/api/gestion/1
	@PutMapping("/{id}/{ref}")
	public ResponseEntity<Gestion> updateProduit(@PathVariable("id") long id ,@PathVariable("ref") long ref ,@RequestBody Gestion gestion){
		return new ResponseEntity<Gestion>(gestionService.updateAchat(gestion, id,ref), HttpStatus.OK);
	}
	
	// build delete buyer REST API
	// http://localhost:8080/api/gestion/1
	@DeleteMapping("{ref}")
	public ResponseEntity<String> deleteProduit(@PathVariable("ref") long ref){
		
	// delete buyer from DB
	gestionService.deleteAchat(ref);
	
	return new ResponseEntity<String>("Produit deleted successfully!.", HttpStatus.OK);
	}
	
}