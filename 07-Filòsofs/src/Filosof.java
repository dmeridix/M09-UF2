import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana=0;
    private String nom="";
    private Random random = new Random();
    
    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int getGana() {
        return gana;
    }

    public void setGana(int gana) {
        this.gana = gana;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    private void menjar(){
        while (true) {
            if (!forquillaDreta.isEnUs()){
                forquillaEsquerra.setEnUs(true);
                System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
                
                if (!forquillaDreta.isEnUs()){
                    System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getNumero());
                    System.out.println("Filòsof: " + nom + " menja");
                    gana = 0;
                    
    
                    try {
                        Thread.sleep(random.nextInt(1000) + 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    forquillaDreta.setEnUs(false);
                    forquillaEsquerra.setEnUs(false);
                    System.out.println("Filòsof: " + nom + " deixa de menjar");

                    return;
                }
                else{
                    System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + forquillaEsquerra.getNumero() + ") i espera (dreta ocupada)");
                    forquillaEsquerra.setEnUs(false);
                    gana++;
                    System.out.println("Filòsof: " + nom + " gana=" + gana);
                }
                
            }
            else{
                System.out.println("Filòsof: " + nom + " intenta l'esquerra(" + forquillaEsquerra.getNumero() + ") i esta ocupada");
                gana++;
                System.out.println("Filòsof: " + nom + " gana=" + gana);
            }
            try {
                Thread.sleep(random.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void pensar(){
        System.out.println("Filòsof: " + nom + " pensant");
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) { 
            menjar(); 
            pensar(); 
        }
    }
}
