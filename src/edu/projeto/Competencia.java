package edu.projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;


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
    public String toStringFicheiroCompetencia(){
        return idCompetencia + ";" + nomeCompetencia + ";";
    }


    public static String guardarCompetencia(SeparateChainingHashST<Integer,Competencia> competenciasST, String path){

        Out o = new Out(path);
        for(Integer idaux : competenciasST.keys()){
            Competencia com = (Competencia) competenciasST.get(idaux);
            o.println(com.toStringFicheiroCompetencia());
        }
        return "Guardou as Competencias no TXT!";
    }

    public static void carregarCompetencias(SeparateChainingHashST<Integer,Competencia> competenciasST, String path) {
        In in = new In(path);
        while (!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer idCompetencia = Integer.parseInt(split[0]);
            String nomeCompetencia = split[1];

            Competencia com = new Competencia(idCompetencia, nomeCompetencia);
            competenciasST.put(idCompetencia, com);

        }
    }
}