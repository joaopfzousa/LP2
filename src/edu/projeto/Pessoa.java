package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.Scanner;


public class Pessoa {

  private String nomePessoa;

  private String apelidoPessoa;

  private Date dataNasc;

  private Integer idPessoa;

  private Empresa empresa;
    private RedBlackBST<Integer,Encontro> encontrosST = new RedBlackBST<>();
    private SeparateChainingHashST<Integer,Competencia> competencias = new SeparateChainingHashST();
    private SeparateChainingHashST<Integer,Area> areas = new SeparateChainingHashST();
     private RedBlackBST<Integer,Historico> empregosST = new RedBlackBST<>();

    private Localizacao localizacao;

  public Pessoa(String nomePessoa, String apelidoPessoa, Date dataNasc, Integer idPessoa, Empresa empresa, RedBlackBST<Integer, Encontro> encontrosST, SeparateChainingHashST<Integer, Competencia> competencias, SeparateChainingHashST<Integer, Area> areas, RedBlackBST<Integer, Historico> empregosST, Localizacao localizacao) {
    this.nomePessoa = nomePessoa;
    this.apelidoPessoa = apelidoPessoa;
    this.dataNasc = dataNasc;
    this.idPessoa = idPessoa;
    this.empresa = empresa;
    this.encontrosST = encontrosST;
    this.competencias = competencias;
    this.areas = areas;
    this.empregosST = empregosST;
    this.localizacao = localizacao;
  }

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


  public void listarArea() {
  }

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

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  /**
 *
 * @element-type Encontro
 */
  public RedBlackBST<Integer, Encontro> getEncontrosST() {
    return encontrosST;
  }

  public void setEncontrosST(RedBlackBST<Integer, Encontro> encontrosST) {
    this.encontrosST = encontrosST;
  }

  /**
 *
 * @element-type Competencia
 */
  public SeparateChainingHashST<Integer, Competencia> getCompetencias() {
    return competencias;
  }

  public void setCompetencias(SeparateChainingHashST<Integer, Competencia> competencias) {
    this.competencias = competencias;
  }

  /**
 *
 * @element-type Area
 */
  public SeparateChainingHashST<Integer, Area> getAreas() {
    return areas;
  }

  public void setAreas(SeparateChainingHashST<Integer, Area> areas) {
    this.areas = areas;
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

  public Localizacao getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(Localizacao localizacao) {
    this.localizacao = localizacao;
  }
}