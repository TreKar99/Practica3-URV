package classes;

import java.time.Month;
import java.util.Currency;

import javax.xml.crypto.Data;

import java.sql.Date;
import java.time.*;

public class Servei extends Producte {

    private String fiOferiment;

    public Servei(String codi, String descripcio, String tipus, String dataOferta, String fiOferiment) {
        super(codi, descripcio, tipus, dataOferta);
        this.fiOferiment = fiOferiment;
    }

    public String getFiOferiment() {
        return this.fiOferiment;
    }

    public void setFiOferiment(String fiOferiment) {
        this.fiOferiment = fiOferiment;
    }

    /**
     * Métode que diu si un servei esta actiu o no
     * 
     * @return boolean
     */
    public boolean estaActiu() {
        boolean actiu = false;
        String[] arrOfDate = fiOferiment.split("/", 3);
        LocalDate currentdate = LocalDate.now();



        if (Integer.parseInt(arrOfDate[2]) <= currentdate.getYear()) {
            if (Integer.parseInt(arrOfDate[1]) <= currentdate.getMonthValue()) {
                if  (Integer.parseInt(arrOfDate[0]) < currentdate.getDayOfMonth()){
                    actiu = false;
                } else {
                    actiu = true;
                }
            } else {
                actiu = true;
            }
        } else {
            actiu = true;
        }

        return (actiu);
    }

    public Servei copia() {
        return (new Servei(super.getCodi(), super.getDescripcio(), super.getTipus(), super.getDataOferta(),
                fiOferiment));
    }

    public String toString() {
        return ("Es un servei " + fiOferiment);
    }

}
