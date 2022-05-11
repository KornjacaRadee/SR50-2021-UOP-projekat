
import java.util.ArrayList;

import knjige.Biblioteka;
import ljudi.Admin;
import ljudi.Bibliotekar;
import ljudi.Pol;


public class Main {

    public static void main(String[] args) {
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.ucitajAdmine();
        for(Admin admin : biblioteka.getAdmini()) {
            System.out.println(admin.getKorisnickoIme());	

        }
        Admin admin = new Admin(002, "ALEKSANDAR", "DOKTORIRAOJAVU", "12313212312312", "BULEVAR JAVE", Pol.valueOf("MUSKI"), "RADI", "MOLIMTE", 9999999.00);
        ArrayList<Admin> admini = new ArrayList<Admin>();
        admini.add(admin);
        biblioteka.setAdmini(admini);
        biblioteka.snimiAdmine();

    }
    
}