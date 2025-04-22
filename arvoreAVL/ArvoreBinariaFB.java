import java.util.ArrayList;

public class ArvoreBinariaFB{
    public class Node{
        Node pai, filhoDireita, filhoEsquerda;
        int valor, FB;
        //Atributos

        public Node getPai(){
            return pai;
        }
        public void setPai(Node noPai){
            pai = noPai;
        }
        //Métodos
    }
    //The Node
    public Node root;
    //Root

    public ArvoreBinariaFB(){
        this.root = null;
    }
    //Construtor

    public Node theRoot(){
        return this.root;
    }

    //Métodos gerais 

    public void insert(int v, int fb){
        Node novo = new Node();
        novo.valor = v;
        novo.FB = fb;
        if (theRoot() == null){
            novo.filhoDireita = null;
            novo.filhoEsquerda = null;
            this.root = novo;
            novo.pai = null;
        }
        else{
            Node p = this.root;
            while(p != null){
                if (p.valor < v){
                    if (p.filhoDireita == null) break;
                     p = p.filhoDireita;
                }
                else{
                    if (p.filhoEsquerda == null) break;
                     p = p.filhoEsquerda;
                }
            }
            novo.setPai(p);
            if (p.valor > v) p.filhoEsquerda = novo;
            else p.filhoDireita = novo;

        }
    }

    public void remove(int v) throws EBinVazio{
        Node no = buscar(v);
        if (no == null){
            throw new EBinVazio("Não existe esse elemento");
        }
        else{
            if (isExternal(no)){ //Quando ele é um nó folha 
                if (no.pai.filhoDireita == no) no.pai.filhoDireita = null;
                else no.pai.filhoEsquerda = null;
            }
            else if ((no.filhoDireita == null && no.filhoEsquerda != null) || (no.filhoDireita != null && no.filhoEsquerda == null)){ //Só tem um filho
                Node mudar;
                if (no.filhoEsquerda != null) mudar = no.filhoEsquerda;
                else mudar = no.filhoDireita;
                if (no.pai.filhoDireita == no){
                    no.pai.filhoDireita = mudar;
                }
                else{
                    no.pai.filhoEsquerda = mudar;
                }
                mudar.pai = no.pai;
            }
            else{ //Se ele tiver dois filhos 
                Node p = no.filhoDireita;
                while (p.filhoEsquerda != null){
                    p = p.filhoEsquerda;
                }
                if (no.filhoDireita.filhoEsquerda == null){ //Tava dando erro no 4 (root) ligado ao 5 e euq uerendo retirar o 5
                    no.filhoDireita.pai = no;
                    no.filhoDireita = no.filhoDireita.filhoDireita;
                }
                else{
                    if (p.pai.filhoDireita == p) p.pai.filhoDireita = null;
                    else p.pai.filhoEsquerda = null;
                }
                no.valor = p.valor; 
            }
        }
    }

    public Node buscar(int no){
        Node p = this.root;
        while (p != null){
            if (p.valor == no) break;
            else{
                if (p.valor > no) p = p.filhoEsquerda;
                else p = p.filhoDireita;
            }
        }
        return p;
    }
}