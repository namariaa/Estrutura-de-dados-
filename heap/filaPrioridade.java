public class filaPrioridade{
    class Node{
        private int key;
        private Object value;
        private Node pai;
        private Node filhoEsquerdo;
        private Node filhoDireito;
        //Atributos 

        public filaPrioridade(){
            this.root = null;
            this.last = null;
        }
        //Construtor

        public Object getKey(){
            return key;
        }
        public void setKey(Object k){
            key = k;
        }
        public Object getValue(){
            return value;
        }
        public void setValue(Object v){
            value = v;
        }
        //Métodos
    }
    //Classe nó 
    private Node root, last; //Armazena o último nó 
    private int tamanho;

    public filaPrioridade(){
        this.root = null;
        this.last = null;
        this.tamanho = 0;
    }
    //Construtor classe filaPrioridade

    public void insert(Object key, Object value){
        Node no = new Node();
        no.key = key;
        no.value = value;
        no.filhoDireito = null;
        no.filhoEsquerdo = null;
        this.tamanho += 1;
        if (this.root == null){
            no.pai = null;
            this.root = no;
            this.last = no;
        }
        else{
            TheLast();
            this.last.filhoEsquerdo = no;
            no.pai = this.last;
            this.last = no;
            upHeap();
        }
    }

    public void upHeap(){
        Node pos = this.last;
        while (pos.pai.key > pos.key){
            Node antigo = pos.pai;
            pos.pai = pos;
            pos = antigo;
            pos = pos.pai;
        }
    }

    public void TheLast(){
        if (this.last.pai.filhoDireito != this.last){
            this.last = this.last.pai;
        }
        else{
            Node pos = this.last;
            while (pos.pai != this.root && pos.pai.filhoEsquerdo != pos){
                pos = pos.pai;
            }
            if (pos.pai.filhoEsquerdo == pos){
                pos = pos.pai.filhoDireito;
            }
            else{
                pos = pos.pai.filhoEsquerdo;
            }
            while (pos.filhoEsquerdo != null){
                pos = pos.filhoEsquerdo;
            }
            this.last = pos;
        }
    }

    public void removeMin() throws EFilaPrioridade {
        if (isEmpty()){
            throw new EFilaPrioridade("Não há elementos para retirar");
        }
        else{
            this.root = this.last;
            this.last 
        }
    }

    public Object min(){
        return this.root.getValue();
    } 

    public int size(){
        return this.tamanho;   
    }

    public boolean isEmpty(){
        return this.root == null;
    }
    //Métodos de fila de prioridade com heap

}