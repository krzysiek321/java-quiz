package com.example.projekt_quiz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;



public class HelloController {
    Uzytkownik u;
    Pytanie p;
    Quiz q;
    ObservableList<String> category = FXCollections.observableArrayList("Wiedza ogólna", "Matematyka", "Informatyka", "Sport", "Historia", "Inne");
    ObservableList<String> trudnos_wybor = FXCollections.observableArrayList("Łatwy", "Średni", "Trudny");
    @FXML
    private TextField nazwa1;
    @FXML
    private VBox pole1;
    @FXML
    private VBox pole2;
    @FXML
    private VBox pole3;
    @FXML private VBox pole4;
    @FXML
    private VBox pole5;
    @FXML
    private ChoiceBox kategorie;
    @FXML
    private ChoiceBox trudnosc;
    @FXML
    private Label nazwa3;
    @FXML
    private Label sku3;
    @FXML
    private Label gry3;
    @FXML
    private Label stw3;
    @FXML
    private Label nazwa41;
    @FXML
    private Label sku41;
    @FXML
    private Label gry41;
    @FXML
    private Label stw41;

    @FXML
    private ChoiceBox kategorie2;
    @FXML
    private ChoiceBox trudnosc2;
    @FXML
    private Button wybor32;
    @FXML
    private TextArea tresc_pytania;
    @FXML
    private TextField odp1;
    @FXML
    private TextField odp2;
    @FXML
    private TextField odp3;
    @FXML
    private TextField odp4;
    @FXML
    private CheckBox p_odp1;
    @FXML
    private CheckBox p_odp2;
    @FXML
    private CheckBox p_odp3;
    @FXML
    private CheckBox p_odp4;
    @FXML
    private Label t_pyt;
    @FXML
    private CheckBox u_odp1;
    @FXML
    private CheckBox u_odp2;
    @FXML
    private CheckBox u_odp3;
    @FXML
    private CheckBox u_odp4;
    @FXML
    private Label nr_pyt;
    @FXML
    private Label wynik;
    @FXML
    void initialize() {
        kategorie.setItems(category);
        kategorie.setValue("Wiedza ogólna");
        trudnosc.setItems(trudnos_wybor);
        trudnosc.setValue("Średni");
        kategorie2.setItems(category);
        kategorie2.setValue("Sport");
        trudnosc2.setItems(trudnos_wybor);
        trudnosc2.setValue("Średni");
        pole2.setPrefHeight(0);
        pole3.setPrefHeight(0);
        pole4.setPrefHeight(0);
        pole5.setPrefHeight(0);

    }

    @FXML
    protected void zaloguj_administrator() throws Exception {
        String tekst = nazwa1.getText();
        if (tekst.equals("") == false) {
            u = new Administrator(tekst);
            Administrator u1=(Administrator)u;
            pole1.setPrefHeight(0);
            pole3.setPrefHeight(400);
            pole1.setVisible(false);
            pole3.setVisible(true);
            stw3.setText("Liczba stworzonych: " + u1.getIle_stworzonych());
            nazwa3.setText("Witaj " + u.getNazwa());
        }
    }

    @FXML
    protected void menuglowne() {
        pole3.setPrefHeight(0);
        pole2.setPrefHeight(0);
        pole4.setPrefHeight(0);
        pole5.setPrefHeight(0);
        pole1.setPrefHeight(400);
        pole2.setVisible(false);
        pole3.setVisible(false);
        pole4.setVisible(false);
        pole5.setVisible(false);
        wynik.setVisible(false);
        stw41.setVisible(false);
        pole1.setVisible(true);
        gry3.setVisible(false);
        sku3.setVisible(false);
   }

    @FXML
    protected void stworz_pytanie() {
        Object kat = kategorie.getValue();
        String a = kat.toString();
        Object tru = trudnosc.getValue();
        String b = tru.toString();
        p=new Pytanie(a,b);
        pole3.setPrefHeight(0);
        pole2.setPrefHeight(400);
        pole2.setVisible(true);
        pole3.setVisible(false);
        tresc_pytania.setText("");
        odp1.setText("");
        odp2.setText("");
        odp3.setText("");
        odp4.setText("");
        p_odp1.setSelected(false);
        p_odp2.setSelected(false);
        p_odp3.setSelected(false);
        p_odp4.setSelected(false);
    }
    @FXML
    protected void zapiszpytanie()throws Exception
    {
        if(odp1.getText().equals("")==false &&odp2.getText().equals("")==false &&
                odp3.getText().equals("")==false && odp4.getText().equals("")==false && tresc_pytania.getText().equals("")==false &&
                (p_odp1.isSelected() || p_odp2.isSelected()|| p_odp3.isSelected() || p_odp4.isSelected()))
        {
            p.setTresc(tresc_pytania.getText());
            Odpowiedz o1=new Odpowiedz(odp1.getText(),p_odp1.isSelected());
            Odpowiedz o2=new Odpowiedz(odp2.getText(),p_odp2.isSelected());
            Odpowiedz o3=new Odpowiedz(odp3.getText(),p_odp3.isSelected());
            Odpowiedz o4=new Odpowiedz(odp4.getText(),p_odp4.isSelected());
            p.dodaj_odpowiedz(o1);
            p.dodaj_odpowiedz(o2);
            p.dodaj_odpowiedz(o3);
            p.dodaj_odpowiedz(o4);
            Administrator admin = (Administrator) u;
            admin.stworzpytanie(p);
            pole2.setVisible(false);
            pole2.setPrefHeight(0);
            pole3.setPrefHeight(400);
            pole3.setVisible(true);
            stw3.setText("Liczba stworzonych: " + admin.getIle_stworzonych());
            sku3.setVisible(false);
            gry3.setVisible(true);
        }

    }
    @FXML
    protected void menuglowne2() {
        pole2.setPrefHeight(0);
        pole3.setPrefHeight(400);
        pole2.setVisible(false);
        pole3.setVisible(true);
        if(!gry3.isVisible()) {
            sku3.setVisible(true);
        }
    }
    @FXML
    protected void zaloguj_uzytkownik() throws Exception {
        String tekst = nazwa1.getText();
        if (!tekst.equals("")) {
            u = new Zwyklyuzytkownik(tekst);
            Zwyklyuzytkownik u1=(Zwyklyuzytkownik)u ;
            pole1.setPrefHeight(0);
            pole4.setPrefHeight(400);
            pole1.setVisible(false);
            pole4.setVisible(true);
            sku41.setText("Skuteczność: " + String.format("%.2f",u1.getSr_pkt())+"%");
            gry41.setText("Liczba gier: " + u1.getIle_wykonanych());
            nazwa41.setText("Witaj " + u.getNazwa());
            }
    }
    @FXML
    protected void rozpocznij() throws Exception {
        Object pom=kategorie2.getValue();
        String kat=pom.toString();
        pom=trudnosc2.getValue();
        String trud=pom.toString();
        q=new Quiz(kat,trud);
        pole4.setPrefHeight(0);
        pole5.setPrefHeight(400);
        pole4.setVisible(false);
        pole5.setVisible(true);
        if(q.getIlosc_pytan()<5)
        {
            stw41.setVisible(true);
            koniec_quizu();
        }
        else {
            odp_na_pytanie();
        }

    }
    @FXML
    protected void odp_na_pytanie()throws Exception
    {
        int ile=q.getIlosc_pytan();
        int nr=q.getNr_pytania();
        if(nr<ile) {
            nr_pyt.setText("Pytanie "+(nr+1));
            Pytanie p = q.getPytanie(nr);
            String txt=p.getTresc();
            t_pyt.setText(txt);
            Odpowiedz o1 = p.getOdpowiedz(0);
            Odpowiedz o2 = p.getOdpowiedz(1);
            Odpowiedz o3 = p.getOdpowiedz(2);
            Odpowiedz o4 = p.getOdpowiedz(3);
            u_odp1.setSelected(false);
            u_odp2.setSelected(false);
            u_odp3.setSelected(false);
            u_odp4.setSelected(false);
            u_odp1.setText(o1.getTresc());
            u_odp2.setText(o2.getTresc());
            u_odp3.setText(o3.getTresc());
            u_odp4.setText(o4.getTresc());
        }
        else
        {
            wynik.setVisible(true);
            stw41.setVisible(false);
            wynik.setText("Wynik: "+String.format("%.2f",q.getWynik()/q.getIlosc_pytan()*100)+"%");
            koniec_quizu();
        }
    }
    @FXML
    protected void kolejne_pytanie() throws Exception {
        if(u_odp1.isSelected() ||u_odp2.isSelected()||
                u_odp3.isSelected() ||u_odp4.isSelected())
        {
            int nr=q.getNr_pytania();
            Pytanie p=q.getPytanie(nr);
            Odpowiedz o1=p.getOdpowiedz(0);
            Odpowiedz o2=p.getOdpowiedz(1);
            Odpowiedz o3=p.getOdpowiedz(2);
            Odpowiedz o4=p.getOdpowiedz(3);
            int pkt=0;
            if(u_odp1.isSelected()==o1.getPoprawna())
                pkt++;
            if(u_odp2.isSelected()==o2.getPoprawna())
                pkt++;
            if(u_odp3.isSelected()==o3.getPoprawna())
                pkt++;
            if(u_odp4.isSelected()==o4.getPoprawna())
                pkt++;
            if(pkt==4)
            {
                q.setWynik(q.getWynik()+1);
            }
            q.setNr_pytania(nr+1);
            odp_na_pytanie();
        }
    }
    protected void koniec_quizu()throws Exception
    {
        double wynik=q.getWynik();
        double ile=q.getIlosc_pytan();
        pole5.setPrefHeight(0);
        pole4.setPrefHeight(400);
        pole5.setVisible(false);
        pole4.setVisible(true);
        Zwyklyuzytkownik u1 = (Zwyklyuzytkownik) u;
        if(ile>=5) {
            u1.zapisz_wynik(u1.getIle_wykonanych() + 1, wynik / ile * 100);
        }
        gry41.setText("Liczba gier "+u1.getIle_wykonanych());
        sku41.setText("Skuteczność: "+String.format("%.2f",u1.getSr_pkt())+"%");

    }
    @FXML
    protected void sprawdz1()
    {
        String s=nazwa1.getText();
        if(s.length()>0) {
            byte b = (byte) s.charAt(nazwa1.getCaretPosition() - 1);
            if(b==32)
            {
                String s1=s.substring(0,nazwa1.getCaretPosition()-1);
                nazwa1.setText(s1);
                nazwa1.positionCaret(s1.length());
            }
        }
    }
    @FXML
    protected void sprawdz2()
    {
        String s=tresc_pytania.getText();
        if(s.length()>0) {
            byte b = (byte) s.charAt(tresc_pytania.getCaretPosition() - 1);
            if(b==10 || b==59)
            {
                String s1=s.substring(0,tresc_pytania.getCaretPosition()-1);
                tresc_pytania.setText(s1);
                tresc_pytania.positionCaret(s1.length());
            }
        }
    }
}