package com.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="gestion")
public class Gestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nbAchat;
	
	@Column(name="id_user")
	private long idU;
	
	@Column(name="ref_produit")
	private long refP;
	
	@Column(name="quantite")
	private int quantite;
	
	public long getId() {
		return idU;
	}

	public void setId(long id) {
		this.idU = id;
	}

	public long getRef() {
		return refP;
	}

	public void setRef(long ref) {
		this.refP = ref;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
