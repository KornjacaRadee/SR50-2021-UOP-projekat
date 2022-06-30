package ljudi;

import java.time.LocalDate;

public class Clan extends Osoba{
	private String brojClanskeKarte;
	private String tip;
	private LocalDate datumUplate;
	private int brojMeseci;
	private boolean aktivnost;
	public Clan() {
		super();
	}
	public Clan(String id, String ime, String prezime, String adresa, String jMBG, Pol polovi, String brojClanskeKarte,
			String tip, LocalDate datumUplate, int brojMeseci, boolean aktivnost) {
		super(id, ime, prezime, adresa, jMBG, polovi);
		this.brojClanskeKarte = brojClanskeKarte;
		this.tip = tip;
		this.datumUplate = datumUplate;
		this.brojMeseci = brojMeseci;
		this.aktivnost = aktivnost;
	}
	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public LocalDate getDatumUplate() {
		return datumUplate;
	}
	public void setDatumUplate(LocalDate datumUplate) {
		this.datumUplate = datumUplate;
	}
	public int getBrojMeseci() {
		return brojMeseci;
	}
	public void setBrojMeseci(int brojMeseci) {
		this.brojMeseci = brojMeseci;
	}
	public boolean isAktivnost() {
		return aktivnost;
	}
	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}
	
}
