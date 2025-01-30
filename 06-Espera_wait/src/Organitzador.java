public class Organitzador {
    public static void main(String[] args){
        Esdeveniment esd = new Esdeveniment(5);
        
        for (int i = 1; i <= 10; i++) {
            Assistent assis = new Assistent(esd, "Assistent-" + i);
            assis.start();
        }
    }
}
