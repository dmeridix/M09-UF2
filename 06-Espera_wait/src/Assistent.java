import java.util.Random;

public class Assistent extends Thread {
    private Esdeveniment es;
    private String nom;
    public String getNom() {
        return nom;
    }

    private Random rnd;
    
    public Assistent(Esdeveniment es, String nom) {
        this.es = es;
        this.nom = nom;
        this.rnd = new Random();
    }

    @Override
    public void run(){
        while (true) {
            try {
                int interval = rnd.nextInt(2);
                switch (interval) {
                    case 0:
                        es.ferReserva(this);
                        break;
                    case 1:
                        es.cancelaReserva(this);
                        break;
                    default:
                        break;
                }
                Thread.sleep(rnd.nextInt(2) * 1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.err.println("Error en el run() de l'Assistent");
            }
        }
    }
}