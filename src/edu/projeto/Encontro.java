package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;


public class Encontro {

  private Date dataInicio;

  private Date dataFinal;

  private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

  private Integer idEmpresa;

  private Integer idArea;

  private Double latitude;

  private Double longitude;

    @Override
    public String toString() {
        return "Encontro{" +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", idEmpresa=" + idEmpresa +
                ", idArea=" + idArea +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    /**
   *
   * Construtor
   */
  public Encontro(Date dataInicio, Date dataFinal, Integer idEmpresa, Integer idArea, Double latitude, Double longitude) {
    this.dataInicio = dataInicio;
    this.dataFinal = dataFinal;
    this.idEmpresa = idEmpresa;
    this.idArea = idArea;
    this.latitude = latitude;
    this.longitude = longitude;
  }


  /**
   *
   * Getter and Setter
   */

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Date getDataFinal() {
      return dataFinal;
  }

  public void setDataFinal(Date dataFinal) {
      this.dataFinal = dataFinal;
  }


  /**
 *
 * @element-type Pessoa
 */
  public RedBlackBST<Integer, Pessoa> getPessoasST() {
    return pessoasST;
  }

  public void setPessoasST(RedBlackBST<Integer, Pessoa> pessoasST) {
    this.pessoasST = pessoasST;
  }

  public Integer getIdEmpresa() {
    return idEmpresa;
  }

  public void setIdEmpresa(Integer idEmpresa) {
    this.idEmpresa = idEmpresa;
  }


  public Integer getIdArea() {
    return idArea;
  }

  public void setIdArea(Integer idArea) {
    this.idArea = idArea;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  /**
     *
     * Funções
     */
    public String toStringFicheiroEncontro(){
        return  dataInicio + ";" + dataFinal + ";" + idEmpresa + ";"  + idArea + ";" + latitude + ";" +  longitude +";";
    }



}