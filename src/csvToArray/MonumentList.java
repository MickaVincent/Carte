package csvToArray;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamor on 19/12/2016.
 */
public class MonumentList {
    private static List<Musee> museesList = new ArrayList<Musee>();
    private static List<MonumentHistorique> monumentHistoriqueList = new ArrayList<MonumentHistorique>();

    static String pathMusee;
    static String pathMonument;

    private static void setPath(){
        pathMusee = "res" + File.separator + "Musee.csv";
        pathMonument = "res" + File.separator + "MonumentsHistoriquesFrancheComte.csv";
    }

    private static MonumentList INSTANCE = new MonumentList();
        //Constructeur de museesList

    private MonumentList() {
        setPath();
        Parse pMusee = new Parse(new File(pathMusee));
        while(!pMusee.isFinished()) {
            String name = pMusee.nextField();
            String addresse = pMusee.nextField();
            int cp = Integer.parseInt(pMusee.nextField());
            String commune = pMusee.nextField();
            int numInsee = Integer.parseInt(pMusee.nextField());
            String acces = pMusee.nextField();
            float latitude = Float.parseFloat(pMusee.nextField());
            float longitude = Float.parseFloat(pMusee.nextField());
            String telephone = pMusee.nextField();
            String courriel = pMusee.nextField();
            String site = pMusee.nextField();
            String facebook = pMusee.nextField();
            String descriptif = pMusee.nextField();
            Musee m = new Musee(numInsee, latitude, longitude, name, descriptif, addresse, cp,
                    commune, acces, telephone, courriel, site, facebook);
            //System.out.println(m);
            museesList.add(m);
            pMusee.nextLine();
        }
        //On ferme le parseur (consigne de java.util.Scanner
        pMusee.close();

        //Meme chose avec monumentHistorique
        Parse pHistorique = new Parse(new File(pathMonument));
        while(!pHistorique.isFinished()){
            float latitude = Float.parseFloat(pHistorique.nextField());
            float longitude = Float.parseFloat(pHistorique.nextField());
            String reference = pHistorique.nextField();
            int departement = Integer.parseInt(pHistorique.nextField());
            String commune = pHistorique.nextField();
            int insee = Integer.parseInt(pHistorique.nextField());
            String categorie = pHistorique.nextField();
            String designation = pHistorique.nextField();
            String proprietaire = pHistorique.nextField();
            String description = pHistorique.nextField();
            String protection = pHistorique.nextField();
            String auteur = pHistorique.nextField();
            String siecle = pHistorique.nextField();
            MonumentHistorique m = new MonumentHistorique(insee, latitude, longitude, designation, description,
                    reference, departement, commune, categorie, proprietaire, protection, auteur, siecle);
            //System.out.println(m);
            monumentHistoriqueList.add(m);
            pHistorique.nextLine();
        }
        pHistorique.close();

    }

    //Retourne la liste des musees uniquement
    public static List<Musee> getMuseesList() {
        return museesList;
    }

    //Retourne la liste des monument historiques uniquement
    public static List<MonumentHistorique> getMonumentHistoriqueList() {
        return monumentHistoriqueList;
    }
            
    //Retourne la liste complète        
    public static List<PointInteret> getFullList(){
        List<PointInteret> res = new ArrayList<PointInteret>();
        res.addAll(monumentHistoriqueList);
        res.addAll(museesList);
        return res;
    }
}
