package pglp.formes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
  Rectangle rec;

  @Before
  public void init() {
    rec= new Rectangle("rec1",1,1,5,3);
  }


  @Test
  public void testDeplacer() {
    rec.deplacer(3,7);
    assertFalse(rec.getOrigine().getX()==1);
    assertTrue(rec.getOrigine().getY()==7);
  }

  @Test
  public void testToString() {
    String value = "identifiant= rec1"
        +"-->Rectangle(origine=(X:1, Y:1)"
        +", lon=5, lar=3)";

    assertTrue(rec.toString().equals(value));
  }
}