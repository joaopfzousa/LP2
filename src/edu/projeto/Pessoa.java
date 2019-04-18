package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;
import java.util.Scanner;


public class Pessoa {

    private Integer idPessoa;

  private String nomePessoa;

  private String apelidoPessoa;

  private Date dataNasc;

  private Integer idEmpresa;

  private RedBlackBST<Date,Encontro> encontrosST = new RedBlackBST<>();

  private SeparateChainingHashST<Integer,Competencia> competenciasST = new SeparateChainingHashST();

  private SeparateChainingHashST<Integer,Area> areasST = new SeparateChainingHashST();

  private RedBlackBST<Integer,Historico> empregosST = new RedBlackBST<>();

  private Integer idLocalizacao;


    /**
     *s
     * Construtor
     */
  public Pessoa(Integer idPessoa, String nomePessoa, String apelidoPessoa, Date dataNasc, Integer idEmpresa, Integer idLocalizacao) {
      this.idPessoa = idPessoa;
      this.nomePessoa = nomePessoa;
      this.apelidoPessoa = apelidoPessoa;
      this.dataNasc = dataNasc;
      this.idEmpresa = idEmpresa;
      this.idLocalizacao = idLocalizacao;
  }

    /**
     *
     * Getter and Setter
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getApelidoPessoa() {
        return apelidoPessoa;
    }

    public void setApelidoPessoa(String apelidoPessoa) {
        this.apelidoPessoa = apelidoPessoa;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
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
     * @element-type Encontro
     */
    public RedBlackBST<Date, Encontro> getEncontrosST() {
        return encontrosST;
    }

    public void setEncontrosST(RedBlackBST<Date, Encontro> encontrosST) {
        this.encontrosST = encontrosST;
    }

    /**
     *
     * @element-type Competencia
     */
    public SeparateChainingHashST<Integer, Competencia> getCompetenciasST() {
        return competenciasST;
    }

    public void setCompetencias(SeparateChainingHashST<Integer, Competencia> competenciasST) {
        this.competenciasST = competenciasST;
    }

    /**
     *
     * @element-type Area
     */
    public SeparateChainingHashST<Integer, Area> getAreasST() {
        return areasST;
    }

    public void setAreas(SeparateChainingHashST<Integer, Area> areasST) {
        this.areasST = areasST;
    }

    /**
     *
     * @element-type Historico
     */
    public RedBlackBST<Integer, Historico> getEmpregosST() {
        return empregosST;
    }

    public void setEmpregosST(RedBlackBST<Integer, Historico> empregosST) {
        this.empregosST = empregosST;
    }

    public Integer getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Integer idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", apelidoPessoa='" + apelidoPessoa + '\'' +
                ", dataNasc=" + dataNasc +
                ", IdEmpresa=" + idEmpresa +
                ", idLocalizacao=" + idLocalizacao +
                '}';
    }


    /**
     *
     * Funções
     */
  public static void addCompetencia(SeparateChainingHashST<Integer,Competencia>competencias, Integer idCompetencia,  String nomeCompetencia) {
      Competencia aux_competencia = new Competencia(idCompetencia, nomeCompetencia);
      competencias.put(idCompetencia, aux_competencia);

      if(competencias.contains(idCompetencia)){
          System.out.println("Competencia adicionada com sucesso ");
      }else{
          System.out.println("Competencia não adcionada");
      }
  }

  public static void removerCompetencia(SeparateChainingHashST <Integer,Competencia>competencias, Integer idCompetencia) {

      if (competencias.contains(idCompetencia)) {
          competencias.delete(idCompetencia);
          System.out.println("\n Competencia removida com sucesso ");
      } else {
          System.out.println("\n Esta competencia nao existe!!" + "\n");
      }
  }


  public static void alterarCompetencia(SeparateChainingHashST <Integer,Competencia>competencias, Integer idCompetencia){
      //string name
      if(competencias.contains(idCompetencia)){
          System.out.println("1 - nome");

          Scanner scanIn = new Scanner(System.in);
          String escolha = scanIn.nextLine();

          switch (escolha){

              case"1":
                  String nome = scanIn.nextLine();
                  competencias.get(idCompetencia).setNomeCompetencia(nome);
                  break;
          }
          System.out.println("\n Competencia alterada com sucesso");
      }else{
          System.out.println("\n Esta competencia nao existe!" + "\n");
      }
    }


  public void listarCompetencia() {
  }

  public static void addArea(SeparateChainingHashST<Integer,Area> areas, Integer idArea,  String nomeArea) {
      Area aux_area = new Area(idArea, nomeArea);
      areas.put(idArea, aux_area);

      if(areas.contains(idArea)){
          System.out.println("Competencia adicionada com sucesso ");
      }else{
          System.out.println("Competencia não adcionada");
      }
  }

  public static void removeArea(SeparateChainingHashST<Integer,Area> areas, Integer idArea) {

      if (areas.contains(idArea)) {
          areas.delete(idArea);
          System.out.println("\n Area removida com sucesso ");
      } else {
          System.out.println("\n Esta area nao existe!!" + "\n");
      }
  }

  public static void alterarArea(SeparateChainingHashST<Integer,Area> areas, Integer idArea){
        //string name
        if(areas.contains(idArea)){
            System.out.println("1 - nome");

            Scanner scanIn = new Scanner(System.in);
            String escolha = scanIn.nextLine();

            switch (escolha){

                case"1":
                    String nome = scanIn.nextLine();
                    areas.get(idArea).setNomeArea(nome);
                    break;
            }
            System.out.println("\n Area alterada com sucesso");
        }else{
            System.out.println("\n Esta area nao existe!" + "\n");
        }
    }


    /**
     *
     * Falta acabar
     */
  public static ArrayList<String> pesquisarPessoaArea(RedBlackBST<Integer,Pessoa> pessoasST, int idPessoa) {
      ArrayList<String> res = new ArrayList<>();
      for(Integer aux : pessoasST.keys()){
          Pessoa p = pessoasST.get(aux);
          if(p.getIdPessoa().equals(idPessoa)){
              res.add(p.toString());
          }
      }
      return res;
  }


    public String toStringFicheiroPessoa(){
        return idPessoa + ";" + nomePessoa + ";" + apelidoPessoa + ";" + dataNasc + ";" + idEmpresa + ";" +  idLocalizacao + ";";
    }



}