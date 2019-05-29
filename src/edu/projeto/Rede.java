package edu.projeto;



import javax.swing.*;


public class Rede {

    public static void caminho_mais_curto(SymbolDigraph grafo, EdgeWeightedDigraph d, String latitude, String longitude, JTextArea textarea) {

        int latitude2 = grafo.indexOf(latitude);
        int longitude2 = grafo.indexOf(longitude);


        DijkstraSP curto_caminho = new DijkstraSP(d, latitude2);

        double distancia = 0;

        for (DirectedEdge g : curto_caminho.pathTo(longitude2)) {
            textarea.append(grafo.nameOf(g.from()) + " -> " + grafo.nameOf(g.to()) + ":" + g.weight() + "\n");
            //System.out.println(grafo.nameOf(g.from()) + " -> " + grafo.nameOf(g.to()) + ":" + g.weight() + "\n");
            distancia = distancia + g.weight();
        }
        //System.out.println("distancia total= " + distancia);
        textarea.append("\nDistancia total= " + distancia + "km");
        //custo(f,distancia);
    }


    public static void caminho_mais_barato(SymbolDigraph grafo, EdgeWeightedDigraph d, String latitude, String longitude/*, JTextArea textarea*/) {

        double distancia = 500000000, distanciatotal = 0;
        String ligBarata = null;

        int latitude2 = grafo.indexOf(latitude);
        int longitude2 = grafo.indexOf(longitude);
        //System.out.println(maisBarato.pathTo(grafo.indexOf(ponto_destino)));
        for (DirectedEdge de : d.adj(grafo.indexOf(latitude))) {
            System.out.println(grafo.nameOf(de.from()) + "->" + grafo.nameOf(de.to()) + ":" + de.weight());
            DijkstraSP caminhoCurto = new DijkstraSP(grafo.digraph(), de.to());
            distanciatotal = 0;
            distanciatotal = distanciatotal + de.weight();
            for (DirectedEdge g : caminhoCurto.pathTo(longitude2)) {
                System.out.println(grafo.nameOf(g.from()) + "->" + grafo.nameOf(g.to()) + ":" + g.weight());
                distanciatotal = distanciatotal + g.weight();
            }
            if (distanciatotal < distancia) {
                distancia = distanciatotal;
                ligBarata = "\nligacao: " + grafo.nameOf(de.to()) + "->" + longitude + " distancia total: " + distancia;
            }
            System.out.println("\nligacao: " + grafo.nameOf(de.to()) + "->" + longitude + " distancia total: " + distanciatotal);
            System.out.println("----------------------");
        }

        System.out.println("##############A ligacao mais curta é###############");
        System.out.println(ligBarata);
        //custo();
    }

    public static void adicionar_ligacao(SymbolDigraph grafo, EdgeWeightedDigraph d, String ponto_origem, String ponto_destino, Double distancia, Float latitude, Float longitude) {

        if (grafo.contains(ponto_destino)) {
            Ligacao l = new Ligacao(grafo.indexOf(ponto_origem), grafo.indexOf(ponto_destino), distancia, latitude, longitude);
            d.addEdge(l);
        } else {
            System.out.println("Nao existe este aeroporto, adicione-o");
        }
        for (DirectedEdge de : d.adj(grafo.indexOf(ponto_origem))) {
            System.out.println(grafo.nameOf(de.from()) + "->" + grafo.nameOf(de.to()) + " distancia: " + de.weight() + "km");
        }
        if (grafo.contains(ponto_origem)) {
            Ligacao l = new Ligacao(grafo.indexOf(ponto_destino), grafo.indexOf(ponto_origem), distancia, latitude, longitude);
            d.addEdge(l);
        } else {
            System.out.println("Nao existe este aeroporto, adicione-o");
        }
        for (DirectedEdge de : d.adj(grafo.indexOf(ponto_destino))) {
            System.out.println(grafo.nameOf(de.from()) + "->" + grafo.nameOf(de.to()) + " distancia: " + de.weight() + "km");
        }
    }

    public static void caminho_mais_direto(SymbolDigraph2 grafo, String altitude, String longitude, JTextArea textarea) {
        BreadthFirstDirectedPaths bfp = new BreadthFirstDirectedPaths(grafo.digraph(), grafo.indexOf(altitude));

        for (int i : bfp.pathTo(grafo.indexOf(longitude))) {
            textarea.append(grafo.nameOf(i) + "\n");
        }
    }
}
