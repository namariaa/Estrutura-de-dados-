import java.util.ArrayList;

public class ArvoreGenerica{
    private class Node{
        Object valor;
        Node pai;
        ArrayList<Node> filhos;

        public Node getPai(){
            return pai;
        }
        public void setPai(Node p){
            pai = p;
        }
    }
    private Node root;
    private int q_nos;
    //O Nó

    public ArvoreGenerica(){
        this.root = null;
        this.q_nos = 0;
    }
    //Construtor

    public int Size(){
        return q_nos;
    }
    public int height(Node no){
        if (isExternal(no)) return 0;
        else{
            int contador = 0;
            for (Node filhote:no.filhos){
                contador = Math.max(contador,height(filhote));
            }
            return 1 + contador;
        }
    }
    public int depth(Node no){
        if (no == this.root) 
            return 0;
        else
            return 1 + depth(no.pai);
    }

    public boolean isExternal(Node no){
        return no.filhos.size() == 0;
    }
    //Métodos genéricos - //O nó que vai ser o pai 
    public void insert(Object pai, Object valor){
        Node no = busca(pai,this.root);
        this.q_nos++;
        Node novo = new Node();
        novo.valor = valor;
        novo.pai = no;
        novo.filhos = new ArrayList<>();
        no.filhos.add(no.filhos.size(),novo);
    }
    public void insertRoot(Object valor){
        this.q_nos++;
        Node novo = new Node();
        novo.valor = valor;
        novo.pai = null;
        novo.filhos = new ArrayList<>();
        novo.filhos.add(this.root);
        this.root.pai = novo;
        this.root = novo;
    }

    public Node busca(Object valor, Node no){
         if (no.valor == valor) return no;
         else{
             for (Node filhote:no.filhos){
                 return busca(valor,filhote);
             }
         }
    }
    //Métodos de alteração 
}