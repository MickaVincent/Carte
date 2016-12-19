package csvToArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Hamor on 19/12/2016.
 */

public class Parse {
    private static final char DEFAULT_SEPARATOR = '\t';
    private static final char DEFAULT_NEW_LINE = '\n';
    //private static String str;
    private Scanner sc;

    //Constructeur
    //Construit un "Parse" avec un parseur sur le fichier fournit en parametre
    public Parse(File f){
        try {
            sc = new Scanner(f).useDelimiter("\t");
            //On "passe" la première ligne de description
            sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String nextField(){
        return sc.next();
    }

    public boolean isFinished(){
        return (!sc.hasNextLine());
    }

    public void close(){
        sc.close();
    }
}
