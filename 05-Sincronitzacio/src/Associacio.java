import java.util.Random;

public class Associacio {
    private int numSocis;
    private Soci[] socis;
    // Propiedad para despues selecionar un socio aleatorio
    private Random rnd = new Random();

    public Associacio(){
        this.numSocis = 1000;
        this.socis = new Soci[this.numSocis];
        for(int i = 0; i < socis.length; i++){
            socis[i] = new Soci();   
        }
    }

    public void iniciaCompteTempsSocis(){
        for(Soci soci: socis){
            soci.start();
        }
    }
    public void esperaPeriodeSocis(){
        try{
            for(Soci soci: socis){
                soci.join();
            }
        }
        catch (InterruptedException e) {
            System.err.println("Cicle interromput.");
        }
    }
    public void mostraBalancComptes(){
        int randomNum = rnd.nextInt(numSocis);
        System.out.println("Saldo: " + socis[randomNum].getComp().getSaldo());
    }

    public static void main(String[] args){
        Associacio associ = new Associacio();
        associ.iniciaCompteTempsSocis();
        associ.esperaPeriodeSocis();
        associ.mostraBalancComptes();
    }
}
