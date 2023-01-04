package lists;

import classes.Usuari;

public class LlistaUsuaris {
    private Usuari[] llista;
    private int numUsuaris;


    public LlistaUsuaris(int mida) {
        llista = new Usuari[mida];
        this.numUsuaris = 0;
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
    public String toString() {
        String text = "";

        for(int i = 0; i < numUsuaris; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);

    }
}