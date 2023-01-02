package classes;

public class PeticioIntercanvi {
    
    private String codi;
    private Producte prodEmisor, prodRemitent;
    private Usuari usuEmisor, usuRemitent;
    private boolean acceptaIntercanvi, contestada;
    private int valoracioEmisor, valoracioRemitent;


    // ToDo posar la valoració del emisor i el remitent al confirmar
    // l'intercanvi

    /**
     * Els béns 1 intercanvi
     * Els serveis N intercanvis
    */
    public PeticioIntercanvi(String codi) {
        this.codi = codi;
    }

    /**
     * Constructor Petició intercanvi
     * @param codi
     * @param emisor
     * @param remitent
     * @param pRebre
     * @param pOferit
     */
    public PeticioIntercanvi(String codi, Usuari emisor, Usuari remitent, Producte pEmisor, Producte pRemitent)
    {
        this.codi = codi;
        this.usuEmisor = emisor; 
        this.usuRemitent = remitent; 
        this.prodEmisor = pEmisor;
        this.prodRemitent = pRemitent;
        this.acceptaIntercanvi = false;
        this.contestada = false;
    }


    public String getCodi() {
        return this.codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public boolean intercanviAcceptat() {
        return this.acceptaIntercanvi;
    }

    public void setIntercanviAcceptat(boolean acceptaIntercanvi) {
        this.acceptaIntercanvi = acceptaIntercanvi;
    }

    public int getValoracioEmisor() {
        return this.valoracioEmisor;
    }

    public boolean isContestada() {
        return this.contestada;
    }

    public boolean getContestada() {
        return this.contestada;
    }

    public void setContestada(boolean contestada) {
        this.contestada = contestada;
    }

    public void setValoracioEmisor(int valoracioEmisor) {
        this.valoracioEmisor = valoracioEmisor;
    }

    public int getValoracioRemitent() {
        return this.valoracioRemitent;
    }

    public void setValoracioRemitent(int valoracioRemitent) {
        this.valoracioRemitent = valoracioRemitent;
    }

    public Producte getProdEmisor() {
        return prodEmisor;
    }

    public void setProdEmisor(Producte prodEmisor) {
        this.prodEmisor = prodEmisor;
    }

    public Producte getProdRemitent() {
        return prodRemitent;
    }

    public void setProdRemitent(Producte prodRemitent) {
        this.prodRemitent = prodRemitent;
    }

    public Usuari getUsuEmisor() {
        return usuEmisor;
    }

    public void setUsuEmisor(Usuari usuEmisor) {
        this.usuEmisor = usuEmisor;
    }

    public Usuari getUsuRemitent() {
        return usuRemitent;
    }

    public void setUsuRemitent(Usuari usuRemitent) {
        this.usuRemitent = usuRemitent;
    }

    /**
     * Métode per fer una copia de una PeticioIntercanvi
     * @return PeticioIntercanvi
     */
    public PeticioIntercanvi copia() {

        PeticioIntercanvi aux = new PeticioIntercanvi(this.codi);

        aux.usuEmisor = this.usuEmisor;
        aux.usuRemitent = this.usuRemitent;
        aux.prodEmisor = this.prodEmisor;
        aux.prodRemitent = this.prodRemitent;
        aux.acceptaIntercanvi = this.acceptaIntercanvi;
        aux.valoracioEmisor = this.valoracioEmisor;
        aux.valoracioRemitent = this.valoracioRemitent;
        aux.contestada = this.contestada;

        return (aux);
    }

    public String toString() {
        return ("La peticio: " + codi + " emesa per l'usuari: " + usuEmisor + " rebra el producte " + prodRemitent + " i oferira el producte " + prodEmisor + " al usuari " + usuRemitent + ". Aquesta peticio es " + acceptaIntercanvi + " i te com a valoracions " + valoracioEmisor + " (emisor) " + valoracioRemitent + " (remitent). Contestada: " + contestada);
    }
}
