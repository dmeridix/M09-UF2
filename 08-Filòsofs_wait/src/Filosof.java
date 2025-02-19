import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana=0;
    private int num;
    
    private Random random = new Random();
    
    public Filosof(int num, Forquilla esquerra, Forquilla dreta) {
        this.num = num;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
    }
    
    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }
    
    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }
    
    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }
    
    public int getGana() {
        return gana;
    }
    
    public void setGana(int gana) {
        this.gana = gana;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    private void menjar(){
            agafarForquilles();
    }
    private void agafarForquilles(){
        agafaForquillaEsquerra();
        agafaForquillaDreta();
    }
    private void agafaForquillaEsquerra(){
        if (forquillaEsquerra.getPropietari() == -1){
                forquillaEsquerra.setPropietari(num);
                System.out.println("Filòsof: " + num + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
                
            }
            else{
                System.out.println("Filòsof: " + num + " intenta l'esquerra(" + forquillaEsquerra.getNumero() + ") i esta ocupada");
                gana++;
                System.out.println("Filòsof: " + num + " gana=" + gana);
            }
            try {
                Thread.sleep(random.nextInt(500) + 500);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    private void agafaForquillaDreta(){
        if (forquillaDreta.getPropietari() == -1 ){
            System.out.println("Filòsof: " + num + " agafa la forquilla dreta " + forquillaDreta.getNumero());
            System.out.println("Filòsof: " + num + " menja");
            gana = 0;
            try {
                Thread.sleep(random.nextInt(1000) + 1000);
                System.out.println("Filòsof: " + num + " deixa de menjar");
                deixarForquilles();
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        else{
            System.out.println("Filòsof: " + num + " deixa l'esquerra(" + forquillaEsquerra.getNumero() + ") i espera (dreta ocupada)");
            deixarForquilles();
            gana++;
            System.out.println("Filòsof: " + num + " gana=" + gana);
        }
    }
    private void deixarForquilles(){
        forquillaEsquerra.setPropietari(-1);
        forquillaDreta.setPropietari(-1);
        notifyAll();
    }
    private void pensar(){
        System.out.println("Filòsof: " + num + " pensant");
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) { 
            menjar(); 
            pensar(); 
        }
    }
}