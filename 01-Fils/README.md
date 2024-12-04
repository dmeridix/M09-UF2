Comportament 1
Es el codi principal del repositori
![image](https://github.com/user-attachments/assets/c43597ae-667b-48aa-9ccd-1d0cac635cdc)

Comportament 2
Codi afegit
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");
        
        pepe.setPriority(Thread.MAX_PRIORITY);  <---
        juan.setPriority(Thread.MIN_PRIORITY);  <---

        juan.start();
        pepe.start();
