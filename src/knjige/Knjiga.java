package knjige;

import javax.swing.table.DefaultTableModel;

public class Knjiga {
	private String id;
	private String naslov;
	private String orgNaslov;
	private String pisac;
	private int godinaIzdavanja;
	private String jezik;
	private String opis;
	private String zanr;
	
	public Knjiga() {
		super();
	}
	public Knjiga(String id, String naslov, String orgNaslov, String pisac, int godinaIzdavanja, String jezik, String opis,
			String zanr) {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	
	
}
