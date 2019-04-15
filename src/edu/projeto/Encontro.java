package edu.projeto;


import edu.princeton.cs.algs4.RedBlackBST;



public class Encontro {

  private Date dataEncontro;

  private Integer idEncontro;

  public Encontro(Date dataEncontro, Integer idEncontro, RedBlackBST<Integer, Pessoa> pessoasST, Empresa empresa, Localizacao localizacao, Area area) {
    this.dataEncontro = dataEncontro;
    this.idEncontro = idEncontro;
    this.pessoasST = pessoasST;
    this.empresa = empresa;
    this.localizacao = localizacao;
    this.area = area;
  }

  private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

    private Empresa empresa;
    private Localizacao localizacao;
    private Area area;

  public Date getDataEncontro() {
    return dataEncontro;
  }

  public void setDataEncontro(Date dataEncontro) {
    this.dataEncontro = dataEncontro;
  }

  public Integer getIdEncontro() {
    return idEncontro;
  }

  public void setIdEncontro(Integer idEncontro) {
    this.idEncontro = idEncontro;
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

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public Localizacao getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(Localizacao localizacao) {
    this.localizacao = localizacao;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }
}