import java.util.ArrayList;

public class Grafo {
    public ArrayList<Verticie> verticies;
    public ArrayList<Aresta> arestas;
    private Basics insercoes;
    private Exibition exibir;
    private Search busca;

    public Grafo(){
        this.verticies = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.insercoes = new Basics();
        this.exibir = new Exibition();
        this.busca = new Search();
    }

    //Métodos básicos
    public void insertVertex(String v){
        verticies.add(this.insercoes.inserirVerticie(v));
    }

    public void insertEdge(int valor, Verticie v1, Verticie v2, boolean direcionada){
        this.arestas.add(this.insercoes.inserirAresta(valor,v1,v2,direcionada));
    }

    public void removeVertex(Verticie v){
        this.insercoes.removerVerticie(v);
        this.verticies.remove(v);
    }

    public void removeEdge(Aresta a){
        this.insercoes.removerAresta(a);
    }

    //Métodos de busca 
    public Verticie getVerticie(Grafo lista, String valor){
        return this.busca.getVerticie(lista, valor);
    }

    //Métodos de exibição
    public void showAll(Grafo lista){
        this.exibir.showAll(lista);
    }
 
}
