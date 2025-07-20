import java.util.ArrayList;

public class Basics {

    public Verticie inserirVerticie(String valor){
        return new Verticie(valor);
    }

    public void inserirAresta(int custo, Verticie v1, Verticie v2, Boolean direcionado){
        Aresta novo = new Aresta(custo, v1, v2, direcionado);
        v1.ligados.add(novo);
        v2.ligados.add(novo);  
    }

    public void removerAresta(Aresta a){ //Retiro o nó de quem se liga a ele
        a.v1.ligados.remove(a);
        a.v2.ligados.remove(a);
    }

    public void removerVerticie(Verticie verticie){
        ArrayList<Aresta> arestas = new ArrayList<>(verticie.ligados);
        for (Aresta a : arestas){
            a.v2.ligados.remove(a);
            a.v1.ligados.remove(a);
        }
    }

}
