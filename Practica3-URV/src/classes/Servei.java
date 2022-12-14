package classes;

public class Servei extends Producte{

    private String fiOferiment;

    public Servei(String codi, String descripcio, String tipus, String dataOferta, String fiOferiment) {
        super(codi, descripcio, tipus, dataOferta);
        this.fiOferiment = fiOferiment;
    }

    public Producte copia() {
        return (new Servei(super.getCodi(), super.getDescripcio(), super.getTipus(), super.getDataOferta(), fiOferiment));
    }

}
