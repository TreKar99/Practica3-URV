package lists;

import classes.*;

public class LlistaPeticionsIntercanvi {


    private PeticioIntercanvi[] llista;
    private int numPeticions;


    public LlistaPeticionsIntercanvi(int mida) {
        llista = new PeticioIntercanvi[mida];
        this.numPeticions = 0;
    }

    public void afegirPeticio(PeticioIntercanvi intercanvi) {

        llista[numPeticions] = intercanvi.copia();
        numPeticions++;
    }

    /**
     * Métode que accepta un intercanvi
     * @param codiIntercanvi
     */
    public void acceptaIntercanvi(int codiIntercanvi) {
        if (this.existeixCodiIntercanvi(codiIntercanvi)) {
            llista[codiIntercanvi].setIntercanviAcceptat(true);
            llista[codiIntercanvi].setContestada(true);
        }
    }

    /**
     * Métode que refusa un intercanvi
     * @param codiIntercanvi
     */
    public void refusaIntercanvi(int codiIntercanvi) {
        if (this.existeixCodiIntercanvi(codiIntercanvi)) {
            llista[codiIntercanvi].setIntercanviAcceptat(false);
            llista[codiIntercanvi].setContestada(true);
        }
    }

    /**
     * Métode que retorna la posicio d'un intercanvi dintre d'una llista, retorna -1 si no getCodiIntercanvi
     * @param codiIntercanvi
     * @return posTrobat
     */
    public boolean existeixCodiIntercanvi(int codiIntercanvi) {

        int i = 0;
        boolean existeix = false;
        while ((i < numPeticions) && (!existeix)) {
            if (llista[i].getCodi() == (codiIntercanvi)) {
                existeix = true;
            }
            i++;
        }

        return (existeix);
    }

    /**
     * Mètode que retorna en format text totes les peticions per respondre
     * @return text
     */
    public String toStringPerRespondre() {
        String text = "";

        for (int i = 0; i < numPeticions; i++) {
            if (!llista[i].getContestada()) {
                text += llista[i].toString() + "\n";;
            }
        }

        return (text);
    }

    /**
     * Mètode que retorna en format text totes les peticions acceptades
     * @return text
     */
    public String toStringAcceptades() {
        String text = "";

        for (int i = 0; i < numPeticions; i++) {
            if (llista[i].intercanviAcceptat()) {
                text += llista[i].toString() + "\n";;
            }
        }

        return (text);
    }

    /**
     * Mètode que retorna en format text totes les peticions refusades
     * @return text
     */
    public String toStringRefusades() {
        String text = "";

        for (int i = 0; i < numPeticions; i++) {
            if (!llista[i].intercanviAcceptat()) {
                text += llista[i].toString() + "\n";
            }
        }

        return (text);
    }

    /**
     * Mètode que retorna en format text totes les peticions
     * @return text
     */
    public String toString() {

        String text = "";

        for(int i = 0; i < numPeticions; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);
    }

    public PeticioIntercanvi[] getLlista() {
        return llista;
    }

    public void setLlista(PeticioIntercanvi[] llista) {
        this.llista = llista;
    }

    public int getNumPeticions() {
        return numPeticions;
    }

    public void setNumPeticions(int numPeticions) {
        this.numPeticions = numPeticions;
    }

    public PeticioIntercanvi getIntercanvi(int num) {
        return (llista[num]);
    }


    public String getAliesProducte(int num) {
        return (llista[num].getUsuEmisor().getAlies());
    }

    public boolean getIntercanviAcceptat(int num) {
        return (llista[num].intercanviAcceptat());
    }
}
