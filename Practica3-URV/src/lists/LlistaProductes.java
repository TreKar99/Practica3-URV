package lists;

import classes.*;

public class LlistaProductes {
    private Producte[] llista;
    private int numProductes, numBens, numServeis;

    public LlistaProductes(int mida) {
        llista = new Producte[mida];
        this.numProductes = 0;
    }

    public void afegirProducte(Producte p) {

        llista[numProductes] = p.copia();
        if (p.getTipus().equals("be")) {
            numBens++;
        } else if (p.getTipus().equals("servei")) {
            numServeis++;
        }
        numProductes++;

    }
    
    public Boolean eliminarProducte(String codi) {
    	int i;
    	boolean trobat = false;
    	i = buscarProducte(codi);
    	if (i != -1)
    		trobat = true;
    	if (trobat) {
    		if (llista[i].estaActiu() && (llista[i].getTipus().equals("be"))) {
    			llista[i].desactivar();
    			while (i < numProductes) {
        			llista[i] = llista[i+1];
        			i++;
        		}
        		numProductes--;
    		}
    		else
    			trobat = false;
    	}
    	
    	return(trobat);
    }

    public Producte getProducte(int num) {
        return (llista[num]);
    }

    public String getAliesProducte(int num) {
        return (llista[num].getUsuari().getAlies());
    }
    /**
     * Métode que retorna els serveis actius
     * 
     * @return text
     */
    public String serveisActius() {
        String text = "";
        for (int i = 0; i < numProductes; i++) {
            if (llista[i].getTipus().equals("servei")) {
                if (llista[i].estaActiu()) {
                    text += llista[i].toString() + "\n";
                }
            }
        }
        return (text);
    }

    /**
     * Métode que retorna els bens actius
     * 
     * @return text
     */
    public String bensActius() {

        String text = "";
        for (int i = 0; i < numProductes; i++) {
            if (llista[i].getTipus().equals("be")) {
                if (llista[i].estaActiu()) {
                    text += llista[i].toString() + "\n";
                }
            }
        }
        return (text);
    }
    
    /**
     * Metodo que busca un producto a partir de su codigo
     * @param codi
     * @return la posicion del producto, -1 si no está
     */
    public int buscarProducte(String codi) {
    	int i = 0;
    	boolean trobat = false;
    	while (i < numProductes && !trobat)
    	{
    		if (codi.equalsIgnoreCase(llista[i].getCodi()))
    			trobat = true;
    		else
    			i++;
    	}
    	
    	if (!trobat)
    		i = -1;
    	
    	return i;
    }
    
    
    /**
     * Métode que retorna els serveis
     * 
     * @return text
     */
    public String toStringServeis() {
        String text = "";

        for (int i = 0; i < numProductes; i++) {
            if (llista[i].getTipus().equals("servei")) {
                text += llista[i].toString() + "\n";
            }
        }
        return (text);
    }

    /**
     * Métode que retorna els bens
     * 
     * @return text
     */
    public String toStringBens() {
        String text = "";

        for (int i = 0; i < numProductes; i++) {
            if (llista[i].getTipus().equals("be")) {
                text += llista[i].toString() + "\n";
            }
        }
        return (text);
    }

    /**
     * Métode que retorna tots els productes
     * 
     * @return text
     */
    public String toString() {
        String text = "";

        for (int i = 0; i < numProductes; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);

    }

    public Producte[] getLlista() {
        return llista;
    }

    public void setLlista(Producte[] llista) {
        this.llista = llista;
    }

    public int getNumProductes() {
        return numProductes;
    }

    public void setNumProductes(int numProductes) {
        this.numProductes = numProductes;
    }

    public int getNumBens() {
        return numBens;
    }

    public void setNumBens(int numBens) {
        this.numBens = numBens;
    }

    public int getNumServeis() {
        return numServeis;
    }

    public void setNumServeis(int numServeis) {
        this.numServeis = numServeis;
    }
}