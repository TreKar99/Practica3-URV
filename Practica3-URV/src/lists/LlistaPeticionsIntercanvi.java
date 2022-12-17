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

    /**
     * Métode que accepta un intercanvi
     * @param codiIntercanvi
     */
    public void accepta(String codiIntercanvi) {
        if (this.existeix(codiIntercanvi) != -1) {
            llista[this.existeix(codiIntercanvi)].setConstestada(true);
        }
    }

    /**
     * Métode que refusa un intercanvi
     * @param codiIntercanvi
     */
    public void refusa(String codiIntercanvi) {
        if (this.existeix(codiIntercanvi) != -1) {
            llista[this.existeix(codiIntercanvi)].setConstestada(false);
        }
    }

    /**
     * Métode que retorna la posicio d'un intercanvi dintre d'una llista, retorna -1 si no existeix
     * @param codiIntercanvi
     * @return
     */
    public int existeix(String codiIntercanvi) {

        int i = 0;
        boolean existeix = false;
        int posTrobat = -1;
        while ((i < numPeticions) && (!existeix)) {
            if (llista[i].getCodi().equals(codiIntercanvi)) {
                existeix = true;
            }
            i++;
        }
        
        if (existeix) {
            posTrobat = i;
        }

        return (posTrobat);
    }

    public String toString() {

        String text = "";

        for(int i = 0; i < numPeticions; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);
    }
}
