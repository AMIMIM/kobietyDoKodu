package org.cat.domain;

import java.time.LocalDate;
import java.util.Date;

public class Kot {
	 
	private String imie;
	private LocalDate data_urodzenia;
	private double waga;
	private String opiekun_name;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public LocalDate getData_urodzenia() {
		return data_urodzenia;
	}
	public void setData_urodzenia(LocalDate data) {
		this.data_urodzenia = data;
	}
	public double getWaga() {
		return waga;
	}
	public void setWaga(double waga) {
		this.waga = waga;
	}
	public String getOpiekun_name() {
		return opiekun_name;
	}
	public void setOpiekun_name(String opiekun_name) {
		this.opiekun_name = opiekun_name;
	}
	
	public String przedstawSie(){
		
		return "Imie kota: " + this.imie + ", data urodzenia: " + this.data_urodzenia.toString() 
				+ ", waga: " + this.waga + ", opiekun: " + this.opiekun_name ; 
	}
	
	public String getAllIfnomration() {
		return "Imie kota: " + this.getImie() + " oraz imie w�a�ciciela: " + this.getOpiekun_name() + " urodzonego: " + this.getData_urodzenia() + " kt�ry wa�y dok�adnie: " + this.getWaga();
	}
	
	public static void main(String[] args) {
		Kot kot = new Kot();
		kot.setImie("Śmierdziel");
		kot.setData_urodzenia(LocalDate.now());
		kot.setWaga(100.0);
		kot.setOpiekun_name("Jakiś debol");
		
		System.out.println(kot.przedstawSie());
	}
	
}
