package edu.projeto;



public class Historico {

  public Historico(Date dataInicio, Date dataFim, String cargo, Pessoa pessoa, Empresa empresa) {
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.cargo = cargo;
    this.pessoa = pessoa;
    this.empresa = empresa;
  }

  private Date dataInicio;

  private Date dataFim;

  private String cargo;

    private Pessoa pessoa;
    private Empresa empresa;

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

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }
}