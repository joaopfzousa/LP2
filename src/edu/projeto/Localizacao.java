package edu.projeto;


public class Localizacao {

  private Integer idLocalizacao;

  private double latitude;

  private double longitude;


  /**
   *
   * Construtor
   */
  public Localizacao(Integer idLocalizacao, double latitude, double longitude) {
    this.idLocalizacao = idLocalizacao;
    this.latitude = latitude;
    this.longitude = longitude;
  }


  /**
   *
   * Getter and Setter
   */

  public Integer getIdLocalizacao() {
    return idLocalizacao;
  }

  public void setIdLocalizacao(Integer idLocalizacao) {
    this.idLocalizacao = idLocalizacao;
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


  /**
   *
   * Funções
   */
  public String toStringFicheiroLocalizacao(){
    return idLocalizacao + ";" + latitude + ";" + longitude + ";";
  }




  public double distancia(Localizacao l) {
    return 0.0;
  }
}