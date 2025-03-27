package main;

import java.util.Random;


public class Jatek 
{
    public final static Random RND = new Random();
    
    int korDb;
    int kor;
    int fogadId;
    final int MAXKORSZAM = 5;
    Csiga csigak[];
    String csuszasLista[];

    public Jatek(int korDb)
    {
        setKordDb(korDb);
        this.kor = 1;
        this.fogadId = 0;
        
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
        
    }
    
    public int fogadas()
    {
        return 0;
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
        
    }
    
    
}
