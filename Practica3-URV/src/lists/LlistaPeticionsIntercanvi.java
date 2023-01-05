package lists;

import java.io.Serializable;

import classes.*;

public class LlistaPeticionsIntercanvi{


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
    public void acceptaIntercanvi(String codiIntercanvi) {
        int posIntercanvi = this.existeixCodiIntercanvi(codiIntercanvi);
        if (posIntercanvi  != -1) {
            llista[posIntercanvi].setAfirmativa(true);
            llista[posIntercanvi].setContestada(true);
        }
    }

    /**
     * Métode que refusa un intercanvi
     * @param codiIntercanvi
     */
    public void refusaIntercanvi(String codiIntercanvi) {
        int posIntercanvi = this.existeixCodiIntercanvi(codiIntercanvi);
        if (posIntercanvi  != -1) {
            llista[posIntercanvi].setAfirmativa(false);
            llista[posIntercanvi].setContestada(true);
        }
    }

    /**
     * Métode que retorna la posicio d'un intercanvi dintre d'una llista, retorna -1 si no getCodiIntercanvi
     * @param codiIntercanvi
     * @return posTrobat
     */
    public int existeixCodiIntercanvi(String codiIntercanvi) {
        int i = 0;
        int posIntercanvi = -1;
        boolean existeix = false;
        while ((i < numPeticions) && (!existeix)) {
            if (llista[i].getCodi() == (codiIntercanvi)) {
                existeix = true;
                posIntercanvi = i;
            }
            i++;
        }

        return (posIntercanvi);
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
            if (llista[i].isContestada()) {
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
            if (!llista[i].isContestada()) {
                text += llista[i].toString() + "\n";
            }
        }

        return (text);
    }

    public String usuarisLlindar(int llindar) {
    	String usuarisLlindar = "";
    	int i;
    	for (i = 0; i < numPeticions; i++) {
    		if (llista[i].getValoracioEmisor() >= llindar && !usuarisLlindar.contains(llista[i].getUsuariEmisor()))
    			usuarisLlindar = usuarisLlindar + llista[i].getUsuariEmisor() + " ";
    		if (llista[i].getValoracioRemitent() >= llindar && !usuarisLlindar.contains(llista[i].getUsuariRemitent()))
    			usuarisLlindar = usuarisLlindar + llista[i].getUsuariRemitent();
    		}
    	return (usuarisLlindar);
    	}
    /**
     * 
     * @return un String del formato "Servei: (codi), repeticions: (n)" que contiene el codigo del servicio mas intercambiado y cuantas veces se hizo
     */
    public String serveiMesIntercanviat() {
    	String resultat = "", prod1, prod2;
    	int i = 0, contador1 = 0, contador2 = 0, contador3 = 0, j;
    	
    	while (i < numPeticions) {
    		if (llista[i].getAfirmativa()) {
    			prod1 = llista[i].getProducteOferit();
        		prod2 = llista[i].getProducteRebre();
        		for (j = i; j < numPeticions; j++) {
        			if (llista[j].getAfirmativa()) {
        				if (prod1.equals(llista[j].getProducteOferit()))
            				contador1++;
            			if (prod1.equals(llista[j].getProducteRebre()))
            				contador1++;
            			if (prod2.equals(llista[i].getProducteOferit()))
            				contador2++;
            			if (prod2.equals(llista[j].getProducteRebre()))
            				contador2++; 
        			}
        		}
        		
        		if (contador1 > contador3 && contador1 > 1) {
        			resultat = "Servei: " + prod1 + ", repeticions: " + Integer.toString(contador1);
        			contador3 = contador1;
        		}
        		
        		if (contador2 > contador3 && contador2 > 1) {
        			resultat = "Servei: " + prod2 + ", repeticions: " + Integer.toString(contador2);
        			contador3 = contador2; 
        		}
        		contador1 = 0;
        		contador2 = 0;
        		i++;
    		}
    		else {
    			i++;
    		}
    	}
    	if (resultat.isBlank())
    		resultat = "Todos los servicios que hay se intercambian solo una vez";
    	
    	return resultat;
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
    
    public String getAliesEmisor(int num) {
        return (llista[num].getUsuariEmisor());
    }

    public String getAliesRemitent(int num) {
    	return (llista[num].getUsuariRemitent());
    }
    public boolean getIsContestada(int num) {
        return (llista[num].isContestada());
    }
    
    public boolean getIsAfirmativa(int num) {
    	return (llista[num].isAfirmativa());
    }
}