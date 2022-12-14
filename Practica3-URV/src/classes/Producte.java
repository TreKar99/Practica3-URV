package classes;

public abstract class Producte {
    
    private String codi, descripcio, tipus, dataOferta;

    public Producte(String codi, String descripcio, String tipus, String dataOferta) {
        this.codi = codi;
        this.descripcio = descripcio;
        this.tipus = tipus;
        this.dataOferta = dataOferta;
    }

    public String getCodi() {
        return this.codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getDescripcio() {
        return this.descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getTipus() {
        return this.tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getDataOferta() {
        return this.dataOferta;
    }

    public void setDataOferta(String dataOferta) {
        this.dataOferta = dataOferta;
    }


    abstract Producte copia();
}
