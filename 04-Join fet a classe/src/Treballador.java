import java.util.Random;

public class Treballador extends Thread{
    private int sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private double cobrat;
    private int Num;
    private Random rnd = new Random();
    
    // Constructor del Treballador
    public Treballador(int sou, int edat_inici, int edat_fi, int num){
        this.sou_anual_brut = sou;
        this.edat_inici_treball = edat_inici;
        this.edat_fi_treball = edat_fi;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.Num = num;
    }
    
    public int getNum() {
        return Num;
    }
    public double getCobrat() {
        return cobrat;
    }
    public int getEdat_actual() {
        return edat_actual;
    }
    public void cobra(){
        cobrat = cobrat + sou_anual_brut /12;
    }

    // Mètode on resta els impostos que ha de pagar a la propietat cobrat
    public void pagaImpostos(){
        double pagar = sou_anual_brut /12;
        cobrat = cobrat - (pagar*0.24);
    }

    // Modifiquem el run perquè per cada any es cobri i es pagui impostos cada mes
    @Override
    public void run(){
        try {
            for (edat_actual = edat_inici_treball;edat_actual<edat_fi_treball;edat_actual++){
                for(int i = 0; i <12;i++){
                    cobra();
                    Thread.sleep(10);
                    pagaImpostos();
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Cicle interromput.");
        }
    }
}
