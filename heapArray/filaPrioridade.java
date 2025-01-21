import javafx.util.Pair;

class filaPrioridade{
    private Object [] lista;
    private int capacidade;
    private int tamanho;
    private int last;
    //Atributos 
    
    public filaPrioridade(int n){
        this.tamanho = 0;
        this.capacidade = n + 1;
        this.lista = new Pair<Interger, Object>[capacidade];
        this.last = 0;
    }
    public filaPrioridade(){
        this.tamanho = 0;
        this.capacidade = 8;
        this.lista = new Object[capacidade];
        this.last = 0;
    }
    //Construtor

    public void increase(){
        this.capacidade *= 2;
        Object [] listaAumentada = new Object[capacidade];
        for (int i = 0; i < this.tamanho; i++){
            listaAumentada[i] = this.lista[i];
        }
    }
    //Incremento do array

    public void insert(int key, Object value){
        Pair<Interger, Object> item = new Pair<Interger, Object>(); 
        if (this.last * 2 + 1 > capacidade) increase();
        item[0] = key;
        item[1] = value;
        this.last++;
        this.lista[last] = item;
        this.tamanho++;
        if (lista[last].get(0) < lista[last / 2].get(0)) upHeap();
    }

    public void upHeap(){
        int index = this.last;
        while (this.lista[index / 2].get(0) > this.lista[index].get(0)){
            int antigo = this.lista[index]; 
            this.lista[index] = this.lista[index / 2];
            this.lista[index / 2] = antigo;
            index /= 2;
        }
    }
    
    public void removeMin() throws EFilaPrioridade{
        this.lista[1] = this.lista[last];
        this.lista[last] = null;
        this.last --;
        this.tamanho--;
        if (this.lista.length > 1 && this.lista[1].get(0) > this.lista[2].get(0) || this.lista[1].get(0) > this.lista[3].get(0)) downHeap();
    }

    public void downHeap(){
        int index = 1;
        while (this.lista[index].get(0) > this.lista[index + 1].get(0) || this.lista[index].get(0) > this.lista[index + 2].get(0)) {
            if (this.lista[index + 1].get(0) < this.lista[index + 2].get(0)){
                int antigo = this.lista[index];
                this.lista[index] = this.lista[index + 1].get(0);
                this.lista[index + 1] = antigo; 
            }
            else{
                int antigo = this.lista[index];
                this.lista[index] = this.lista[index + 2].get(0);
                this.lista[index + 2] = antigo; 
            }
        }
    }


    public int size(){
        return this.lista.length;
    }

    public boolean isEmpty(){
        return this.lista.length == 0;
    }

    public int min() throws EFilaPrioridade{
        if (this.lista[1] != null) return this.lista[1];
        else{
            throw new EFilaPrioridade("Não existe nenhum elemento nesse array");
        }
    }

    //Métodos

}