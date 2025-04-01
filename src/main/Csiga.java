package main;


public class Csiga 
{
    int csuszas;
    boolean bonus;
    String szin;
    String szinKod;
    String csTest;
    String csNev;
<<<<<<< HEAD
       
=======
>>>>>>> 2f29849ccd93140f2255691f98393f14d73ca83a

    public Csiga(String szin, String szinKod, String csNev)
    {
        this.csuszas = 0;
        this.bonus = false;
        this.szin = szin;
        this.szinKod = szinKod;
        this.csTest = "Ov";
        this.csNev = csNev;
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
<<<<<<< HEAD
    public String getCsNev(){return csNev;}
=======
    public String getNev() {return csNev;}
>>>>>>> 2f29849ccd93140f2255691f98393f14d73ca83a
    
    public void setCsuszas(int csuszas){this.csuszas = csuszas;}
    public void setBonus(boolean bonus){this.bonus = bonus;}
    public void setCsNev(String csNev){this.csNev = csNev;}
   
    
}
