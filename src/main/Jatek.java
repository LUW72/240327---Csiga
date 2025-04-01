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
        this.csuszasLista = new String[] {"", "", ""};
        this.csigaSzulet();
        
    }
    
    public void setKordDb(int kor)
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
    {                
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

    }
    
    
}
