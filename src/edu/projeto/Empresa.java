package edu.projeto;
import edu.princeton.cs.algs4.RedBlackBST;
import java.util.ArrayList;


public class Empresa {

    private Integer idEmpresa;

    private String nomeEmpresa;

    private String areaEmpresa;

    private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

    private RedBlackBST<Integer,Encontro> encontrosST = new RedBlackBST<>();

    private Localizacao localizacao;



    public Empresa(Integer idEmpresa,String nomeEmpresa, String areaEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.areaEmpresa = areaEmpresa;
    }

  public void addPessoa(Pessoa p) {

  }

  public Pessoa removePessoa(int idp) {
  return null;
  }

  public Pessoa alterarPessoa(int idp) {
  return null;
  }

  public void listarPessoa() {
  }

  public void addEncontro(Encontro en) {
  }

  public Encontro removeEncontro(int iden) {
  return null;
  }

  public Encontro alterarEncontro(int iden) {
  return null;
  }

  public ArrayList<Encontro> listarEncontros(Date di, Date df) {
  return null;
  }




    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getAreaEmpresa() {
        return areaEmpresa;
    }

    public void setAreaEmpresa(String areaEmpresa) {
        this.areaEmpresa = areaEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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
   * @element-type Encontro
   */
    public RedBlackBST<Integer, Encontro> getEncontrosST() {
        return encontrosST;
    }

    public void setEncontrosST(RedBlackBST<Integer, Encontro> encontrosST) {
        this.encontrosST = encontrosST;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}