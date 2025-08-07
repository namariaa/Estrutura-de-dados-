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
    ArrayList<ArrayList<Posicao>> painhos = new ArrayList<>();

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
          for (int i = 0; i <  custos.size(); i++) {
            ArrayList<Posicao> linha = new ArrayList<>();
            for (int j = 0; j < custos.get(0).size(); j++) {
                linha.add(new Posicao(-1, -1));
            }
            painhos.add(linha);
        }
    }

    private void atualizarVizinhos(Posicao no){
        int lenHorizontal = this.original.get(0).size();
        int lenVertical = this.original.size();
        int novoCusto = this.custos.get(no.x).get(no.y) + formulinha(no, 1);
        if (this.custos.get(no.x).get(no.y) == 1000) novoCusto = formulinha(no, 1);
        if(no.y + 1 < lenHorizontal){
            if (this.original.get(no.x).get(no.y + 1) == 0 || this.original.get(no.x).get(no.y + 1) == 3){
                int atual = this.custos.get(no.x).get(no.y + 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x).set(no.y + 1, novoCusto);
                    this.painhos.get(no.x).set(no.y + 1, new Posicao(no.x, no.y));
                }
            }
        }
        if(no.y -1 >= 0){
            if (this.original.get(no.x).get(no.y - 1) == 0 || this.original.get(no.x).get(no.y - 1) == 3){
                int atual = this.custos.get(no.x).get(no.y - 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x).set(no.y - 1, novoCusto);
                    this.painhos.get(no.x).set(no.y - 1, new Posicao(no.x, no.y));
                }
            }
        }
        if(no.x + 1 < lenVertical){
            if (this.original.get(no.x + 1).get(no.y) == 0 || this.original.get(no.x + 1).get(no.y) == 3){
                int atual = this.custos.get(no.x + 1).get(no.y);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x + 1).set(no.y, novoCusto);
                    this.painhos.get(no.x + 1).set(no.y, new Posicao(no.x, no.y));
                }
            }
        }
        if(no.x - 1 >= 0){
            if (this.original.get(no.x - 1).get(no.y) == 0 || this.original.get(no.x - 1).get(no.y) == 3){
                int atual = this.custos.get(no.x - 1).get(no.y);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x - 1).set(no.y, novoCusto);
                    this.painhos.get(no.x - 1).set(no.y, new Posicao(no.x, no.y));
                }
            }
        }
        if(no.x - 1 > 0 && no.y + 1 < lenHorizontal){
            if (this.original.get(no.x - 1).get(no.y + 1) == 0 || this.original.get(no.x - 1).get(no.y + 1) == 3){
                int atual = this.custos.get(no.x - 1).get(no.y + 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x - 1).set(no.y + 1, novoCusto);
                    this.painhos.get(no.x -1).set(no.y + 1, new Posicao(no.x, no.y));
                }
            }
        }
        if(no.x - 1 >= 0 && no.y - 1 >= 0){
            if (this.original.get(no.x - 1).get(no.y - 1) == 0 || this.original.get(no.x - 1).get(no.y - 1) == 3){
                int atual = this.custos.get(no.x - 1).get(no.y - 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x - 1).set(no.y - 1, novoCusto);
                    this.painhos.get(no.x - 1).set(no.y - 1, new Posicao(no.x, no.y));
                }
            }
        }
        if(no.x + 1 < lenVertical && no.y + 1 < lenHorizontal){
            if (this.original.get(no.x + 1).get(no.y + 1) == 0 || this.original.get(no.x + 1).get(no.y + 1) == 3){
                int atual = this.custos.get(no.x + 1).get(no.y + 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x + 1).set(no.y + 1, novoCusto);
                    this.painhos.get(no.x + 1).set(no.y + 1, new Posicao(no.x, no.y));
                }
            }
        }
        if(no.x + 1 < lenVertical && no.y - 1 >= 0){
            if (this.original.get(no.x + 1).get(no.y - 1) == 0 || this.original.get(no.x + 1).get(no.y - 1) == 3){
                int atual = this.custos.get(no.x + 1).get(no.y - 1);
                if (atual == 1000  || novoCusto < atual){
                    this.custos.get(no.x + 1).set(no.y - 1, novoCusto);
                    this.painhos.get(no.x + 1).set(no.y - 1, new Posicao(no.x, no.y));
                }
            }
        }
    }

    //Quem realmente vai ser chamado
    public void AEstrela(){
        Posicao noAtual = pontoInicial();
        while (noAtual != null){
            System.out.println(noAtual.x);
            atualizarVizinhos(noAtual);
            visitados.get(noAtual.x).set(noAtual.y, true);
            noAtual = menorCusto(); 
        }
    }

    //Utilitários
    public Posicao pontoInicial(){
        Posicao p = null;
        for (int i = 0; i < this.original.size(); i++){
            for (int j = 0; j < this.original.get(i).size(); j++){
                if (this.original.get(i).get(j) == 2) p = new Posicao(i,j);
            }
        }
        return p;
    }

    public Posicao pontoFinal(){
        Posicao p = null;
        for (int i = 0; i < this.original.size(); i++){
            for (int j = 0; j < this.original.get(i).size(); j++){
                if (this.original.get(i).get(j) == 3){
                    p = new Posicao(i,j);
                    return p;
                } 
            }
        }
        return p;
    }

    public int heuristica(Posicao pAtual){
        Posicao pFinal = pontoFinal();
        //Usando mahatan 
        return Math.abs(pAtual.x - pFinal.x) + Math.abs(pAtual.y - pFinal.y);
    }

    public int formulinha(Posicao pAtual, int custo){
        return heuristica(pAtual) + custo;
    }

    private Posicao menorCusto(){
        int menor = 1000;
        Posicao pos = null;
        for (ArrayList<Integer> c : this.custos){
            for (int custo : c){
                int indicie1 = this.custos.indexOf(c);
                int indicie2 = c.indexOf(custo);
                if (custo < menor && !visitados.get(indicie1).get(indicie2)){
                    menor = custo;
                    pos = new Posicao(indicie1,indicie2);
                }
            }
        }
        return pos;
    }

    public void exibir(){
        for (int i = 0; i < custos.size(); i++) {
            for (int j = 0; j < custos.get(0).size(); j++) {
                System.out.print(custos.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
