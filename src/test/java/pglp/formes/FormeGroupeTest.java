package pglp.formes;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FormeGroupeTest {
  private Cercle cercle;
  private Carre carre;

  @Before
  public void init(){
    cercle = new Cercle("c1",1,1,5);
    carre = new Carre("ca1",8,1,4);
  }

  @Test
  public void testAddContient(){
    FormeGroupe groupe1 = new FormeGroupe("groupe1");
    groupe1.addForme(cercle);
    assertEquals(groupe1.getEnsemble().get(0),cercle);
  }

  @Test
  public void testDeplacer() {
    FormeGroupe groupe1 = new FormeGroupe("groupe1");
    groupe1.addForme(cercle);
    groupe1.addForme(carre);
    groupe1.deplacer(4,4);
    Cercle c = (Cercle) groupe1.getEnsemble().get(0);
    Carre ca = (Carre) groupe1.getEnsemble().get(1);
    assertTrue(c.getCentre().getX()==5);
    assertTrue(c.getCentre().getY()==5);
    assertTrue(ca.getOrigine().getX()==12);
    assertTrue(ca.getOrigine().getY()==5);
  }

  @Test
  public void TestContient() {
    FormeGroupe groupe1 = new FormeGroupe("groupe1");
    groupe1.addForme(cercle);
    groupe1.addForme(carre);
    assertTrue(groupe1.contient(cercle));
  }

  @Test
  public void remove() {
    FormeGroupe groupe1 = new FormeGroupe("groupe1");
    List<Forme> liste = new ArrayList<>();
    liste.add(carre);
    groupe1.setEnsemble(liste);
    groupe1.remove(carre);
    assertFalse(groupe1.contient(carre));
  }
}