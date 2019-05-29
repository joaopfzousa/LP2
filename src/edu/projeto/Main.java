package edu.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static RedBlackBST<Date, Encontro> encontrosST = new RedBlackBST<>();

    public static SeparateChainingHashST<Integer, Empresa> empresasST = new SeparateChainingHashST();

    public static RedBlackBST<Integer, Pessoa> pessoasST = new RedBlackBST<>();

    public static SeparateChainingHashST<Integer, Area> areasST = new SeparateChainingHashST();

    public static SeparateChainingHashST<Integer, Competencia> competenciasST = new SeparateChainingHashST();

    public static RedBlackBST<Date, Historico> historicoST = new RedBlackBST<>();

    public static SeparateChainingHashST<Integer, Localizacao> localizacaoST = new SeparateChainingHashST<>();


    public static void main(String[] args) throws IOException {

        Gestao.carregarEmpresas(empresasST, ".//data//empresas.txt");
        Gestao.carregarPessoa(pessoasST, ".//data//pessoas.txt");
        Gestao.carregaEncontro(encontrosST, ".//data//encontros.txt");
        Gestao.carregarAreas(areasST, ".//data//areas.txt");
        Gestao.carregarCompetencias(competenciasST, ".//data//competencias.txt");
        Gestao.carregaHistorico(historicoST, ".//data//historico.txt");
        Gestao.carregarLocalizacao(localizacaoST, ".//data//localizacao.txt");

        Scanner sca = new Scanner(System.in);
        Main n = new Main();
        String op;
        do {
            System.out.println("\t\t -----> Rede Social <-----\n");
            System.out.println(" [1] -> Empresas\n");
            System.out.println(" [2] -> Pessoas\n");
            System.out.println(" [3] -> Encontros\n");
            System.out.println(" [4] -> Areas\n");
            System.out.println(" [S] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    n.menuEmresas();
                    break;
                case "2":
                    n.menuPessoa();
                    break;
                case "3":
                    n.menuEncontro();
                    break;
                case "4":
                    n.menuArea();
                    break;
                case "s":
                case "S":
                    break;
                default:
                    ///system("cls"); // clear screen - cls windows or clear for linux/unix
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"s".equals(op) && !"S".equals(op));
    }

    /**
     * MENU Empresas
     */
    @SuppressWarnings("empty-statement")
    public void menuEmresas() {
        Scanner s = new Scanner(System.in);
        String op;
        do {

            System.out.println("\t\t -----> Empresas <-----\n");
            System.out.println(" [1] -> Inserir Empresa\n");
            System.out.println(" [2] -> Editar empresa\n");
            System.out.println(" [3] -> Remover empresa\n");
            System.out.println(" [4] -> Listar empresas\n");
            System.out.println(" [5] -> Pesquisa empresas\n");
            System.out.println(" [6] -> Salvar empresas\n");
            System.out.println(" [V] -> Voltar\n");
            System.out.println("OP: ");
            op = s.nextLine();
            switch (op) {
                case "1":

                    Scanner empScan = new Scanner(System.in);
                    int idAux = 0;

                    for (Integer id_Aux : empresasST.keys()) {
                        Empresa em = empresasST.get(id_Aux);
                        if (em.getIdEmpresa() > idAux) {
                            idAux = em.getIdEmpresa();
                        }
                    }

                    idAux += 1;
                    System.out.println("id = " + idAux);
                    System.out.println("\t\t -----> Inserir empresa <-----\n");
                    System.out.println("Nome Empresa: ");
                    String nome_empresa = empScan.nextLine();
                    System.out.println("idAreaEmpresa: ");
                    Integer idarea_empresa = Integer.parseInt(empScan.nextLine());

                    while (Gestao.idAreaValida(areasST, idarea_empresa) == false) {
                        System.out.println("\nA localizacao nao existe");
                        System.out.println("IdLoxalizacao:");
                        idarea_empresa = Integer.parseInt(empScan.nextLine());
                    }

                    System.out.println("IdLocalizacao: ");
                    String idLocal = empScan.nextLine();
                    Integer id_local = Integer.parseInt(idLocal);

                    while (Gestao.idLocalizacaoValida(localizacaoST, id_local) == false) {
                        System.out.println("\nA localizacao nao existe");
                        System.out.println("IdLoxalizacao:");
                        id_local = Integer.parseInt(empScan.nextLine());
                    }

                    System.out.println("Latitude: ");
                    Double latitude = Double.parseDouble(empScan.nextLine());
                    System.out.println("Longitude: ");
                    Double longitude = Double.parseDouble(empScan.nextLine());

                    Gestao.addEmpresa(empresasST, idAux, nome_empresa, idarea_empresa, latitude, longitude);

                    break;

                case "2":
                    Scanner sa = new Scanner(System.in);
                    String update;
                    String oP = "";
                    System.out.println("Editar Empresa (idEmpresa): ");
                    String idEmpresa = sa.nextLine();
                    Integer id_Empresa = Integer.parseInt(idEmpresa);

                    while (Gestao.idEmpresaValida(empresasST, id_Empresa) == false) {
                        System.out.println("\nId da empresa NAO ESXITE");
                        System.out.println("Editar empresa (idEmpresa): ");
                        id_Empresa = Integer.parseInt(sa.nextLine());
                    }
                    Gestao.alterarEmpresa(empresasST, id_Empresa);
                    break;

                case "3":
                    Scanner sca = new Scanner(System.in);

                    System.out.println("\t\t -----> ELIMINAR EMPRESA <-----\n");
                    System.out.println("Elimina Empresa (idEmpresa): ");
                    String idEmpres = sca.nextLine();
                    Integer id_Empres = Integer.parseInt(idEmpres);

                    while (Gestao.idEmpresaValida(empresasST, id_Empres) == false) {
                        System.out.println("\nId da empresa NAO ESXITE");
                        System.out.println("Editar empresa (idEmpresa): ");
                    }

                    System.out.println("\nGuardar Historio da Empresa(Y/N): ");
                    String v = sca.nextLine();
                    if (v.contains("y") || v.contains("Y")) {
                        String path = ".//data//historico//empresa//" + id_Empres + ".txt";
                        System.out.println("MENSAGEM: " + Gestao.arquivarHistoricoEmpresa(empresasST, id_Empres, path));
                    }
                    System.out.println("MENSAGEM: " + Gestao.removeEmpresa(empresasST, pessoasST, encontrosST, id_Empres));
                    break;

                case "4":
                    System.out.println("\t\t -----> Listar Empresas <-----\n");
                    Gestao.listarEmpresa(empresasST);
                    break;
                case "5":
                    do {
                        System.out.println("\t\t -----> Pesquisar Empresas <-----\n");
                        System.out.println(" [1] -> Por Area\n");
                        System.out.println(" [V] -> Voltar\n");
                        System.out.println("OP: ");
                        op = s.nextLine();
                        switch (op) {
                            case "1":
                                Gestao.listarArea(areasST);
                                Scanner p = new Scanner(System.in);
                                System.out.println("\nidArea: ");
                                Integer idAreaAux = Integer.parseInt(p.nextLine());

                                while (Gestao.idAreaValida(areasST, idAreaAux) == false) {
                                    System.out.println("\nIdArea nao existe");
                                    System.out.println("\nIdArea: ");
                                    idAreaAux = Integer.parseInt(p.nextLine());
                                }
                                Gestao.printArraList(Empresa.pesquisarEmpresaByArea(empresasST, idAreaAux));
                                break;
                        }
                    } while (!"v".equals(op) && !"V".equals(op));
                    break;
                case "6":
                    System.out.println("MENSAGEM: " + Gestao.guardarEmpresa(empresasST, ".//data//empresas.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));

    }

    public void menuPessoa() {
        Scanner s = new Scanner(System.in);
        String op;
        do {

            System.out.println("\t\t -----> Pessoa <-----\n");
            System.out.println(" [1] -> Inserir Pessoa\n");
            System.out.println(" [2] -> Editar Pessoa\n");
            System.out.println(" [3] -> Remover Pessoa\n");
            System.out.println(" [4] -> Listar Pessoa\n");
            System.out.println(" [5] -> Pesquisa Pessoa\n");
            System.out.println(" [6] -> Salvar Pessoas\n");
            System.out.println(" [V] -> Voltar\n");
            System.out.println("OP: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    Scanner pScan = new Scanner(System.in);
                    int id_pessoa = pessoasST.get(pessoasST.size() - 1).getIdPessoa() + 1;
                    System.out.println("\t\t -----> Nova Pessoa  <-----");
                    System.out.println("Nome pessoa: ");
                    String nome_pessoa = pScan.nextLine();
                    System.out.println("Apelido pessoa: ");
                    String apelido_pessoa = pScan.nextLine();
                    System.out.println("Cartao de cidadao: ");
                    Integer cc = Integer.parseInt(pScan.nextLine());
                    System.out.println("Data de Nascimento(yy-MM-dd): ");
                    String data = pScan.nextLine();
                    String[] items = data.split("-");
                    Date date = new Date(Integer.parseInt(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
                    System.out.println("IdEmpresa: ");
                    String idEM = pScan.nextLine();
                    Integer id_em = Integer.parseInt(idEM);
                    System.out.println("Latitude: ");
                    Double latitude = Double.parseDouble(pScan.nextLine());
                    System.out.println("Longitude: ");
                    Double longitude = Double.parseDouble(pScan.nextLine());


                    Empresa.addPessoa(pessoasST, id_pessoa, nome_pessoa, apelido_pessoa, cc, date, id_em, latitude, longitude);
                    break;

                case "2":
                    Scanner psca = new Scanner(System.in);
                    String update;
                    String val;
                    System.out.println("Editar Pessoa (ID Pessoas): ");
                    int idAux = Integer.parseInt(psca.nextLine());

                    while (Gestao.idPessoaValida(pessoasST, idAux) == false) {
                        System.out.println("\nID Da Pessoa NAO ESXITE" + "(" + pessoasST.max() + ")");
                        System.out.println("\nNovo ID pessoa: ");
                        idAux = Integer.parseInt(psca.nextLine());
                    }

                    Empresa.alterarPessoa(pessoasST, idAux);
                    break;

                case "3":
                    Scanner sc = new Scanner(System.in);
                    System.out.println("\t\t -----> ELIMINAR PESSOA <-----\n");
                    System.out.printf("Eliminar Pessoa(ID): ");
                    int id = sc.nextInt();
                    while (Gestao.idPessoaValida(pessoasST, id) == false) {
                        System.out.println("\nID Da Pessoa NAO ESXITE" + "(" + pessoasST.max() + ")");
                        System.out.println("\nNovo ID pessoa: ");
                        id = Integer.parseInt(sc.nextLine());
                    }

                    System.out.println("\nGuardar Historio da Pessoa(Y/N): ");
                    String v = sc.nextLine();
                    if (v.contains("y") || v.contains("Y")) {
                        String path = ".//data//historico//pessoa//" + id + ".txt";
                        System.out.println("MENSAGEM: " + Gestao.arquivarHistoricoPessoa(pessoasST, id, path));
                    }

                    System.out.println("MENSAGEM: " + Empresa.removePessoa(pessoasST, encontrosST, competenciasST, areasST, historicoST, id));
                    break;
                case "4":
                    System.out.println("\t\t -----> LISTAR PESSOA <-----\n");
                    Gestao.listarPessoa(pessoasST);
                    break;
                case "5":
                    do {
                        System.out.println("\t\t -----> Pesquisar Pessoa <-----\n");
                        System.out.println(" [1] -> Por Empresa\n");
                        System.out.println(" [V] -> Voltar\n");
                        System.out.println("OP: ");
                        op = s.nextLine();
                        switch (op) {
                            case "1":
                                Gestao.listarEmpresa(empresasST);
                                Scanner pe = new Scanner(System.in);
                                System.out.println("\nIdEmpresa: ");
                                Integer idAEmpresaAux = Integer.parseInt(pe.nextLine());

                                while (Gestao.idEmpresaValida(empresasST, idAEmpresaAux) == false) {
                                    System.out.println("\nEmpresa não existe");
                                    System.out.println("\nIdEmpresa: ");
                                    idAEmpresaAux = Integer.parseInt(pe.nextLine());
                                }

                                Gestao.printArraList(Pessoa.pesquisarPessoasByEmpresa(pessoasST, idAEmpresaAux));
                                break;
                        }
                    } while (!"v".equals(op) && !"V".equals(op));
                    break;
                case "6":
                    System.out.println("MENSAGEM: " + Gestao.guardarPessoa(pessoasST, ".//data//pessoas.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));

    }

    public void menuArea() {
        Scanner s = new Scanner(System.in);
        String op;
        do {

            System.out.println("\t\t -----> Area <-----\n");
            System.out.println(" [1] -> Inserir Area\n");
            System.out.println(" [2] -> Editar Area\n");
            System.out.println(" [3] -> Remover Area\n");
            System.out.println(" [4] -> Listar Areas\n");
            System.out.println(" [5] -> Salvar Area\n");
            System.out.println(" [V] -> Voltar\n");
            System.out.println("OP: ");
            op = s.nextLine();
            switch (op) {

                case "1":
                    Scanner aScan = new Scanner(System.in);
                    int id_area = areasST.get(areasST.size() - 1).getIdArea() + 1;
                    System.out.println("\t\t -----> Nova Area  <-----");
                    System.out.println("Nome Area: ");
                    String nome_area = aScan.nextLine();

                    Pessoa.addArea(areasST, id_area, nome_area);
                    break;

                case "2":
                    Scanner asca = new Scanner(System.in);
                    Gestao.listarArea(areasST);
                    System.out.println("Editar Area (ID areas): ");
                    int idAux = Integer.parseInt(asca.nextLine());


                    while (Gestao.idAreaValida(areasST, idAux) == false) {
                        System.out.println("\nID Da Area NAO ESXITE");
                        System.out.println("\nNovo ID Area: ");
                        idAux = Integer.parseInt(asca.nextLine());
                    }

                    Pessoa.alterarArea(areasST, idAux);
                    break;
                case "3":
                    Scanner sc = new Scanner(System.in);
                    System.out.println("\t\t -----> ELIMINAR Area <-----\n");
                    Gestao.listarArea(areasST);
                    System.out.printf("Eliminar Area(ID): ");
                    int id = sc.nextInt();

                    while (Gestao.idAreaValida(areasST, id) == false) {
                        System.out.println("\nID Da Area NAO ESXITE");
                        System.out.println("\nNovo ID Area: ");
                        id = Integer.parseInt(sc.nextLine());
                    }

                    System.out.println("\nGuardar Historio da Area(Y/N): ");
                    String v = sc.nextLine();
                    if (v.contains("y") || v.contains("Y")) {
                        String path = ".//data//historico//Area//" + id + ".txt";
                        System.out.println("MENSAGEM: " + Gestao.arquivarHistoricoArea(areasST, id, path));
                    }

                    Pessoa.removeArea(areasST, id);

                case "4":
                    System.out.println("\t\t -----> LISTAR AREAS <-----\n");
                    Gestao.listarArea(areasST);
                    break;
                case "5":
                    System.out.println("MENSAGEM: " + Gestao.guardarArea(areasST, ".//data//encontros.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }


    public void menuEncontro() {
        Scanner s = new Scanner(System.in);
        String op;
        do {

            System.out.println("\t\t -----> Encontro <-----\n");
            System.out.println(" [1] -> Inserir Encontro\n");
            System.out.println(" [2] -> Editar Encontro\n");
            System.out.println(" [3] -> Remover Encontro\n");
            System.out.println(" [4] -> Listar Encontro\n");
            System.out.println(" [5] -> Pesquisa Encontro\n");
            System.out.println(" [6] -> Salvar Encontro\n");
            System.out.println(" [V] -> Voltar\n");
            System.out.println("OP: ");
            op = s.nextLine();
            switch (op) {

                case "1":
                    Scanner enScan = new Scanner(System.in);
                    System.out.println("\t\t -----> Novo Encontro <-----");
                    System.out.println("Data Inicio (dd/mm/yyyy hh:mm): ");
                    Date dataInicio = new Date(enScan.nextLine());
                    System.out.println("Data Fim (dd/mm/yyyy hh:mm): ");
                    Date dataFim = new Date(enScan.nextLine());
                    while (dataFim.compareTo(dataInicio) <= 0) {
                        System.out.println("\nDATA DE FIM INCORRECTA");
                        System.out.println("Nova Data Fim (dd/mm/yyyy hh:mm): ");
                        dataFim = new Date(enScan.nextLine());
                    }
                    Gestao.listarEmpresa(empresasST);
                    System.out.println("\nId Empresa: ");
                    int idEmpresa = Integer.parseInt(enScan.nextLine());
                    System.out.println("\n");

                    while (Gestao.idEmpresaValida(empresasST, idEmpresa) == false) {
                        System.out.println("\nId da empresa NAO ESXITE");
                        System.out.println("idEmpresa: ");
                        idEmpresa = Integer.parseInt(enScan.nextLine());
                    }

                    System.out.println("\nId Localização: ");
                    int idLocal = Integer.parseInt(enScan.nextLine());
                    System.out.println("\n");

                    while (Gestao.idLocalizacaoValida(localizacaoST, idLocal) == false) {
                        System.out.println("\nA localizacao nao existe");
                        System.out.println("IdLocalizacao:");
                        idLocal = Integer.parseInt(enScan.nextLine());
                    }

                    Gestao.listarArea(areasST);
                    System.out.println("\nIdArea: ");
                    int idArea = Integer.parseInt(enScan.nextLine());

                    while (Gestao.idAreaValida(areasST, idArea) == false) {
                        System.out.println("\nArea nao existe");
                        System.out.println("IdArea:");
                        idArea = Integer.parseInt(enScan.nextLine());
                    }

                    System.out.println("Latitude: ");
                    Double latitude = Double.parseDouble(enScan.nextLine());
                    System.out.println("Longitude: ");
                    Double longitude = Double.parseDouble(enScan.nextLine());


                    Encontro en = new Encontro(dataInicio, dataFim, idEmpresa, idArea, latitude, longitude);
                    Empresa.addEncontro(encontrosST, en);

                    System.out.println("MENSAGEM: " + Empresa.addEncontro(encontrosST, en));
                    break;

                case "2":

                    Scanner sca = new Scanner(System.in);
                    String val;
                    String update;
                    System.out.println("Editar ENCONTRO(DATA INICIO): ");
                    Date dataInicioUp = new Date(sca.nextLine());
                    Encontro enc = (Encontro) encontrosST.get(dataInicioUp);
                    if (enc.getDataInicio().equals(dataInicioUp)) {
                        do {
                            System.out.println("\t\t -----> EDITAR Encontro <-----\n");
                            System.out.println(" [1] -> Data Inicial \n");
                            System.out.println(" [2] -> Data Final \n");
                            System.out.println(" [3] -> Id da Empresa \n");
                            System.out.println(" [4] -> Id da Localizaçao\n");
                            System.out.println(" [4] -> ID da Area\n");
                            System.out.println(" [V] -> Voltar\n");
                            System.out.println("OP: ");
                            val = sca.nextLine();
                            switch (val) {

                                case "1":
                                    System.out.println("Nova Data Inicio(dd/mm/yyy hh:mm): ");
                                    update = sca.nextLine();
                                    System.out.println("MENSAGEM: " + Empresa.alterarEncontro(enc, op, update));
                                    break;
                                case "2":
                                    System.out.println("Nova Data Fim(dd/mm/yyy hh:mm): ");
                                    Date dF = new Date(sca.nextLine());
                                    while (enc.getDataInicio().afterDate(dF) == true || enc.getDataInicio().equals(dF)) {
                                        System.out.println("\nDATA DE FIM INCORRECTA");
                                        System.out.println("Nova Data Fim (dd/mm/yyyy hh:mm): ");
                                        dF = new Date(sca.nextLine());
                                    }
                                    System.out.println("MENSAGEM: " + Empresa.alterarEncontro(enc, op, dF.toString()));
                                    break;

                                case "3":
                                    System.out.println("IdEmpresa: ");
                                    String id_Empresa = sca.nextLine();
                                    System.out.println("MENSAGEM: " + Empresa.alterarEncontro(enc, op, id_Empresa));
                                    break;

                                case "4":
                                    System.out.println("IdLocalizacao: ");
                                    String idLocal1 = sca.nextLine();
                                    System.out.println("MENSAGEM: " + Empresa.alterarEncontro(enc, op, idLocal1));
                                    break;
                                case "5":
                                    System.out.println("IdArea: ");
                                    String id_a = sca.nextLine();
                                    System.out.println("MENSAGEM: " + Empresa.alterarEncontro(enc, op, id_a));
                                    break;
                                case "v":
                                case "V":
                                    break;
                                default:
                                    System.out.println("Opcao Errada!!!\n");
                            }
                        } while (!"v".equals(val) && !"V".equals(val));
                    }

                    break;

                case "3":
                    Scanner sc = new Scanner(System.in);
                    Gestao.listarEncontro(encontrosST);
                    System.out.printf("Eliminar Encontro(DATA INICIO): ");
                    Date dataI = new Date(sc.nextLine());
                    System.out.println("MENSAGEM: " + Empresa.removeEncontro(encontrosST, dataI));
                    break;

                case "4":
                    System.out.println("\t\t -----> LISTAR Encontros <-----\n");
                    Gestao.listarEncontro(encontrosST);
                    break;
                case "5":
                    do {
                        System.out.println("\t\t -----> Pesquisar Encontros <-----\n");
                        System.out.println(" [1] -> Por Empresa\n");
                        System.out.println(" [2] -> Por Area\n");
                        System.out.println(" [V] -> Voltar\n");
                        System.out.println("OP: ");
                        op = s.nextLine();
                        switch (op) {
                            case "1":
                                Gestao.listarEmpresa(empresasST);
                                Scanner ee = new Scanner(System.in);
                                System.out.println("\nIdEmpresa: ");
                                Integer idempresaAux = Integer.parseInt(ee.nextLine());

                                while (Gestao.idEmpresaValida(empresasST, idempresaAux) == false) {
                                    System.out.println("\nEmpresa não existe");
                                    System.out.println("\nIdEmpresa: ");
                                    idempresaAux = Integer.parseInt(ee.nextLine());
                                }
                                Gestao.printArraList(Gestao.pesquisarEncontroByEmpresa(encontrosST, idempresaAux));
                                break;
                            case "2":
                                Gestao.listarArea(areasST);
                                Scanner ea = new Scanner(System.in);
                                System.out.println("\nidArea: ");
                                Integer idAreaAux = Integer.parseInt(ea.nextLine());

                                while (Gestao.idAreaValida(areasST, idAreaAux) == false) {
                                    System.out.println("\nIdArea nao existe");
                                    System.out.println("\nIdArea: ");
                                    idAreaAux = Integer.parseInt(ea.nextLine());
                                }
                                Gestao.printArraList(Gestao.pesquisarEncontroByArea(encontrosST, idAreaAux));
                        }
                    } while (!"v".equals(op) && !"V".equals(op));
                    break;
                case "6":
                    System.out.println("MENSAGEM: " + Gestao.guardarEncontro(encontrosST, ".//data//encontros.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }
}