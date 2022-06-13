package com.example.projekt_quiz;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Zwyklyuzytkownik extends Uzytkownik{
    int ile_wykonanych;
    double sr_pkt;
    public Zwyklyuzytkownik(String nazwa) throws Exception {
        super(nazwa);
        int pom = 0;
        ArrayList<String> lista_u = lista_uzytkownikow();
        for (String s : lista_u) {
            String[] tab = s.split(" ");
            if (tab[0].equals(this.nazwa)) {
                ile_wykonanych = Integer.parseInt(tab[1]);
                sr_pkt = Double.parseDouble(tab[2]);
                pom = 1;
            }
        }
        if (pom == 0) {
            PrintWriter pw = new PrintWriter("uzytkownicy.txt");
            for (String s : lista_u) {
                pw.println(s);
            }
            ile_wykonanych = 0;
            sr_pkt = 0;
            pw.println(this.nazwa + " " + this.ile_wykonanych + " " + this.sr_pkt);
            pw.close();
        }
    }
    protected ArrayList<String> lista_uzytkownikow() throws Exception
    {
        Scanner scan=new Scanner( new File("uzytkownicy.txt"));
        ArrayList<String>lista=new ArrayList<>();
        while(scan.hasNext())
        {
            String w=scan.nextLine();
            lista.add(w);
        }
        scan.close();
        return lista;
    }
    public int getIle_wykonanych() {
        return ile_wykonanych;
    }

    public double getSr_pkt() {
        return sr_pkt;
    }

    public void zapisz_wynik(int ile, double sr_pkt) throws Exception {
        this.sr_pkt=this.sr_pkt*ile_wykonanych+sr_pkt;
        ile_wykonanych=ile;
        this.sr_pkt=this.sr_pkt/ile_wykonanych;
        ArrayList<String>lista_u=lista_uzytkownikow();
        PrintWriter pw= new PrintWriter("uzytkownicy.txt");
        for( String s:lista_u)
        {
            String[] tab=s.split(" ");
            if(tab[0].equals(this.nazwa)==false)
            {
                pw.println(s);
            }
            else
            {
                pw.println(this.nazwa+" "+this.ile_wykonanych+" "+this.sr_pkt);
            }
        }
        pw.close();
    }


}


