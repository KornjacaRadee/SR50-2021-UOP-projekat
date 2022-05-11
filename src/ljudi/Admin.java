package ljudi;

public class Admin extends Zaposleni {

	public Admin() {
		super();
	}

	public Admin(int id, String ime, String prezime, String adresa, String jMBG, Pol polovi, String korisnickoIme,
			String korisnickaSifra, double plata) {
		super(id, ime, prezime, adresa, jMBG, polovi, korisnickoIme, korisnickaSifra, plata);
	}
	
}
