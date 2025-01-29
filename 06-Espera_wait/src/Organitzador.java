import java.util.ArrayList;
import java.util.List;

public class Organitzador {
    public static void main(String[] args){
        Esdeveniment esd = new Esdeveniment(5);
        
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Assistent assistent = new Assistent(esd, "Assistent-" + i);
            Thread thread = new Thread(assistent);
            threads.add(thread);
            thread.start();
        }
    }
}
