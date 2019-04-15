package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;



public class Competencia {

  private Integer idCompetencia;

  private String nomeCompetencia;

    public Competencia(Integer idCompetencia, String nomeCompetencia) {
        this.idCompetencia = idCompetencia;
        this.nomeCompetencia = nomeCompetencia;
    }

    private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();


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
}