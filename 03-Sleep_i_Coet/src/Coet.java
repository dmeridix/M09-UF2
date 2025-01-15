import java.util.Scanner;


public class Coet {
    private final Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.err.println("Error: potència fora de rang");
            return;
        }
        System.out.println("Passant a potència " + p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
            if (!motor.isAlive()) {
                motor.start();
            }
        }
    }

    public void arranca() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introdueix la potència (0-10, 0 per acabar): ");
            int potencia = scanner.nextInt();
            if (potencia == 0) {
                passaAPotencia(0);
                break;
            }
            passaAPotencia(potencia);
        }
        scanner.close();
        for (Motor motor : motors) {
            try {
                motor.join();
            } catch (InterruptedException e) {
                System.err.println("Error esperant el motor ");
            }
        }
        System.out.println("Programa finalitzat.");
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();
    }
}