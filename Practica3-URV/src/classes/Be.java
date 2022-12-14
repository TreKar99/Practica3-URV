package classes;

public class Be extends Producte{
    
    private float amplada, alcada, fons, pes;
    private String dataIntercanvi;

    // TODO tenir en compte la dataIntercanvi;

    public Be(String codi, String descripcio, String tipus, String dataOferta, float amplada, float alcada, float fons, float pes) {
        super(codi, descripcio, tipus, dataOferta);
        this.amplada = amplada;
        this.alcada = alcada;
        this.fons = fons;
        this.pes = pes;
    }

    public Be copia() {

        Be b = new Be(super.getCodi(), super.getDescripcio(), super.getTipus(), super.getDataOferta(), amplada, alcada, fons, pes);
        b.dataIntercanvi = this.dataIntercanvi;

        return (b);
    }

    public String toString() {
        return("Es un be " + amplada + " " + alcada + " " + fons + " " + pes);
    }
}
