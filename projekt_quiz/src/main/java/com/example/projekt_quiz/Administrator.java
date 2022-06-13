package com.example.projekt_quiz;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrator extends Uzytkownik
{
    int ile_stworzonych;
    public Administrator(String nazwa) throws Exception {
        super(nazwa);
        int pom=0;
        ArrayList<String>lista_u=lista_uzytkownikow();
        for( String s:lista_u)
        {
            String[] tab=s.split(" ");
            if(tab[0].equals(this.nazwa))
            {
                ile_stworzonych= Integer.parseInt(tab[1]);
                pom=1;
            }
        }
        if(pom==0)
        {
            PrintWriter pw= new PrintWriter("administratorzy.txt");
            for( String s:lista_u) {
                pw.println(s);
            }
            ile_stworzonych=0;
            pw.println(this.nazwa+" "+this.ile_stworzonych);
            pw.close();
        }

    }
    public void stworzpytanie(Pytanie p) throws Exception{
        ArrayList<String>lista=new ArrayList<>();
        Scanner scan=new Scanner( new File("pytania.txt"));
        while(scan.hasNext())
        {
            lista.add(scan.nextLine());
        }
        scan.close();
        PrintWriter pw= new PrintWriter("pytania.txt");
        for(String s:lista)
        {
            pw.println(s);
        }
        if(lista.size()>0) {
            String s = lista.get(lista.size() - 1);
            String[]tab=s.split(";");
            pw.print((Integer.parseInt(tab[0])+1)+";");
        }
        else
        {
            pw.print(1+";");
        }
        pw.print(p.getKategoria()+";"+p.getTrudnosc()+";"+p.getTresc()+";");
        ArrayList<Odpowiedz>odpowiedzi=p.getOdpowiedzi();
        for(Odpowiedz odp:odpowiedzi)
        {
            pw.print(odp.getTresc()+";"+odp.getPoprawna()+";");
        }
        pw.println(super.getNazwa()+";");
        pw.close();
        setIle_stworzonych(getIle_stworzonych()+1);
    }
    public int getIle_stworzonych() {
        return ile_stworzonych;
    }
    protected ArrayList<String> lista_uzytkownikow() throws Exception
    {
        Scanner scan=new Scanner( new File("administratorzy.txt"));
        ArrayList<String>lista=new ArrayList<>();
        while(scan.hasNext())
        {
            String w=scan.nextLine();
            lista.add(w);
        }
        scan.close();
        return lista;
    }
    public void setIle_stworzonych(int ile) throws Exception {
        ile_stworzonych=ile;
        ArrayList<String>lista_u=lista_uzytkownikow();
        PrintWriter pw= new PrintWriter("administratorzy.txt");
        for( String s:lista_u)
        {
            String[] tab=s.split(" ");
            if(tab[0].equals(this.nazwa)==false)
            {
                pw.println(s);
            }
            else
            {
                pw.println(this.nazwa+" "+this.ile_stworzonych);
            }
        }
        pw.close();
    }
    public String toString()
    {
        return "Administrator"+super.toString();
    }
}