package no.hvl.data102;
import no.hvl.data102.adt.*;
import no.hvl.data102.*;

public class Filmarkiv implements FilmarkivADT {
	private Film[] tab;
	private int antall;
	
	public Filmarkiv(int lengde) {
		tab = new Film[lengde];
		antall = 0;
	}
	
	private void utvid() {
		Film[] hjelpetabell = new Film[antall*2];
		for(int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}
	
	private Film[] trimTab(Film[] tab, int n) { 
		// n er antall elementer 
		Film[] nytab = new Film[n]; 
		int i = 0; 
		while (i < n) { 
			nytab[i] = tab[i]; 
			i++; 
		} 
		return nytab; 
	} 

	@Override
	public Film finnFilm(int nr) {
		Film funnetfilm = null;
		boolean funnet=false;
		int i=0;
		while(i<antall&&!funnet) {
			if(tab[i].getFilmnr()==nr) {
				funnet=true;
				tab[i]=funnetfilm;
			}
			i++;
		}
		return funnetfilm;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(antall<tab.length) {
			tab[antall+1]=nyFilm;
			antall++;
		}else{
			utvid();
		}
		leggTilFilm(nyFilm);
	}

	@Override
	public boolean slettFilm(int filmnr) {
		int i=0;
		boolean slettet=false;
		while(i<antall&&!slettet) {
			if(tab[i].getFilmnr()==filmnr) {
				tab[i]=tab[antall];
				antall--;
				slettet=true;
			}
			i++;
		}
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] ny = new Film[antall];
		int teller=0;
		for(int i=0; i<ny.length; i++) {
			if(tab[i].getTittel().contains(delstreng)) {
				ny[teller]=tab[i];
				teller++;
			}
		}
		return trimTab(ny, teller);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] ny = new Film[antall];
		int teller=0;
		for(int i=0; i<ny.length; i++) {
			if(tab[i].getFilmskaper().contains(delstreng)) {
				ny[teller]=tab[i];
				teller++;
			}
		}
		return trimTab(ny, teller);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int teller=0;
		for(int i=0; i<tab.length; i++) {
			if(tab[i].getSjanger()==sjanger) {
				teller++;
			}
		}
		return teller;
	}

	@Override
	public int antall() {
		return antall;
	}
	
}