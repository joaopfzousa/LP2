package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.Scanner;


public class Gestao {

    private RedBlackBST<Integer,Encontro> encontrosST = new RedBlackBST<>();

    private SeparateChainingHashST <Integer,Empresa> empresasST = new SeparateChainingHashST();

    private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

    private SeparateChainingHashST<Integer,Area> areasST = new SeparateChainingHashST();

    private SeparateChainingHashST<Integer,Competencia> competenciasST = new SeparateChainingHashST();
/**
 *
 * Getter and Setter
 */
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
     * @element-type Empresa
     */
    public SeparateChainingHashST<Integer, Empresa> getEmpresas() {
        return empresasST;
    }

    public void setEmpresas(SeparateChainingHashST<Integer, Empresa> empresasST) {
        this.empresasST = empresasST;
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

    /**
     *
     * @element-type Area
     */
    public SeparateChainingHashST<Integer, Area> getAreasST() {
        return areasST;
    }

    public void setAreasST(SeparateChainingHashST<Integer, Area> areasST) {
        this.areasST = areasST;
    }

    /**
     *
     * @element-type Competencia
     */
    public SeparateChainingHashST<Integer, Competencia> getCompetenciasST() {
        return competenciasST;
    }

    public void setCompetenciasST(SeparateChainingHashST<Integer, Competencia> competenciasST) {
        this.competenciasST = competenciasST;
    }
    /**
     *
     * Funções
     */
    public static void addEmpresa(SeparateChainingHashST <Integer,Empresa>empresasST, Integer idEmpresa,  String nomeEmpresa, String areaEmpresa, Integer idLocalizacao) {

        Empresa aux_empresa = new Empresa(idEmpresa, nomeEmpresa, areaEmpresa, idLocalizacao);
        empresasST.put(idEmpresa, aux_empresa);

        if(empresasST.contains(idEmpresa)){
            System.out.println("Empresa adicionada com sucesso");
        }else{
            System.out.println("Empresa não adcionada");
        }
    }

    public static void removeEmpresa(SeparateChainingHashST <Integer,Empresa>empresasST, Integer idEmpresa) {

        if (empresasST.contains(idEmpresa)) {
            empresasST.delete(idEmpresa);
            System.out.println("\n Empresa removido com sucesso ");
        } else {
            System.out.println("\n Esta empresa nao existe!!" + "\n");
        }
    }

    public static void alterarEmpresa(SeparateChainingHashST <Integer,Empresa>empresasST, Integer idEmpresa){
        //string name || string areaEmpresa || Integer idEmpresa
        if(empresasST.contains(idEmpresa)){
            System.out.println("1 - nome");
            System.out.println("2 - areaEmpresa");
            System.out.println("3 - Localizacao");

            Scanner scanIn = new Scanner(System.in);
            String escolha = scanIn.nextLine();

            switch (escolha){

                case"1":
                    String nome = scanIn.nextLine();
                    empresasST.get(idEmpresa).setNomeEmpresa(nome);
                    break;

                case"2":
                    String areaEmpresa = scanIn.nextLine();
                    empresasST.get(idEmpresa).setAreaEmpresa(areaEmpresa);
                    break;

                case"3":
                    String Localizacao = scanIn.nextLine();
                    Integer local = Integer.parseInt(Localizacao);
                    empresasST.get(idEmpresa).setIdLocalizacao(local);
                    break;
            }
            System.out.println("\n Empresa alterada com sucesso");
        }else{
            System.out.println("\n Esta empresa nao existe!" + "\n");
        }
    }


  public static void listarEmpresa(SeparateChainingHashST <Integer,Empresa> empresasST) {
        for(Integer idaux : empresasST.keys()){
            Empresa em = (Empresa) empresasST.get(idaux);
            System.out.println(em.toString());
        }
  }

  public static void listarPessoa(RedBlackBST<Integer,Pessoa> pessoasST) {
      for (Integer idaux : pessoasST.keys()) {
          Pessoa p = (Pessoa) pessoasST.get(idaux);
          System.out.println(p.toString());
      }
  }


  public static void listarEncontro(RedBlackBST<Integer,Encontro> encontrosST) {
      for (Integer idaux : encontrosST.keys()) {
          Encontro en = (Encontro) encontrosST.get(idaux);
          System.out.println(en.toString());
      }

  }

  public static void listarCompetencia(SeparateChainingHashST<Integer,Competencia> competenciasST) {
      for (Integer idaux : competenciasST.keys()) {
          Competencia con = (Competencia) competenciasST.get(idaux);
          System.out.println(con.toString());
      }
  }

  public static void listarArea(SeparateChainingHashST<Integer,Area> areasST) {
      for (Integer idaux : areasST.keys()) {
          Area a = (Area) areasST.get(idaux);
          System.out.println(a.toString());
      }
  }

    public static void main(String[] args) {

    }


}