package pglp.formes;

import java.io.Serializable;

/**
 * Classe abstraite des formes
 */
public abstract class Forme implements Serializable{


  public void setIdentifiant(String identifiant) {
    this.identifiant = identifiant;
  }

  private String identifiant;

  public String getIdentifiant() {
    return identifiant;
  }

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

  @Override
  public String toString() {
    return "identifiant= " + identifiant;
  }
}
