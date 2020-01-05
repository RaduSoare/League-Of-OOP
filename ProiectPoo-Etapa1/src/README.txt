
Student: Soare Radu-Georgian
Grupa: 323CD
League Of OOP - Etapa 2

Design Patterns:
* Factory:
- folosit pentru crearea ingerilor si strategiilor.
* Strategy:
- am creat interfata PlayerStrategy ce contine cele 2 strategii cerute si
o metoda care alege strategia necesara in functie de HP.
- interfata este implementata de cate o clasa corespunzatoare fiecarui tip de
erou.
- este aplicat la parcurgerea hartii, se parcurge lista de jucatori de pe 
terenul respectiv si se alege pentru fiecare strategia necesara, daca este
cazul.
* Visitor:
- clasa abstracta Player este vizitata si contine prototipul functiei getBuff.
- clasa abstracta Angel este vizitatorul si contine prototipurile functiilor
buff corespunzatoare fiecarui tip de jucator.
- este aplicat la sfarsitul fiecarei runde cand Ingerul dintr-un teren isi
aplica efectul pe ficare jucatorul din acel teren, daca este cazu.l
* Observer:
- interfata Observable contine prototipurile functiilor pentru attach, detach 
si notify.
- interfata Observer contine prototipul functiei update.
- clasa GreatMagician implementeaza update si scrie in fisier "observatiile" 
cerute de Marele Magician.

Modificari fata de etapa anterioara:
- aplicarea strategiilor in functie de HP, ceea ce a constat in adunarea unui
nou modificator la skill-urile eroilor.
- aplicarea efectelor ingerilor, ceea ce a constat in modificarea HP-ului, 
adaugarea modificatorilor si a uciderii/invierii unui jucator.
- notificarea observerului care nota in fisier informatiile cerute.





