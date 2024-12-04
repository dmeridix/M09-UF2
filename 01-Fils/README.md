Comportament 1
Es el codi principal del repositori

Comportament 2
Codi afegit
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");
        
        pepe.setPriority(Thread.MAX_PRIORITY);  <---
        juan.setPriority(Thread.MIN_PRIORITY);  <---

        juan.start();
        pepe.start();