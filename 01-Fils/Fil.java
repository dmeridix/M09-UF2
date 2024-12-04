public class Fil extends Thread {
    private final String name;

    public Fil(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(100); // Es el que fa que intercali les trucades del Fil
            } catch (InterruptedException e) {
                System.out.println("Error al aplicar el sleep: " + e);
            }
        }
        System.out.println("Termina el fil " + name);
    }
}
