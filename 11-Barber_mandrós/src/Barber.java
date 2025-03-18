public class Barber extends Thread {
    private String nom;
    private Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient();
            if (client == null) {
                System.out.println("Barber " + nom + " dormint");
                synchronized (barberia.getCondBarber()) {
                    try {
                        barberia.getCondBarber().wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                System.out.println("Li toca al client " + client.getNom());
                tallarCabell(client);
            }
        }
    }

    private void tallarCabell(Client client) {
        System.out.println("Tallant cabell a " + client.getNom());
        try {
            Thread.sleep(900 + (long) (Math.random() * 100));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}