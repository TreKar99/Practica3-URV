package lists;

import classes.Usuari;

public class LlistaUsuaris {
    private Usuari[] llista;
    private int numUsuaris;


    public LlistaUsuaris(int mida) {
        llista = new Usuari[mida];
        this.numUsuaris = 0;
    }

    public void AfegirUsuari(Usuari currUsuari) {
        llista[numUsuaris] = new Usuari(currUsuari);
        numUsuaris++;
    }

    public String toString() {
        String text = "";

        for(int i = 0; i < numUsuaris; i++) {
            text += llista[i].toString() + "\n";
        }

        return (text);

    }
}
