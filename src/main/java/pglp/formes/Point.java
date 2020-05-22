package pglp.formes;

import java.io.Serializable;

/**
 *Classe Position.
 */
public class Point implements Serializable {

  /**
   * uid Serial.
   */
  private static final long serialVersionUID = 1L;
  private static int id = 0;

  //postion x
  private int x;
  //position y
  private int y;

  Point(final int x, final int y) {
    this.x = x;
    this.y = y;
    this.id += 1;
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
   * deplacer l'abcisse du point.
   * @param nx nouvelle abcisse
   * @return la position
   */
  public Point deplacerX(final int nx) {
    this.setX(this.getX() + nx);
    return this;
  }

  @Override
  public String toString() {
    return "X:" + this.getX()
        + ", Y:" + this.getY();
  }

  /**
   * Deplacer l'ordonée du point.
   * @param ny nouvelle ordonéee
   * @return la point
   */
  public Point deplacerY(final int ny) {
    this.setY(this.getY() + ny);
    return this;
  }

  /**
   * Deplacer les coordonées point.
   * @param nx nouvelle abcisse
   * @param ny nouvelle ordonnée
   * @return  le point
   */
  public Point deplacer(final int nx, final int ny) {
    this.setX(this.getX() + nx);
    this.setY(this.getY() + ny);
    return this;
  }

}
