import java.util.Random;

public class Filosof extends Thread {
    private final int nom;
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    public int getNom() {
        return nom;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    private long iniciGana;
    private long fiGana;
    private long Gana;
    private final Random random = new Random();


    public Filosof(int nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    @Override
    public void run() {
        try {
            while (true) {
                menjar();
                pensar();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void menjar() throws InterruptedException {
        while (true) {
            if (agafarForquilles()) {
                fiGana = System.currentTimeMillis();
                calcularGana();
                System.out.println(nom + " menja amb gana " + Gana);
                Thread.sleep(random.nextInt(1000) + 1000);
                resetGana();
                deixarForquilles();
                System.out.println(nom + " a acabat de menjar");
            }else{
                Thread.sleep(random.nextInt(500) + 500);
            }
        }
    }
    

    public boolean agafarForquilles() {
        if (!forquillaEsquerra.bloqueig.isLocked()) {
            if (!forquillaDreta.bloqueig.isLocked()){
                return true;
            }else{
                return false;
            }
        }else{return false;}
    }

    public void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar();
        System.out.println("Fi: " + nom + " agafa la forquilla esquerra (" + forquillaEsquerra.getNumero() + ")");
    }

    public void agafarForquillaDreta() {
        forquillaDreta.agafar();
        System.out.println("Fi: " + nom + " agafa la forquilla dreta (" + forquillaDreta.getNumero() + ")");
    }

    public void deixarForquilles() {
        forquillaDreta.deixar();
        System.out.println("Fi" + nom + " ha deixat la forquilla dreta.");
        forquillaEsquerra.deixar();
        System.out.println("Fi" + nom + " ha deixat la forquilla esquerra.");
    }

    public void pensar() throws InterruptedException {
        System.out.println("Fi" + nom + " pensant");
        iniciGana = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long calcularGana() {
        return (fiGana - iniciGana)/1000;
    }

    public void resetGana() {
        iniciGana = System.currentTimeMillis();
        Gana = 0;
    }
}
