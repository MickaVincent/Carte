package csvToArray;

/**
 * Created by Hamor on 19/12/2016.
 */
public class MonumentMusee extends Monument{
    private String adresse;
    private String codePostal;
    private String commune;
    private String acces;
    private String telephone;
    private String courriel;
    private String siteInternet;
    private String facebook;

    public MonumentMusee(int numInsee, float latitude, float longitude, String nom, String desc, String adresse,
                         String codePostal, String commune, String acces, String telephone, String courriel,
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

    public String getCodePostal() {
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
