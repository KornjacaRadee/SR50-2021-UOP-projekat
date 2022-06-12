package knjige;

import ljudi.Clan;
import ljudi.Zaposleni;

public class Iznajmljivanje {
	private Zaposleni zaposleni;
	private Clan clan;
	private String datumIznajmljivanja;
	private String datumVracanja;
	private Primerak primerak;
	private String naslovKnjige;
	
	
	public Iznajmljivanje() {
		super();
	}


	public Iznajmljivanje(Zaposleni zaposleni, Clan clan, String datumIznajmljivanja, String datumVracanja,
			Primerak primerak, String naslovKnjige) {
		super();
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.primerak = primerak;
		this.naslovKnjige = naslovKnjige;
	}


	public Zaposleni getZaposleni() {
		return zaposleni;
	}


	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}


	public Clan getClan() {
		return clan;
	}


	public void setClan(Clan clan) {
		this.clan = clan;
	}


	public String getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}


	public void setDatumIznajmljivanja(String datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}


	public String getDatumVracanja() {
		return datumVracanja;
	}


	public void setDatumVracanja(String datumVracanja) {
		this.datumVracanja = datumVracanja;
	}


	public Primerak getPrimerak() {
		return primerak;
	}


	public void setPrimerak(Primerak primerak) {
		this.primerak = primerak;
	}


	public String getNaslovKnjige() {
		return naslovKnjige;
	}


	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}
	
}
