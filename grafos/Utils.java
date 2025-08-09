import java.util.ArrayList;

public class Utils {
    //Retorna os dois vetices de uma aresta 
    public ArrayList<Verticie> finalVertices(Aresta e){
        ArrayList<Verticie> v = new ArrayList<>();
        v.add(e.v1);
        v.add(e.v2);
        return v;
    }

    //Retorno o outro verticie ligado a uma aresta 
    public Verticie oposto(Verticie v, Aresta e){
        if (e.v1 == v) return e.v2;
        else return e.v1;
    }

    //Muda o valor do verticie/aresta
    public void substituirVerticie(Verticie v, String novoNome){
        v.valor = novoNome;
    }

    public void substituirAresta(Aresta a, int n){
        a.valor = n;
    }

    //Retorna todas as arestas que se ligam a um verticie 
    public ArrayList<Aresta> arestasIncidente(Verticie v){
        ArrayList<Aresta> incidentes = new ArrayList<>();
        for (Aresta ligados : v.ligados){
            if (ligados.v1 == v){
                if (!ligados.direcionada) incidentes.add(ligados); // Pois fiz para v2 ser estar na ponta da seta quando é direcionado
            }
            else{
                incidentes.add(ligados);
            }
        }
        return incidentes;
    }

    //Retorna todos os vertecies/arestas de um grafo
    public ArrayList<Verticie> Verticie(Grafo g){
        return g.verticies;
    }

    public ArrayList<Aresta> Aresta(Grafo g){
        return g.arestas;
    }

    //Diz se a aresta é direcionada ou não
    public boolean eDirecionada(Aresta e){
        return e.direcionada;
    }
}
