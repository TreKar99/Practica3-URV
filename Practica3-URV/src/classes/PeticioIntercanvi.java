package classes;

public class PeticioIntercanvi {
    
	private String codi, usuariEmisor, usuariRemitent, producteRebre, producteOferit;
    private boolean afirmativa, contestada;
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
    public PeticioIntercanvi(String codi, String emisor, String remitent, String pRebre, String pOferit)
    {
        this.codi = codi;
        this.usuariEmisor = emisor; 
        this.usuariRemitent = remitent; 
        this.producteRebre = pRebre;
        this.producteOferit = pOferit;
        this.afirmativa = false;
        this.contestada = false;
    }


    public String getCodi() {
        return this.codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getUsuariEmisor() {
        return this.usuariEmisor;
    }

    public void setUsuariEmisor(String usuariEmisor) {
        this.usuariEmisor = usuariEmisor;
    }

    public String getUsuariRemitent() {
        return this.usuariRemitent;
    }

    public void setUsuariRemitent(String usuariRemitent) {
        this.usuariRemitent = usuariRemitent;
    }

    public String getProducteRebre() {
        return this.producteRebre;
    }

    public void setProducteRebre(String producteRebre) {
        this.producteRebre = producteRebre;
    }

    public String getProducteOferit() {
        return this.producteOferit;
    }

    public void setProducteOferit(String producteOferit) {
        this.producteOferit = producteOferit;
    }

    public boolean isAfirmativa() {
        return this.afirmativa;
    }

    public boolean getAfirmativa() {
        return this.afirmativa;
    }

    public void setAfirmativa(boolean afirmativa) {
        this.afirmativa = afirmativa;
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

    /**
     * Métode per fer una copia de una PeticioIntercanvi
     * @return PeticioIntercanvi
     */
    public PeticioIntercanvi copia() {

        PeticioIntercanvi aux = new PeticioIntercanvi(this.codi);

        aux.usuariEmisor = this.usuariEmisor;
        aux.usuariRemitent = this.usuariRemitent;
        aux.producteRebre = this.producteRebre;
        aux.producteOferit = this.producteOferit;
        aux.afirmativa = this.afirmativa;
        aux.valoracioEmisor = this.valoracioEmisor;
        aux.valoracioRemitent = this.valoracioRemitent;
        aux.contestada = this.contestada;

        return (aux);
    }

    public String toStringAceptada() {
        return (codi + ";" + usuariEmisor + ";" + usuariRemitent + ";" + producteOferit + ";" + producteRebre + ";true;" + valoracioEmisor + ";" + valoracioRemitent + ";true");
    }

    public String toStringRefusada() {
        return (codi + ";" + usuariEmisor + ";" + usuariRemitent + ";" + producteOferit + ";" + producteRebre + ";true;" + valoracioEmisor + ";" + valoracioRemitent + ";false");
    }

    public String toString() {
        return ("La peticio: " + codi + " emesa per l'usuari: " + usuariEmisor + " rebra el producte " + producteRebre + " i oferira el producte " + producteOferit + " al usuari " + usuariRemitent + ". Aquesta peticio es " + afirmativa + " i te com a valoracions " + valoracioEmisor + " (emisor) " + valoracioRemitent + " (remitent). Contestada: " + contestada);
    }
}