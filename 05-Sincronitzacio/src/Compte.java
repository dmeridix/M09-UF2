public class Compte {
    private static Compte comp = new Compte();
    private float saldo =0;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public static Compte getInstance(){
        return comp;
    }

    private Compte(){
        if (comp != null) {
            throw new IllegalStateException("Nomès pot existir una instancia");
        }
    }
}
