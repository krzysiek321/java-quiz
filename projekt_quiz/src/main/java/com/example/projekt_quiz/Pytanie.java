package com.example.projekt_quiz;


import java.util.ArrayList;
import java.util.Random;

public class Pytanie {
    String kategoria;
    String trudnosc;
    String tresc;
    ArrayList<Odpowiedz> odpowiedzi;

    Pytanie(String kategoria, String trudnosc) {
        this.kategoria = kategoria;
        this.trudnosc = trudnosc;
        odpowiedzi = new ArrayList<>();
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getTrudnosc() {
        return trudnosc;
    }

    public void setTrudnosc(String trudnosc) {
        this.trudnosc = trudnosc;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public void dodaj_odpowiedz(Odpowiedz o) {
        odpowiedzi.add(o);
    }

    public Odpowiedz getOdpowiedz(int nr) {
        Odpowiedz o = odpowiedzi.get(nr);
        return o;
    }
    public void sortuj()
    {
        Random rand=new Random();
        for(int i=0; i<10; i++)
        {
            int x= rand.nextInt(0,4);
            Odpowiedz o=odpowiedzi.get(x);
            odpowiedzi.remove(o);
            odpowiedzi.add(o);
        }
    }

    public ArrayList<Odpowiedz> getOdpowiedzi() {
        return odpowiedzi;
    }
}