package org.cat.application;

import org.cat.application.InterfejsCat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.cat.domain.Kot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Repository
public class CatDAO{
	
	@PersistenceContext
    EntityManager e;
	
	private List<Kot> kotList;
	
	public CatDAO() {
		this.kotList = new ArrayList<Kot>();
	}
	
	@Transactional
	public List<Kot> dodajKota(Kot kot) {
		System.out.println("Dodaję kota!");
		kotList.add(kot);
		return kotList;
	}
	
	public List<Kot> getKoty() {
		return kotList;
	}
	
	public Kot getKotById(Integer id) {
		if (id<kotList.size()) {
			return kotList.get(id);
		} else {
			return null;
		}
	}
		
}
