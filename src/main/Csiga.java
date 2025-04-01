package main;


public class Csiga 
{
    boolean bonus;
    String szin;
    String szinKod;
    String csTest;
    String csNev;


    public Csiga(String szin, String szinKod, String csNev)
    {
        this.bonus = false;
        this.szin = szin;
        this.szinKod = szinKod;
        this.csTest = "Ov";
        this.csNev = csNev;
    }
    
    public boolean isBonus(){return bonus;}
    public String getSzin(){return szin;}
    public String getSzinKod(){return szinKod;}
    public String getCsTest(){return csTest;}
    public String getCsNev(){return csNev;}
    
    public void setBonus(boolean bonus){this.bonus = bonus;}
    public void setCsNev(String csNev){this.csNev = csNev;}
   
    
}
