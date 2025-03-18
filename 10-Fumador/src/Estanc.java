import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    private List<Tabac> tabac = new ArrayList<>();
    private List<Paper> paper = new ArrayList<>();
    private List<Llum> llumins = new ArrayList<>();
    private boolean obert = true;
    private final Random random = new Random();
    
    public synchronized void nouSubministrament() {
        while (obert) {
            try {
                Thread.sleep((long) (500 + Math.random() * 1000));
                int rand = random.nextInt(3);
                switch (rand) {
                    case 0 -> { addTabac(); System.out.println("Afegint Tabac"); }
                    case 1 -> { addPaper(); System.out.println("Afegint Paper"); }
                    case 2 -> { addLlum(); System.out.println("Afegint Llum"); }
                }
                notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public synchronized void addTabac() { tabac.add(new Tabac()); }
    public synchronized void addPaper() { paper.add(new Paper()); }
    public synchronized void addLlum() { llumins.add(new Llum()); }
    
    public synchronized Tabac venTabac() throws InterruptedException {
        while (tabac.isEmpty() && obert) {
            System.out.println("Fumador esperant Tabac...");
            wait();
        }
        System.out.println("Fumador comprant Tabac");
        return tabac.remove(0);
    }
    public synchronized Paper venPaper() throws InterruptedException {
        while (paper.isEmpty() && obert) {
            System.out.println("Fumador esperant Paper...");
            wait();
        }
        System.out.println("Fumador comprant Paper");
        return paper.remove(0);
    }
    public synchronized Llum venLlum() throws InterruptedException {
        while (llumins.isEmpty() && obert) {
            System.out.println("Fumador esperant Llum...");
            wait();
        }
        System.out.println("Fumador comprant Llum");
        return llumins.remove(0);
    }
    
    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
    }
}
