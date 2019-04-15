package edu.projeto;


public class Localizacao {

  public Localizacao(double latitude, double longitude, Empresa empresa) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.empresa = empresa;
  }

  private double latitude;

  private double longitude;

    private Empresa empresa;
      
  public double distancia(Localizacao l) {
  return 0.0;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }
}