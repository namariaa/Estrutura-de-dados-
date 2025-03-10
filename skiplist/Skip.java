package skiplist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Skip {
    public class QuadNode{
        private int value;
        private QuadNode left;
        private QuadNode right;
        private QuadNode down;
        private QuadNode up;
    }
    private QuadNode first;
    private QuadNode last;
    private int tamanho;
    //Atributos e nó

    public Skip(int n){
        this.tamanho = 0;
        this.first = null;
        this.last = null;
    }
    //Construtor 

    public int random(){
        double random = Math.random();
        int cont = 0;
        while ((int) random != 1){
            cont++;
            random = Math.random();
            if (random > 0.5) random = 1;
            else random = 0;
            System.out.println(random);
        }
        System.out.println("count: " + cont);
        return cont;
    }

    public QuadNode acharPos(int value){
        QuadNode no = this.first;
        //QuadNode noPai = this.first; //Guarda o primeiro nó da coluna para caso seja o root eu saber
        while (no != null){
            // System.out.println(no.value);
            if (no.right != null){
                if (no.right.value < value){
                    no = no.right;
                    //noPai = no.right;
                    continue;
                } 
                if (no.left != null){ //Se o root é o antecessor 
                    if (no.right.value >= value && no.left == this.first) break; // 25 exemplo
                }
            }
            if (no.left != null){
                if (no.left.value > value){
                    no = no.left;
                    //noPai = no.left;
                    continue;
                } 
                if (no.right != null){ //Se o last é o sucessor 
                    if (no.left.value <= value && no.right == this.last) break;
                }
            }
            if (no.left != null && no.right != null){
                if (no.left.value <= value && no.right.value >= value) break;
            }
            if (no.left != null && no.right == null && no.down == null){ // É o ultimo npó do last 
                if (no.left.value <= value) break; 
            }
            if (no.left == null && no.right != null && no.down == null){ // É o primeiro nó do first 
                if (no.right.value >= value) break;
            }
            if (no.down == null) break; //Caso só tenha o root e é o segundo elemento que eu vou inserir
            if (no.left == null && no.right == null) no = no.down; // or por causa do 40
            if (no.left != null && no.right == null){
                if (no.left.value <= value) no = no.down;
            }
            if (no.right != null && no.left == null){
                if (no.right.value >= value) no = no.down;
            }
        }
        return no;
    }

    public void insert(int value){
        this.tamanho++;
        int tamanhoColuna = random();
        QuadNode no = new QuadNode();
        no.value = value;
        no.left = null;
        no.right = null;
        no.down = null;
        no.up = null;
        System.out.println("Valor: " + no.value + " tamanho clonua: " + tamanhoColuna);
        for (int i = 0; i < tamanhoColuna; i++){ //Cria a coluna 
            QuadNode coluna = new QuadNode();
            coluna.value = value;
            coluna.down = no;
            coluna.left = null;
            coluna.right = null;
            coluna.up = null;
            no.up = coluna;
            no = new QuadNode();
            no = coluna;
        }
        if (this.first == null){ //Quer dizer que o root
            this.first = no;
            this.last = no;
        }
        else{
            QuadNode antecessor = new QuadNode();
            antecessor = acharPos(value); //Acha o nó antecessor ao que eu tenho que inserir
            System.out.println("antecessor: " + antecessor.value); 
            while (antecessor.down != null){ //Para ter certeza que começo do primeiro da coluna para fazer as referencias certas
                antecessor = antecessor.down;
            }
            QuadNode noP =  new QuadNode();
            noP = no;
            while (noP.down != null){ //Para ter certeza que começo do primeiro da coluna para fazer as referencias certas
                noP = noP.down;
            }
            if (this.first.value < noP.value){ //Quer dizer que ele não vai substituir o root
                if (noP.up == null || antecessor.up == null){ // Se só tiver um elemento na coluna
                    noP.right = antecessor;
                    noP.left = null;
                    antecessor.left = noP;
                }
                else{
                    while (noP.up != null && antecessor.up != null ){ //Fazer todas as referencias 
                        noP.left = antecessor;
                        noP.right = antecessor.right;
                        antecessor.right = noP;
                        if (noP.up != null && antecessor.up != null){
                            noP = noP.up;
                            antecessor = antecessor.up;
                        }
                        else break;
                    }
                }
                if (antecessor == this.last) this.last = noP;
            }
            else{
                if (noP.up == null || antecessor.up == null){ // Se só tiver um elemento na coluna
                    noP.right = antecessor;
                    noP.left = null;
                    antecessor.left = noP;
                }
                else{
                    while (noP.up != null && antecessor.up != null){ //Fazer todas as referencias 
                        noP.right = antecessor;
                        noP.left = null;
                        antecessor.left = noP;
                       if (noP.up != null && antecessor.up != null){
                           noP = noP.up;
                           antecessor = antecessor.up;
                       }
                       else break;
                    }
                }
                if (antecessor == this.first) this.first = noP;
            }
        }

    }

    public int size(){
        return this.tamanho;
    }
}

