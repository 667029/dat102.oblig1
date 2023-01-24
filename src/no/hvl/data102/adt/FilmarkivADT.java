package no.hvl.data102.adt;
import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;

public interface FilmarkivADT {
	/**
	 * Hent en film med gitt nr fra arkivet.
	 * @param nr på filmne som skal finnes.
	 * @return film med gitt nr. Returnerer null dersom den ikke eksisterer.
	 */
	 Film finnFilm(int nr);
	 
	 /**
	  * Legger til en ny film.
	  * @param nyFilm
	  */
	 void leggTilFilm(Film nyFilm); 
	 
	 /**
	  * Sletter en film med gitt filmnr.
	  * @param filmnr på filmen som skal slettes.
	  * @return true dersom filmen ble slettet, false ellers.
	  */
	 boolean slettFilm(int filmnr);  
	 
	 /**
	  * Søker og henter filmer med en gitt delstreng i tittelen.
	  * @param delstreng som må være i tittelen.
	  * @return tabell med filmer som delstreng i tittelen.
	  */
	 Film[] soekTittel(String delstreng); 
	 
	 /**
	  * Søker og henter filmer med en gitt delstreng av filmprodusenten.
	  * @param delstreng av prodsenten.
	  * @return tabell med filmer med delstreng av produsent.
	  */
	 Film[] soekProdusent(String delstreng);
	 
	 /**
	  * Søker filmer med gitt sjanger.
	  * @param sjanger til filmen.
	  * @return antallet filmer med gitt sjanger.
	  */
	 int antall(Sjanger sjanger); 
	 
	 /**
	  * 
	  * @return antall filmer i arkivet.
	  */
	 int antall();
}