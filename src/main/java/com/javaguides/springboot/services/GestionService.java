package com.javaguides.springboot.services;

import java.util.List;

import com.javaguides.springboot.model.Gestion;

public interface GestionService {
	Gestion saveAchat(long id,long ref,Gestion gestion);
	List<Gestion> getAllAchat();
	Gestion getAchatByNum(long nb);
	Gestion updateAchat(Gestion gestion, long nb, long ref);
	void deleteAchat(long nb);
}

