package csvToArray;

/**
 * Created by Hamor on 19/12/2016.
 */
public abstract class Monument {
    private int numInsee;
    private float latitude;
    private float longitude;
    private String nom;
    private String description;

    public Monument(int numInsee, float latitude, float longitude, String nom, String desc) {
        this.numInsee = numInsee;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
        description = desc;
    }

    @Override
    public String toString() {
        return "Monument{" +
                "numInsee=" + numInsee +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
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
}
