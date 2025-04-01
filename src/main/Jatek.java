package main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Jatek 
{
    private final static Random RND = new Random();
    private final static Scanner SC = new Scanner(System.in);
    
    int korDb;
    int kor;
    int fogadId;
    final int MAXKORSZAM = 5;
    Csiga csigak[];
    String csuszasLista[];

    public Jatek(int korDb)
    {
        setKordDb(korDb);
        this.fogadId = 0;
        this.csigak = new Csiga[3];
        this.csuszasLista = new String[] {"--===", "---", "-======="};
        this.csigaSzulet();
        
    }
    
    private void setKordDb(int kor)
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
        Csiga piros = new Csiga("piros", "\033[31m", "Gáspár");
        this.csigak[0] = piros;
        Csiga kek = new Csiga("kék", "\033[34m", "Bingus");
        this.csigak[1] = kek;
        Csiga zold = new Csiga("zöld", "\033[32m", "Ernő");
        this.csigak[2] = zold;
        
        
    }
    
    public void fogadas()               
    {
        int valasztas;
        do
        {            
            System.out.printf("Üdvözöllek a Csigaverseny fergeteges játékában\n"
                              + "Kérlek tedd meg tétjeidet!\n"
                              + "\t1) Kék csiga\n"
                              + "\t2) Piros csiga\n"
                              + "\t3) Zöld csiga\n>");
            valasztas = SC.nextInt();
        }
        while (!(valasztas == 1 || valasztas == 2 || valasztas == 3));
        
        this.fogadId = valasztas;
    }
    
    
    public void csigagyorsito()
    {
        int gyorsitsunk = RND.nextInt(0,9);
        if(gyorsitsunk == 0 || gyorsitsunk == 1){
            int melyiket = RND.nextInt(0,3);
            
            this.csigak[melyiket].setBonus(true);
            System.out.println(csigak[melyiket].getSzin());
        }
    }
    
    public String status()
    {
        return "";
    }
    
    public void csusznak()
    {
        //fogadas();
        for (int i = 0; i < korDb; i++) {
            csigagyorsito();
            for (int j = 0; j < csigak.length; j++) {
                int mennyit = RND.nextInt(0,4);
                csigak[j].setCsuszas(mennyit);
                if(mennyit == 0 && csigak[j].isBonus()){
                    csuszasLista[j] += "=";
                }
                for (int k = 0; k < mennyit; k++) {
                    
                    if(csigak[j].isBonus()){
                        csuszasLista[j] += "==";
                    }else{
                        csuszasLista[j] += "_";
                    }
                    
                }
                this.csigak[j].setBonus(false);
            }
            for (int j = 0; j < csuszasLista.length; j++) {
                System.out.println(csuszasLista[j] + "oV");
            }
            System.out.println("Press enter to continue: ");
            SC.nextLine();
            
            //System.out.println(Arrays.toString(csuszasLista));
            
        }
        
        fogadCheck();
        
    }
    
    public void fogadCheck(){
        int nyertes = 0;
        for (int i = 0; i < csuszasLista.length; i++) {
            if(csuszasLista[i].length()> csuszasLista[nyertes].length()){
                nyertes = i;
            }
        }
        System.out.println(nyertes);
        
        if(fogadId == nyertes){
            System.out.println("big win!!!");
        }else{
            System.out.println("much sad");
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
       
        csigak[0].bonus = true;
        fogadId = 0;
        
        System.out.println("╔════════════════════════════════════╦═════════════════════════╦═══════════╗");
        System.out.printf("║ %s%-20s 🐌.   \033[0m    ║  %s  ║ KÖR: %02d. ║\n", csigak[0].getSzinKod(), csigak[0].getCsNev() + " csiga", csigak[0].isBonus() ? "BONUS (2× speed)  " : " ".repeat(18), kor);
        System.out.printf("║ %s%-20s 🐌.     \033[0m  ║  %s  ╚════════════╣\n", csigak[1].getSzinKod(), csigak[1].getCsNev() + " csiga", csigak[1].isBonus() ? "BONUS (2× speed)  " : " ".repeat(18));
        System.out.printf("║ %s%-20s 🐌.     \033[0m  ║  %s             ║\n", csigak[2].getSzinKod(), csigak[2].getCsNev() + " csiga", csigak[2].isBonus() ? "BONUS (2× speed)  " : " ".repeat(18));
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
