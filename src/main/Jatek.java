package main;

import java.util.Random;
import java.util.Scanner;


public class Jatek 
{
    public final static Random RND = new Random();
    public final static Scanner SC = new Scanner(System.in);
    
    int korDb;
    int kor;
    int fogadId;
    final int MAXKORSZAM = 5;
    Csiga csigak[];
    String csuszasLista[] = {"--===", "--", "-======="};

    public Jatek(int korDb)
    {
        setKordDb(korDb);
        this.kor = 1;
        this.fogadId = 0;
        
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
    
    public void megnezKorDb()
    {
        
    }
    
    public int csigagyorsito()
    {
        return 0;
    }
    
    public String status()
    {
        return "";
    }
    
    public void csusznak()
    {
        
    }
    
    public void kepernyo() 
    {
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
    
    }

    
        
    
    
    
}
