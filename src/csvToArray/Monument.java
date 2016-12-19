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
