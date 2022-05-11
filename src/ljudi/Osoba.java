package ljudi;

public abstract class Osoba {
	private int id;
	private String ime;
	private String prezime;
	private String adresa;
	private String JMBG;
	private Pol polovi;
	public Osoba() {
		super();
	}
	public Osoba(int id, String ime, String prezime, String adresa, String jMBG, Pol polovi) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		JMBG = jMBG;
		this.polovi = polovi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	public Pol getPolovi() {
		return polovi;
	}
	public void setPolovi(Pol polovi) {
		this.polovi = polovi;
	}
	
	
	
	
}
