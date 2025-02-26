import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana = 0;
    private int num;
    
    private final Random random = new Random();

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

    private void menjar() {
        agafarForquilles();
    }

    private void agafarForquilles() {
        agafaForquillaEsquerra();
        agafaForquillaDreta();
    }

    private synchronized void agafaForquillaEsquerra() {
        while (forquillaEsquerra.getPropietari() != -1) {
            gana++;
            System.out.println("Filòsof: " + num + " intenta l'esquerra(" + forquillaEsquerra.getNumero() + ") i esta ocupada");
            System.out.println("Filòsof: " + num + " gana=" + gana);
            try {
                Thread.sleep(random.nextInt(500) + 500);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        forquillaEsquerra.setPropietari(num);
        System.out.println("Filòsof: " + num + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
    }

    private synchronized void agafaForquillaDreta() {
        if (forquillaDreta.getPropietari() != -1) {
            System.out.println("Filòsof: " + num + " deixa l'esquerra(" + forquillaEsquerra.getNumero() + ") i espera (dreta ocupada)");
            forquillaEsquerra.setPropietari(-1);
            notifyAll();
            gana++;
            System.out.println("Filòsof: " + num + " gana=" + gana);
            try {
                Thread.sleep(random.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        forquillaDreta.setPropietari(num);
        System.out.println("Filòsof: " + num + " agafa la forquilla dreta " + forquillaDreta.getNumero());
        System.out.println("Filòsof: " + num + " menja");
        gana = 0;
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Filòsof: " + num + " deixa de menjar");

        deixarForquilles();
    }

    private synchronized void deixarForquilles() {
        System.out.println("Filòsof: " + num + " deixa les forquilles");
        forquillaEsquerra.setPropietari(-1);
        forquillaDreta.setPropietari(-1);
        notifyAll();
    }

    private void pensar() {
        System.out.println("Filòsof: " + num + " pensant");
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
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