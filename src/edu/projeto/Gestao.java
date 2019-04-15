package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.Scanner;


public class Gestao {

    private RedBlackBST<Integer,Encontro> encontrosST = new RedBlackBST<>();

    private SeparateChainingHashST <Integer,Empresa> empresas = new SeparateChainingHashST();
    private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

    public Gestao(RedBlackBST<Integer, Encontro> encontrosST, SeparateChainingHashST<Integer, Empresa> empresas, RedBlackBST<Integer, Pessoa> pessoasST) {
        this.encontrosST = encontrosST;
        this.empresas = empresas;
        this.pessoasST = pessoasST;
    }

    public static void addEmpresa(SeparateChainingHashST <Integer,Empresa>empresas, Integer idEmpresa,  String nomeEmpresa, String areaEmpresa) {

        Empresa aux_empresa = new Empresa(idEmpresa, nomeEmpresa, areaEmpresa);
        empresas.put(idEmpresa, aux_empresa);

        if(empresas.contains(idEmpresa)){
            System.out.println("Empresa adicionada com sucesso");
        }else{
            System.out.println("Empresa não adcionada");
        }
    }

    public static void removeEmpresa(SeparateChainingHashST <Integer,Empresa>empresas, Integer idEmpresa) {

        if (empresas.contains(idEmpresa)) {
            empresas.delete(idEmpresa);
            System.out.println("\n Empresa removido com sucesso ");
        } else {
            System.out.println("\n Esta empresa nao existe!!" + "\n");
        }
    }

    public static void alterarEmpresa(SeparateChainingHashST <Integer,Empresa>empresas, Integer idEmpresa){
        //string name || string area
        if(empresas.contains(idEmpresa)){
            System.out.println("1 - nome");
            System.out.println("2 - areaEmpresa");

            Scanner scanIn = new Scanner(System.in);
            String escolha = scanIn.nextLine();

            switch (escolha){

                case"1":
                    String nome = scanIn.nextLine();
                    empresas.get(idEmpresa).setNomeEmpresa(nome);
                    break;

                case"2":
                    String areaEmpresa = scanIn.nextLine();
                    empresas.get(idEmpresa).setAreaEmpresa(areaEmpresa);
                    break;
            }
            System.out.println("\n Empresa alterada com sucesso");
        }else{
            System.out.println("\n Esta empresa nao existe!" + "\n");
        }
    }


  public void listarEmpresa() {
  }

  public void listarPessoa() {
  }

  public void listarEncontro() {
  }

  public void listarCompetencia() {
  }

  public void listarArea() {
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
   * @element-type Empresa
   */
    public SeparateChainingHashST<Integer, Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(SeparateChainingHashST<Integer, Empresa> empresas) {
        this.empresas = empresas;
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
}