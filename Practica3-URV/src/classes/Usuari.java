package classes;

import java.io.Serializable;

import lists.*;

public class Usuari implements Serializable{

    private static final long serialVersionUID = -4071729240270017811L;
	private String alies, email;
    private int codiPostal;

    private LlistaProductes productesUsuari;                    // Productes que ofereix l'usuari
    private LlistaPeticionsIntercanvi intercanvisUsuari;        // LLista per guardar intercanvis fets
    

    public Usuari(Usuari usuari) {
        this(usuari.alies, usuari.email, usuari.codiPostal);
    }

    public Usuari(String alies ) {
    	this.alies = alies;
    }
    public Usuari(String alies, String email, int codiPostal) {
        this.alies = alies;
        this.email = email;
        this.codiPostal = codiPostal;
        this.productesUsuari = new LlistaProductes(100);
    }
    
    /**
     * metodo para saber los productos del usuario
     * @param llista donde veremos sus productos
     * @return Llista con los productos del usuario
     */
    public LlistaProductes numProductesUsuari (LlistaProductes llista) {
        for(int i = 0; i<llista.getNumProductes(); i++) {
            if(llista.getAliesProducte(i).equals(alies))
            		this.productesUsuari.afegirProducte(llista.getProducte(i));     
        }
        return (productesUsuari);
    }
    
    /**
     * metodo para saber los intercambios del usuario
     * @param llista donde veremos sus intercambios
     * @return Llista con los intercambios del usuario
     */
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

    /////////////////////////////////////////////Getters, Setters, toString, Copia////////////////////////////////////////
    
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
    	Usuari aux = new Usuari(this.alies, this.email, this.codiPostal);
    	aux.intercanvisUsuari = this.intercanvisUsuari;
    	aux.productesUsuari = this.productesUsuari;
    	return (aux);
    }
}