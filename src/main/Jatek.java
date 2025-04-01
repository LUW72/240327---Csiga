package main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Jatek 
{
<<<<<<< HEAD
    private final static Random RND = new Random();
    private final static Scanner SC = new Scanner(System.in);
=======
    public final static Random RND = new Random();
    public final static Scanner SC = new Scanner(System.in);
>>>>>>> 2f29849ccd93140f2255691f98393f14d73ca83a
    
    int korDb;
    int kor;
    int fogadId;
    final int MAXKORSZAM = 5;
    Csiga csigak[];
    String csuszasLista[] = {"--===", "--", "-======="};

    public Jatek(int korDb)
    {
        setKordDb(korDb);
        this.fogadId = 0;
        this.csigak = new Csiga[3];
        this.csuszasLista = new String[] {"", "", ""};
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
        Csiga piros = new Csiga("piros", "\u001B[31m","Gáspár");
        this.csigak[0] = piros;
        Csiga kek = new Csiga("kék", "\u001B[34m", "Bingus");
        this.csigak[1] = piros;
        Csiga zold = new Csiga("zöld", "\u001B[32m", "Ernő");
        this.csigak[2] = zold;
    }
    
    public void fogadas()
<<<<<<< HEAD
    {                
=======
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
>>>>>>> 2f29849ccd93140f2255691f98393f14d73ca83a
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
<<<<<<< HEAD

=======
        String alapUt = "║                                                                    ║";
        String csiga1 = "\033[34m" + csuszasLista[0]; // Blue
        String csiga2 = "\033[31m" + csuszasLista[1]; // Red
        String csiga3 = "\033[32m" + csuszasLista[2]; // Green

        int szelesseg = alapUt.length() - 2;
        String vonal1 = "║ " + csiga1 + "Ov\033[0m" + " ".repeat(szelesseg - csiga1.length()) + "║";
        String vonal2 = "║ " + csiga2 + "Ov\033[0m" + " ".repeat(szelesseg - csiga2.length()) + "║";
        String vonal3 = "║ " + csiga3 + "Ov\033[0m" + " ".repeat(szelesseg - csiga3.length()) + "║";

        String alapnev = "║ [B]                                                              ║";
        
        
        String csigaNevKiir1 = "║ " + csiga1 + "Ov\033[0m" + " ".repeat(szelesseg - csiga1.length()) + "║";
        String csigaNevKiir2 = "║ " + csiga2 + "Ov\033[0m" + " ".repeat(szelesseg - csiga2.length()) + "║";
        String csigaNevKiir3 = "║ " + csiga3 + "Ov\033[0m" + " ".repeat(szelesseg - csiga3.length()) + "║";
        
        
        System.out.println("╔════════════════════════════════════╦═════════════════════════╦═══════════╗");
        System.out.println("║ [B] csiga          02 lépés    ║  [BONUS (2× speed)]  ║ KÖR: 01. ║");
        System.out.println("║ [R] csiga          03 lépés    ║  .                   ╚═══════════╣");
        System.out.println("║ [G] csiga          01 lépés    ║  .                              ║");
        System.out.println("╠════════════════════════════════════╩═════════════════════════════════════╣");
        System.out.printf("║ %-64s ║\n", "[Tesztnév]");
        System.out.println(vonal1);
        System.out.println("║ [R]                                                              ║");
        System.out.println(vonal2);
        System.out.println("║ [G]                                                              ║");
        System.out.println(vonal3);
        System.out.println("║                                             ╔══════════════════════╣");
        System.out.println("║                                             ║ FOGADÁS: [KÉK]     ║");
        System.out.println("╚═══════════════════════════════════════════════════╩══════════════════════╝");
        System.out.println();
    
>>>>>>> 2f29849ccd93140f2255691f98393f14d73ca83a
    }

    
        
    
    
    
}
