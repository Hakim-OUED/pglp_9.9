package pglp.commandes;

import org.junit.BeforeClass;
import org.junit.Test;
import pglp.exceptions.UnloadedDrawingException;
import pglp.formes.Cercle;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class CmdMoveTest {
  private static CmdMove cmd;
  @BeforeClass
  public static void init() {
    String saisie="move(c1,(10,20))";
    String parametres  = saisie.substring(5,saisie.length()-1);
    Pattern p = Pattern.compile(",");
    String[] params = p.split(parametres,2);
    cmd = new CmdMove(params);
  }
  @Test
  public void execute() throws UnloadedDrawingException {
    Cercle c1 = new Cercle("c1",2,2,6);

    CmdCreate.formes.put(c1.getIdentifiant(),c1);
    String result = cmd.execute();
    String movedElement = CmdCreate.formes.get("c1").toString();
    String expected = "identifiant= c1" +
        "--> Cercle(centre=(X:12, Y:22),rayon=6)";
    assertEquals(expected,movedElement);
  }
}