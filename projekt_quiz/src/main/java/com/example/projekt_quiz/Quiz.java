package com.example.projekt_quiz;


import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    Double wynik;
    int ilosc_pytan;
    ArrayList<Pytanie>lista_pytan;
    String kategoria;
    String trudnosc;
    int nr_pytania;
    public Quiz(String kategoria, String trudnosc) throws Exception {
        this.kategoria=kategoria;
        this.trudnosc=trudnosc;
        nr_pytania=0;
        wynik=0.0;
        ArrayList<Pytanie>lista_pom=lista_pytan(kategoria,trudnosc);
        ilosc_pytan=Math.min(lista_pom.size(),5);
        lista_pytan=new ArrayList<>();
        for(int i=0; i<ilosc_pytan; i++)
        {
            Random rand= new Random();
            int x=rand.nextInt(0,lista_pom.size());
            Pytanie p1=lista_pom.get(x);
            p1.sortuj();
            lista_pytan.add(p1);
            lista_pom.remove(x);
        }

    }

    private ArrayList<Pytanie>lista_pytan(String kategoria,String trudnosc) throws Exception
    {
        Scanner scan=new Scanner( new File("pytania.txt"));
        ArrayList<Pytanie>lista=new ArrayList<>();
        while(scan.hasNext())
        {
            String s=scan.nextLine();
            String[] tab=s.split(";");
            if(tab[1].equals(kategoria) && tab[2].equals(trudnosc))
            {

                Pytanie p =new Pytanie(tab[1],tab[2]);
                p.setTresc(tab[3]);
                for(int i=0; i<4; i++)
                {
                    Odpowiedz o =new Odpowiedz(tab[i*2+4],Boolean.parseBoolean(tab[i*2+5]));
                    p.dodaj_odpowiedz(o);
                }
                lista.add(p);
            }
        }
        scan.close();
        return lista;
    }

    public Double getWynik() {
        return wynik;
    }

    public int getIlosc_pytan() {
        return ilosc_pytan;
    }

    public ArrayList<Pytanie> getLista_pytan() {
        return lista_pytan;
    }
    public Pytanie getPytanie(int nr)
    {
        return lista_pytan.get(nr);
    }

    public int getNr_pytania() {
        return nr_pytania;
    }

    public void setWynik(Double wynik) {
        this.wynik = wynik;
    }

    public void setNr_pytania(int nr_pytania) {
        this.nr_pytania = nr_pytania;
    }
}

