
public class Fumador implements Runnable {
    private final int id;
    private final Estanc estanc;
    private int fumades = 0;

    public Fumador(int id, Estanc estanc) {
        this.id = id;
        this.estanc = estanc;
    }

    private void fumar() throws InterruptedException {
        System.out.println("Fumador " + id + " fumant...");
        Thread.sleep((long) (500 + Math.random() * 500));
        fumades++;
    }

    @Override
    public void run() {
        try {
            while (fumades < 3) {
                estanc.venTabac();
                estanc.venPaper();
                estanc.venLlum();
                fumar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}