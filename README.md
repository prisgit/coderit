# coderit
usato pattern Singleton per popolare lista dipendenti
diagramma delle classi con una sintassi simil-UML
ho fatto delle assunzioni:
- ho scelto di non inserire gli anni di anzianità come attributo di dipendente per non doverlo modificare ogni anno. Per questo però ho dovuto "impostare" arbitrariamente una data di assunzione compatibile con i dati forniti
- ho scelto di tenere l'informazione del riporto in un attributo di dipendente e non, ad esempio, di creare un array specifico per manager e dirigenti con l'elenco degli id dei dipendenti che riportano a loro. La scelta è dettata da una maggiore facilità di aggiornamento nel caso in cui un dipendente dovesse cambiare riporto. 

Avevo un dubbio sulle modalità di calcolo dei bonus, chiarito da Coderit: i bonus di chi sta sopra nella gerarchia si calcolano sugli stipendi di chi sta sotto nella gerarchia già comprensivi di bonus (esempio: se un manager percepisce 2235 € di stipendio di cui 2000 € di stipendio base e 235 € di bonus, il bonus del dirigente si calcola come il 10% di 2235 €, non di 2000 €).

Ho suddiviso le classi in 4 package:
1.data: contiene i dati, cioè le classi Dipendente e ListaDipendenti
2.app: contiene l'applicazione vera e propria con i metodi di calcolo
3.utils: contiene la classe StaffUtilities con alcune costanti ed un metodo potenzialmente "riusabili"
4.test: contiene la classe col metodo main
