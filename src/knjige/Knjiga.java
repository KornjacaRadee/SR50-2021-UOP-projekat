package knjige;

public class Knjiga {
	private int id;
	private String naslov;
	private String orgNaslov;
	private String pisac;
	private int godinaIzdavanja;
	private String jezik;
	private String opis;
	private ZanrKnjige zanr;
	public Knjiga() {
		super();
	}
	public Knjiga(int id, String naslov, String orgNaslov, String pisac, int godinaIzdavanja, String jezik, String opis,
			ZanrKnjige zanr) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.orgNaslov = orgNaslov;
		this.pisac = pisac;
		this.godinaIzdavanja = godinaIzdavanja;
		this.jezik = jezik;
		this.opis = opis;
		this.zanr = zanr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getOrgNaslov() {
		return orgNaslov;
	}
	public void setOrgNaslov(String orgNaslov) {
		this.orgNaslov = orgNaslov;
	}
	public String getPisac() {
		return pisac;
	}
	public void setPisac(String pisac) {
		this.pisac = pisac;
	}
	public int getGodinaIzdavanja() {
		return godinaIzdavanja;
	}
	public void setGodinaIzdavanja(int godinaIzdavanja) {
		this.godinaIzdavanja = godinaIzdavanja;
	}
	public String getJezik() {
		return jezik;
	}
	public void setJezik(String jezik) {
		this.jezik = jezik;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public ZanrKnjige getZanr() {
		return zanr;
	}
	public void setZanr(ZanrKnjige zanr) {
		this.zanr = zanr;
	}
	
	
	
}
