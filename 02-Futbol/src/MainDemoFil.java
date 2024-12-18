
public class MainDemoFil {
    public static void main(String[] args) {
        Thread th = Thread.currentThread();
        System.out.println("Nom: " + th.getName() + "\tPrioritat: " + th.getPriority() + "\ttoString: " + th.toString());
    }
}
