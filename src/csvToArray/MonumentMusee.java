package csvToArray;

/**
 * Created by Hamor on 19/12/2016.
 */
public class MonumentMusee extends Monument{
    private String adresse;
    private int codePostal;
    private String commune;
    private String acces;
    private String telephone;
    private String courriel;
    private String siteInternet;
    private String facebook;

    @Override
    public String toString() {
        return "MonumentMusee{" +
                "nom ='" + super.getNom() + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", commune='" + commune + '\'' +
                ", NumInsee='" + super.getNumInsee() + '\'' +
                ", acces='" + acces + '\'' +
                ", Latitude='" + super.getLatitude() + '\'' +
                ", Longitude='" + super.getLongitude() + '\'' +
                ", telephone='" + telephone + '\'' +
                ", courriel='" + courriel + '\'' +
                ", siteInternet='" + siteInternet + '\'' +
                ", facebook='" + facebook + '\'' +
                ", DescriptifLong='" + super.getDescription() + '\'' +
                '}';
    }

    public MonumentMusee(int numInsee, float latitude, float longitude, String nom, String desc, String adresse,
                         int codePostal, String commune, String acces, String telephone, String courriel,
                         String siteInternet, String facebook) {
        super(numInsee, latitude, longitude, nom, desc);
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.commune = commune;
        this.acces = acces;
        this.telephone = telephone;
        this.courriel = courriel;
        this.siteInternet = siteInternet;
        this.facebook = facebook;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public String getAcces() {
        return acces;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public String getFacebook() {
        return facebook;
    }
}
