package com.example.projekt_quiz;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Uzytkownik {
    String nazwa;

    public Uzytkownik(String nazwa)throws Exception
    {
        this.nazwa=nazwa.toUpperCase();
    }


    public String getNazwa() {
        return nazwa;
    }





    public String toString()
    {
        return nazwa;
    }
}

