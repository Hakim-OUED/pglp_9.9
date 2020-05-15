package pglp.formes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe composite de Groupe
 */
public class FormeGroupe extends Forme implements Iterable<Forme>{

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
  }

  @Override
  public Forme deplacer(int x, int y) {
    for (Forme forme : ensemble){
      forme.deplacer(x,y);
    }
    return this;
  }

  public void addForme(Forme forme) {
    ensemble.add(forme);
  }

  public boolean contient(Forme forme) {
    return ensemble.contains(forme);
  }

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
