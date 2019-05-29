package edu.projeto;


public class Ligacao extends DirectedEdge {

    private float latitude;
    private float longitude;


    public Ligacao(int v, int w, double weight, float latitude, float longitude) {
        super(v, w, weight);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }


    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
