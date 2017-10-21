package org.cat.application;

import org.cat.application.InterfejsCat;
import org.cat.domain.Kot;

import java.util.ArrayList;
import java.util.List;

import org.cat.domain.Kot;
import org.springframework.stereotype.Repository;

@Repository
public class CatDAO{
	private List<Kot> kotList;
	public CatDAO() {
		this.kotList = new ArrayList<Kot>();
	}
	
	public List<Kot> getKotList() {
		return kotList;
	}


	public List<Kot> dodajKota(Kot kot) {
		System.out.println("Dodaję kota!");
		kotList.add(kot);
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
