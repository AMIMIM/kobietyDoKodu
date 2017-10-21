package org.cat.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

public class CatDto {
	
	@NotBlank
	@Pattern(regexp="([A-Z]{1,1})[a-z]{1}")
	private String imie;
	
	@NotBlank
	@Pattern(regexp="([0-3]{1,1})([0-9]{1,1}).([0-9]{1,1})([0-9]{1,1}).([2]{1,1})([0-9]{1,3})")
	private String dataUrodzenia;
	
	@NotNull
	private float waga;
	
	@NotBlank
	@Pattern(regexp="([A-Z]{1,1})[a-z]{1}")
	private String imieOpiekuna;

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(String dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public float getWaga() {
		return waga;
	}

	public void setWaga(float waga) {
		this.waga = waga;
	}

	public String getImieOpiekuna() {
		return imieOpiekuna;
	}

	public void setImieOpiekuna(String imieOpiekuna) {
		this.imieOpiekuna = imieOpiekuna;
	}
	
	
	
}
