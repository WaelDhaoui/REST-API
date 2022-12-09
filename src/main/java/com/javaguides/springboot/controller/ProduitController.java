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

import com.javaguides.springboot.model.Produit;
import com.javaguides.springboot.service.impl.ProduitServiceImpl;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {
	
	private ProduitServiceImpl produitService;

	public ProduitController(ProduitServiceImpl produitService) {
		super();
		this.produitService = produitService;
	}
	
	// build create product REST API
	@PostMapping()
	public ResponseEntity<Produit> saveUser(@RequestBody Produit produit){
		return new ResponseEntity<Produit>(produitService.saveProduit(produit), HttpStatus.CREATED);
	}
	
	// build get all products REST API
	@GetMapping
	public List<Produit> getAllUsers(){
		return produitService.getAllProduit();
	}
	
	// build get product by id REST API
	// http://localhost:8080/api/produit/1
	@GetMapping("{ref}")
	public ResponseEntity<Produit> getUserById(@PathVariable("ref") long ProduitRef){
		return new ResponseEntity<Produit>(produitService.getProduitById(ProduitRef), HttpStatus.OK);
	}
	
	// build update employee REST API
	// http://localhost:8080/api/produit/1
	@PutMapping("{ref}")
	public ResponseEntity<Produit> updateProduit(@PathVariable("ref") long ref ,@RequestBody Produit produit){
		return new ResponseEntity<Produit>(produitService.updateProduit(produit, ref), HttpStatus.OK);
	}
	
	// build delete product REST API
	// http://localhost:8080/api/produit/1
	@DeleteMapping("{ref}")
	public ResponseEntity<String> deleteProduit(@PathVariable("ref") long ref){
		
	// delete employee from DB
	produitService.deleteProduit(ref);
	
	return new ResponseEntity<String>("Produit deleted successfully!.", HttpStatus.OK);
	}
	
}