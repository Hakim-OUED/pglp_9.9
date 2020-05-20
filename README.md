# pgpl_9.9
# Logiciel de dessin

Le but de cet application est de réaliser un logiciel de dessin. On se limite ici à un affichage textuel, i.e. seule une description des figures est affichée. Par exemple, un cercle de centre (0, 0) et de rayon 50 sera "affiché" par la chaîne de caractères "Cercle(centre=(0,0),rayon=50)".

L'utilisateur interagit avec l'application par l'intermédiaire de la ligne de commandes. Chaque commande débute par une instruction suivie des arguments de cette instruction. Par exemple, pour créer un cercle, l'utilisateur pourra taper "c1 = Cercle((0, 0), 50)", puis pour le déplacer "move(c1, (10, 20))".

Le logiciel offre les fonctionnalités suivantes:
* Chaque forme est identifiée par un nom ("c1", "unCercle", ...).
* L'application permett de manipuler des cercles, des rectangles, des carrés et des triangles.
* Chaque forme peut être être affichée et déplacée.
* Les formes peuvent être regroupées et pourront subir des traitements globaux comme par exemple déplacer ensemble un cercle et un triangle.
* Un dessin (ensemble de formes) peut être sauvegardé/chargé dans un SGBD embarqué c [Derby](https://db.apache.org/derby/).
