package classes;

public class Be extends Producte {

    private float amplada, alcada, fons, pes;
    private String dataIntercanvi;

    public Be(String codi, String descripcio, String dataOferta, float amplada, float alcada, float fons,
            float pes) {
        super(codi, descripcio, "be", dataOferta);
        this.amplada = amplada;
        this.alcada = alcada;
        this.fons = fons;
        this.pes = pes;

    }

    public Be(String codi, String descripcio, String tipus, String dataOferta, float amplada, float alcada, float fons,
            float pes) {
        super(codi, descripcio, tipus, dataOferta);
        this.amplada = amplada;
        this.alcada = alcada;
        this.fons = fons;
        this.pes = pes;
    }

    public Be(String codi, String descripcio, String tipus, String dataOferta, float amplada, float alcada, float fons,
            float pes, String dataIntercanvi) {
        super(codi, descripcio, tipus, dataOferta);
        this.amplada = amplada;
        this.alcada = alcada;
        this.fons = fons;
        this.pes = pes;
        this.dataIntercanvi = dataIntercanvi;
    }

    /**
     * Métode que retorna si el be esta actiu
     * 
     * @return boolean
     */
    public boolean estaActiu() {

        if (dataIntercanvi != null) {
            return (false);
        } else {
            return (true);
        }
    }
    
    /**
     * Mètode que desactiva el intercanvi
     */
    public void desactivar() {
    	dataIntercanvi = "-1";
    }

    /**
     * Mètode que retrona una copia del Be
     * @return aux
     */
    public Be copia() {

        Be b = new Be(super.getCodi(), super.getDescripcio(), super.getTipus(), super.getDataOferta(), amplada, alcada,
                fons, pes);
        b.dataIntercanvi = this.dataIntercanvi;

        return (b);
    }

    public String toString() {
        return ("Es un be amb codi: " + super.getCodi() + ", descripcio: " + super.getDescripcio() + ", amplada: " + amplada + ", alcada: " + alcada + ", fondo:  " + fons + ", pes: " + pes + ", data intercanvi: " + dataIntercanvi);
    }

    public String toStringFitxer() {
        return ("Es un be amb codi: " + super.getCodi() + ", descripcio: " + super.getDescripcio() + ", amplada: " + amplada + ", alcada: " + alcada + ", fondo:  " + fons + ", pes: " + pes + ", data intercanvi: " + dataIntercanvi);
    }
}