package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;


public class Encontro {

  private Date dataInicio;

  private Date dataFinal;

  private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

  private Integer idEmpresa;

  private Integer idLocalizacao;

  private Integer idArea;

    @Override
    public String toString() {
        return "Encontro{" +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", pessoasST=" + pessoasST +
                ", idEmpresa=" + idEmpresa +
                ", idLocalizacao=" + idLocalizacao +
                ", idArea=" + idArea +
                '}';
    }

    /**
   *
   * Construtor
   */
  public Encontro(Date dataInicio, Date dataFinal, Integer idEmpresa,Integer idLocalizacao, Integer idArea) {
    this.dataInicio = dataInicio;
    this.dataFinal = dataFinal;
    this.idEmpresa = idEmpresa;
    this.idLocalizacao = idLocalizacao;
    this.idArea = idArea;
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

  public Integer getIdLocalizacao() {
    return idLocalizacao;
  }

  public void setIdLocalizacao(Integer idLocalizacao) {
    this.idLocalizacao = idLocalizacao;
  }

  public Integer getIdArea() {
    return idArea;
  }

  public void setIdArea(Integer idArea) {
    this.idArea = idArea;
  }


    /**
     *
     * Funções
     */
    public String toStringFicheiroEncontro(){
        return  dataInicio + ";" + dataFinal + ";" + idEmpresa + ";" + idLocalizacao + ";" + idArea + ";";
    }



}