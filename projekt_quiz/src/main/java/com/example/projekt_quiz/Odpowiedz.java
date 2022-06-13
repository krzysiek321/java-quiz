package com.example.projekt_quiz;


public class Odpowiedz {
    String tresc;
    Boolean poprawna;

    public Odpowiedz(String tresc, Boolean poprawna)
    {
        this.tresc=tresc;
        this.poprawna=poprawna;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Boolean getPoprawna() {
        return poprawna;
    }

    public void setPoprawna(Boolean poprawna) {
        this.poprawna = poprawna;
    }
}
