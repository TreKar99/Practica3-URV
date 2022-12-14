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

        if (p instanceof Servei) {
            llista[numProductes] = ¿?
            numProductes++;
        } else if (p instanceof Be) {
            llista[numProductes] = ¿?
            numProductes++;
        }

    }
}
