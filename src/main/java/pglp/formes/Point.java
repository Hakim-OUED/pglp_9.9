package pglp.formes;

/**
 *Classe Position
 */
public class Point {
  //postion x
  private int x;
  //position y
  private int y;

  Point(final int x, final int y) {
    this.x = x;
    this.y = y;
  }
  public Point() {
    this.setX(0);
    this.setY(0);
  }

  //
  public int getX() {
    return x;
  }
  //
  public void setX(final int x) {
    this.x = x;
  }
  //
  public int getY() {
    return y;
  }
  //
  public void setY(final int y) {
    this.y = y;
  }




  /**
   * deplacer l'abcisse du point
   * @param nx nouvelle abcisse
   * @return la position
   */
  public Point deplacerX(final int nx) {
    this.setX(nx);
    return this;
  }

  @Override
  public String toString() {
    return "X:" + this.getX()
        + ", Y:" + this.getY();
  }

  /**
   * Deplacer l'ordonée du point
   * @param ny nouvelle ordonéee
   * @return la point
   */
  public Point deplacerY(final int ny) {
    this.setY(ny);
    return this;
  }

  /**
   * Deplacer les coordonées point
   * @param nx nouvelle abcisse
   * @param ny nouvelle ordonnée
   * @return  le point
   */
  public Point deplacer(final int nx, final int ny) {
    this.setX(nx);
    this.setY(ny);
    return this;
  }

}
