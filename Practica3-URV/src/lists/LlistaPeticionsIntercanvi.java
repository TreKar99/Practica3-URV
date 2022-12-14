package lists;

import classes.PeticioIntercanvi;

public class LlistaPeticionsIntercanvi {


    private PeticioIntercanvi[] llista;
    private int numPeticions;


    public LlistaPeticionsIntercanvi(int mida) {
        llista = new PeticioIntercanvi[mida];
        this.numPeticions = 0;
    }

    public void AfegirPeticio(PeticioIntercanvi codiIntercanvi) {

        llista[numPeticions] = codiIntercanvi.copia();
        numPeticions++;
    }

    public String toString() {

        String text = "";

        for(int i = 0; i < numPeticions; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);
    }
}
