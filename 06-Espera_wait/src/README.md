# Preguntes teòriques

## 1. Per què s’atura l’execució al cap d’un temps?
Perquè quan totes les places estan ocupades o lliures (depenent de si hi ha més assitent cancel·lant o reservant), els assistents que volen reservar entren en espera. Si no hi ha prou cancel·lacions o reservas, els fils queden bloquejats ja que no existeixen més assistents que pugui fer cap de les dues opcions.


## 2. Què passaria si en lloc d’una probabilitat de 50%-50% fos 70% fer reserva i 30% cancel·lar? I si fos al revés?
Que les places s’omplen més ràpid perque hi han més reserves i els assistents acaben bloquejats en espera. Si fos al revés, hi ha més cancel·lacions i el sistema manté més places lliures, evitant bloquejos freqüents.



## 3. Per què fa falta la llista i no n’hi hauria prou amb una variable sencera de reserves?
Fa falta la llista perque permet saber quins assistents han fet una reserva i pot controlar casos com que algú cancel·li sense haver reservat abans. Amb només una variable sencera no es podria controlar això i es podrien produir errors.
