# Activitat 01: Programació de Fils

---

## **Comportament 1**
### Descripció:
És el codi principal del repositori. En aquest comportament, els fils **Juan** i **Pepe** s'executen de manera intercalada, però no estrictament.

### Resultat:
![Comportament 1](https://github.com/user-attachments/assets/a5bfe5f7-d527-4a68-93f4-4b7987e009d8)

---
## **Comportament 2**

### Descripció:
Per a aquest comportament, hem afegit prioritat als fils. Això permet que el fil **Pepe** tingui més probabilitat d'executar-se primer que **Juan**.

### Codi afegit:
```java
Fil juan = new Fil("Juan");
Fil pepe = new Fil("Pepe");

pepe.setPriority(5);    <--- Prioritat més alta per a Pepe
juan.setPriority(2);    <--- Prioritat més baixa per a Juan

juan.start();
pepe.start();
```

### Resultat:
![image](https://github.com/user-attachments/assets/e7770e4a-944b-4c88-9f85-9c989047c75d)

---
## **Comportament 3**

### Descripció:
En aquest comportament, hem garantit que els fils **Juan** i **Pepe** s'executin de manera estrictament alternada. A més, hem eliminat l'ús del mètode `setPriority` del comportament anterior.

### Codi afegit:
```java
public void run() {
    for (int i = 1; i <= 9; i++) {
        System.out.println(name + " " + i);
        try {                                                                    <---
            Thread.sleep(100); // Controla la intercalación amb un delay         <---
        } catch (InterruptedException e) {                                       <---
            System.out.println("Error al aplicar el sleep " + e);                <---
        }                                                                        <---
    }
    System.out.println("Termina el fil " + name);
}
```

### Codi eliminat:
```java
Fil juan = new Fil("Juan");
Fil pepe = new Fil("Pepe");

pepe.setPriority(5);    <--- Prioritat més alta per a Pepe
juan.setPriority(2);    <--- Prioritat més baixa per a Juan

juan.start();
pepe.start();
```

### Resultat:
![image](https://github.com/user-attachments/assets/f6c6d622-929d-4ebc-95f5-d0c0863c3ece)
