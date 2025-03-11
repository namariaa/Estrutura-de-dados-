import java.util.ArrayList;

public class ArvoreBinaria{
    public class Node{
        Node pai, filhoDireita, filhoEsquerda;
        int valor, tamanho;
        //Atributos

        public Node getPai(){
            return pai;
        }
        public void setPai(Node noPai){
            pai = noPai;
        }
        public Node getFilhoE(){
            return filhoEsquerda;
        }
        public void setFilhoE(Node noE){
            filhoEsquerda = noE;
        }
        public Node getFilhoD(){
            return filhoDireita;
        }
        public void setFilhoD(Node noD){
            filhoDireita = noD;
        }
        public boolean temFilhoD(){
            return filhoDireita != null;
        }
        public boolean temFilhoE(){
            return filhoEsquerda != null;
        }
        //Métodos
    }
    //The Node
    public Node root;
    //Root

    public ArvoreBinaria(){
        this.root = null;
    }
    //Construtor

    // public int size(){ //Quantidade de nós
    //     return this.tamanho;
    // }
    /*public int tamanho(Node no){
        if (isExternal(no)) return 1;
        else{
            int cont = 0;
            if (no.filhoEsquerda != null) cont += 1 + tamanho(no.filhoEsquerda);
            else if (no.filhoDireita != null){System.out.println(no.valor + " " + no.filhoDireita.valor); cont += 1 + tamanho(no.filhoDireita);}
            return cont;
        }
    }*/

    public boolean isExternal(Node no){
        return (no.filhoDireita == null && no.filhoEsquerda == null);
    }

    public boolean isInternal(Node no){
        return (no.filhoDireita != null || no.filhoEsquerda != null);
    }

    public int depth(Node no){
        if (no == theRoot()) return 0;
        else return 1 + depth(no.getPai());
    }

    public int height(Node no){
        if (isExternal(no)) return 0;
        else{
            int cont = 0;
            if (no.filhoDireita == null) cont += Math.max(cont, height(no.filhoEsquerda));
            else if (no.filhoEsquerda == null) cont += Math.max(cont, height(no.filhoDireita));
            else cont += Math.max(cont, (Math.max(height(no.filhoDireita), height(no.filhoEsquerda))));
            return 1 + cont;
        }
    }
    
    public void imprimePre(Node no){
        if (no != null){
            System.out.println(no.valor);
            imprimePre(no.filhoEsquerda);
            imprimePre(no.filhoDireita);
        }
    }

    public void imprimeOrdem(Node no){
        if (no != null){
            imprimeOrdem(no.filhoEsquerda);
            System.out.println(no.valor);
            imprimeOrdem(no.filhoDireita);
        }
    }

    public void imprimePos(Node no){
        if (no != null){
            imprimePos(no.filhoEsquerda);
            imprimePos(no.filhoDireita);
            System.out.println(no.valor);
        }
    }

    public Node theRoot(){
        return this.root;
    }

    //Métodos gerais 

    public void insert(int v){
        Node novo = new Node();
        novo.valor = v;
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


    //Inserção, deleção e alteração
    public void inverter(Node no1, Node no2){
        if (no1 != null && no2 != null){
            int salvar = no1.valor;
            no1.valor = no2.valor; 
            no2.valor = salvar;
            inverter(no1.filhoDireita,no2.filhoEsquerda);
            inverter(no1.filhoEsquerda, no2.filhoDireita);
        }
        /*
         *    6
         *  4     8
         * 1 5   7  9
         * 2
         */
        /*
         *    6
         *  8     4
         * 9 7   5  1
         * 2
         */
    }
    //Algoritmos especiais 
}