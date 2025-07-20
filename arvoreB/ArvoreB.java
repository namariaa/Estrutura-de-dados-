import java.util.Arrays;
import java.util.ArrayList;

public class ArvoreB {
    public class Node {
        ArrayList<Integer> chaves;
        ArrayList<Node> filhos;
        Node pai;
    }

    Node root;
    int ordem;

    public ArvoreB(int ordem) {
        this.ordem = ordem;
        this.root = null;
    }

    public void Insert(int valor){
        if (this.root == null){
            Node novo = new Node();
            novo.pai = null;
            ArrayList<Integer> c = new ArrayList<Integer>(2 * this.ordem - 1);
            ArrayList<Node> f = new ArrayList<Node>(2 * this.ordem);
            novo.filhos = f;
            novo.chaves = c;
            novo.chaves.add(valor);
            this.root = novo;
        }
        else{
            if (this.root.chaves.size() < (2 * this.ordem - 1) && this.root.filhos.size() == 0){ //Se ainda tiver espaço no root e ele não tiver filhos
                this.root.chaves.add(valor);
                this.root.chaves.sort(null);
            }
            else{
                Node last = Busca(valor);
                if (last.chaves.size() == (2 * this.ordem - 1)){ 
                    cisao(last);
                    last = Busca(valor);
                    // System.out.println(last.chaves + " " + valor);
                }
                last.chaves.add(valor);
                last.chaves.sort(null);
            }
        }
    }

    public Node cisao(Node no){
        Node esquerda = new Node();
        ArrayList<Integer> c = new ArrayList<Integer>(2 * this.ordem - 1);
        ArrayList<Node> f = new ArrayList<Node>(2 * this.ordem);
        ArrayList<Integer> c2 = new ArrayList<Integer>(2 * this.ordem - 1);
        ArrayList<Node> f2 = new ArrayList<Node>(2 * this.ordem);
        Node direita = new Node();
        esquerda.filhos = f;
        esquerda.chaves = c;
        direita.filhos = f2;
        direita.chaves = c2;
        for (int i = 0; i < no.chaves.size() / 2; i++){
            esquerda.chaves.add(no.chaves.get(i));
            if (no.filhos.size() > i) esquerda.filhos.add(no.filhos.get(i));
        }
        for (int i = no.chaves.size() / 2 + 1; i < no.chaves.size(); i++){
            direita.chaves.add(no.chaves.get(i));
            if (no.filhos.size() > i) direita.filhos.add(no.filhos.get(i));
        }
        if (no.pai != null){
            int meio = no.chaves.get(no.chaves.size() / 2);
            Node pai = no.pai;
            if (no.pai.chaves.size() >= 2 * this.ordem - 1){
                pai =  cisao(no.pai); //Caso não possa inserir mais faço cisão recursivamente
            }
            pai.chaves.add(meio); // Salvo no final o do meio
            esquerda.pai = pai;
            direita.pai = pai;
            int index = pai.filhos.indexOf(no);
            pai.filhos.remove(no);
            pai.filhos.add(index, esquerda);
            pai.filhos.add(index + 1, direita);
            pai.chaves.sort(null); //Pois caso eu insira uma chave encima tenho que ordenar de novo
            no = esquerda;
            return no;
        }
        else{
            Node pai = new Node();
            ArrayList<Integer> ch = new ArrayList<Integer>(2 * this.ordem - 1);
            ArrayList<Node> fi = new ArrayList<Node>(2 * this.ordem);
            pai.filhos = fi;
            pai.chaves = ch;
            pai.chaves.add(no.chaves.get(no.chaves.size() / 2));
            esquerda.pai = pai;
            direita.pai = pai;
            no = esquerda;
            pai.filhos.add(esquerda);
            pai.filhos.add(direita);
            this.root = pai;
            return no;
        }
    }

    public Node Busca(int valor) throws EBVazio{
        Node r = this.root;
        while (r != null) {
            for (int i = 0; i < r.chaves.size(); i++){
                if (r.chaves.get(i) == valor)
                return r;
                else if (r.chaves.get(i) > valor){
                    if (r.filhos.get(i) != null){
                        r = r.filhos.get(i);
                        break;
                    }
                    else{
                        // throw new EBVazio("Não existe esse valor");
                        return r;
                    }
                }
                else{
                    if (i + 1 >= r.chaves.size()){ //Se não tiver mais elementos
                        if (r.filhos.size() >= i + 1){
                            r = r.filhos.get(i + 1);
                            break;
                        }
                        else{
                            // throw new EBVazio("Não existe esse valor");
                            return r;
                        }
                    }
                    else{
                        continue;
                    }
                }
            }
            if (r.filhos.size() == 0){
                return r;
            }
        }
        throw new EBVazio("Não existe esse valor");
    }
}