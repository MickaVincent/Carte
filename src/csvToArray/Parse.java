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
    //private static final char DEFAULT_NEW_LINE = '\n';
    //private static String str;

    //parseur du fichier scv en entier
    private Scanner fileScan;

    //parseur de ligne
    private Scanner sc;

    //Constructeur
    //Construit un "Parse" avec un parseur sur le fichier fournit en parametre
    public Parse(File f){
        try {
            //fileScan parsera sur tout le fichier
            fileScan = new Scanner(f);

            //On "passe" la première ligne de description
            fileScan.nextLine();

            //sc n'aura qu'une seule ligne a parsé avec la tabulation comme séparateur
            sc = new Scanner(fileScan.nextLine()).useDelimiter("DEFAULT_SEPARATOR");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //methode pour passée à la tabulation suivante, renvoie une chaine vide si la ligne est finie
    public String nextField(){
        try {
            return sc.next();
        } catch (NoSuchElementException e){
            return "";
        }
    }

    //sert à savoir si le fichier en lecture est fini ou non
    public boolean isFinished(){
        return (!fileScan.hasNextLine());
    }

    //permet à sc de lire la ligne suivante fournie par fileScan, on doit fermer sc avant de lui réaffecter une
    //nouvelle ligne, on reprécise le délimiteur
    public void nextLine(){
        sc.close();
        sc = new Scanner(fileScan.nextLine()).useDelimiter("DEFAULT_SEPARATOR");
    }

    //ferme tous les scanners ouvert
    public void close(){
        sc.close();
        fileScan.close();
    }
}
