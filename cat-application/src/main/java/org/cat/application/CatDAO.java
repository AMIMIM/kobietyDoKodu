package org.cat.application;

import org.cat.application.InterfejsCat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
//		kotList.add(kot);
		e.merge(kot);
		System.out.println("Dodaję kota: " + kot.getAllIfnomration());
		return kotList;
	}
	
	@Transactional
	public List<Kot> getKoty() {
		Query query = e.createQuery("Select * from koty");
		kotList = query.getResultList();
		System.out.println("Ilość pobranych kotów z bazy to: " + kotList.size());
		return kotList;
	}
	
	@Transactional
	public Kot getKotById(Integer id) {
		Kot kot = new Kot();
		if (id<kotList.size()) {
			kot = e.find(Kot.class, 1L);
			System.out.println("Wybrany kot: " + kot.getAllIfnomration());
			return kot;	
		} else {
			return null;
		}
	}
		
}
