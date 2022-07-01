package knjige;

import java.time.LocalDate;

import ljudi.Clan;
import ljudi.Zaposleni;

public class Iznajmljivanje {
	private String zaposleni;
	private String clan;
	private LocalDate datumIznajmljivanja;
	private LocalDate datumVracanja;
	private String primerakk;
	private String naslovKnjige;
	
	
	public Iznajmljivanje() {
		super();
	}


	public Iznajmljivanje(String zaposleni, String clan, LocalDate datumIznajmljivanja, LocalDate datumVracanja,
			 String naslovKnjige, String primerakk) {
		super();
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.primerakk = primerakk;
		this.naslovKnjige = naslovKnjige;
	}


	public String getZaposleni() {
		return zaposleni;
	}


	public void setZaposleni(String zaposleni) {
		this.zaposleni = zaposleni;
	}


	public String getClan() {
		return clan;
	}


	public void setClan(String clan) {
		this.clan = clan;
	}


	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}


	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}


	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}


	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}


	public String getPrimerakk() {
		return primerakk;
	}


	public void setPrimerakk(String primerakk) {
		this.primerakk = primerakk;
	}


	public String getNaslovKnjige() {
		return naslovKnjige;
	}


	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}


	





	
	
}
