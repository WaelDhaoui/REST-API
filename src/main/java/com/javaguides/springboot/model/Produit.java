package com.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ref;

	@Column(name="prix")
	private long prix;
	
	@Column(name="quantite")
	private int quantite;

	public long getRef() {
		return ref;
	}

	public void setRef(long ref) {
		this.ref = ref;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
