
import java.time.LocalDate;
import java.util.ArrayList;

import knjige.Biblioteka;
import knjige.Knjiga;
import knjige.ZanrKnjige;
import ljudi.Admin;
import ljudi.Bibliotekar;
import ljudi.Clan;
import ljudi.Pol;
import ljudi.TipClanarine;


public class Main {

    public static void main(String[] args) {
        Biblioteka biblioteka = new Biblioteka();
       
        
        // pravljenje i zapisivanje testiranje
        
        ZanrKnjige zanr = new ZanrKnjige("1111","aaaaa");
        Knjiga knjiga = new Knjiga("11","BRATE","MOLIMTE","RADI",1389,"KONJ","vrlodobra knjiga",zanr);
        ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
        knjige.add(knjiga);
        biblioteka.setKnjiga(knjige);
        biblioteka.snimiKnjige();
        
        
        
        
        Admin admin = new Admin("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA","DASDASD",123123123.22);
        ArrayList<Admin> admini = new ArrayList<Admin>();
        admini.add(admin);
        biblioteka.setAdmini(admini);
        biblioteka.snimiAdmine();
        
        
        ZanrKnjige zanr2 = new ZanrKnjige("HOROR","STRASNO");
        ArrayList<ZanrKnjige> zanrovi = new ArrayList<ZanrKnjige>();
        zanrovi.add(zanr2);
        biblioteka.setZanrovi(zanrovi);
        biblioteka.snimiZanr();
        
        
            
        Bibliotekar bibliotekar = new Bibliotekar("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA","DASDASD",123123123.22);
        ArrayList<Bibliotekar> bibliotekari = new ArrayList<Bibliotekar>();
        bibliotekari.add(bibliotekar);
        biblioteka.setBibliotekari(bibliotekari);
        biblioteka.snimiBibliotekare();
        
        
        
        TipClanarine tip = new TipClanarine("12","DECIJA",200.33);
        LocalDate date = LocalDate.of(2020, 1, 8);
        Boolean boolTry = new Boolean(true);
        
        
        Clan clan = new Clan("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA",tip,date,13,boolTry);
        ArrayList<Clan> clanovi = new ArrayList<Clan>();
        clanovi.add(clan);
        biblioteka.setClanovi(clanovi);
        biblioteka.snimiClanove();
        
        
        // ucitavanje iz fajla testiranje
        
        biblioteka.ucitajClanove();
        for(Clan clan1 : biblioteka.getClanovi()) {
            System.out.println(clan1.getId());

        }
        
        
        biblioteka.ucitajKnjige();
        for(Knjiga knjiga2 : biblioteka.getKnjiga()) {
            System.out.println(knjiga2.getOpis());

        }
        
        biblioteka.ucitajBibliotekare();
        for(Bibliotekar bibliotekar1 : biblioteka.getBibliotekari()) {
            System.out.println(bibliotekar1.getKorisnickoIme());
        
        }
        biblioteka.ucitajZanrove();
        for(ZanrKnjige zanr1 : biblioteka.getZanrovi()) {
            System.out.println(zanr1.getOpis());
        }
         
        
        


    }
    
}