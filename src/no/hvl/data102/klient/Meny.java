package no.hvl.data102.klient;
import java.util.Scanner;
import no.hvl.data102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr=new Tekstgrensesnitt();
		this.filmarkiv=filmarkiv;
	}
	
	public void start() {
		System.out.println("Legg til film tast:			1");
		System.out.println("Lese film fra fil tast:		2");
		System.out.println("Skriv ut statestikk  tast:	3");
		System.out.println("Søk film etter tittel:		4");
		System.out.println("Søk film etter produsent:	5");
		System.out.println("For å avslutte tast:		6");
		
		Scanner in=new Scanner(System.in);
		int tast=in.nextInt();
		
		if(tast==1) {
			filmarkiv.leggTilFilm(tekstgr.lesFilm());
//			Fil.skrivTilFil(filmarkiv, "Filmer.txt");
			start();
		} else if(tast==2) {
//			Fil.skrivTilFil(filmarkiv, "Filmer.txt");
			start();
		} else if(tast==3) {
			tekstgr.skrivUtStatistikk(filmarkiv);
		} else if(tast==4) {
			System.out.println("Skriv tittel på filmen: ");
			String tittel=in.next();
			tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittel);
			start();
		} else if(tast==5) {
			System.out.println("Skriv inn navnet på produsenten: ");
			String produsent=in.next();
			tekstgr.skrivUtFilmProdusent(filmarkiv, produsent);
			start();
		} else if(tast==6) {
			in.close();
			System.out.println("Programmet er avsluttet.");
		}
			
	}

}