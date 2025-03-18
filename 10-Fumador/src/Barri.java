
public class Barri {
    public static void main(String[] args) throws InterruptedException {
        Estanc estanc = new Estanc();
        Thread subministrament = new Thread(estanc::nouSubministrament);
        Fumador[] fumadors = {new Fumador(0, estanc), new Fumador(1, estanc), new Fumador(2, estanc)};
        Thread[] filsFumadors = new Thread[fumadors.length];
        
        for (int i = 0; i < fumadors.length; i++) {
            filsFumadors[i] = new Thread(fumadors[i]);
            filsFumadors[i].start();
        }
        
        subministrament.start();
        for (Thread fil : filsFumadors) fil.join();
        
        estanc.tancarEstanc();
        subministrament.join();
    }
}
