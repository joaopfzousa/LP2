package edu.projeto;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Area {

  private Integer idArea;

  private String nomeArea;

  /**
   *s
   * Construtor
   */
  public Area(Integer idArea, String nomeArea) {
    this.idArea = idArea;
    this.nomeArea = nomeArea;
  }

  /**
   *
   * Getter and Setter
   */
  public Integer getIdArea() {
    return idArea;
  }

  public void setIdArea(Integer idArea) {
    this.idArea = idArea;
  }

  public String getNomeArea() {
    return nomeArea;
  }

  public void setNomeArea(String nomeArea) {
    this.nomeArea = nomeArea;
  }

    @Override
    public String toString() {
        return "Area{" +
                "idArea=" + idArea +
                ", nomeArea='" + nomeArea + '\'' +
                '}';
    }
    public String toStringFicheiroArea(){
        return idArea + ";" + nomeArea + ";";
    }


    public static String guardarArea(SeparateChainingHashST<Integer,Area> areasST, String path){

        Out o = new Out(path);
        for(Integer idaux : areasST.keys()){
            Area a = (Area) areasST.get(idaux);
            o.println(a.toStringFicheiroArea());
        }
        return "Guardou as Areas no TXT!";
    }

    public static void carregarAreas(SeparateChainingHashST<Integer,Area> areasST, String path) {
        In in = new In(path);
        while (!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer idArea = Integer.parseInt(split[0]);
            String nomeArea = split[1];

            Area a = new Area(idArea, nomeArea);
            areasST.put(idArea, a);

        }
    }
}