package main;

import java.util.Random;
import java.util.Scanner;


public class Jatek 
{
    private final static Random RND = new Random();
    private final static Scanner SC = new Scanner(System.in);


    int korDb;
    int fogadId;
    final int MAXKORSZAM = 5;
    Csiga csigak[];
    String csuszasLista[];
    int kor;

    public Jatek(int korDb)
    {
        setKorDb(korDb);
        this.fogadId = 0;
        this.csigak = new Csiga[3];
        this.csuszasLista = new String[] {"", "", ""};
        this.csigaSzulet();
        
    }
    
    private void setKorDb(int kor)
    {
        if(kor > MAXKORSZAM || kor <= 0)
        {
            this.korDb = 5;
        }
        else
        {
            this.korDb = kor;
        }
    }
    
    public void csigaSzulet()
    {

        this.csigak[0] = new Csiga("piros", "\u001B[31m","Gáspár");
        this.csigak[1] = new Csiga("kék", "\u001B[34m", "Bingus");
        this.csigak[2] = new Csiga("zöld", "\u001B[32m", "Ernő");
    }
    
    
    public void fogadas()               
    {
        int valasztas;
        do
        {            
            System.out.printf("Üdvözöllek a Csigaverseny fergeteges játékában\n"
                              + "Kérlek tedd meg tétjeidet!\n"
                              + "\t1) " + csigak[0].getSzin() + " csiga - " + csigak[0].getCsNev() + "\n"
                              + "\t2) " + csigak[1].getSzin() + " csiga - " + csigak[1].getCsNev() + "\n"
                              + "\t3) " + csigak[2].getSzin() + " csiga - " + csigak[2].getCsNev() + "\n>");
            valasztas = SC.nextInt();
        }
        while (!(valasztas == 1 || valasztas == 2 || valasztas == 3));
        

        this.fogadId = valasztas-1;

    }
    
    

    
    public void csigagyorsito() {
    if (RND.nextInt(5) == 0) { 
        int melyiket = RND.nextInt(3);
        this.csigak[melyiket].setBonus(true);
    }
}
    
    public String status()
    {
        return "";
    }
    
    public void csusznak()
    {
        fogadas();
        SC.nextLine();
        
        
        for (int i = 0; i < korDb; i++) {
            
            
            
            csigagyorsito();
            for (int j = 0; j < csigak.length; j++) {
                int mennyit = RND.nextInt(0,4);
                if(mennyit == 0 && csigak[j].isBonus()){
                    csuszasLista[j] += "=";
                }
                for (int k = 0; k < mennyit; k++) {
                    
                    if(csigak[j].isBonus()){
                        csuszasLista[j] += "==";
                    }else{
                        csuszasLista[j] += "-";
                    }
                    
                }
                
                
            }
            this.kor +=1;
            kepernyo();
                    
            for (int j = 0; j < csigak.length; j++) {
                this.csigak[j].setBonus(false);
            }
            

            
            System.out.printf("Press enter to continue: \n");
            SC.nextLine();
            
        }
        if(fogadCheck()){
            System.out.printf(csigak[fogadId].getSzinKod() + "A te csigád (%s) nyert!!!\033[0m\n", csigak[fogadId].getCsNev());
        }else{
            System.out.println("Veszített a csigád :((((");
        }
    }
    
    
    public boolean fogadCheck(){
        int nyertes = 0;
        for (int i = 0; i < csuszasLista.length; i++) {
            if(csuszasLista[i].length()> csuszasLista[nyertes].length()){
                nyertes = i;
            }
        }
        
        if(fogadId == nyertes){
            return true;
        }else{
            return false;
        }
    }
    
 public void kepernyo() 
    {

        String alapUt = "║                                                               ║";
        int kepSzelesseg = alapUt.length() - 2;

        String[] csigaVonal = new String[3];
        
        for (int i = 0; i < csigak.length; i++) 
        {
            String szin = csigak[i].getSzinKod();
            csigaVonal[i] = "║ " + szin + csuszasLista[i] + csigak[i].getCsTest() +"\033[0m" + " ".repeat(kepSzelesseg - csuszasLista[i].length()) + "║";
        }
        
        System.out.println("╔════════════════════════════════════╦═════════════════════════╦═══════════╗");
        System.out.printf("║ %s%-20s 🐌.   \033[0m    ║  %s  ║ KÖR: %02d. ║\n", csigak[0].getSzinKod(), csigak[0].getCsNev() + " csiga", csigak[0].isBonus() ? "\033[33mBONUS (2× speed) \033[0m" : " ".repeat(18), kor);
        System.out.printf("║ %s%-20s 🐌.     \033[0m  ║  %s  ╚════════════╣\n", csigak[1].getSzinKod(), csigak[1].getCsNev() + " csiga", csigak[1].isBonus() ? "\033[33mBONUS (2× speed) \033[0m" : " ".repeat(18));
        System.out.printf("║ %s%-20s 🐌.     \033[0m  ║  %s             ║\n", csigak[2].getSzinKod(), csigak[2].getCsNev() + " csiga", csigak[2].isBonus() ? "\033[33mBONUS (2× speed) \033[0m" : " ".repeat(18));
        System.out.println("╠════════════════════════════════════╩═════════════════════════════════════╣");
        System.out.printf("║ %-64s ║\n", "[" + csigak[0].getCsNev() + "]");
        System.out.println(csigaVonal[0]);
        System.out.printf("║ %-64s ║\n", "[" + csigak[1].getCsNev() + "]");
        System.out.println(csigaVonal[1]);
        System.out.printf("║ %-64s ║\n", "[" + csigak[2].getCsNev() + "]");
        System.out.println(csigaVonal[2]);
        System.out.println("║                                             ╔═══════════════════════╣");
        System.out.printf("║                                             ║ FOGADÁS: %s%-8s \033[0m ║\n", csigak[fogadId].getSzinKod(), "[" + csigak[fogadId].getCsNev() + "]");
        System.out.println("╚═══════════════════════════════════════════════════╩══════════════════════╝");
        System.out.println();
    
    }

    
        
    
    
    
}
