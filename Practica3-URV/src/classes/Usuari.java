package classes;

import java.io.Serializable;

import lists.*;

public class Usuari implements Serializable{

    private static final long serialVersionUID = -4071729240270017811L;
	private String alies, email;
    private int codiPostal;

    private LlistaProductes productesUsuari;                    // Productes que ofereix l'usuari
    private LlistaPeticionsIntercanvi intercanvisUsuari;        // LLista per guardar intercanvis fets
    //TODO Guardar els productes que ofereix i els intercanvis 
    
    public Usuari(String alies ) {
    	this.alies = alies;
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
    
    public Usuari copia() {
    	Usuari aux = new Usuari(this.alies);
    	aux.codiPostal = this.codiPostal;
    	aux.email = this.email;
    	aux.intercanvisUsuari = this.intercanvisUsuari;
    	aux.productesUsuari = this.productesUsuari;
    	return (aux);
    }
    public LlistaProductes numProductesUsuari (LlistaProductes llista) {
        for(int i = 0; i<llista.getNumProductes(); i++) {
            if(llista.getAliesProducte(i) == this.alies) this.productesUsuari.afegirProducte(llista.getProducte(i));     
        }
        return (productesUsuari);
    }

    public LlistaPeticionsIntercanvi intercanvisFetsUsuari (LlistaPeticionsIntercanvi llista) {
    	int i, aux = llista.getNumPeticions();
    	LlistaPeticionsIntercanvi intercanvisFets = new LlistaPeticionsIntercanvi(aux);
    	for (i = 0; i < aux; i++) {
    		if ((llista.getAliesEmisor(i) == alies || llista.getAliesRemitent(i) == alies) && (llista.getIsAfirmativa(i))) {
    			intercanvisFets.afegirPeticio(llista.getIntercanvi(i));
    		}
    	}
    	
    	return(intercanvisFets);
    	
    }
}