import java.util.ArrayList;

public class Dijkstra {
    //Vamos criar primeiro as hashs que são as matriz de custo, os custos e os pais 
    ArrayList<ArrayList<Integer>> matrizCusto = new ArrayList<>();
    ArrayList<ArrayList<Integer>> custoVerticies = new ArrayList<>();
    ArrayList<ArrayList<posicao>> painhos = new ArrayList<>();

    //Construtor que vai receber uma matriz
    public Dijkstra(ArrayList<ArrayList<Integer>> matrizCusto){
        this.matrizCusto = matrizCusto;
        for (int i = 0; i < matrizCusto.size(); i++) {
            ArrayList<Integer> linha = new ArrayList<>();
            for (int j = 0; j < matrizCusto.get(0).size(); j++) {
                linha.add(1000);
            }
            custoVerticies.add(linha);
        }
        for (int i = 0; i <  matrizCusto.size(); i++) {
            ArrayList<custoMomento> linha = new ArrayList<>();
            for (int j = 0; j < matrizCusto.get(0).size(); j++) {
                linha.add(new custoMomento(false, 0));
            }
            processados.add(linha);
        }
        for (int i = 0; i <  matrizCusto.size(); i++) {
            ArrayList<posicao> linha = new ArrayList<>();
            for (int j = 0; j < matrizCusto.get(0).size(); j++) {
                linha.add(new posicao(-1, -1));
            }
            painhos.add(linha);
        }
    }

    //Array que vai armazenar quais já foram processados 
    ArrayList<ArrayList<custoMomento>> processados = new ArrayList<>();

    //Como não achei uma forma estou armazenando o menor custo do momento em uma classe
    private class custoMomento{
        boolean processado;
        int custo;

        custoMomento(boolean processado, int custo){
            this.processado = processado;
            this.custo = custo;
        }
    }

    //Só para ter o retorno para a função de menor custo 
    private class posicao{
        int v1;
        int v2;

        posicao(int v1, int v2){
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    //Função para achar qual o que tem menos custo em custo vai me retornar o valor do menor custo
    private posicao menorCusto(){
        int menor = 1000;
        posicao pos = null;
        for (ArrayList<Integer> c : this.custoVerticies){
            for (int custo : c){
                int indicie1 = this.custoVerticies.indexOf(c);
                int indicie2 = c.indexOf(custo);
                if (custo < menor && !processados.get(indicie1).get(indicie2).processado){
                    menor = custo;
                    pos = new posicao(indicie1,indicie2);
                }
            }
        }
        return pos;
    }

    //FUnção para atualizar vizinhos de um nó
    private void atualizarVizinhos(posicao no){
        int lenHorizontal = this.matrizCusto.get(0).size();
        int lenVertical = this.matrizCusto.size();
        int novoCusto = this.custoVerticies.get(no.v1).get(no.v2) + 1;
        if (this.custoVerticies.get(no.v1).get(no.v2) == 1000) novoCusto = 1;
        if(no.v2 + 1 < lenHorizontal){
            if (this.matrizCusto.get(no.v1).get(no.v2 + 1) == 0 || this.matrizCusto.get(no.v1).get(no.v2 + 1) == 3){
                int atual = this.custoVerticies.get(no.v1).get(no.v2 + 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1).set(no.v2 + 1, novoCusto);
                    this.painhos.get(no.v1).set(no.v2 + 1, new posicao(no.v1, no.v2));
                }
            }
        }
        if(no.v2 -1 >= 0){
            if (this.matrizCusto.get(no.v1).get(no.v2 - 1) == 0 || this.matrizCusto.get(no.v1).get(no.v2 - 1) == 3){
                int atual = this.custoVerticies.get(no.v1).get(no.v2 - 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1).set(no.v2 - 1, novoCusto);
                    this.painhos.get(no.v1).set(no.v2 - 1, new posicao(no.v1, no.v2));
                }
            }
        }
        if(no.v1 + 1 < lenVertical){
            if (this.matrizCusto.get(no.v1 + 1).get(no.v2) == 0 || this.matrizCusto.get(no.v1 + 1).get(no.v2) == 3){
                int atual = this.custoVerticies.get(no.v1 + 1).get(no.v2);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1 + 1).set(no.v2, novoCusto);
                    this.painhos.get(no.v1 + 1).set(no.v2, new posicao(no.v1, no.v2));
                }
            }
        }
        if(no.v1 - 1 >= 0){
            if (this.matrizCusto.get(no.v1 - 1).get(no.v2) == 0 || this.matrizCusto.get(no.v1 - 1).get(no.v2) == 3){
                int atual = this.custoVerticies.get(no.v1 - 1).get(no.v2);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1 - 1).set(no.v2, novoCusto);
                    this.painhos.get(no.v1 - 1).set(no.v2, new posicao(no.v1, no.v2));
                }
            }
        }
        if(no.v1 - 1 > 0 && no.v2 + 1 < lenHorizontal){
            if (this.matrizCusto.get(no.v1 - 1).get(no.v2 + 1) == 0 || this.matrizCusto.get(no.v1 - 1).get(no.v2 + 1) == 3){
                int atual = this.custoVerticies.get(no.v1 - 1).get(no.v2 + 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1 - 1).set(no.v2 + 1, novoCusto);
                    this.painhos.get(no.v1 -1).set(no.v2 + 1, new posicao(no.v1, no.v2));
                }
            }
        }
        if(no.v1 - 1 >= 0 && no.v2 - 1 >= 0){
            if (this.matrizCusto.get(no.v1 - 1).get(no.v2 - 1) == 0 || this.matrizCusto.get(no.v1 - 1).get(no.v2 - 1) == 3){
                int atual = this.custoVerticies.get(no.v1 - 1).get(no.v2 - 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1 - 1).set(no.v2 - 1, novoCusto);
                    this.painhos.get(no.v1 - 1).set(no.v2 - 1, new posicao(no.v1, no.v2));
                }
            }
        }
        if(no.v1 + 1 < lenVertical && no.v2 + 1 < lenHorizontal){
            if (this.matrizCusto.get(no.v1 + 1).get(no.v2 + 1) == 0 || this.matrizCusto.get(no.v1 + 1).get(no.v2 + 1) == 3){
                int atual = this.custoVerticies.get(no.v1 + 1).get(no.v2 + 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1 + 1).set(no.v2 + 1, novoCusto);
                    this.painhos.get(no.v1 + 1).set(no.v2 + 1, new posicao(no.v1, no.v2));
                }
            }
        }
        if(no.v1 + 1 < lenVertical && no.v2 - 1 >= 0){
            if (this.matrizCusto.get(no.v1 + 1).get(no.v2 - 1) == 0 || this.matrizCusto.get(no.v1 + 1).get(no.v2 - 1) == 3){
                int atual = this.custoVerticies.get(no.v1 + 1).get(no.v2 - 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custoVerticies.get(no.v1 + 1).set(no.v2 - 1, novoCusto);
                    this.painhos.get(no.v1 + 1).set(no.v2 - 1, new posicao(no.v1, no.v2));
                }
            }
        }
    }

    //Achar ponto inicial 
    public posicao pontoInicial(){
        posicao p = null;
        for (int i = 0; i < this.matrizCusto.size(); i++){
            for (int j = 0; j < this.matrizCusto.get(i).size(); j++){
                if (this.matrizCusto.get(i).get(j) == 2) p = new posicao(i,j);
            }
        }
        return p;
    }

    //Vamos implementar o algoritmo realmente ;)
    public void dijkstra(){
        posicao no = pontoInicial();
        while (no != null){
            atualizarVizinhos(no);
            custoMomento novo = new custoMomento(true, this.matrizCusto.get(no.v1).get(no.v2));
            processados.get(no.v1).set(no.v2, novo);
            no = menorCusto();
        }
    }

    //Só para ver se deu bom 
    public void exibir(){
        for (int i = 0; i < custoVerticies.size(); i++) {
            for (int j = 0; j < custoVerticies.get(0).size(); j++) {
                System.out.print(custoVerticies.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    //A partir dos pais vou pegando o menor caminho 

}
