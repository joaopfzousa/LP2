package edu.projeto;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Localizacao {

  private Integer idLocalizacao;

  private double latitude;

  private double longitude;


  /**
   *
   * Construtor
   */
  public Localizacao(Integer idLocalizacao, double latitude, double longitude) {
    this.idLocalizacao = idLocalizacao;
    this.latitude = latitude;
    this.longitude = longitude;
  }


  /**
   *
   * Getter and Setter
   */

  public Integer getIdLocalizacao() {
    return idLocalizacao;
  }

  public void setIdLocalizacao(Integer idLocalizacao) {
    this.idLocalizacao = idLocalizacao;
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

  public String toStringFicheiroLocalizacao(){
    return idLocalizacao + ";" + latitude + ";" + longitude + ";";
  }


  public static String guardarlocalizacao(SeparateChainingHashST<Integer,Localizacao> localizacaoST, String path){

    Out o = new Out(path);
    for(Integer idaux : localizacaoST.keys()){
      Localizacao loc = (Localizacao) localizacaoST.get(idaux);
      o.println(loc.toStringFicheiroLocalizacao());
    }
    return "Guardou as Pessoa no TXT!";
  }

  public static void carregarPessoa(SeparateChainingHashST<Integer,Localizacao> localizacaoST, String path) {
    In in = new In(path);
    while (!in.isEmpty()){
      String[] split = in.readLine().split(";");
      Integer idLocalizacao = Integer.parseInt(split[0]);
      Double latitude = Double.parseDouble(split[1]);
      Double longitude = Double.parseDouble(split[2]);

      Localizacao loc = new Localizacao(idLocalizacao, latitude, longitude);
      localizacaoST.put(idLocalizacao, loc);

    }

  }

  public double distancia(Localizacao l) {
    return 0.0;
  }
}