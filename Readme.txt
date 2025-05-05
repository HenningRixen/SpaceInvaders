Todo:





performace optimiert								check Läuft mit Community IntelliJ butterweich
collission möglich machen 							check schüsse mit enemy
- potentielle Ausbaustufe: Collision einseitig machen oder verschiedene Collisionsflags mit verschiedenen Auswirkungen auf beiden Seiten der Collision
- wäre es möglich, die Collision zu einer Interaktion von zwei Klassen (Enemy, Player und Bullet) zu machen, der eine Flag für den konkreten Effekt der Collision mitbekommt?
wenn die enmemys eine bestimmte stelle erreichen leben spieler abziehen 
hintergrund muss rein
enemy schreiben 								check
schüsse implementieren								check
leben von player und enemy							leben von enemy check
mehr enemy typen
- erstmal simpel halten, können wir später immer noch erweitern
boss battle
unterschiedliche schwierigkeitsgrade
- würde ich erstmal hinten anstellen
shop mit upgrades für player
- würde ich erstmal hinten anstellen
score einfügen
start screen
game over screen
highscore
multiplayer
- sollten wir nochmal drüber reden
wellen einfügen 
unterschiedliche enemys mit schüssen?
- würde ich erstmal simpel halten und später ggf. erweitern
Sounds für Schuss, Treffer, getroffen werden/Lebensverlust, Wellenstart, Bosskampf
besondere Screens/Schrift-Overlays beim Start einer neuen Welle/Bosskampf
- ggf. auch für den Start, hier könnten wir einen kleinen Countdown einfügen bis zur ersten Welle (vielleicht auch vor dem Bosskampf - oder einfach den Overlay vor dem Bosskampf etwas länger und imposanter machen als bei normalen Wellen)
potentiell Wellencounter
(simple) Musik
Steuerungsschema erweitern: Pfeiltasten und Enter (ließe sich für lokales Coop verwenden oder einfach nur als alternatives Steuerungschema)
                                    Check; derzeitiges Problem: Bewegungen in die gleiche Richting (z.B. W und Up gleichzeitig) stacken
eventuell könnten wir das Schießen des Spielers über verschiedene Klassen regeln (eigene Klasse für die einzelnen Waffen?), die alle die gleiche Methode shoot() verschiedenen implementieren, um verschiedenes Verhalten zu ermöglichen
- ich würde auch den Schaden der Bullet von der Bullet oder der Waffe abhängig machen (potentiell noch modifiziert durch die Spielerklasse oder Power-ups)