package org.cat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.cat.application.CatDAO;
import org.cat.dao.JDBCCatDAO;
import org.cat.domain.Kot;
import org.cat.dto.CatDto;

@Controller
public class CatsController {

	@Autowired
	CatDAO dao;
	
	@Autowired
	JDBCCatDAO dbCatDao;
	
	@RequestMapping("/lista")
	public String listaKotow(Model model) {
		System.out.println("Lista kota odpalone...");
		model.addAttribute("koty", dao.getKoty());
		dbCatDao.findCatbyName("Filemon");
		return "lista";
	}
	
	@RequestMapping("/dodaj")
//	public String dodajKota(Model model) {
	public String dodajKota(HttpServletRequest request, @ModelAttribute("catDto") @Valid CatDto catDto, BindingResult result) {
		System.out.println("Dodawanie kota odpalone...");
		if (request.getMethod().equalsIgnoreCase("post") || !result.hasErrors()) {
			Kot kot = new Kot();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			try {
				kot.setData_urodzenia(sdf.parse(catDto.getDataUrodzenia()));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			kot.setImie(catDto.getImie());
			kot.setOpiekun_name(catDto.getImieOpiekuna());
			kot.setWaga(catDto.getWaga());
			dao.dodajKota(kot);
			dbCatDao.insert(kot);
			return "redirect:/lista";
		}
		return "dodaj";
	}
	
	@RequestMapping("/kot-{id}")
	public String szczegolyKota(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("kot", dao.getKotById(id));
		return "szczegoly";
	}
	
}
