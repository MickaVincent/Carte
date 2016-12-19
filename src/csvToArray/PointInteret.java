package csvToArray;

/**
 * Created by Hamor on 19/12/2016.
 */
public abstract class PointInteret {
    private int numInsee;
    private float latitude;
    private float longitude;
    private String nom;
    private String description;
    private String commune;
    private int departement;

    public PointInteret(int numInsee, float latitude, float longitude, String nom, String desc, String commune,
                        int departement) {
        this.numInsee = numInsee;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
        description = desc;
        this.commune = commune;
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Monument{" +
                "numInsee=" + numInsee +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", commune='" + commune + '\'' +
                '}';
    }

    public int getNumInsee() {
        return numInsee;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription(){
        return description;
    }

    public String getCommune(){
        return commune;
    }

    public int getDepartement(){
        return departement;
    }
}
