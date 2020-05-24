# Logiciel de dessin

Le but de ce projet est de réaliser un logiciel de dessin. On se limite à un affichage textuel, i.e. seule une description des figures est affichée. Par exemple, un cercle de centre (0, 0) et de rayon 50 sera "affiché" par la chaîne de caractères "Cercle(centre=(0,0),rayon=50)".

L'utilisateur interagit avec l'application par l'intermédiaire de la ligne de commandes. Chaque commande débute par une instruction suivie des arguments de cette instruction.

Le logiciel offre les fonctionnalités suivantes:


# Outils:
* Maven
* JDBC
* Derby

# mise en oeuvre:
## Execution
- > Se positionner dans le projet
- > mvn package
- > java -jar pglp_9.9-1.0-SNAPSHOT.jar (Il faut au préalable indiquer le classpath de du driver Derby dans le path)
- > ou encore ouvrir le projet avec un IDE et executer DrawingApp.java

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
![image1](https://github.com/Hakim-OUED/pgpl_9.9/blob/master/captures/Capture8.PNG)

## Regrouper des formes
- > ``` Nom_groupe = group(forme1, forme2, ....., formeN) ```
### Exemple
![image2](https://github.com/Hakim-OUED/pgpl_9.9/blob/master/captures/Capture2.PNG)

## Sauvegarder une forme ou un ensemble de forme
- > ```Save(nom_forme) ou save(nom_groupe) ```
### Exemple
![image4](https://github.com/Hakim-OUED/pgpl_9.9/blob/master/captures/Capture3.PNG)

## Afficher une forme ou un groupe de forme
- > ```Show(nom_forme) ou Show(nom_groupe) ```
## Charger une forme ou un ensemble de forme sauvegardé dans la BD
- > ```Load(nom_forme) ou load(nom_groupe) ```
### Exemple
![image5](https://github.com/Hakim-OUED/pgpl_9.9/blob/master/captures/Capture5.PNG)

## Deplacer une forme ou un groupe
- > ``` Move(nom_forme, (nx,ny)) ou move(nom_groupe, (nx,ny)) ```
nx: augmentation de l'abcisse
ny: augmentation de l'ordonnée
- > NB: Il faut au préalable créer ou charger la figure s'elle est dans la BD
### Exemple
![image4](https://github.com/Hakim-OUED/pgpl_9.9/blob/master/captures/Capture4.PNG)

## Afficher la liste des commandes
- > ``` Help ```
## Quitter le programme
- > ``` Quit ```
### Exemple
![image6](https://github.com/Hakim-OUED/pgpl_9.9/blob/master/captures/Capture6.PNG)
![image7](https://github.com/Hakim-OUED/pgpl_9.9/blob/master/captures/Capture7.PNG)


 
