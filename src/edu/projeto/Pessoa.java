package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;
import java.util.Scanner;


public class Pessoa {

    private Integer idPessoa;

  private String nomePessoa;

  private String apelidoPessoa;

  private Integer cc;

  private Date dataNasc;

  private Integer idEmpresa;

  private RedBlackBST<Date,Encontro> encontrosST = new RedBlackBST<>();

  private SeparateChainingHashST<Integer,Competencia> competenciasST = new SeparateChainingHashST();

  private SeparateChainingHashST<Integer,Area> areasST = new SeparateChainingHashST();

  private RedBlackBST<Integer,Historico> empregosST = new RedBlackBST<>();

  private double latitude;

  private double longitude;

  private Seguidores seguidores;


    /**
     *s
     * Construtor
     */
  public Pessoa(Integer idPessoa, String nomePessoa, String apelidoPessoa, Integer cc, Date dataNasc, Integer idEmpresa, double latitude, double longitude) {
      this.idPessoa = idPessoa;
      this.nomePessoa = nomePessoa;
      this.apelidoPessoa = apelidoPessoa;
      this.cc = cc;
      this.dataNasc = dataNasc;
      this.idEmpresa = idEmpresa;
      this.latitude = latitude;
      this.longitude = longitude;

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

    public Integer getcc() {
        return cc;
    }

    public void setcc(Integer cc) {
        this.cc = cc;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", apelidoPessoa='" + apelidoPessoa + '\'' +
                ", cc='" + cc + '\'' +
                ", dataNasc=" + dataNasc +
                ", IdEmpresa=" + idEmpresa +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
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


    public String toStringFicheiroPessoa(){
        return idPessoa + ";" + nomePessoa + ";" + apelidoPessoa + ";" + cc + ":" + dataNasc + ";" + idEmpresa + ";" + latitude + ";" + longitude + ";" ;
    }

    public static ArrayList<String> pesquisarPessoasByEmpresa(RedBlackBST<Integer,Pessoa> pessoasST, Integer idEmpresa) {

        ArrayList<String> res = new ArrayList<>();
        for (Integer idaux : pessoasST.keys()) {
            Pessoa p = pessoasST.get(idaux);
            if (p.getIdEmpresa().equals(idEmpresa))
            {
                //System.out.println(p.toString());
                res.add(p.toString());
            }
        }
        return res;
    }

}