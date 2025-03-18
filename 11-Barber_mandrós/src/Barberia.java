import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private Queue<Client> salaEspera;
    private int maxCadires;
    private Object condBarber;
    private static Barberia instancia;

    private Barberia(int maxCadires) {
        this.salaEspera = new LinkedList<>();
        this.maxCadires = maxCadires;
        this.condBarber = new Object();
    }

    public static Barberia getInstance(int maxCadires) {
        if (instancia == null) {
            instancia = new Barberia(maxCadires);
        }
        return instancia;
    }

    public Client seguentClient() {
        synchronized (condBarber) {
            if (!salaEspera.isEmpty()) {
                return salaEspera.poll();
            }
            return null;
        }
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    public void executa() {
        new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Client client = new Client(i);
                entrarClient(client);
            }
        }).start();
    }

    public Object getCondBarber() {
        return condBarber;
    }

    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstance(3);
        Barber barber = new Barber("Pepe", barberia);

        barber.start();
        barberia.executa();
    }
}