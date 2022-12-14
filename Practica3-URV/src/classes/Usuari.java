package classes;

import java.io.Serializable;

import lists.LlistaPeticionsIntercanvi;
import lists.LlistaProductes;

public class Usuari implements Serializable{

    private String alies, email;
    private int codiPostal;
    //private LlistaPeticionsIntercanvi intercanvisUsuari;        // LLista per guardar intercanvis fets
    //private LlistaProductes productesUsuari;                    // Productes que ofereix l'usuari
    //TODO Guardar els productes que ofereix i els intercanvis 


    public Usuari(Usuari usuari) {
        this(usuari.alies, usuari.email, usuari.codiPostal);
    }


    public Usuari(String alies, String email, int codiPostal) {
        this.alies = alies;
        this.email = email;
        this.codiPostal = codiPostal;
    }
   
}