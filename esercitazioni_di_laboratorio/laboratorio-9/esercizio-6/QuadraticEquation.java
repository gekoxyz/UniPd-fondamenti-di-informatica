public class QuadraticEquation {
    double acoeff, bcoeff, ccoeff;
    double delta;

    /*
     * Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica
     * e inizializza i campi di esemplare secondo i valori ricevuti
     */
    public QuadraticEquation(double acoeff, double bcoeff, double ccoeff) {
        this.acoeff = acoeff;
        this.bcoeff = bcoeff;
        this.ccoeff = ccoeff;
        this.delta = Math.sqrt((Math.pow(bcoeff, 2)) - (4 * acoeff * ccoeff));
    }

    /*
     * Restituisce la prima delle due soluzioni dell'equazione quadratica,
     * usando la ben nota formula...
     */
    public double getSolution1() {
        return (-bcoeff + delta) / 2 * acoeff;
    }

    /*
     * Restituisce la seconda delle due soluzioni dell'equazione quadratica,
     * usando la ben nota formula...
     */
    public double getSolution2() {
        return (-bcoeff - delta) / 2 * acoeff;
    }

    /*
     * Restituisce il valore false se l'equazione non ha soluzioni
     * (ovvero se il discriminante e` negativo)
     */
    public boolean hasSolutions() {
        return delta >= 0;
    }

    @Override
    public String toString() {
        return acoeff + "x^2 + " + bcoeff + "x + " + ccoeff;
    }

}
