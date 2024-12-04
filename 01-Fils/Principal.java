public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");

        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");

        juan.start();
        pepe.start();

        try {
            juan.join();
            pepe.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
