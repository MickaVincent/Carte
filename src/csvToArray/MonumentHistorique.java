package csvToArray;

/**
 * Created by Hamor on 19/12/2016.
 */
public class MonumentHistorique extends Monument{

    private String reference;
    private int departement;
    private String categorie;
    private String proprietaire;
    private String dateProtection;
    private String auteurs;

    public MonumentHistorique(int numInsee, float latitude, float longitude, String nom, String desc, String reference,
                              int departement, String categorie, String proprietaire, String dateProtection,
                              String auteurs) {
        super(numInsee, latitude, longitude, nom, desc);
        this.reference = reference;
        this.departement = departement;
        this.categorie = categorie;
        this.proprietaire = proprietaire;
        this.dateProtection = dateProtection;
        this.auteurs = auteurs;
    }

    public String getReference() {
        return reference;
    }

    public int getDepartement() {
        return departement;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public String getDateProtection() {
        return dateProtection;
    }

    public String getAuteurs() {
        return auteurs;
    }

}
