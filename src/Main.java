//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import knjige.Biblioteka;
//import knjige.Knjiga;
//import knjige.Povez;
//import knjige.Primerak;
//import knjige.ZanrKnjige;
//import ljudi.Admin;
//import ljudi.Bibliotekar;
//import ljudi.Clan;
//import ljudi.Pol;
//import ljudi.TipClanarine;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        Biblioteka biblioteka = new Biblioteka();
//        Boolean boolTry = new Boolean(true);
//        
//        // pravljenje i zapisivanje testiranje
//        
//        
//        ZanrKnjige zanr = new ZanrKnjige("1111","aaaaa");
//       
//        Knjiga knjiga = new Knjiga("11","BRATE","MOLIMTE","RADI",1389,"KONJ","vrlodobra knjiga",zanr);
//        ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
//        knjige.add(knjiga);
//        biblioteka.setKnjiga(knjige);
//        biblioteka.snimiKnjige();
//        
//        Knjiga knjigaO = new Knjiga("11","BRATE","MOLIMTE","RADI",1389,"KONJ","vrlodobra knjiga",zanr);
//        
//        Primerak primerak = new Primerak(knjigaO,30,Povez.valueOf("MEK"),1389,"Spanski",boolTry);
//        ArrayList<Primerak> primerci = new ArrayList<Primerak>();
//        primerci.add(primerak);
//        biblioteka.setPrimerak(primerci);
//        biblioteka.snimiPrimerke();
//        
//       // Admin admin = new Admin("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA","DASDASD",123123123.22);
//       // ArrayList<Admin> admini = new ArrayList<Admin>();
//       // admini.add(admin);
//      //  biblioteka.setAdmini(admini);
//       // biblioteka.snimiAdmine("admini.txt",true);
//        
//     
//        
////        ZanrKnjige zanr2 = new ZanrKnjige("HOROR","STRASNO");
////        ArrayList<ZanrKnjige> zanrovi = new ArrayList<ZanrKnjige>();
////        zanrovi.add(zanr2);
////        biblioteka.setZanrovi(zanrovi);
////        biblioteka.snimiZanr();
//        
//        
//            
//      //  Bibliotekar bibliotekar = new Bibliotekar("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA","DASDASD",123123123.22);
//     //   ArrayList<Bibliotekar> bibliotekari = new ArrayList<Bibliotekar>();
//     //   bibliotekari.add(bibliotekar);
//     //   biblioteka.setBibliotekari(bibliotekari);
//     //   biblioteka.snimiBibliotekare();
//        
//        
//        
//        TipClanarine tip = new TipClanarine("12","DECIJA",200.33);
//        
//        LocalDate date = LocalDate.of(2020, 1, 8);
//        
//        
////        
////        Clan clan = new Clan("002","Milorad","Djurica","Bulevar","1231231231",Pol.valueOf("MUSKI"),"sIFRA",tip,date,13,boolTry);
////        ArrayList<Clan> clanovi = new ArrayList<Clan>();
////        clanovi.add(clan);
////        biblioteka.setClanovi(clanovi);
////        biblioteka.snimiClanove();
//        
//       // TipClanarine tipClanarine = new TipClanarine("002321","Decija",150.00);
//     //   ArrayList<TipClanarine> tipClan = new ArrayList<TipClanarine>();
//      //  tipClan.add(tipClanarine);
//      //  biblioteka.setTipClanarine(tipClan);
//       // biblioteka.snimiTipClanarine();
//        
//        
//        
//        // ucitavanje iz fajla testiranje
//        
////        biblioteka.ucitajClanove();
////        for(Clan clan1 : biblioteka.getClanovi()) {
////            System.out.println(clan1.getId());
////
////        }
////        
////        biblioteka.ucitajTipClanarine();
////        for(TipClanarine tipclan1 : biblioteka.getTipClanarine()) {
////            System.out.println(tipclan1.getNaziv());
////
////        }
////        
////        biblioteka.ucitajKnjige();
////        for(Knjiga knjiga2 : biblioteka.getKnjiga()) {
////            System.out.println(knjiga2.getOpis());
////
////        }
////        
////        biblioteka.ucitajBibliotekare();
////        for(Bibliotekar bibliotekar1 : biblioteka.getBibliotekari()) {
////            System.out.println(bibliotekar1.getKorisnickoIme());
////        
////        }
////        biblioteka.ucitajZanrove();
////        for(ZanrKnjige zanr1 : biblioteka.getZanrovi()) {
////            System.out.println(zanr1.getOpis());
////        }
////        
////   //    biblioteka.ucitajAdmine();
////    //    for(Admin admin1 : biblioteka.getAdmini()) {
////   //         System.out.println(admin1.getId());
////  //      }
////        
////        biblioteka.ucitajPrimerakKnjige();
////        for(Primerak primerak2 : biblioteka.getPrimerak()) {
////            System.out.println(primerak2.getBrojStrana());
//        }
//        
//        
//     
//
//
//    }
//    
//}