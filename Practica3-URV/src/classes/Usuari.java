package classes;

import java.io.Serializable;

import lists.*;

public class Usuari implements Serializable{

    private String alies, email;
    private int codiPostal;

    private LlistaProductes productesUsuari;                    // Productes que ofereix l'usuari
    private LlistaPeticionsIntercanvi intercanvisUsuari;        // LLista per guardar intercanvis fets
    //TODO Guardar els productes que ofereix i els intercanvis 


    public Usuari(Usuari usuari) {
        this(usuari.alies, usuari.email, usuari.codiPostal);
    }

    public Usuari(String alies, String email, int codiPostal) {
        this.alies = alies;
        this.email = email;
        this.codiPostal = codiPostal;
        this.productesUsuari = new LlistaProductes(100);
    }

    public String toString() {
        return ("Usuari " + alies + " amb correu " + email + " i codi postal " + codiPostal);
    }
   
    public String getAlies() {
        return alies;
    }

    public void setAlies(String alies) {
        this.alies = alies;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getCodiPostal() {
        return codiPostal;
    }


    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public LlistaProductes numProductesUsuari (LlistaProductes llista) {
        for(int i = 0; i<llista.getNumProductes(); i++) {
            if(llista.getAliesProducte(i) == this.alies) this.productesUsuari.afegirProducte(llista.getProducte(i));     
        }
        return (productesUsuari);
    }

    public LlistaPeticionsIntercanvi numIntercanvisFetsUsuari (LlistaPeticionsIntercanvi llista) {
        for(int i = 0; i<llista.getNumPeticions(); i++) {
            if((llista.getAliesProducte(i) == this.alies) && (llista.getIntercanviAcceptat(i)))
                this.intercanvisUsuari.afegirPeticio(llista.getIntercanvi(i));     
        }
        return (intercanvisUsuari);
    }
}