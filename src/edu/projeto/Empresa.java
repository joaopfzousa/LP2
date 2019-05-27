package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;
import java.util.Scanner;



public class Empresa {

    private Integer idEmpresa;

    private String nomeEmpresa;

    private Integer idAreaEmpresa;

    private RedBlackBST<Integer,Pessoa> pessoasST = new RedBlackBST<>();

    private RedBlackBST<Integer,Encontro> encontrosST = new RedBlackBST<>();

    private Double latitude;

    private Double longitude;

    private Seguidores seguidores;

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", areaEmpresa='" + idAreaEmpresa + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    /**
     *
     * Construtor
     */
    public Empresa(Integer idEmpresa, String nomeEmpresa, Integer idAreaEmpresa, Double latitude, Double longitude) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.idAreaEmpresa = idAreaEmpresa;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Integer getIdAreaEmpresa() {
        return idAreaEmpresa;
    }

    public void setIdAreaEmpresa(Integer idAreaEmpresa) {
        this.idAreaEmpresa = idAreaEmpresa;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * Funções
     */
    public static void addPessoa(RedBlackBST<Integer,Pessoa> pessoasST, Integer idPessoa, String nomePessoa, String apelidoPessoa, Integer cc, Date dataNasc, Integer idEmpresa, double latitude, double longitude) {

        Pessoa aux_pessoa = new Pessoa(idPessoa, nomePessoa, apelidoPessoa, cc, dataNasc, idEmpresa, latitude, longitude);
        pessoasST.put(idPessoa, aux_pessoa);

        if(pessoasST.contains(idPessoa)){
            System.out.println("Pessoa adicionada com sucesso ");
        }else{
            System.out.println("Pessoa não adcionada");
        }
    }


    public static String removePessoa(RedBlackBST<Integer,Pessoa> pessoasST,RedBlackBST<Date,Encontro> encontrosST, SeparateChainingHashST<Integer,Competencia> competenciasST, SeparateChainingHashST<Integer,Area> areasST, RedBlackBST<Date,Historico> empregosST, Integer idPessoa) {

        for(Integer id_paux : pessoasST.keys()){
            Pessoa p = (Pessoa) pessoasST.get(id_paux);
            if(p.getIdPessoa().equals(idPessoa)){
                pessoasST.delete(id_paux);
            }
        }
        for(Date dateaux : encontrosST.keys()) {
            Encontro en = (Encontro) encontrosST.get(dateaux);
            if (en.getDataInicio().equals(idPessoa)) {
                encontrosST.delete(dateaux);
            }
        }
        for(Integer id_conaux : competenciasST.keys()) {
            Competencia con = (Competencia) competenciasST.get(id_conaux);
            if (con.getIdCompetencia().equals(idPessoa)) {
                competenciasST.delete(id_conaux);
            }
        }
        for(Integer id_araux : areasST.keys()) {
            Area a = (Area) areasST.get(id_araux);
            if (a.getIdArea().equals(idPessoa)) {
                areasST.delete(id_araux);
            }
        }
        for(Date daux : empregosST.keys()) {
            Historico his = (Historico) empregosST.get(daux);
            if (his.getIdHistorico().equals(idPessoa)) {
                empregosST.delete(daux);
            }
        }
        return "Empresa" + idPessoa + "apagada com sucesso";
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
                    Date date = new Date(Integer.parseInt(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
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
    public static String addEncontro(RedBlackBST<Date,Encontro> encontrosST, Encontro en) {
        encontrosST.put(en.getDataInicio(), en);
        return "encontro inserido";
    }

    public static String removeEncontro(RedBlackBST<Date,Encontro> encontrosST, Date dataInicio) {
        for(Date dateAux : encontrosST.keys()){
            Encontro en = (Encontro) encontrosST.get(dateAux);
            if(en.getDataInicio().equals(dataInicio)){
                encontrosST.delete(dataInicio);
            }
        }
        return "Encontro apagado";
    }

    public static String alterarEncontro(Encontro en, String op, String update) {
        //Integer idEncontro || Date dataInicio || Date dataFinal || Integer idEmpresa || Integer idLocalizacao || Integer idArea
        switch (op){
            case"1":
                en.setDataInicio(new Date(update));
                return " campo editado";
            case"2":
                en.setDataFinal(new Date(update));
                return " campo editado";
            case"3":
                en.setIdEmpresa(Integer.parseInt(update));
                return " campo editado";
            case"4":
                en.setIdArea(Integer.parseInt(update));
                return " campo editado";
        }
        return " ";
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
        return idEmpresa + ";" + nomeEmpresa + ";" + idAreaEmpresa + ";";
    }

    public static ArrayList<String> pesquisarEmpresaByArea(SeparateChainingHashST <Integer,Empresa> empresasST, Integer idArea) {

        ArrayList<String> res = new ArrayList<>();
        for (Integer idAux : empresasST.keys()) {
            Empresa emp  = empresasST.get(idAux);
            if (emp.getIdAreaEmpresa().equals(idArea)) {
                //StdOut.println(a.toString());
                res.add(emp.toString());
            }
        }
        return res;
    }

    public static ArrayList<String> pesquisarEmpresaByPessoa(SeparateChainingHashST <Integer,Empresa> empresasST, Integer idPessoa) {

        ArrayList<String> res = new ArrayList<>();
        for (Integer idAux : empresasST.keys()) {
            Empresa emp  = empresasST.get(idAux);
            if (emp.getPessoasST().equals(idPessoa)) {
                //StdOut.println(a.toString());
                res.add(emp.toString());
            }
        }
        return res;
    }



}