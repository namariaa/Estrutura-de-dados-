package estrela;

import java.util.ArrayList;

public class Estrela {
    public class Posicao{
        int x;
        int y;
        public Posicao(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    ArrayList<ArrayList<Integer>> original = new ArrayList<>();
    ArrayList<ArrayList<Boolean>> visitados = new ArrayList<>();
    ArrayList<ArrayList<Integer>> custos = new ArrayList<>();

    public Estrela(ArrayList<ArrayList<Integer>> original){
        this.original = original;
        
        for (int i = 0; i < original.size(); i++) {
            ArrayList<Integer> linha = new ArrayList<>();
            for (int j = 0; j < original.get(0).size(); j++) {
                linha.add(1000);
            }
            custos.add(linha);
        }
        for (int i = 0; i <  original.size(); i++) {
            ArrayList<Boolean> linha = new ArrayList<>();
            for (int j = 0; j < original.get(0).size(); j++) {
                linha.add(false);
            }
            visitados.add(linha);
        }
    }


}
