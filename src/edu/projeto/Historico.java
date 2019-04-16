package edu.projeto;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;

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

  public String toStringFicheiroHistorico(){
    return idHistorico + ";" + dataInicio + ";" + dataFim + ";" + cargo + ";"  + idPessoa + ";" + idEmpresa + ";";
  }


  public static String guardarHistorico(RedBlackBST<Date,Historico> historicoST, String path){

    Out o = new Out(path);
    for(Date dateaux : historicoST.keys()){
      Historico hi = (Historico) historicoST.get(dateaux);
      o.println(hi.toStringFicheiroHistorico());
    }
    return "Guardou os encontros no TXT!";
  }

  public static void carregaHistorico(RedBlackBST<Integer,Historico> historicoST, String path) {
    In in = new In(path);
    while (!in.isEmpty()){
      String[] split = in.readLine().split(";");
      Integer idHistorico = Integer.parseInt(split[0]);
      String dataInicio = split[1];
      String dataFim = split[2];
      String cargo = split[2];
      Integer idPessoa = Integer.parseInt(split[3]);
      Integer idEmpresa = Integer.parseInt(split[4]);

      Historico hi =  new Historico(idHistorico, new Date(dataInicio), new Date(dataFim), cargo, idPessoa, idEmpresa);
      historicoST.put(idHistorico, hi);

    }
  }

}