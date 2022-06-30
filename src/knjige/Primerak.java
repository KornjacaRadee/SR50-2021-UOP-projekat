package knjige;

public class Primerak {

	private String knjiga;
	private String id;
	private int brojStrana;
	private Povez povez;
	private int godinaStampanja;
	private String jezikStampanja;
	private boolean dostupnost;
	public Primerak() {
		super();
	}
	public Primerak(String knjiga, int brojStrana, Povez povez, int godinaStampanja, String jezikStampanja,
			boolean dostupnost, String id) {
		super();
		this.knjiga = knjiga;
		this.id = id;
		this.brojStrana = brojStrana;
		this.povez = povez;
		this.godinaStampanja = godinaStampanja;
		this.jezikStampanja = jezikStampanja;
		this.dostupnost = dostupnost;
	}
	
	public String getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(String knjiga) {
		this.knjiga = knjiga;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBrojStrana() {
		return brojStrana;
	}
	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}
	public Povez getPovez() {
		return povez;
	}
	public void setPovez(Povez povez) {
		this.povez = povez;
	}
	public int getGodinaStampanja() {
		return godinaStampanja;
	}
	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}
	public String getJezikStampanja() {
		return jezikStampanja;
	}
	public void setJezikStampanja(String jezikStampanja) {
		this.jezikStampanja = jezikStampanja;
	}
	public boolean isDostupnost() {
		return dostupnost;
	}
	public void setDostupnost(boolean dostupnost) {
		this.dostupnost = dostupnost;
	}
	
	


	
}
