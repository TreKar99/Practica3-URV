package lists;

import classes.Producte;
import classes.Be;
import classes.Servei;

public class LlistaProductes {
    private Producte[] llista;
    private int numProductes;

    public LlistaProductes(int mida) {
        llista = new Producte[mida];
        this.numProductes = 0;
    }

    public void afegirProducte(Producte p) {

        llista[numProductes] = p.copia();
        numProductes++;

    }

    public String toString() {
        String text = "";

        for (int i = 0; i < numProductes; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);

    }
}
