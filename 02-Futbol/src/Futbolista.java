import java.util.Random;

public class Futbolista extends Thread{
    private final static int NUM_JUGADORS = 11;
    private final static int NUM_TIRADES = 20;
    private final static float PROBABILITAT = 0.5f;
    
    private int ngols;
    private int ntirades;
    
    public int getNgols() {
        return ngols;
    }

    public void setNgols(int ngols) {
        this.ngols = ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public void setNtirades(int ntirades) {
        this.ntirades = ntirades;
    }

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override
    public void run() {
        for(int i=0; i<NUM_TIRADES;i++){
            float probal = new Random().nextFloat();

            if(probal > PROBABILITAT){
                ngols++;
            }
            ntirades++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String[] noms = {"Pau","Alex","Joan","Dani","Ari","Pedro","Marc","Juan","Maya","Martina","Carlos"};

        Futbolista[] futbolistas = new Futbolista[11];
        System.out.println("Inici dels xuts --------------------");
        for (int i=0; i<NUM_JUGADORS;i++){
            Futbolista jugador = new Futbolista(noms[i]); 
            futbolistas[i] = jugador;
        }  
        for (Futbolista jugador : futbolistas){
            jugador.start();   
        }  
        for (Futbolista jugador : futbolistas){
            jugador.join();   
        }   
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        for (Futbolista jugador : futbolistas){
            System.out.println(jugador.getName() + "\t-> Ha marcat " + jugador.getNgols() + " gols");
        } 
        
    }
}