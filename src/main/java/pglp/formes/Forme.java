package pglp.formes;

/**
 * Classe abstraite des formes
 */
public abstract class Forme {

  private String identifiant;

  public Forme(String id) {
    this.identifiant = id;
  }

  /**
   * Methode abstraite pour deplacer les formes.
   * @param x Nouvelle coordonnée X
   * @param y Nouvelle coordonnée Y
   * @return la forme déplacer
   */
  public abstract Forme deplacer(int x, int y);

}
