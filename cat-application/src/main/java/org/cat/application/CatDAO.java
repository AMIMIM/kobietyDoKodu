package org.cat.application;

import org.cat.application.InterfejsCat;

import java.util.ArrayList;
import java.util.List;

import org.cat.domain.Kot;

public class CatDAO{
	private List<Kot> kotList;
	public CatDAO() {
		this.kotList = new ArrayList<Kot>();
	}
	
	public List<Kot> dodajKota(Kot kot) {
		System.out.println("Dodaję kota!");
		kotList.add(kot);
		return kotList;
	}
	
}
