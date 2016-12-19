package search;

import csvToArray.PointInteret;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamor on 19/12/2016.
 */


public final class research {

    //Renvoie une liste suivant si "name" est dans un nom ou designation d'un point d'interet
    public static List<PointInteret> getWithName(String name, List<PointInteret> m){
        List<PointInteret> res = new ArrayList<PointInteret>();
        //Enlève les accents de name et le met en minuscule
        name = Normalizer.normalize(name, Normalizer.Form.NFD).toLowerCase();

        //For each
        for (PointInteret item : m
                ) {
            //met le nom d'item sans accents et en minuscule + regarde si name est dedans
            if(item.getNom().replaceAll("\\p{M}", "").toLowerCase().contains(name)) {
                res.add(item);
            }
        }
        return res;
    }

    //Renvoie une liste suivant si "commune" est dans un nom ou designation d'un point d'interet
    public static List<PointInteret> getWithCommune(String commune, List<PointInteret> m){
        List<PointInteret> res = new ArrayList<PointInteret>();
        //Enlève les accents de name et le met en minuscule
        commune = Normalizer.normalize(commune, Normalizer.Form.NFD).toLowerCase();

        //For each
        for (PointInteret item : m
                ) {
            //met le nom d'item sans accents et en minuscule + regarde si name est dedans
            if(item.getCommune().replaceAll("\\p{M}", "").toLowerCase().contains(commune)) {
                res.add(item);
            }
        }
        return res;
    }

    //Renvoie une liste suivant si "numInsee" est dans un nom ou designation d'un point d'interet
    public static List<PointInteret> getWithCommune(int numInsee, List<PointInteret> m){
        List<PointInteret> res = new ArrayList<PointInteret>();

        //For each
        for (PointInteret item : m
                ) {
            if(item.getNumInsee() == numInsee) {
                res.add(item);
            }
        }
        return res;
    }

    public static List<PointInteret> getWithCP(int cp, List<PointInteret> m){
        List<PointInteret> res = new ArrayList<PointInteret>();

        //For each
        for (PointInteret item : m
                ) {
            if(item.getDepartement() == cp) {
                res.add(item);
            }
        }
        return res;
    }
}
