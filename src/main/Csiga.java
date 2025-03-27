package main;


public class Csiga 
{
    int csuszas;
    boolean bonus;
    String szin;
    String szinKod;
    String csTest;

    public Csiga(String szin, String szinKod)
    {
        this.csuszas = 0;
        this.bonus = false;
        this.szin = szin;
        this.szinKod = szinKod;
        this.csTest = "Ov";
    }
    
    public void csuszasHozzaad(int csusz)
    {
        this.csuszas += csusz;
    }
    
    public int getCsuszas(){return csuszas;}
    public boolean isBonus(){return bonus;}
    public String getSzin(){return szin;}
    public String getSzinKod(){return szinKod;}
    public String getCsTest(){return csTest;}
    
    public void setCsuszas(int csuszas){this.csuszas = csuszas;}
    public void setBonus(boolean bonus){this.bonus = bonus;}
   
    
}
