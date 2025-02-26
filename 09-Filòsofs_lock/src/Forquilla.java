import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private final int numero;
    public final ReentrantLock bloqueig = new ReentrantLock(true);

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void agafar() {
        bloqueig.lock();
    }

    public void deixar() {
        if (bloqueig.isHeldByCurrentThread()){
            bloqueig.unlock();
        }
    }
}
