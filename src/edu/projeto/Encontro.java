package edu.projeto;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;


public class Encontro {

  private Integer idEncontro;

  private Date dataInicio;

  private Date dataFinal;

  private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

  private Integer idEmpresa;

  private Integer idLocalizacao;

  private Integer idArea;

    @Override
    public String toString() {
        return "Encontro{" +
                "idEncontro=" + idEncontro +
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
  public Encontro(Integer idEncontro, Date dataInicio, Date dataFinal, Integer idEmpresa,Integer idLocalizacao, Integer idArea) {
    this.idEncontro = idEncontro;
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
  public Integer getIdEncontro() { return idEncontro; }

  public void setIdEncontro(Integer idEncontro) { this.idEncontro = idEncontro; }

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



    public String toStringFicheiroEncontro(){
        return idEncontro + ";" + dataInicio + ";" + dataFinal + ";" + idEmpresa + ";" + idLocalizacao + ";" + idArea + ";";
    }


    public static String guardarEncontro(RedBlackBST<Integer,Encontro> encontrosST, String path){

        Out o = new Out(path);
        for(Integer idaux : encontrosST.keys()){
            Encontro en = (Encontro) encontrosST.get(idaux);
            o.println(en.toStringFicheiroEncontro());
        }
        return "Guardou os encontros no TXT!";
    }

    public static void carregaEncontro(RedBlackBST<Integer,Encontro> encontrosST, String path) {
        In in = new In(path);
        while (!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer idEncontro = Integer.parseInt(split[0]);
            String dataInicio = split[1];
            String dataFinal = split[2];
            Integer idEmpresa = Integer.parseInt(split[3]);
            Integer idLocalizacao = Integer.parseInt(split[4]);
            Integer idArea = Integer.parseInt(split[5]);

            Encontro en =  new Encontro(idEncontro,new Date(dataInicio), new Date(dataFinal), idEmpresa, idLocalizacao, idArea);
            encontrosST.put(idEncontro, en);

        }
    }
}