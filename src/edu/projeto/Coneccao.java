package edu.projeto;

import edu.princeton.cs.algs4.DirectedEdge;

public class Coneccao extends DirectedEdge{

        private Integer vertice;

        private Double distancia;

    public Coneccao(int v, int w, double weight, Integer vertice,  Double distancia) {
        super(v, w, weight);
        this.vertice = vertice;
        this.distancia = distancia;
    }

    public Integer getVertice() {
        return vertice;
    }

    public void setVertice(Integer vertice) {
        this.vertice = vertice;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
}
