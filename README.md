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


# Syntaxes

## Création d'une forme
- > Cercle:
```Nom_forme = Cercle((x,y), r) ```
x: abcisse du centre
y: ordonnée du centre
r: rayon

- > Carre: 
```Nom_forme = Carre((x,y), c) ```
x: abcisse du point origine (en haut à gauche)
y: ordonnée du point origine
c: coté

- >Rectangle:
```Nom_forme = Rectangle((x,y), lon,lar) ```
x: abcisse du point origine (en haut à gauche)
y: ordonnée du point origine
lon: longueur
lar: largeur

- >Triangle:
```Nom_forme = Triangle((x1,y1), (x2,y2), (x3,y3)) ```
xi: abcisse du point i 
yi: ordonnée du point i

### Exemple


