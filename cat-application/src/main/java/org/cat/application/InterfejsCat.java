package org.cat.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.cat.domain.Kot;

public class InterfejsCat extends CatDAO{
//	protected final static Logger log = Logger.getLogger(InterfejsCat.class);
	static Scanner sc = new Scanner(System.in);
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	private static String typeName;
	private static String typeMenu;
	private static final String patOpiekunPattern = ("([A-Z]{1,1})[a-z]{1}");
	private static final String weightPattern = ("([1-9]+)([0-9]{1})");
	private static final String datePattern = ("([0-3]{1,1})([0-9]{1,1}).([0-9]{1,1})([0-9]{1,1}).([2]{1,1})([0-9]{1,3})");
	private static CatDAO kotDao = new CatDAO();
	private static List<Kot> tempList = new ArrayList<Kot>();
	
	public static String getUserInput() {
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
//		BasicConfigurator.configure();
		Pattern patOpeikunName = Pattern.compile("([A-Z]+)[a-z]{1}");
		
//		log.debug("START " + kot.getClass().getTypeName());
		do {
			System.out.println("1. Dodaj kota\n2. Wybierz kota do prezentacji\n3. Zakończ!");
			typeMenu = getUserInput();
			if(typeMenu.equals("1")) {
				
				dodajKoty();
				
			}else if(typeMenu.equals("2")) {
				pokazKoty();
			}else {
				System.out.println("KONIEC!");
			}
			
			
		}while(!typeMenu.equals("3"));
		
//		tempList = kotDao.dodajKota(kot);
//		System.out.println(tempList.size());
//		log.debug("KONIEC!");
	}
	
	private static void dodajKoty() {
		Kot kot = new Kot();
		do {
			System.out.print("Podaj imie kota: ");
			typeName = getUserInput();
			
			kot.setImie(typeName);
		}while(Pattern.matches(patOpiekunPattern, typeName)==false);
		
		do {
			System.out.print("Podaj imie opiekuna: ");
			typeName = getUserInput();
			kot.setOpiekun_name(typeName);
		}while(Pattern.matches(patOpiekunPattern, typeName)==false);
		
		do {
			System.out.print("Podaj wagę kota: ");
			typeName = getUserInput();
			if(Pattern.matches(weightPattern, typeName)==true){
				kot.setWaga(Double.valueOf(typeName));
			}
		}while(kot.getWaga()==0.0);
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		do {
			System.out.print("Podaj date urodzenia kota: ");
			typeName = getUserInput();
			if(Pattern.matches(datePattern, typeName)==true){
				try {
					kot.setData_urodzenia(sdf.parse(typeName));
				}catch(ParseException e){
					System.out.print("Kiedy ten bydla się urodził?!: ");
				}
			}
		}while(kot.getData_urodzenia()==null);
		
//		System.out.println(kot.getAllIfnomration());
//		System.out.println(kot.getData_urodzenia().format(f));
		tempList = kotDao.dodajKota(kot);
	}
	
	private static void pokazKoty() {
		int i = 0;
		for (Kot kotek : tempList) {
			System.out.println(i + ". Kot o imieniu: "+kotek.getImie());
		}
		
		System.out.print("Podaj numer kota, którego chcesz wyświetlić: ");
		try {
			System.out.println(tempList.get(Integer.valueOf(getUserInput())).getAllIfnomration());
		}catch(IndexOutOfBoundsException e){
			System.out.println("Wprowadzony numer jest niepoprawny lub wykracza poza rozmiar tablicy: " + e);
		}
	}
}
