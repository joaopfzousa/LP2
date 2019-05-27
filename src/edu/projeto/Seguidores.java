package edu.projeto;

import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.StdOut;


public class Seguidores {

    private Utilizadores utilizadores;

    private LinearProbingHashST<Integer,Empresa> empresaSeguir = new LinearProbingHashST<>();

    private LinearProbingHashST<Integer,Empresa> empresaSeguindo = new LinearProbingHashST<>();

    private LinearProbingHashST<Integer,Pessoa> pessoaSeguir = new LinearProbingHashST<>();

    private LinearProbingHashST<Integer,Pessoa> pessoaSeguindo = new LinearProbingHashST<>();


    //construtor
    public Seguidores(Pessoa pessoa , Empresa empresa) {
        if(pessoa != null) this.utilizadores = pessoa;
        if(empresa != null) this.utilizadores = empresa;
    }


    //Funções

    public int totalEmpresaSeguidores() {
        return empresaSeguindo.size();
    }

    public int totalPessoaSeguidores() {
        return pessoaSeguindo.size();
    }

    public int totalPessoaSeguindo() {
        return pessoaSeguir.size();
    }

    public int totalEmpresaSeguindo() {
        return empresaSeguir.size();
    }

    public int totalSeguidores() {
        return totalEmpresaSeguidores() + totalPessoaSeguidores();
    }

    public int totalSeguindo() {

        return this.totalEmpresaSeguindo() + this.totalPessoaSeguindo();
    }

    private boolean existePessoa(Pessoa pessoa) {
        if(pessoa != null) {
            for (Integer aux : this.pessoaSeguir.keys()) {
                if (this.pessoaSeguir.get(aux).getIdPessoa() == pessoa.getIdPessoa())
                    return true;
            }
        }
        return false;
    }

    private boolean existeEmpresa(Empresa empresa) {
        // funcao auxiliar a funcao Seguir
        if(empresa != null) {
            for (Integer aux : this.empresaSeguir.keys()) {
                if (this.empresaSeguir.get(aux).getIdEmpresa() == empresa.getIdEmpresa())
                    return true;
            }
        }
        return false;
    }

    public void Seguir(Pessoa pessoa , Empresa empresa) {
        if (pessoa != null) {
            if(!existePessoa(pessoa)) {
                pessoaSeguir.put(this.totalPessoaSeguindo()+1, pessoa);
                if(this.utilizadores instanceof Pessoa)
                    pessoa.getSeguidores().pessoaSeguindo.put(pessoa.getSeguidores().pessoaSeguindo.size()+1,(Pessoa)this.utilizadores);
                else pessoa.getSeguidores().empresaSeguindo.put(pessoa.getSeguidores().empresaSeguindo.size()+1,(Empresa) this.utilizadores);
            }

            else System.out.println("Ja segue o utilizador " + pessoa.getNomePessoa());
        }


        if (empresa != null) {
            if(!existeEmpresa(empresa)) {
                empresaSeguir.put(this.totalEmpresaSeguindo()+1, empresa);
                if(this.utilizadores instanceof Empresa)
                    empresa.getSeguidores().empresaSeguindo.put(empresa.getSeguidores().empresaSeguindo.size()+1,(Empresa) this.utilizadores);
                else empresa.getSeguidores().pessoaSeguindo.put(empresa.getSeguidores().pessoaSeguindo.size()+1,(Pessoa) this.utilizadores);
            }
            else System.out.println("Ja segue a empresa " + empresa.getNomeEmpresa());
        }

    }

    public void rmSeguir(Pessoa pessoa , Empresa empresa) {
        if(pessoa != null) {
            for(Integer aux : pessoaSeguir.keys()) {
                // ciclo que vai de key a key
                if(pessoaSeguir.get(aux).getIdPessoa() == pessoa.getIdPessoa()) {
                    // caso o id do utilizador for da key
                    pessoaSeguir.delete(aux);
                    if(this.utilizadores instanceof Pessoa)
                        pessoa.getSeguidores().pessoaSeguindo.delete(aux);
                    else pessoa.getSeguidores().empresaSeguindo.delete(aux);
                    System.out.println("Deixou de seguir o utilizador " + pessoa.getNomePessoa());
                }
            }
        }

        if(empresa != null) {
            for(Integer aux : empresaSeguir.keys()) {
                // ciclo que vai de key a key
                if(empresaSeguir.get(aux).getIdEmpresa() == empresa.getIdEmpresa()) {
                    // caso o id do utilizador for da key
                    empresaSeguir.delete(aux);
                    if(this.utilizadores instanceof Empresa)
                        empresa.getSeguidores().empresaSeguindo.delete(aux);
                    else empresa.getSeguidores().pessoaSeguindo.delete(aux);
                    System.out.println("Deixou de seguir a empresa " + empresa.getNomeEmpresa());
                }
            }
        }
    }

    public void imprimeSeguidores() {
        System.out.println("Total a seguir : "  + this.totalSeguindo());
    }

    public void imprimeSeguindo() {
        System.out.println("Total seguindo : "  + this.totalSeguidores());
    }
}
