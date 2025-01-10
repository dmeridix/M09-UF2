import java.util.Random;

public class DormAleatori extends Thread {
    private final long tempsActual;

    public DormAleatori(String name) {
        super(name);
        this.tempsActual = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int interval = random.nextInt(1000);
            long tempsTransc = System.currentTimeMillis() - tempsActual;
            System.out.printf("%s(%d) a dormir %dms total %d\n", getName(), i, interval, tempsTransc);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.err.println(getName() + ": " + e);
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}