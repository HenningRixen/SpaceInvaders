Space Invaders Roadmap

Nächste schritte / gerade in bearbeitung:
spieler verliert leben -idee spieler hat drei leben und wenn gegner stelle erreicht verliert er 1
canvas zu machen henning
factory und objekte für architektur bereit machen henning
wellen jonathan

Im Auge behalten:
Performance

Kernziele MVP:

architektonische aufteilung der ebenen
spieler
kleine gegnervielfalt (3-4 eventuell boss)
der spieler und die gegner sollen leben haben
spieler verliert leben wenn die gegner eine bestimmte stelle erreichen
collission gegner schüsse
hintergrund im Weltall
mehrere schnellere Schüsse vom Spieler
boss battle
score einfügen
start menü / gameover screen / vicory screen
wellen die man besiegen kann um zu gewinnen (2-3 + boss)
aktuelle welle anzeigen
boss mit angriffsmuster (teppichmuster)
sounds: hintergrund, treffer, schuss


Ausbaustufen:
- optionen menü
- potentielle Ausbaustufe: Collision einseitig machen oder verschiedene Collisionsflags mit verschiedenen Auswirkungen auf beiden Seiten der Collision
- wäre es möglich, die Collision zu einer Interaktion von zwei Klassen (Enemy, Player und Bullet) zu machen, der eine Flag für den konkreten Effekt der Collision mitbekommt?
- mehr gegner!
- score berechnen mithilfe von z.B. zeitlichen faktoren
- gegner oder boss angriffsmuster
- sounds: wellestart, bosskampf, lebesverlust
- besondere Screens/Schrift-Overlays beim Start einer neuen Welle/Bosskampf
- ggf. auch für den Start, hier könnten wir einen kleinen Countdown einfügen bis zur ersten Welle (vielleicht auch vor dem Bosskampf - oder einfach den Overlay vor dem Bosskampf etwas länger und imposanter machen als bei normalen Wellen)
- powerups: bsp schießen des spielers über verschiedene Klassen um verschiedenes verhalten zu ermöglichen
- powerups: schaden der bullet von der bullet oder der waffe abhängig machen
- collission möglich machen für spieler gegner und gegner gegner

Wackelkandidat:
- shop mit upgrades für player
- unterschiedliche schwierigkeitsgrade


Konkrete Fragen an Betreuer:
Wie sollen wir den multiplayer umsetzen was ist realistisch (highscore/ 2 spieler)?
Wie sieht es aus mit immersion wie doll soll das gemacht werden?
Wie gut ist der rahmen ist es umsetzbar?

Überarbeiten:
Steuerungsschema erweitern: Pfeiltasten und Enter (ließe sich für lokales Coop verwenden oder einfach nur als alternatives Steuerungschema) derzeitiges Problem: Bewegungen in die gleiche Richting (z.B. W und Up gleichzeitig) stacken

Besprechungen:
Optionen: festes Jpanel aber skalierbares Jframe

