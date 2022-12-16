package lists;

import classes.Producte;
import classes.Be;
import classes.Servei;

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
}
