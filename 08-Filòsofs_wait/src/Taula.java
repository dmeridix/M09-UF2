import java.util.ArrayList;
import java.util.List;

public class Taula {
    private List<Filosof> comensals;
    private List<Forquilla> forquilles;

    public Taula(int numComensals) {
        this.comensals = new ArrayList<>();
        this.forquilles = new ArrayList<>();

        for (int i = 0; i < numComensals; i++) {
            this.forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numComensals; i++) {
            Forquilla esquerra = this.forquilles.get(i);
            Forquilla dreta = this.forquilles.get((i + 1) % numComensals);

            this.comensals.add(new Filosof(i,esquerra, dreta));
        }
    }

    public void showTaula() {
        for (int i = 0; i < comensals.size(); i++) {
            Filosof f = comensals.get(i);
            System.out.println("Comensal:" + f.getNum() +
                               "  esq:" + f.getForquillaEsquerra().getNumero() +
                               "  dret:" + f.getForquillaDreta().getNumero());
        }
    }
    
    public void cridarTaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }
    public class Main {
        public static void main(String[] args) {
            Taula taula = new Taula(4);
            taula.showTaula();
            System.out.println("---------------------------");
            taula.cridarTaula();
        }
    }
    
}
