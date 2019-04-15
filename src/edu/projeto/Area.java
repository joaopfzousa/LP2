package edu.projeto;


public class Area {

  private Integer idArea;

  private String nomeArea;

  public Area(Integer idArea, String nomeArea) {
    this.idArea = idArea;
    this.nomeArea = nomeArea;
  }

  public Integer getIdArea() {
    return idArea;
  }

  public void setIdArea(Integer idArea) {
    this.idArea = idArea;
  }

  public String getNomeArea() {
    return nomeArea;
  }

  public void setNomeArea(String nomeArea) {
    this.nomeArea = nomeArea;
  }
}