package org.cat.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="koty")
public class Kot {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long id;
	
	@Column(name="imie")
	private String imie;
	
	@Column(name="data")
	private Date data_urodzenia;
	
	@Column(name="waga")
	private double waga;
	
	@Column(name="IMIEOPIEKUNA")
	private String opiekun_name;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public Date getData_urodzenia() {
		return data_urodzenia;
	}
	public void setData_urodzenia(Date date) {
		this.data_urodzenia = date;
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
		kot.setData_urodzenia(new Date());
		kot.setWaga(100.0);
		kot.setOpiekun_name("Jakiś debol");
		
		System.out.println(kot.przedstawSie());
	}
	
}
