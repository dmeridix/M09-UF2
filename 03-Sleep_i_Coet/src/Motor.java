import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private final int motorId;

    public Motor(int id) {
        this.motorId = id;
    }

    public void setPotencia(int p) {
        potenciaObjectiu = p;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d\n", motorId, potenciaObjectiu, potenciaActual);
                } else if (potenciaActual > potenciaObjectiu) {
                    potenciaActual--;
                    System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d\n", motorId, potenciaObjectiu, potenciaActual);
                } else {
                    if (potenciaObjectiu == 0) {
                        System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d\n", motorId, potenciaObjectiu, potenciaActual);
                        break;
                    }
                }
                Thread.sleep(random.nextInt(2000) + 1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Motor " + motorId + " interromput.");
        }
    }
}
