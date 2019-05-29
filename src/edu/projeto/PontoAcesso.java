package edu.projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;

public class PontoAcesso  {

    private String code;
    private Double latitude;
    private Double longitude;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public PontoAcesso(String code, Double latitude, Double longitude) {
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static void loadPontoAcesso(RedBlackBST<String, PontoAcesso> pontoAcessoST, String path){
        In in = new In(path);

        try {
            while (!in.isEmpty()) {

                String[] token = in.readLine().split(";");
                String aux = token[0];
                String aux2 = token[1];
                String aux3 = token[2];

                PontoAcesso aux_aceso = new PontoAcesso(aux, Double.parseDouble(aux2), Double.parseDouble(aux3));
                pontoAcessoST.put(aux, aux_aceso);

            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void savePontoAcesso(RedBlackBST<String, PontoAcesso> pontoAcessoST, String path){
        Out out = new Out(path);


        for (String key : pontoAcessoST.emordem()) {
            out.println(key + ";" + pontoAcessoST.get(key).getLatitude() + ";" + pontoAcessoST.get(key).getLongitude());
            System.out.println(key + ";" + pontoAcessoST.get(key).getLatitude());
        }
    }
    public static void removePontoAcesso(RedBlackBST<String, PontoAcesso> pontoAcessoST, String code){
        if (pontoAcessoST.contains(code)){
            pontoAcessoST.delete(code);
            System.out.println("\n PontoAcesso removido com sucesso ");
        }else System.out.println("\n Este PontoAcesso nao existe!!" + "\n");

    }
    public static void insertPontoAcesso(RedBlackBST<String, PontoAcesso> pontoAcessoST,String code, Double latitude, Double longitude){

        PontoAcesso aux_airport = new PontoAcesso(code,latitude,longitude);
        pontoAcessoST.put(code, aux_airport);

        if(pontoAcessoST.contains(code)){
            System.out.println("PontoAcesso inserido com sucesso");
        }else{
            System.out.println("PontoAcesso nao inserido");
        }

    }
}

