package classes;

import lists.LlistaPeticionsIntercanvi;
import lists.LlistaProductes;

public class Usuari{

    private String alies, email;
    private int codiPostal;
    //private LlistaPeticionsIntercanvi intercanvisUsuari;        // LLista per guardar intercanvis fets
    //private LlistaProductes productesUsuari;                    // Productes que ofereix l'usuari
    //TODO Guardar els productes que ofereix i els intercanvis 

    public Usuari(String alies, String email, int codiPostal) {
        this.alies = alies;
        this.email = email;
        this.codiPostal = codiPostal;
    }

    public Usuari(Usuari usuari) {
        this(usuari.alies, usuari.email, usuari.codiPostal);
    }
   
}