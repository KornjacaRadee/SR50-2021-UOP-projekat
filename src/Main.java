
import java.util.ArrayList;

import knjige.Biblioteka;
import knjige.Knjiga;
import knjige.ZanrKnjige;
import ljudi.Admin;
import ljudi.Bibliotekar;
import ljudi.Clan;
import ljudi.Pol;


public class Main {

    public static void main(String[] args) {
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.ucitajKnjige();
        for(Knjiga knjiga : biblioteka.getKnjiga()) {
            System.out.println(knjiga.getOpis());

        }
        ZanrKnjige zanr = new ZanrKnjige("1111","aaaaa");
        
        
        Knjiga knjiga = new Knjiga("11","BRATE","MOLIMTE","RADI",1389,"KONJ","OOOOOO",zanr);
        ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
        knjige.add(knjiga);
        biblioteka.setKnjiga(knjige);
        biblioteka.snimiKnjige();
        
        
        
        
        Admin admin = new Admin("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA","DASDASD",123123123.22);
        ArrayList<Admin> admini = new ArrayList<Admin>();
        admini.add(admin);
        biblioteka.setAdmini(admini);
        biblioteka.snimiAdmine();
        
        
        biblioteka.ucitajAdmine();
        for(Admin admin1 : biblioteka.getAdmini()) {
            System.out.println(admin1.getKorisnickoIme());
            
        Bibliotekar bibliotekar = new Bibliotekar("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA","DASDASD",123123123.22);
        ArrayList<Bibliotekar> bibliotekari = new ArrayList<Bibliotekar>();
        bibliotekari.add(bibliotekar);
        biblioteka.setBibliotekari(bibliotekari);
        biblioteka.snimiBibliotekare();

        }
        biblioteka.ucitajBibliotekare();
        for(Bibliotekar bibliotekar : biblioteka.getBibliotekari()) {
            System.out.println(bibliotekar.getKorisnickoIme());
        
        }
         
        
        


    }
    
}