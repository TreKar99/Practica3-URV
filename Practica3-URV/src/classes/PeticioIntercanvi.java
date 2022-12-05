package classes;

public class PeticioIntercanvi {
    
    private String codi, usuariEmisor, usuariRemitent, producteRebre, producteOferit;
    private boolean afirmativa;
    int valoracioEmisor, valoracioRemitent;

    /**
     * Els béns 1 intercanvi
     * Els serveis N intercanvis
    */
    public PeticioIntercanvi(String codi) {
        this.codi = codi;
    }
}
