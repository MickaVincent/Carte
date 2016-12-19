package csvToArray;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamor on 19/12/2016.
 */
public class MonumentList {
    private List<MonumentMusee> monumentMuseesList = new ArrayList<MonumentMusee>();
    private List<MonumentHistorique> monumentHistoriqueList = new ArrayList<MonumentHistorique>();

    public MonumentList(String pathToMusee, String pathToHistorique){
        Parse pMusee = new Parse(new File(pathToMusee));
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
            MonumentMusee m = new MonumentMusee(numInsee, latitude, longitude, name, descriptif, addresse, cp,
                    commune, acces, telephone, courriel, site, facebook);
            //System.out.println(m);
            monumentMuseesList.add(m);
            pMusee.nextLine();
        }
        pMusee.close();

        Parse pHistorique = new Parse(new File(pathToHistorique));
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

    public List<MonumentMusee> getMonumentMuseesList() {
        return monumentMuseesList;
    }

    public List<MonumentHistorique> getMonumentHistoriqueList() {
        return monumentHistoriqueList;
    }

    public List<Monument> getFullList(){
        List<Monument> res = new java.util.ArrayList<Monument>();
        res.addAll(monumentHistoriqueList);
        res.addAll(monumentMuseesList);
        return res;
    }
}
