package pglp.commandes;

import pglp.exceptions.UnloadedDrawingException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CmdMove implements Commande {

  public static List<Integer> parsedParams= new ArrayList();
  public static String identifiant;

  public CmdMove(String[] params){
    identifiant = params[0];
    Pattern p = Pattern.compile("-?\\d+");
    Matcher m = p.matcher(params[1]);
    while (m.find()){
      int n = Integer.parseInt(m.group());
      parsedParams.add(n);
    }

  }


  @Override
  public String execute() throws UnloadedDrawingException {
    if (CmdCreate.formes.containsKey(identifiant)){
      int nx = parsedParams.get(0);
      int ny = parsedParams.get(1);
      CmdCreate.formes.get(identifiant).deplacer(nx,ny);
      return String.valueOf(1);
    } else throw new UnloadedDrawingException();
  }
}
