package knjige;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import ljudi.Admin;
import ljudi.Bibliotekar;
import ljudi.Clan;
import ljudi.Pol;
import ljudi.TipClanarine;

public class Biblioteka {
	private String naziv;
	private String adresa;
	private String brojTelefona;
	private String vremeRada;
	private ArrayList<Clan> clanovi;
	private ArrayList<Bibliotekar> bibliotekari;
	private ArrayList<Admin> admini;
	private ArrayList<TipClanarine> tipClanarine;
	private ArrayList<Primerak> primerak;
	private ArrayList<Knjiga> knjiga;
	private ArrayList<ZanrKnjige> zanrovi;
	private ArrayList<Iznajmljivanje> iznajmljivanje;
	public Biblioteka() {
        super();
        this.admini = new ArrayList<Admin>();
        this.bibliotekari = new ArrayList<Bibliotekar>();
        this.clanovi = new ArrayList<Clan>();
        this.tipClanarine = new ArrayList<TipClanarine>();
        this.knjiga = new ArrayList<Knjiga>();
        this.primerak = new ArrayList<Primerak>();
        this.zanrovi = new ArrayList<ZanrKnjige>();
        this.iznajmljivanje = new ArrayList<Iznajmljivanje>();
    }


	public Biblioteka(String naziv, String adresa, String brojTelefona, String vremeRada, ArrayList<Clan> clanovi,
			ArrayList<Bibliotekar> bibliotekari, ArrayList<Admin> admini, ArrayList<TipClanarine> tipClanarine,
			ArrayList<Primerak> primerak, ArrayList<Knjiga> knjiga, ArrayList<Iznajmljivanje> iznajmljivanje) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.vremeRada = vremeRada;
		this.clanovi = clanovi;
		this.bibliotekari = bibliotekari;
		this.admini = admini;
		this.tipClanarine = tipClanarine;
		this.primerak = primerak;
		this.knjiga = knjiga;
		this.iznajmljivanje = iznajmljivanje;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getBrojTelefona() {
		return brojTelefona;
	}


	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}


	public String getVremeRada() {
		return vremeRada;
	}


	public void setVremeRada(String vremeRada) {
		this.vremeRada = vremeRada;
	}


	public ArrayList<Clan> getClanovi() {
		return clanovi;
	}


	public void setClanovi(ArrayList<Clan> clanovi) {
		this.clanovi = clanovi;
	}


	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}


	public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}


	public ArrayList<Admin> getAdmini() {
		return admini;
	}


	public void setAdmini(ArrayList<Admin> admini) {
		this.admini = admini;
	}


	public ArrayList<TipClanarine> getTipClanarine() {
		return tipClanarine;
	}


	public void setTipClanarine(ArrayList<TipClanarine> tipClanarine) {
		this.tipClanarine = tipClanarine;
	}


	public ArrayList<Primerak> getPrimerak() {
		return primerak;
	}


	public void setPrimerak(ArrayList<Primerak> primerak) {
		this.primerak = primerak;
	}


	public ArrayList<Knjiga> getKnjiga() {
		return knjiga;
	}


	public void setKnjiga(ArrayList<Knjiga> knjiga) {
		this.knjiga = knjiga;
	}
	

	public ArrayList<ZanrKnjige> getZanrovi() {
		return zanrovi;
	}


	public void setZanrovi(ArrayList<ZanrKnjige> zanrovi) {
		this.zanrovi = zanrovi;
	}


	public ArrayList<Iznajmljivanje> getIznajmljivanje() {
		return iznajmljivanje;
	}


	public void setIznajmljivanje(ArrayList<Iznajmljivanje> iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}


	public void ucitajClanove() {
        try {
            File korisniciFile = new File("src/fajlovi/clanovi.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
            	
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String adresa = lineSplit[3];
                String jmbg = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                String brojClanskeKarte = lineSplit[6];
                String tipClanarine = lineSplit[7];
                LocalDate datumUplate = LocalDate.parse(lineSplit[8]);
                int brojMeseci = Integer.parseInt(lineSplit[9]);
                boolean aktivnost = Boolean.parseBoolean(lineSplit[10]);
    			LocalDate uplata = datumUplate;
    			LocalDate kraj = uplata.plusDays(brojMeseci*30);
    			if(kraj.isAfter(LocalDate.now())){
    				aktivnost = false;
    			}else {
    				aktivnost = true;
    			}
                
                
                Clan clan = new Clan(id,ime, prezime, adresa, jmbg, pol,brojClanskeKarte,tipClanarine,datumUplate,brojMeseci,aktivnost);
                this.clanovi.add(clan);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public void ucitajZanrove() {
        try {
            File korisniciFile = new File("src/fajlovi/zanrovi.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String oznaka = lineSplit[0];
                String opis = lineSplit[1]; 
                ZanrKnjige zanr = new ZanrKnjige(oznaka,opis);
                this.zanrovi.add(zanr);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
        
    }
	public void snimiZanr(Boolean tip,String fajl) {
		String sadrzaj = "";
		for (ZanrKnjige zanr: this.zanrovi) {
			sadrzaj += zanr.getOznaka() +"|"+ zanr.getOpis() + "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/"+fajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,tip));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	
	public void ucitajAdmine() {
        try {
            File korisniciFile = new File("src/fajlovi/admini.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String adresa = lineSplit[3];
                String jmbg = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                String korisnickoIme = lineSplit[6];
            	String korisnickaSifra = lineSplit[7];
            	double plata = Double.parseDouble(lineSplit[8]);
                Admin admin = new Admin(id,ime, prezime, adresa, jmbg, pol,korisnickoIme,korisnickaSifra,plata);
                this.admini.add(admin);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public void ucitajBibliotekare() {
        try {
            File korisniciFile = new File("src/fajlovi/bibliotekari.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String ime = lineSplit[1];
                String prezime = lineSplit[2];
                String adresa = lineSplit[3];
                String jmbg = lineSplit[4];
                Pol pol = Pol.valueOf(lineSplit[5]);
                String korisnickoIme = lineSplit[6];
            	String korisnickaSifra = lineSplit[7];
            	double plata = Double.parseDouble(lineSplit[8]);
                
                
                Bibliotekar bibliotekar = new Bibliotekar(id,ime, prezime, adresa, jmbg, pol,korisnickoIme,korisnickaSifra,plata);
                this.bibliotekari.add(bibliotekar);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
        
    }
	public void ucitajTipClanarine() {
        try {
            File korisniciFile = new File("src/fajlovi/tipClan.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String naziv = lineSplit[1];
                double cena = Double.parseDouble(lineSplit[2]);
  
                TipClanarine tip  = new TipClanarine(id,naziv,cena);
                this.tipClanarine.add(tip);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
        
    }
	public void snimiTipClanarine(Boolean tipo,String fajl) {
		String sadrzaj = "";
		for (TipClanarine tip: this.tipClanarine) {
			sadrzaj += tip.getId() + "|" + tip.getNaziv() + "|" + tip.getCena()+ "|"+ "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/"+fajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,tipo));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void ucitajKnjige() {
        try {
            File korisniciFile = new File("src/fajlovi/knjige.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String id = lineSplit[0];
                String naslov = lineSplit[1];
                String orgNaslov = lineSplit[2];
                String pisac = lineSplit[3];
                int godinaIzdavanja = Integer.parseInt(lineSplit[4]);
                String jezik = lineSplit[5];
                String opis = lineSplit[6];
                String zanr = lineSplit[7];
                
                
                Knjiga knjiga  = new Knjiga(id,naslov,orgNaslov,pisac,godinaIzdavanja,jezik,opis,zanr);
                this.knjiga.add(knjiga);
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	public ZanrKnjige nadjiZanr(String id) {
        ZanrKnjige trazeni = null;
        for(int i = 0; i < this.zanrovi.size(); i++) {
            if (this.zanrovi.get(i).getOznaka() == id) {
                trazeni = this.zanrovi.get(i);
            }
        }
        return trazeni;
        }
	public Knjiga nadjiKnjigu(String id) {
        Knjiga trazeni = null;
        for(int i = 0; i < this.knjiga.size(); i++) {
            if (this.knjiga.get(i).getId() == id) {
                trazeni = this.knjiga.get(i);
            }
        }
        return trazeni;
        }
	public TipClanarine nadjiTip(String id) {
        TipClanarine trazeni = null;
        for(int i = 0; i < this.tipClanarine.size(); i++) {
            if (this.tipClanarine.get(i).getId() == id) {
                trazeni = this.tipClanarine.get(i);
            }
        }
        return trazeni;
        }
	
	
	public void ucitajPrimerakKnjige() {
        try {
            File korisniciFile = new File("src/fajlovi/primerci.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String knjiga = lineSplit[0];
                int brojStrana = Integer.parseInt(lineSplit[1]);
                Povez povez = Povez.valueOf(lineSplit[2]);;
                int godinaStampanja = Integer.parseInt(lineSplit[3]);
                String jezikStampanja = lineSplit[4];
                Boolean dostupnost = Boolean.parseBoolean(lineSplit[5]);
                String id = String.valueOf(lineSplit[6]);
                
                
                Primerak primerak  = new Primerak(knjiga,brojStrana,povez,godinaStampanja,jezikStampanja,dostupnost,id);
                this.primerak.add(primerak);
                
                
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	
	public void snimiClanove(String fajl,boolean tip) {
		String sadrzaj = "";
		for (Clan clan: this.clanovi) {
			LocalDate uplata = clan.getDatumUplate();
			Integer brojMeseci = clan.getBrojMeseci();
			LocalDate kraj = uplata.plusDays(brojMeseci*30);
			if(kraj.isAfter(LocalDate.now())){
				clan.setAktivnost(false);
			}else {
				clan.setAktivnost(true);
			}
			sadrzaj += clan.getId() + "|" + clan.getIme() + "|" + clan.getPrezime() + "|" + clan.getAdresa() + 
					"|" + clan.getJMBG() +"|" + clan.getPolovi() + "|" + clan.getBrojClanskeKarte() + "|" + clan.getTip() + "|"+ clan.getDatumUplate() + "|"+ clan.getBrojMeseci() + "|"+ clan.isAktivnost() + "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/"+fajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,tip));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiAdmine(String fajl,boolean tip) {
		String sadrzaj = "";
		for (Admin admin: this.admini) {
			sadrzaj += admin.getId() + "|" + admin.getIme() + "|" + admin.getPrezime() + "|" + admin.getAdresa() + 
					"|" + admin.getJMBG() +"|"+ admin.getPolovi() + "|" + admin.getKorisnickoIme() + "|" + admin.getKorisnickaSifra() + "|"+ admin.getPlata() + "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/"+fajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,tip));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
		
	}
	public void snimiBibliotekare(String fajl,boolean tip) {
		String sadrzaj = "";
		for (Bibliotekar bibliotekar: this.bibliotekari) {
			sadrzaj += bibliotekar.getId() + "|" + bibliotekar.getIme() + "|" + bibliotekar.getPrezime() + "|" + bibliotekar.getAdresa() + 
					"|" + bibliotekar.getJMBG()+ "|"+ bibliotekar.getPolovi() + "|" + bibliotekar.getKorisnickoIme() + "|" + bibliotekar.getKorisnickaSifra() + "|"+ bibliotekar.getPlata() + "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/"+fajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,tip));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void snimiKnjige(String fajl,boolean tip) {
		String sadrzaj = "";
		for (Knjiga knjiga: this.knjiga) {
			sadrzaj += knjiga.getId() + "|" + knjiga.getNaslov() + "|"+ knjiga.getOrgNaslov() + "|"+ knjiga.getPisac() + "|"+ knjiga.getGodinaIzdavanja() + "|"+ knjiga.getJezik() + "|"+ knjiga.getOpis() + "|"+ knjiga.getZanr()  + "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/"+fajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,tip));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void snimiPrimerke(String fajl,boolean tip) {
		String sadrzaj = "";
		for (Primerak primerak: this.primerak) {
			sadrzaj += primerak.getKnjiga() + "|" + primerak.getBrojStrana() + "|"+ primerak.getPovez() + "|"+ primerak.getGodinaStampanja() + "|"+ primerak.getJezikStampanja() + "|"+ primerak.isDostupnost()  + "|" + primerak.getId() +"\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/"+fajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,tip));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void ucitajIznajmljeno() {
        try {
            File korisniciFile = new File("src/fajlovi/iznajmljeno.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            System.out.println("sss");
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                System.out.println(lineSplit[2]);
                String zaposleni = lineSplit[0];
                String clan = lineSplit[1];
                LocalDate datumIznajmljivanja =LocalDate.parse(lineSplit[2]);
                LocalDate datumVracanja =LocalDate.parse(lineSplit[3]);
                String primerak =lineSplit[4];
                String naslovKnjige = lineSplit[5];
                
                
                
                Iznajmljivanje knjiga  = new Iznajmljivanje(zaposleni,clan,datumIznajmljivanja,datumVracanja,primerak,naslovKnjige);
                this.iznajmljivanje.add(knjiga);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }

	
	
	
	
	
	
	
	
}
