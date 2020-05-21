package pglp;

import pglp.commandes.*;
import pglp.exceptions.UnknowCommandException;

import java.util.regex.Pattern;


public class DrawingTUI {

    String regExCreate = "^[A-Za-z]+\\w+=[A-Za-z]+[(][(]\\d+,\\d+[)],[((\\d+),\\d+)]+[)]$";
    String regExSave ="^(save)[(][A-Za-z]+\\w+[)]$";
    String regExShow ="^(show)[(][A-Za-z]+\\w+[)]$";
    String regExLoad ="^(load)[(][A-Za-z]+\\w+[)]$";
    String regExMove = "^(move)[(][A-Za-z]+\\w+,[(]\\d+,\\d+[)][)]$";
    String regExQuit ="^(quit)";
    String regExHelp ="^(help)";



    public Commande nextCommand(String string) throws UnknowCommandException {
        String saisie = string.toLowerCase().trim();
        saisie = saisie.replaceAll("\\s+","");
        String parametres;
        if (Pattern.matches(regExCreate,saisie)){
            Pattern p = Pattern.compile("=");
            String[] params = p.split(saisie,2);
            return new CmdCreate(params);
        }
        else if (Pattern.matches(regExSave,saisie)){
            parametres = saisie.substring(5,saisie.length()-1);
            return new CmdSave(parametres);
        }
        else if (Pattern.matches(regExShow,saisie)){
            parametres  = saisie.substring(5,saisie.length()-1);
            return new CmdShow(parametres);
        }
        else if (Pattern.matches(regExLoad,saisie)){
            parametres  = saisie.substring(5,saisie.length()-1);
            return new CmdLoad(parametres);
        }
        else if (Pattern.matches(regExMove,saisie)){
            parametres  = saisie.substring(5,saisie.length()-1);
            Pattern p = Pattern.compile(",");
            String[] params = p.split(parametres,2);
            return new CmdCreate(params);

        }
        else if (Pattern.matches(regExHelp,saisie)){
            System.out.println("quithelp");
        }
        else if (Pattern.matches(regExQuit,saisie)){
            System.out.println("quit");
        }
        else {
            throw new UnknowCommandException();
        }
        return null;


    }

    public void afficher(String id){
        
    }
}
