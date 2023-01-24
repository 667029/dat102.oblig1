package no.hvl.data102.klient;
import java.util.Scanner;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	
	// lese opplysningene om en Film fra tastatur
	 public Film lesFilm(){ 
		 
		 @SuppressWarnings("resource")
		 Scanner sc = new Scanner(System.in);

		 System.out.print("Skriv inn film nummer: ");
		 int filmNr = sc.nextInt();

		 System.out.print("Skriv inn navn på produsent: ");
		 String produsent = sc.next();

		 System.out.print("Skriv inn tittel: ");
		 String tittel = sc.next();

		 System.out.print("Skriv inn lansering: ");
		 int lansering = sc.nextInt();

		 System.out.print("Skriv inn Sjanger: ");
		 Sjanger sjanger1 = Sjanger.finnSjanger(sc.next().toUpperCase());

		 System.out.print("Skriv inn filmselskap: ");
		 String filmSelskap = sc.next();

		 Film nyFilm = new Film(filmNr, produsent, tittel, lansering, sjanger1, filmSelskap);

		 return nyFilm;
		 
	 } 
	 
	 // vise en film med alle opplysninger på skjerm (husk tekst for sjanger) 
	 public void visFilm(Film film) {
		 
		 System.out.println(film.toString());
		 
	 } 
	 
	 // Skrive ut alle Filmer med en spesiell delstreng i tittelen 
	 public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) { 
	  
		 for (Film nyFilm : filma.soekTittel(delstreng)) {
			 visFilm(nyFilm);
		 }
		 
	 } 
	 
	 // Skriver ut alle Filmer av en produsent / en gruppe 
	 public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) { 

		 for (Film nyFilm : filma.soekProdusent(delstreng)) {
			 visFilm(nyFilm);
		 }
		 
	 } 
	 
	 // Skrive ut en enkel statistikk som inneholder antall Filmer totalt 
	 // og hvor mange det er i hver sjanger 
	 public void skrivUtStatistikk(FilmarkivADT filma) { 
		 
		 System.out.println("Antall Filmer totalt: " + filma.antall());

		 for(int i = 0; i < Sjanger.values().length; i++) {
			 System.out.println("Antall Filmer med " + Sjanger.values()[i]+ " sjanger: " + filma.antall(Sjanger.values()[i]) + "\n");
		 }
		 
	 } 
	 
	 // ... Ev. andre metoder

}