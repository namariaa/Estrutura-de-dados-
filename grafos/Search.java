import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Search {
    private class Node{
        Verticie verticie;
        boolean visitado;
        int grau;

        public Node(Verticie v, boolean e, int g){
            this.verticie = v;
            this.visitado = e;
            this.grau = g;
        }
    }

    public Verticie getVerticie(Grafo lista,String valor) throws EGrafo{
        for (Verticie v: lista.verticies){
            if (v.valor == valor) return v;
        }
        throw new EGrafo("Não existe esse véticie no grafo");
    }

    public boolean contain(Deque<Node> f, Verticie v){
        for (Node n : f){
            if (n.verticie == v) return true;
        }
        return false;
    }

    public void BFS(Verticie verticieIncial){
        Deque<Node> fila = new ArrayDeque<>(); 
        fila.add(new Node(verticieIncial, false, 1));
        Deque<Node> visitados = new ArrayDeque<>(); 
        int when = 0;
        while (fila.size() > 0){
            Node atual = fila.removeFirst();
            for (Aresta e : atual.verticie.ligados){  //Salvar adjacentes no fim da lista
                Verticie adjacente;
                if (e.v1 == atual.verticie) adjacente = e.v2;
                else adjacente = e.v1;
                if (!contain(fila, adjacente) && !contain(visitados, adjacente)) fila.addLast(new Node(adjacente, false, 1));
            }
            atual.visitado = true;
            atual.grau = when;
            System.out.println(atual);
            when+= 1;
            visitados.add(atual);
        }
    }

    public boolean containInDFS(ArrayList<Node> f, Verticie v){
        for (Node n : f){
            if (n.verticie == v) return true;
        }
        return false;
    }
    
    ArrayList<Node> visitados = new ArrayList<>(); 
    public void DFS(Verticie verticieIncial){
        int when = 1;
        Node atual = new Node(verticieIncial, false, when);
        for (Aresta e: atual.verticie.ligados){
            if (e.v1 == atual.verticie) {
                if (!containInDFS(visitados, e.v2)) recDFS(new Node(e.v2, false, when), when);
            }
            else{
                if (!containInDFS(visitados, e.v1)) recDFS(new Node(e.v1, false, when), when);
            }
            when+= 1;
        }
    }

    private void recDFS(Node verticie, int when){
        for (Aresta e : verticie.verticie.ligados){
            if (e.v1 == verticie.verticie) {
                if (!containInDFS(visitados, e.v2)) recDFS(new Node(e.v2, false, when), when + 1);
            }
            else{
                if (!containInDFS(visitados, e.v1)) recDFS(new Node(e.v1, false, when), when + 1);
            }
        }
        verticie.visitado = true;
        verticie.grau = when;
        visitados.add(verticie);
    }
}
