import java.util.Random;

public class Soci extends Thread{
    private static final Compte comp = Compte.getInstance();
    
    private float aportacio;
    private int esperaMax;
    private Random rnd;
    private int maxAnys;
    
    public Soci() {
        this.aportacio = 10f;
        this.esperaMax = 100;
        this.rnd = new Random();
        this.maxAnys = 10;
    }
    
    public Compte getComp() {
        return comp;
    }

    @Override
    public void run(){
        try {
            for (int anyactual = 0;anyactual<maxAnys;anyactual++){
                for(int i = 0; i <12;i++){
                    if(i%2==0){
                        comp.setSaldo(comp.getSaldo() + aportacio);
                    }else{
                        comp.setSaldo(comp.getSaldo() - aportacio);
                    }
                    int interval = rnd.nextInt(esperaMax);
                    Thread.sleep(interval);
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Cicle interromput.");
        }
    }
    
}
