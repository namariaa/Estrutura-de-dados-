class filaPrioridade{
    private int [][] lista;
    private int capacidade;
    private int tamanho;
    private int last;
    //Atributos 
    
    public filaPrioridade(int n){
        this.tamanho = 0;
        this.capacidade = n + 1;
        this.lista = new int[capacidade][2];
        this.last = 0;
    }
    public filaPrioridade(){
        this.tamanho = 0;
        this.capacidade = 8;
        this.lista = new int[capacidade][2];
        this.last = 0;
    }
    //Construtor

    public void increase(){
        this.capacidade *= 2;
        int [][] listaAumentada = new int[this.capacidade][2];
        for (int i = 0; i < this.tamanho; i++){
            listaAumentada[i] = this.lista[i];
        }
        lista = listaAumentada;
    }
    //Incremento do array

    public void insert(int key, int value){
        int [] item = new int[2]; 
        if (this.last + 1 >= capacidade) increase();
        item[0] = key;
        item[1] = value;
        this.last++;
        this.lista[last] = item;
        this.tamanho++;
        if (lista[last][0] < lista[last / 2][0]) upHeap();
    }

    public void upHeap(){
        int index = this.last;
        while (this.lista[index / 2][0] > this.lista[index][0]){
            int [] antigo = this.lista[index]; 
            this.lista[index] = this.lista[index / 2];
            this.lista[index / 2] = antigo;
            index /= 2;
        }
    }
    
    public void removeMin() throws EFilaPrioridade{
        if (!isEmpty()){
            this.lista[1] = this.lista[last];
            this.lista[last] = null;
            this.last --;
            this.tamanho--;
            if (this.lista.length > 1 && this.lista[1][0] > this.lista[2][0] || this.lista[1][0] > this.lista[3][0]) downHeap();
        }
        else{
            throw new EFilaPrioridade("Não existe nenhum elemento nesse array");
        }
    }

    public void downHeap(){
        int index = 1;
        while (index * 2 < this.last){
            if (index * 2 + 1 <= this.last){
                if (this.lista[index][0] > this.lista[index * 2][0] || this.lista[index][0] > this.lista[index * 2 + 1][0]){
                    if (this.lista[index * 2][0] < this.lista[index * 2 + 1][0]){
                        int [] antigo = lista[index * 2];
                        lista[index * 2] = lista[index];
                        lista[index] = antigo;
                        index *= 2;
                    }
                    else{
                        int [] antigo = lista[index * 2 + 1];
                        lista[index * 2 + 1] = lista[index];
                        lista[index] = antigo;
                        index *= 2 + 1;
                    }
                }
            }
            else{
                if (index * 2 <= last){
                    if (this.lista[index][0] > this.lista[index * 2][0]){
                        int [] antigo = lista[index * 2];
                        lista[index * 2] = lista[index];
                        lista[index] = antigo;
                        index *= 2;
                    }
                }
                else break;
            }
        }
    }


    public int size(){
        return this.tamanho; 
    }

    public boolean isEmpty(){
        return this.lista.length == 0;
    }

    public int min() throws EFilaPrioridade{
        if (this.lista[1] != null) return this.lista[1][1];
        else{
            throw new EFilaPrioridade("Não existe nenhum elemento nesse array");
        }
    }

    //Métodos

}