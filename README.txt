Stoica Vladut Cristian

Deck.java
	In constructor imi creez pachetul de carti (52), de fiecare culoare, pe care le retin intr-un arrayList de tipul Deck, si imi initialized un jucator si un dealer.
	
	In functia draw, se genereaza un numar random (intre 0 si 52) si este extrasa cartea din arraylist-ul Deck, aceasta fiind elimita din arrayList, ca sa nu mai fie inca odata extrasa.
	
	In functia firsHand, fac doua extrageri de carti, odata pentru jucator, si odata pentru dealer, si de asemenea verific daca jucatorul are un natural Blackjack, caz in care 
	setez un flag.
	
	In functia playing, mai intai verific daca exista un natural blackjack, iar in caz ca exista, jucatorul nu mai are dreptul sa mai extraga o carte, verificand cartea ascunsa 
a dealerului. Verific daca suma cartilor jucatorului depaseste 21, caz in care verific daca are vreun AS (si pot sa transform din 11 in 1, vreun AS din cartile lui, astfel 
incat sa imi ofere o valoare cat mai apropiata de 21, sau chiar 21).Citesc de la tastaura urmatoarea mutare a jucatorului, daca mai extrage o carte, sau nu.
Recalculez suma cartilor jucatorului, astfel incat daca are vreun AS si poate fi transformat din 11 in 1 astfel incat sa imi ofere o suma mai apropiata de 21, sau chiar 21. Dupa
care afisez cartea ascunsa a dealerului, iar daca suma cartilor sale nu a depasit 17, mai extrag inca o carte. 
In final daca ambii jucatori au acelasi nr de puncte (se termina egal), daca jucatorul are peste 21 de puncte, dealerul castiga, daca jucatorul are un natural blackjack, iar dealerul 
nu, jucatorul castiga, iar daca are se termina egal.

Player.java
	In functia, recalculatePlayer, calculeaza suma totala a cartilor jucatorului in functie de punctajul acestora.
	In functia, recalculateHand, se verifica daca suma totala a cartilor jucatorului a depasit 21, caz in care este verificat daca exista vreun AS, si se poate tranforma din punctaj 
de 11 in punctaj de 1, astfel incat sa dea o valoare cat mai apropiata de 21, sau chiar 21, iar daca exista, valoarea cartii AS se seteaza pe 1.

Dealer.java
	In functia addCard se verifica daca suma cartilor dealerului > 17, caz in care nu se mai face o extractie, doar in cazul in care s-a depasit suma de 21, si exista vreun AS ,
caz in care se transforma punctajul de 11 al AS-ului intr-un punctaj de 1, astfel incat sa dea un punctaj mai apropiat de 21, sau chiar 21. Daca suma cartilor este < 17, se mai face
o extragere de carte.

Punctajul cartii AS a fost implicit 11. Aceasta s-a recalculat pentru jucator, cum ii este lui mai favorabil (sa dea o valoare cat mai apropiata de 21), iar pentru dealer, aceasta
s-a recalculat doar in cazul in care suma cartilor ce continea cartea AS, a depasit 21 (nu s-a specificat acest lucru in cerinta, insa asa am gasit in documentatie pe internet).
