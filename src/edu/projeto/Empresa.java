package edu.projeto;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;
import java.util.Scanner;



public class Empresa {

    private Integer idEmpresa;

    private String nomeEmpresa;

    private String areaEmpresa;

    private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

    private RedBlackBST<Integer,Encontro> encontrosST = new RedBlackBST<>();

    private Integer idLocalizacao;

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", areaEmpresa='" + areaEmpresa + '\'' +
                ", pessoasST=" + pessoasST +
                ", encontrosST=" + encontrosST +
                ", idLocalizacao=" + idLocalizacao +
                '}';
    }

    /**
     *
     * Construtor
     */
    public Empresa(Integer idEmpresa, String nomeEmpresa, String areaEmpresa, Integer idLocalizacao) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.areaEmpresa = areaEmpresa;
        this.idLocalizacao = idLocalizacao;
    }


    /**
     *
     * Getter and Setter
     */
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

    public Integer getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Integer idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    /**
     *
     * Funções
     */
    public static void addPessoa(RedBlackBST<Integer,Pessoa> pessoasST, Integer idPessoa, String nomePessoa, String apelidoPessoa, Date dataNasc, Integer idEmpresa, Integer idLocalizacao) {

        Pessoa aux_pessoa = new Pessoa(idPessoa, nomePessoa, apelidoPessoa, dataNasc, idEmpresa, idLocalizacao);
        pessoasST.put(idPessoa, aux_pessoa);

        if(pessoasST.contains(idPessoa)){
            System.out.println("Pessoa adicionada com sucesso ");
        }else{
            System.out.println("Pessoa não adcionada");
        }
    }

    public static void removePessoa(RedBlackBST<Integer,Pessoa> pessoasST, Integer idPessoa) {

        if (pessoasST.contains(idPessoa)) {
            pessoasST.delete(idPessoa);
            System.out.println("\n Pessoa removida com sucesso ");
        } else {
            System.out.println("\n Esta pessoa nao existe!!" + "\n");
        }
    }

    public static void alterarPessoa(RedBlackBST<Integer,Pessoa> pessoasST, Integer idPessoa) {
        //string name || string apelido || data de nascimento || idEmpresa

        if(pessoasST.contains(idPessoa)){
            System.out.println("1 - nome");
            System.out.println("2 - Apelido");
            System.out.println("3 - Data de Nascimento");
            System.out.println("4 - Empresa");

            Scanner scanIn = new Scanner(System.in);
            String escolha = scanIn.nextLine();

            switch (escolha){

                case"1":
                    String nome = scanIn.nextLine();
                    pessoasST.get(idPessoa).setNomePessoa(nome);
                    break;

                case"2":
                    String apelido = scanIn.nextLine();
                    pessoasST.get(idPessoa).setApelidoPessoa(apelido);
                    break;

                case"3":
                    System.out.println("Digite da seguinte forma: yy-MM-dd");
                    String data = scanIn.nextLine();
                    String[] items = data.split("-");
                    Date date = new Date(Integer.parseInt(items[3]), Integer.parseInt(items[2]), Integer.parseInt(items[1]));
                    pessoasST.get(idPessoa).setDataNasc(date);
                    break;

                case"4":
                    String empresa = scanIn.nextLine();
                    Integer empres = Integer.parseInt(empresa);
                    pessoasST.get(idPessoa).setIdEmpresa(empres);
                    break;

            }
            System.out.println("\n Pesssoa alterada com sucesso");
        }else{
            System.out.println("\n Esta Pessoa nao existe!" + "\n");
        }
    }


  public static ArrayList<String> pesquisarPessoaEmpresa(RedBlackBST<String,Pessoa> pessoasST, int idEmpresa) {

        ArrayList<String> res = new ArrayList<>();
        for(String aux : pessoasST.keys()){
            Pessoa p = pessoasST.get(aux);
            if(p.getIdEmpresa() == idEmpresa){
                res.add(p.toString());
            }
        }
        return res;
  }
    public static void addEncontro(RedBlackBST<Integer,Encontro> encontrosST, Integer idEncontro, Date dataInicio, Date dataFinal, Integer idEmpresa, Integer idLocalizacao, Integer idArea) {

        Encontro aux_encontro = new Encontro(idEncontro, dataInicio, dataFinal, idEmpresa, idLocalizacao, idArea);
        encontrosST.put(idEncontro, aux_encontro);

        if(encontrosST.contains(idEncontro)){
            System.out.println("Encontro adicionado com sucesso ");
        }else{
            System.out.println("Encontro não adcionado");
        }
    }

    public static void removeEncontro(RedBlackBST<Integer,Encontro> encontrosST, Integer idEncontro) {

        if (encontrosST.contains(idEncontro)) {
            encontrosST.delete(idEncontro);
            System.out.println("\n Encontro removido com sucesso ");
        } else {
            System.out.println("\n Este encontro nao existe!!" + "\n");
        }
    }

    public static void alterarEncontro(RedBlackBST<Integer,Encontro> encontrosST, Integer idEncontro) {
        //Integer idEncontro || Date dataInicio || Date dataFinal || Integer idEmpresa || Integer idLocalizacao || Integer idArea

        if(encontrosST.contains(idEncontro)){
            System.out.println("1 - Data de inicio");
            System.out.println("2 - Data final ");
            System.out.println("3 - Empresa");
            System.out.println("4 - Localizacao");
            System.out.println("4 - Area");

            Scanner scanIn = new Scanner(System.in);
            String escolha = scanIn.nextLine();

            switch (escolha){

                case"1":
                    System.out.println("Digite da seguinte forma: yy-MM-dd");
                    String datai = scanIn.nextLine();
                    String[] itemi = datai.split("-");
                    Date datei = new Date(Integer.parseInt(itemi[3]), Integer.parseInt(itemi[2]), Integer.parseInt(itemi[1]));
                    encontrosST.get(idEncontro).setDataInicio(datei);
                    break;

                case"2":
                    System.out.println("Digite da seguinte forma: yy-MM-dd");
                    String dataf = scanIn.nextLine();
                    String[] itemf = dataf.split("-");
                    Date datef = new Date(Integer.parseInt(itemf[3]), Integer.parseInt(itemf[2]), Integer.parseInt(itemf[1]));
                    encontrosST.get(idEncontro).setDataFinal(datef);
                    break;

                case"3":
                    String empresa = scanIn.nextLine();
                    Integer empres = Integer.parseInt(empresa);
                    encontrosST.get(idEncontro).setIdEmpresa(empres);
                    break;

                case"4":
                    String localizacao = scanIn.nextLine();
                    Integer local = Integer.parseInt(localizacao);
                    encontrosST.get(idEncontro).setIdEmpresa(local);
                    break;

                case"5":
                    String area = scanIn.nextLine();
                    Integer are = Integer.parseInt(area);
                    encontrosST.get(idEncontro).setIdEmpresa(are);
                    break;
            }
            System.out.println("\n Area alterada com sucesso");
        }else{
            System.out.println("\n Esta area nao existe!" + "\n");
        }
    }

  public static ArrayList<String> pesquisarEncontroData(RedBlackBST<Date,Encontro> encontrosST, Date dinicio, Date dfinal){
      ArrayList<String> res = new ArrayList<>();
      for(Date aux : encontrosST.keys()){
          Encontro en = encontrosST.get(aux);
          if((en.getDataInicio().compareTo(dinicio) > -1 || en.getDataInicio().compareTo(dinicio) == 0) && (en.getDataInicio().compareTo(dfinal) < 1 || en.getDataInicio().compareTo(dfinal) == 0)){
              res.add(en.toString());
          }
      }
      return res;
  }
    public String toStringFicheiroEmpresa(){
        return idEmpresa + ";" + nomeEmpresa + ";" + areaEmpresa + ";" + idLocalizacao + ";";
    }


    public static String guardarEmpresa(SeparateChainingHashST <Integer,Empresa> empresasST, String path){

        Out o = new Out(path);
        for(Integer idaux : empresasST.keys()){
            Empresa em = (Empresa) empresasST.get(idaux);
            o.println(em.toStringFicheiroEmpresa());
        }
        return "Guardou as Empresas no TXT!";
    }

    public static void carregarEmpresas(SeparateChainingHashST <Integer,Empresa> empresasST, String path) {
        In in = new In(path);
        while (!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer idEmpresa = Integer.parseInt(split[0]);
            String nomeEmpresa = split[1];
            String areaEmpresa = split[2];
            Integer idLocalizacao = Integer.parseInt(split[3]);

            Empresa em =  new Empresa(idEmpresa, nomeEmpresa, areaEmpresa, idLocalizacao);
            empresasST.put(idEmpresa, em);

        }
    }

}