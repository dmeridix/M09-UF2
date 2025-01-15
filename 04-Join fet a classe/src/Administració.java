public class Administració {
    private static int num_poblacio_activa = 50;
    private static Treballador[] ciutada = new Treballador[num_poblacio_activa];;

    // Constructor per a inicialitzar tots els treballadors amb un sou, edat_inici, edat_fi i un numero que li assigna en concret
    public Administració(){
        for (int i = 0; i < ciutada.length; i++) {
            ciutada[i] = new Treballador(25000,20,65, i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Administració am = new Administració();
        
        // Arranquem tots els treballadors
        for (Treballador tr : ciutada){
            tr.start();
        }

        // Esperem a que terminin tots els treballadors
        for (Treballador tr : ciutada){
            tr.join();
        }

        // Mostrem la informació dels Treballadors
        for (Treballador tr : ciutada){
            System.out.printf("Ciutadà-%d -> edat: %d / total: %.2f%n", tr.getNum() , tr.getEdat_actual(), tr.getCobrat());
        }
    }
}
