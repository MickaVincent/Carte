package parser;

/**
 * Created by Hamor on 19/12/2016.
 */
public class MonumentHistorique extends PointInteret {

    private String reference;
    private String commune;
    private String categorie;
    private String proprietaire;
    private String dateProtection;
    private String auteurs;
    private String siecle;

    public MonumentHistorique(int numInsee, float latitude, float longitude, String nom, String desc, String reference,
                              int departement, String commune, String categorie, String proprietaire,
                              String dateProtection, String auteurs, String siecle) {
        super(numInsee, latitude, longitude, nom, desc, commune, departement);
        this.reference = reference;
        this.commune = commune;
        this.categorie = categorie;
        this.proprietaire = proprietaire;
        this.dateProtection = dateProtection;
        this.auteurs = auteurs;
        this.siecle = siecle;
    }

    @Override
    public String toString() {
        return  "MonumentHistorique{" +
                "Nom= '" + super.getNom() + '\'' +
                ", Latitude='" + super.getLatitude() + '\'' +
                ", Longitude='" + super.getLongitude() + '\'' +
                ", reference='" + reference + '\'' +
                ", departement=" + super.getDepartement() + '\'' +
                ", commune=" + commune + '\'' +
                ", INSEE='" + super.getNumInsee() + '\'' +
                ", categorie='" + categorie + '\'' +
                ", proprietaire='" + proprietaire + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", dateProtection='" + dateProtection + '\'' +
                ", auteur(s)='" + auteurs + '\'' +
                ", siecle='" + siecle + '\'' +
                '}';
    }

    public String getReference() {
        return reference;
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

    public String getSiecle() {
        return siecle;
    }

}
