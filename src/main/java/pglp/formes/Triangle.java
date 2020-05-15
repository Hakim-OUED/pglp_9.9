package pglp.formes;

public class Triangle extends Forme {
  //Point origine
  private Point point1;
  // deuxième Point
  private Point point2;
  //Troisième Point
  private Point point3;
  public Triangle(final String nom,
                  final int x1, final int y1,
                  final int x2, final int y2,
                  final int x3, final int y3) {
    super(nom);
    this.point1 = new Point(x1,y1);
    this.point2 = new Point(x2,y2);
    this.point3 = new Point(x3,y3);
  }

  /**
   * Deplace le triangle selon le point origine point1.
   * @param x Nouvelle coordonnée X
   * @param y Nouvelle coordonnée Y
   * @return retourne le triangle déplacé
   */
  @Override
  public Forme deplacer(int x, int y) {
    int distX = x - this.point1.getX();
    int distY = y - this.point1.getY();
    this.point1.setX(x);
    this.point1.setY(y);
    this.point2.setX(this.point2.getX() + distX);
    this.point2.setY(this.point2.getY() + distY);
    this.point3.setX(this.point3.getX() + distX);
    this.point3.setY(this.point3.getY() + distY);
    return this;
  }
}
