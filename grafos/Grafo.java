import java.util.ArrayList;

public class Grafo {
    public ArrayList<Verticie> verticies;
    public ArrayList<Aresta> arestas;
    private Basics insercoes;
    private Exibition exibir;
    private Search busca;
    private Utils utils;

    public Grafo(){
        this.verticies = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.insercoes = new Basics();
        this.exibir = new Exibition();
        this.busca = new Search();
        this.utils = new Utils();
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

    //Métodos simples utils
    public ArrayList<Verticie> finalVertex(Aresta e){
        return this.utils.finalVertices(e);
    }

    public Verticie opposite(Verticie v, Aresta e){
        return this.utils.oposto(v, e);
    }

    public void replaceVertex(Verticie v, String novoNom){
        this.utils.substituirVerticie(v, novoNom);
    }

    public void replaceEdge(Aresta a, int n){
        this.utils.substituirAresta(a, n);
    }

    public ArrayList<Aresta> incidentEdges(Verticie v){
        return this.utils.arestasIncidente(v);
    }

    public ArrayList<Aresta> Edges(Grafo g){
        return this.utils.Aresta(g);
    }

    public ArrayList<Verticie> Vertex(Grafo g){
        return this.utils.Verticie(g);
    }

    public boolean isDirected(Aresta e){
        return this.utils.eDirecionada(e);
    }
 
}
