package lists;

import java.io.Serializable;

import classes.Usuari;

public class LlistaUsuaris implements Serializable{
    private Usuari[] llista;
    private int numUsuaris;


    public LlistaUsuaris(int mida) {
        llista = new Usuari[mida];
        this.numUsuaris = 0;
    }


    public Usuari[] getLlista() {
        return this.llista;
    }

    public void setLlista(Usuari[] llista) {
        this.llista = llista;
    }

    public Usuari getUsuari(int i) {
        return llista[i];
    }

    public int getNumUsuaris() {
        return this.numUsuaris;
    }

    public void setNumUsuaris(int numUsuaris) {
        this.numUsuaris = numUsuaris;
    }


    public void afegirUsuari(Usuari currUsuari) {
        if ( buscarUsuari(currUsuari.getAlies()) == -1) {
        	llista[numUsuaris] = currUsuari.copia();
        	numUsuaris++;
        }		
    }
    
    public int buscarUsuari(String nom) {
    	int i = 0;
    	boolean trobat = false;
    	while (i < numUsuaris && !trobat) {
    		if (llista[i].getAlies().compareToIgnoreCase(nom) == 0)
    			trobat = true;
    		else
    			i++;
    	}
    	
    	if (!trobat)
    		i = -1;
    	
    	return i;
    }

    public boolean usuariExisteix (String nomUsuari) {
    	int i = 0;
    	boolean trobat = false;
    	while ((i < numUsuaris) && (!trobat)) {
    		if (llista[i].getAlies().equals(nomUsuari)) {
                 trobat = true;
            }
    		i++;
    	}
    	return trobat;
    }

    public String getAlies(int i) {
        return llista[i].getAlies();
    }

    public void setAlies (int indUsuari, String nom) {
        llista[indUsuari].setAlies(nom);
    }

    public String toString() {
        String text = "";

        for(int i = 0; i < numUsuaris; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);

    }

    
}