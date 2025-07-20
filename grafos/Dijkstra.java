import java.util.ArrayList;

public class Dijkstra {
    //Vamos criar primeiro as hashs que são as matriz de custo, os custos e os pais 
    ArrayList<ArrayList<Integer>> matrizCusto = new ArrayList<>();
    ArrayList<ArrayList<Integer>> custoVerticies = new ArrayList<>();
    ArrayList<Integer> pais = new ArrayList<>();

    //Construtor que vai receber uma matriz
    public Dijkstra(ArrayList<ArrayList<Integer>> matrizCusto){
        this.matrizCusto = matrizCusto;
    }

    //Array que vai armazenar quais já foram processados 
    ArrayList<custoMomento> processados = new ArrayList<>();

    //Como não achei uma forma estou armazenando o menor custo do momento em uma classe
    private class custoMomento{
        int verticie1;
        int verticie2;
        int custo;

        custoMomento(int verticie, int verticie2, int custo){
            this.verticie1 = verticie;
            this.verticie2 = verticie2;
            this.custo = custo;
        }
    }

    //Função para achar qual o que tem menos custo em custo vai me retornar o valor do menor custo
    private custoMomento menorCusto(){
        int menor = -1000;
        custoMomento verticie = null;
        for (custoMomento custo : this.custoVerticies){
            if (custo.custo < menor && !processados.contains(custo)){
                menor = custo.custo;
                verticie = custo;
            }
        }
        return verticie;
    }

    //FUnção para atualizar vizinhos de um nó
    private void atualizarVizinhos(custoMomento no){
        if (no.verticie1)
    }

    //Vamos implementar o algoritmo realmente ;)
    // public void Dijkstra(){
    //     custoMomento no = menorCusto();
    //     while (no.custo != -1000){
    //         for (int i = 0; i < 8; i++){

    //         }
    //     }
    // }


}
