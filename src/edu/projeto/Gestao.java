package edu.projeto;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Gestao {

    private static RedBlackBST<Date, Encontro> encontrosST = new RedBlackBST<>();

    private static SeparateChainingHashST<Integer, Empresa> empresasST = new SeparateChainingHashST();

    private static RedBlackBST<Integer, Pessoa> pessoasST = new RedBlackBST<>();

    private static SeparateChainingHashST<Integer, Area> areasST = new SeparateChainingHashST();

    private static SeparateChainingHashST<Integer, Competencia> competenciasST = new SeparateChainingHashST();

    private static RedBlackBST<Date, Historico> historicoST = new RedBlackBST<>();

    private static SeparateChainingHashST<Integer, Localizacao> localizacaoST = new SeparateChainingHashST<>();

    private EdgeWeightedDigraph ligacoes;

    private EdgeWeightedGraph localizacao;
/**
 *
 * Getter and Setter
 */
    /**
     * @element-type Encontro
     */
    public RedBlackBST<Date, Encontro> getEncontrosST() {
        return encontrosST;
    }

    public void setEncontrosST(RedBlackBST<Date, Encontro> encontrosST) {
        this.encontrosST = encontrosST;
    }

    /**
     * @element-type Empresa
     */
    public SeparateChainingHashST<Integer, Empresa> getEmpresasST() {
        return empresasST;
    }

    public void setEmpresasST(SeparateChainingHashST<Integer, Empresa> empresasST) {
        this.empresasST = empresasST;
    }

    /**
     * @element-type Pessoa
     */
    public RedBlackBST<Integer, Pessoa> getPessoasST() {
        return pessoasST;
    }

    public void setPessoasST(RedBlackBST<Integer, Pessoa> pessoasST) {
        this.pessoasST = pessoasST;
    }

    /**
     * @element-type Area
     */
    public SeparateChainingHashST<Integer, Area> getAreasST() {
        return areasST;
    }

    public void setAreasST(SeparateChainingHashST<Integer, Area> areasST) {
        this.areasST = areasST;
    }

    /**
     * @element-type Competencia
     */
    public SeparateChainingHashST<Integer, Competencia> getCompetenciasST() {
        return competenciasST;
    }

    public void setCompetenciasST(SeparateChainingHashST<Integer, Competencia> competenciasST) {
        this.competenciasST = competenciasST;
    }

    public RedBlackBST<Date, Historico> getHistoricoST() {
        return historicoST;
    }

    public void setHistoricoST(RedBlackBST<Date, Historico> historicoST) {
        this.historicoST = historicoST;
    }

    public SeparateChainingHashST<Integer, Localizacao> getLocalizacaoST() {
        return localizacaoST;
    }

    public void setLocalizacaoST(SeparateChainingHashST<Integer, Localizacao> localizacaoST) {
        this.localizacaoST = localizacaoST;
    }


    /**
     * Funções
     */
    public static void addEmpresa(SeparateChainingHashST<Integer, Empresa> empresasST, Integer idEmpresa, String nomeEmpresa, Integer idAreaEmpresa, double latitude, double longitude) {

        Empresa aux_empresa = new Empresa(idEmpresa, nomeEmpresa, idAreaEmpresa, latitude, longitude);
        empresasST.put(idEmpresa, aux_empresa);

        if (empresasST.contains(idEmpresa)) {
            System.out.println("Empresa adicionada com sucesso");
        } else {
            System.out.println("Empresa não adcionada");
        }
    }

    public static String removeEmpresa(SeparateChainingHashST<Integer, Empresa> empresasST, RedBlackBST<Integer, Pessoa> pessoasST, RedBlackBST<Date, Encontro> encontrosST, Integer idEmpresa) {
        for (Integer id_emaux : empresasST.keys()) {
            Empresa em = (Empresa) empresasST.get(id_emaux);
            if (em.getIdEmpresa().equals(idEmpresa)) {
                empresasST.delete(id_emaux);
            }
        }
        for (Integer id_paux : pessoasST.keys()) {
            Pessoa p = (Pessoa) pessoasST.get(id_paux);
            if (p.getIdPessoa().equals(idEmpresa)) {
                pessoasST.delete(id_paux);
            }
        }
        for (Date enpaux : encontrosST.keys()) {
            Encontro en = (Encontro) encontrosST.get(enpaux);
            if (en.getDataInicio().equals(idEmpresa)) {
                encontrosST.delete(enpaux);
            }
        }
        return "Empresa" + idEmpresa + "apagada com sucesso";
    }

    public static void alterarEmpresa(SeparateChainingHashST<Integer, Empresa> empresasST, Integer idEmpresa) {
        //string name || string areaEmpresa || Integer idEmpresa
        if (empresasST.contains(idEmpresa)) {
            System.out.println("1 - nome");
            System.out.println("2 - idAreaEmpresa");

            Scanner scanIn = new Scanner(System.in);
            String escolha = scanIn.nextLine();

            switch (escolha) {

                case "1":
                    String nome = scanIn.nextLine();
                    empresasST.get(idEmpresa).setNomeEmpresa(nome);
                    break;

                case "2":
                    Integer idAreaEmpresa = Integer.parseInt(scanIn.nextLine());
                    empresasST.get(idEmpresa).setIdAreaEmpresa(idAreaEmpresa);
                    break;

            }
            System.out.println("\n Empresa alterada com sucesso");
        } else {
            System.out.println("\n Esta empresa nao existe!" + "\n");
        }
    }


    public static void listarEmpresa(SeparateChainingHashST<Integer, Empresa> empresasST) {
        for (Integer idaux : empresasST.keys()) {
            Empresa em = (Empresa) empresasST.get(idaux);
            System.out.println(em.toString());
        }
    }

    public static void listarPessoa(RedBlackBST<Integer, Pessoa> pessoasST) {
        for (Integer idaux : pessoasST.keys()) {
            Pessoa p = (Pessoa) pessoasST.get(idaux);
            System.out.println(p.toString());
        }
    }


    public static void listarEncontro(RedBlackBST<Date, Encontro> encontrosST) {
        for (Date daux : encontrosST.keys()) {
            Encontro en = (Encontro) encontrosST.get(daux);
            System.out.println(en.toString());
        }

    }

    public static void listarCompetencia(SeparateChainingHashST<Integer, Competencia> competenciasST) {
        for (Integer idaux : competenciasST.keys()) {
            Competencia con = (Competencia) competenciasST.get(idaux);
            System.out.println(con.toString());
        }
    }

    public static void listarArea(SeparateChainingHashST<Integer, Area> areasST) {
        for (Integer idaux : areasST.keys()) {
            Area a = (Area) areasST.get(idaux);
            System.out.println(a.toString());
        }
    }

    public static String arquivarHistoricoEmpresa(SeparateChainingHashST<Integer, Empresa> empresasST, Integer idEmpresa, String path) {

        Out o = new Out(path);
        for (Integer id_aux : empresasST.keys()) {
            Empresa em = (Empresa) empresasST.get(id_aux);
            if (em.getIdEmpresa().equals(idEmpresa)) {
                o.println(em.toStringFicheiroEmpresa());
            }
        }
        return "Guardou historico da empresa" + idEmpresa + "com Sucesso";
    }


    public static String guardarArea(SeparateChainingHashST<Integer, Area> areasST, String path) {

        Out o = new Out(path);
        for (Integer idaux : areasST.keys()) {
            Area a = (Area) areasST.get(idaux);
            o.println(a.toStringFicheiroArea());
        }
        return "Guardou as Areas no TXT!";
    }

    public static void carregarAreas(SeparateChainingHashST<Integer, Area> areasST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            Integer idArea = Integer.parseInt(split[0]);
            String nomeArea = split[1];

            Area a = new Area(idArea, nomeArea);
            areasST.put(idArea, a);

        }
    }

    public static String guardarCompetencia(SeparateChainingHashST<Integer, Competencia> competenciasST, String path) {

        Out o = new Out(path);
        for (Integer idaux : competenciasST.keys()) {
            Competencia com = (Competencia) competenciasST.get(idaux);
            o.println(com.toStringFicheiroCompetencia());
        }
        return "Guardou as Competencias no TXT!";
    }

    public static void carregarCompetencias(SeparateChainingHashST<Integer, Competencia> competenciasST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            Integer idCompetencia = Integer.parseInt(split[0]);
            String nomeCompetencia = split[1];

            Competencia com = new Competencia(idCompetencia, nomeCompetencia);
            competenciasST.put(idCompetencia, com);

        }
    }

    public static String guardarEmpresa(SeparateChainingHashST<Integer, Empresa> empresasST, String path) {

        Out o = new Out(path);
        for (Integer idaux : empresasST.keys()) {
            Empresa em = (Empresa) empresasST.get(idaux);
            o.println(em.toStringFicheiroEmpresa());
        }
        return "Guardou as Empresas no TXT!";
    }

    public static void carregarEmpresas(SeparateChainingHashST<Integer, Empresa> empresasST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            Integer idEmpresa = Integer.parseInt(split[0]);
            String nomeEmpresa = split[1];
            Integer idArea = Integer.parseInt(split[2]);
            Double latitude = Double.parseDouble(split[3]);
            Double longitude = Double.parseDouble(split[4]);

            Empresa em = new Empresa(idEmpresa, nomeEmpresa, idArea, latitude, longitude);
            empresasST.put(idEmpresa, em);

        }
    }

    public static String guardarEncontro(RedBlackBST<Date, Encontro> encontrosST, String path) {

        Out o = new Out(path);
        for (Date aux : encontrosST.keys()) {
            Encontro en = (Encontro) encontrosST.get(aux);
            o.println(en.toStringFicheiroEncontro());
        }
        return "Guardou os encontros no TXT!";
    }

    public static void carregaEncontro(RedBlackBST<Date, Encontro> encontrosST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            String dataInicio = split[0];
            String dataFinal = split[1];
            Integer idEmpresa = Integer.parseInt(split[2]);
            Integer idArea = Integer.parseInt(split[4]);
            Double latitude = Double.parseDouble(split[5]);
            Double longitude = Double.parseDouble(split[6]);

            Encontro en = new Encontro(new Date(dataInicio), new Date(dataFinal), idEmpresa, idArea, latitude, longitude);
            encontrosST.put(en.getDataInicio(), en);

        }
    }

    public static String guardarHistorico(RedBlackBST<Date, Historico> historicoST, String path) {

        Out o = new Out(path);
        for (Date dateaux : historicoST.keys()) {
            Historico hi = (Historico) historicoST.get(dateaux);
            o.println(hi.toStringFicheiroHistorico());
        }
        return "Guardou os encontros no TXT!";
    }

    public static void carregaHistorico(RedBlackBST<Date, Historico> historicoST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            Integer idHistorico = Integer.parseInt(split[0]);
            String dataInicio = split[1];
            String dataFim = split[2];
            String cargo = split[3];
            Integer idPessoa = Integer.parseInt(split[4]);
            Integer idEmpresa = Integer.parseInt(split[5]);

            Historico hi = new Historico(idHistorico, new Date(dataInicio), new Date(dataFim), cargo, idPessoa, idEmpresa);
            historicoST.put(hi.getDataInicio(), hi);

        }
    }


    public static String guardarlocalizacao(SeparateChainingHashST<Integer, Localizacao> localizacaoST, String path) {

        Out o = new Out(path);
        for (Integer idaux : localizacaoST.keys()) {
            Localizacao loc = (Localizacao) localizacaoST.get(idaux);
            o.println(loc.toStringFicheiroLocalizacao());
        }
        return "Guardou as Pessoa no TXT!";
    }

    public static void carregarLocalizacao(SeparateChainingHashST<Integer, Localizacao> localizacaoST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            Integer idLocalizacao = Integer.parseInt(split[0]);
            Double latitude = Double.parseDouble(split[1]);
            Double longitude = Double.parseDouble(split[2]);

            Localizacao loc = new Localizacao(idLocalizacao, latitude, longitude);
            localizacaoST.put(idLocalizacao, loc);

        }

    }


    public static String guardarPessoa(RedBlackBST<Integer, Pessoa> pessoasST, String path) {

        Out o = new Out(path);
        for (Integer idaux : pessoasST.keys()) {
            Pessoa p = (Pessoa) pessoasST.get(idaux);
            o.println(p.toStringFicheiroPessoa());
        }
        return "Guardou as Pessoa no TXT!";
    }

    public static void carregarPessoa(RedBlackBST<Integer, Pessoa> pessoasST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            Integer idPessoa = Integer.parseInt(split[0]);
            String nomePessoa = split[1];
            String apelidoPessoa = split[2];
            Integer cc = Integer.parseInt(split[3]);
            String dataNasc = split[4];
            Integer idEmpresa = Integer.parseInt(split[5]);
            Double latitude = Double.parseDouble(split[6]);
            Double longitude = Double.parseDouble(split[7]);

            Pessoa p = new Pessoa(idPessoa, nomePessoa, apelidoPessoa, cc, new Date(dataNasc), idEmpresa, latitude, longitude);
            pessoasST.put(idPessoa, p);

        }

    }

    public static String arquivarHistoricoPessoa(RedBlackBST<Integer, Pessoa> pessoasST, Integer idPessoa, String path) {

        Out o = new Out(path);
        for (Integer id_paux : pessoasST.keys()) {
            Pessoa p = (Pessoa) pessoasST.get(id_paux);
            if (p.getIdPessoa().equals(idPessoa)) {
                o.println(p.toStringFicheiroPessoa());
            }
        }
        return "Guardou historico da pessoa" + idPessoa + "com Sucesso";
    }

    public static String arquivarHistoricoArea(SeparateChainingHashST<Integer, Area> areas, Integer idArea, String path) {

        Out o = new Out(path);
        for (Integer id_paux : areas.keys()) {
            Area a = (Area) areas.get(id_paux);
            if (a.getIdArea().equals(idArea)) {
                o.println(a.toStringFicheiroArea());
            }
        }
        return "Guardou historico da Area" + idArea + "com Sucesso";
    }


    public static boolean idEmpresaValida(SeparateChainingHashST<Integer, Empresa> empresasST, Integer idEmpresa) {

        for (Integer idAux : empresasST.keys()) {
            Empresa en = empresasST.get(idAux);
            if (en.getIdEmpresa().equals(idEmpresa)) {
                return true;
            }
        }
        return false;
    }

    public static boolean idPessoaValida(RedBlackBST<Integer, Pessoa> pessoasST, Integer idPessoa) {

        for (Integer idAux : pessoasST.keys()) {
            Pessoa p = pessoasST.get(idAux);
            if (p.getIdPessoa().equals(idPessoa)) {
                return true;
            }
        }
        return false;
    }

    public static boolean idLocalizacaoValida(SeparateChainingHashST<Integer, Localizacao> localizacaoST, Integer idLocalizacao) {

        for (Integer idAux : localizacaoST.keys()) {
            Localizacao loc = localizacaoST.get(idAux);
            if (loc.getIdLocalizacao().equals(idLocalizacao)) {
                return true;
            }
        }
        return false;
    }

    public static boolean idAreaValida(SeparateChainingHashST<Integer, Area> areasST, int id) {
        for (int aux : areasST.keys()) {
            Area a = areasST.get(aux);
            if (a.getIdArea() == id) {
                return true;
            }
        }
        return false;
    }

    public static void printArraList(ArrayList<String> aR) {
        for (String ar : aR) {
            System.out.println(ar.toString());
        }
    }

    public static boolean dataValida(RedBlackBST<Date, Encontro> encontrosST, Date d) {

        for (Date dAux : encontrosST.keys()) {
            Encontro en = encontrosST.get(dAux);
            if (en.getDataInicio().equals(d)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> pesquisarEncontroByEmpresa(RedBlackBST<Date, Encontro> encontrosST, int id) {

        ArrayList<String> res = new ArrayList<>();
        for (Date aux : encontrosST.keys()) {
            Encontro en = encontrosST.get(aux);
            if (en.getIdEmpresa() == id) {
                //StdOut.println(v.toString());
                res.add(en.toString());
            }
        }
        return res;
    }

    public static ArrayList<String> pesquisarEncontroByArea(RedBlackBST<Date, Encontro> encontrosST, int id) {

        ArrayList<String> res = new ArrayList<>();
        for (Date aux : encontrosST.keys()) {
            Encontro en = encontrosST.get(aux);
            if (en.getIdArea() == id) {
                //StdOut.println(v.toString());
                res.add(en.toString());
            }
        }
        return res;
    }
}