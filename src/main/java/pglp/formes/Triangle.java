package pglp.formes;

import java.io.Serializable;

/**
 * Classe implementant la forme Triangle.
 */
public class Triangle extends Forme implements Serializable {

  /**
   * uid Serial.
   */
  private static final long serialVersionUID = 1L;
  private static int id = 0;

  //Point origine
  private Point point1;
  // deuxième Point
  private Point point2;
  //Troisième Point
  private Point point3;

  public Point getPoint1() {
    return point1;
  }

  public void setPoint1(Point point1) {
    this.point1 = point1;
  }

  public Point getPoint2() {
    return point2;
  }

  public void setPoint2(Point point2) {
    this.point2 = point2;
  }

  public Point getPoint3() {
    return point3;
  }

  public void setPoint3(Point point3) {
    this.point3 = point3;
  }

  /**
   * Constructeur d'un triangle.
   * @param nom Nom du dessin
   * @param x1 abcisse du premier point
   * @param y1 ordonnée du premier point
   * @param x2 abcisse du deuxième point
   * @param y2 ordonnée du deuxième point
   * @param x3 abcisse du troisième point
   * @param y3 ordonnée du troisième point
   */
  public Triangle(final String nom,
                  final int x1, final int y1,
                  final int x2, final int y2,
                  final int x3, final int y3) {
    super(nom);
    this.point1 = new Point(x1,y1);
    this.point2 = new Point(x2,y2);
    this.point3 = new Point(x3,y3);
    this.id += 1;
  }

  /**
   * Deplace le triangle selon le point origine point1.
   * @param x Nouvelle coordonnée X
   * @param y Nouvelle coordonnée Y
   * @return retourne le triangle déplacé
   */
  @Override
  public Forme deplacer(int x, int y) {
    this.point1.deplacer(x,y);
    this.point2.deplacer(x,y);
    this.point3.deplacer(x,y);
    return this;
  }

  @Override
  public String toString() {
    return super.toString()
        + "-->Triangle("
        + "point1=(" + point1
        + "), point2=(" + point2
        + "), point3=(" + point3
        + "))";
  }
}
