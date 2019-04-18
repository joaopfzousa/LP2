package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;



public class Competencia {

  private Integer idCompetencia;

  private String nomeCompetencia;

  private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

    /**
     *
     * Construtor
     */
    public Competencia(Integer idCompetencia, String nomeCompetencia) {
        this.idCompetencia = idCompetencia;
        this.nomeCompetencia = nomeCompetencia;
    }

    /**
     *
     * Getter and Setter
     */
    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getNomeCompetencia() {
        return nomeCompetencia;
    }

    public void setNomeCompetencia(String nomeCompetencia) {
        this.nomeCompetencia = nomeCompetencia;
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

    @Override
    public String toString() {
        return "Competencia{" +
                "idCompetencia=" + idCompetencia +
                ", nomeCompetencia='" + nomeCompetencia + '\'' +
                ", pessoasST=" + pessoasST +
                '}';
    }


    /**
     *
     * Funções
     */
    public String toStringFicheiroCompetencia(){
        return idCompetencia + ";" + nomeCompetencia + ";";
    }



}