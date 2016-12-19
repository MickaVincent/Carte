package csvToArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Hamor on 19/12/2016.
 */

public class Parse {
    private static final char DEFAULT_SEPARATOR = '\t';
    private static final char DEFAULT_NEW_LINE = '\n';
    //private static String str;
    private Scanner fileScan;
    private Scanner sc;

    //Constructeur
    //Construit un "Parse" avec un parseur sur le fichier fournit en parametre
    public Parse(File f){
        try {
            fileScan = new Scanner(f);
            //On "passe" la première ligne de description
            fileScan.nextLine();
            sc = new Scanner(fileScan.nextLine()).useDelimiter("\t");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String nextField(){
        try {
            return sc.next();
        } catch (NoSuchElementException e){
            return "";
        }
    }

    public boolean isFinished(){
        return (!fileScan.hasNextLine());
    }

    public void nextLine(){
        sc.close();
        sc = new Scanner(fileScan.nextLine()).useDelimiter("\t");
    }
    public void close(){
        sc.close();
        fileScan.close();
    }
}
