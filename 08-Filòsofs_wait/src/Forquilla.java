
public class Forquilla {
    
    private final int LLIURE = -1;

    private int numero; 
    private int propietari; 
    
    public Forquilla(int numero){
        this.numero = numero;
        this.propietari = LLIURE;
    }
    public synchronized int getPropietari() {
        return propietari;

    }

    public synchronized void setPropietari(int propietari) {
        this.propietari = propietari;
    }
    
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
}