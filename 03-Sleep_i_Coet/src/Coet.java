import java.util.Scanner;

public class Coet {
    private final Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
            motors[i].start();
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.err.println("Error: potència fora de rang");
            return;
        }
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introdueix la potència objectiu (0 per sortir): ");
            int potencia = scanner.nextInt();
            if (potencia == 0) {
                passaAPotencia(0);
                break;
            }
            passaAPotencia(potencia);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();
    }
}