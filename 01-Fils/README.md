Comportament 1
Es el codi principal del repositori
![image](https://github.com/user-attachments/assets/a5bfe5f7-d527-4a68-93f4-4b7987e009d8)

Comportament 2
Codi afegit
Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");

        pepe.setPriority(5);    <---
        juan.setPriority(2);    <---

        juan.start();
        pepe.start();
![image](https://github.com/user-attachments/assets/e7770e4a-944b-4c88-9f85-9c989047c75d)

Comportament 3
Codi afegit
public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(name + " " + i);
            try {                                                                    <---
                Thread.sleep(100); // Controla la intercalación con un delay         <---
            } catch (InterruptedException e) {                                       <---
                System.out.println("Error al aplicar el sleep " + e);                <---
            }                                                                        <---
        }
        System.out.println("Termina el fil " + name);
    }
Hem d'eliminar el setPriority del anterior comportament
![image](https://github.com/user-attachments/assets/f6c6d622-929d-4ebc-95f5-d0c0863c3ece)
