import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
   
    private List<Assistent> llista;
    private int placesDisponibles;
    private int placesMaximes;

    public Esdeveniment(int plazas){
        llista = new ArrayList<>(plazas);
        this.placesDisponibles = plazas;
        this.placesMaximes = plazas;
    }

    public synchronized void ferReserva(Assistent asis){
        while (placesDisponibles == 0) {
            try {
                System.out.println(asis.getNom() + " no ha pogut fer una reserva ja que no hi ha places disponibles.");
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        if (placesDisponibles > 0) {
            llista.add(asis);
            placesDisponibles--;
            notifyAll();
            System.out.println(asis.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
        }
    }

    public synchronized void cancelaReserva(Assistent asis){
        if (llista.size() > placesMaximes) {
            System.out.println("No es poden cancel·lar més reserves que les places màximes.");
            return;
        }

        while (!llista.contains(asis)) {
            try {
                System.out.println(asis.getNom() + " no ha pogut cancel·lar una reserva inexistent.");
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        if (llista.contains(asis)) {
            llista.remove(asis);
            placesDisponibles++;
            notifyAll();
            System.out.println(asis.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
        }
    }
}
