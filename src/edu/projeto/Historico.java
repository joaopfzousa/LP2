package edu.projeto;



public class Historico {

  private Integer idHistorico;

  private Date dataInicio;

  private Date dataFim;

  private String cargo;

  private Integer idPessoa;

  private Integer idEmpresa;


  /**
   *
   * Construtor
   */
  public Historico(Integer idHistorico, Date dataInicio, Date dataFim, String cargo, Integer idPessoa, Integer idEmpresa) {
    this.idHistorico = idHistorico;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.cargo = cargo;
    this.idPessoa = idPessoa;
    this.idEmpresa = idEmpresa;
  }


  /**
   *
   * Getter and Setter
   */
  public Integer getIdHistorico() {
    return idHistorico;
  }

  public void setIdHistorico(Integer idHistorico) {
    this.idHistorico = idHistorico;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public Integer getIdPessoa() {
    return idPessoa;
  }

  public void setIdPessoa(Integer idPessoa) {
    this.idPessoa = idPessoa;
  }

  public Integer getIdEmpresa() {
    return idEmpresa;
  }

  public void setIdEmpresa(Integer idEmpresa) {
    this.idEmpresa = idEmpresa;
  }


  /**
   *
   * Funções
   */
  public String toStringFicheiroHistorico(){
    return idHistorico + ";" + dataInicio + ";" + dataFim + ";" + cargo + ";"  + idPessoa + ";" + idEmpresa + ";";
  }




}