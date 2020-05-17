package pglp.formes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe implementant le pattern composite de forme.
 */
public class FormeGroupe extends Forme implements Iterable<Forme>, Serializable {

  /**
   * uid Serial.
   */
  private static final long serialVersionUID = 1L;
  private static int id = 0;

  //nom de l'ensemble
  private String nom;

  //Liste de l'ensemble
  private List<Forme> ensemble;

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public List<Forme> getEnsemble() {
    return ensemble;
  }

  public void setEnsemble(List<Forme> ensemble) {
    this.ensemble = ensemble;
  }

  public FormeGroupe(String nom) {
    super(nom);
    this.nom = nom;
    this.ensemble = new ArrayList<>();
    this.id +=1;
  }

  /**
   * Deplace un ensemble de dessin.
   * @param x Nouvelle coordonnée X
   * @param y Nouvelle coordonnée Y
   * @return l'le groupe
   */
  @Override
  public Forme deplacer(int x, int y) {
    for (Forme forme : ensemble){
      forme.deplacer(x,y);
    }
    return this;
  }

  /**
   * Ajjoute un dessin au groupe.
   * @param forme le dessin à ajouter
   */
  public void addForme(Forme forme) {
    ensemble.add(forme);
  }

  /**
   * Verifie si le groupe contient un dessin
   * @param forme le dessin à vérifier
   * @return True si le dessin est dans le groupe False sinon
   */
  public boolean contient(Forme forme) {
    return ensemble.contains(forme);
  }

  /**
   * Supprime un dessin de lu groupe
   * @param forme le dessin à supprimer
   */
  public void remove(Forme forme) {
    if (this.contient(forme)){
      this.ensemble.remove(forme);
    }
  }

  @Override
  public Iterator<Forme> iterator() {
    return this.ensemble.iterator();
  }
}
