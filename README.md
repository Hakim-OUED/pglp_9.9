# Logiciel de dessin

Le but de ce projet est de réaliser un logiciel de dessin. On se limite à un affichage textuel, i.e. seule une description des figures est affichée. Par exemple, un cercle de centre (0, 0) et de rayon 50 sera "affiché" par la chaîne de caractères "Cercle(centre=(0,0),rayon=50)".

L'utilisateur interagit avec l'application par l'intermédiaire de la ligne de commandes. Chaque commande débute par une instruction suivie des arguments de cette instruction.

Le logiciel offre les fonctionnalités suivantes:


# Outils:
* Maven
* JDBC
* Derby

# mise en oeuvre:

## Fonctionnalité: 
* Opération CRUD
* Chaque forme est identifiée par un nom ("c1", "unCercle", ...).
* L'application permet de manipuler des cercles, des rectangles, des carrés et des triangles.
* Chaque forme peut être être affichée et déplacée.
* Les formes peuvent être regroupées et pourront subir des traitements globaux comme par exemple déplacer ensemble un cercle et un triangle.
* Un dessin peut être sauvegardé/chargé dans le SGBD embarqué DERBY
