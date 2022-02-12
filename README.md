# Tutoriumsfolien

Dies sind die historisch gewachsenen LaTeX-Quelle für die Eidi-Tutoriums-Folien von Florian Sihler.
Diese Version hier ist eine aus dem Eidi-Repo extrahierte Quelle mit veränderter History und leicht modifizierten
Inhalten um Einzelpersonen anonym zu halten.

Andere Dateien wurden nachträglich entfernt und bleiben in der History, einfach nur weil sie aus historischen Gründen
keine Bedeutung mehr haben.

## Übersicht

Zum Kompilieren empfiehlt sich das Docker-Image. Basteln mit: `make docker`
Danach kann das Skript [`run-docker`](run-docker) verwendet werden (oder auf anderen Betriebssystemen ein vergleichbares Kommando zum starten von Docker-Containern verwenden).

Sonst haben die Ordner folgende Bedeutung:

* [`all_pdfs`](all_pdfs): Hier landen die PDFs. In [`all_pdfs/animated`](all_pdfs/animated) gibt es auch die Varianten mit Animationen.
* `*-Tutorium`: Referenziert das Tutorium zum jeweiligen Blatt (sowie [`Org-Tutorium`](Org-Tutorium) für den Anfang :D)
* [`Dockerfile`](Dockerfile), [`rename-fb`](rename-fb) und [`run-docker`](run-docker): Damit es (hoffentlich) nicht nur bei mir läuft :D
* [`tikz-horner.sty`](tikz-horner.sty): Eine Altlast zum automatischen generieren von Animationen für das Horner-Schema in LaTeX :D
* [`ttt.sty`](ttt.sty): Eine Semi-Altlast für Tic-Tac-Toe (brrrrh, Memories)
* [`makefile`](makefile): Wer weiß was er tut, kann das auch direkt benutzen um seinen Spaß zu haben.
* [`global.src`](global.src): So etwas wie die gemeinsame Präambel aller Foliensätze. Zusammengetackert, damit es auch ohne ein ganzes Ökosystem funktioniert.

## Bonusfolien

Die Episoden & Boni sind auf Github:

* [Rekursion](https://github.com/EagleoutIce/Episode-Recursion)
* [Heaps](https://github.com/EagleoutIce/Episode-Heaps)
* [In-Place Merge-Sort](https://github.com/EagleoutIce/Episode-Inplace)
* [Traversierung](https://github.com/EagleoutIce/Episode-Traversierung)
* [Weihnachtswiederholung](https://github.com/EagleoutIce/christmas-eidi-recap)
*