package edu.projeto;


public class Area {

  private Integer idArea;

  private String nomeArea;

  /**
   *s
   * Construtor
   */
  public Area(Integer idArea, String nomeArea) {
    this.idArea = idArea;
    this.nomeArea = nomeArea;
  }

  /**
   *
   * Getter and Setter
   */
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

    @Override
    public String toString() {
        return "Area{" +
                "idArea=" + idArea +
                ", nomeArea='" + nomeArea + '\'' +
                '}';
    }

    /**
     *
     * Funções
     */
    public String toStringFicheiroArea(){
        return idArea + ";" + nomeArea + ";";
    }


}