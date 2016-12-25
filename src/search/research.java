package search;

import csvToArray.MonumentHistorique;
import csvToArray.Musee;
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

    //Renvoie une liste suivant si "numInsee" est dans un point d'interet
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
        //TODO REMPLACER getClass() par instanceof
        for (PointInteret item : m
                ) {
            if(item.getClass().equals("class cvsToArray.MonumentHistorique")) {
                if (item.getDepartement() == cp || item.getDepartement() == cp/1000) {
                    res.add(item);
                }
            }else if(item.getClass().equals("lass cvsToArray.Musee")){
                if (item.getDepartement() == cp || item.getDepartement()/1000 == cp) {
                    res.add(item);
                }
            }
        }
        return res;
    }

    //A N'APPELER QU'AVEC UNE LISTE DE MONUMENT HISTORIQUE
    public static List<MonumentHistorique> getWithCategorie(String categorie, List<MonumentHistorique> m){
        List<MonumentHistorique> res = new ArrayList<MonumentHistorique>();
        //Enlève les accents de categorie et le met en minuscule
        categorie = Normalizer.normalize(categorie, Normalizer.Form.NFD).toLowerCase();

        //For each
        for (MonumentHistorique item : m
                ) {
            //met le nom d'item sans accents et en minuscule + regarde si categorie est dedans
            if(item.getCategorie().replaceAll("\\p{M}", "").toLowerCase().contains(categorie)) {
                res.add(item);
            }
        }
        return res;
    }

    //A N'APPELER QU'AVEC UNE LISTE DE MONUMENT HISTORIQUE
    public static List<MonumentHistorique> getWithDesignation(String designation, List<MonumentHistorique> m){
        List<MonumentHistorique> res = new ArrayList<MonumentHistorique>();
        //Enlève les accents de designation et le met en minuscule
        designation = Normalizer.normalize(designation, Normalizer.Form.NFD).toLowerCase();

        //For each
        for (MonumentHistorique item : m
                ) {
            //met le nom d'item sans accents et en minuscule + regarde si designation est dedans
            if(item.getCategorie().replaceAll("\\p{M}", "").toLowerCase().contains(designation)) {
                res.add(item);
            }
        }
        return res;
    }

    //A N'APPELER QU'AVEC UNE LISTE DE MONUMENT HISTORIQUE
    public static List<MonumentHistorique> getWithReference(String reference, List<MonumentHistorique> m){
        List<MonumentHistorique> res = new ArrayList<MonumentHistorique>();

        //For each
        for (MonumentHistorique item : m
                ) {
            if(item.getReference().contains(reference.toUpperCase())) {
                res.add(item);
            }
        }
        return res;
    }

    //A N'APPELER QU'AVEC UNE LISTE DE MUSEE
    public static List<Musee> getWithAdresse(String adresse, List<Musee> m){
        List<Musee> res = new ArrayList<Musee>();
        //Enlève les accents de adresse et le met en minuscule
        adresse = Normalizer.normalize(adresse, Normalizer.Form.NFD).toLowerCase();

        //For each
        for (Musee item : m
                ) {
            //met le nom d'item sans accents et en minuscule + regarde si adresse est dedans
            if(item.getAdresse().replaceAll("\\p{M}", "").toLowerCase().contains(adresse)) {
                res.add(item);
            }
        }
        return res;
    }
}
