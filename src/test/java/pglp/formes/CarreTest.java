package pglp.formes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarreTest {
  Carre ca1;

  @Before
  public void init() {
    ca1 = new Carre("ca1",2,4,8);

  }


  @Test
  public void testDeplacer() {
    ca1.deplacer(1,2);
    assertTrue(ca1.getOrigine().getX()==1);
    assertFalse(ca1.getOrigine().getY()==1);
  }

  @Test
  public void testToString() {
    String value = "identifiant= ca1-->Carre(origine=X:2, Y:4), cote=8)";
    assertTrue(ca1.toString().equals(value));
  }
}