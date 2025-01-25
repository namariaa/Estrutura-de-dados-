public class filaPrioridade{
    class Node{
        private int key;
        private Object value;
        private Node pai;
        private Node filhoEsquerdo;
        private Node filhoDireito;
        //Atributos 

        
        public int getKey(){
            return key;
        }
        public void setKey(int k){
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

    public void insert(int key, Object value){
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
            TheLast(); //Retorna o pai antes do vazio
            if (this.last.filhoEsquerdo == null) {
                this.last.filhoEsquerdo = no;
        }
            else this.last.filhoDireito = no;
            no.pai = this.last;
            this.last = no;
            upHeap();
        }
        
    }

    public void upHeap(){
        Node pos = this.last;
        while (pos.pai.key > pos.key){
            Object valueantigo = pos.pai.value;
            int keyantiga = pos.pai.key;
            pos.pai.key = pos.key;
            pos.pai.value = pos.value;
            pos.key = keyantiga;
            pos.value = valueantigo;
        }
    }

    public void TheLast(){
        if (this.last.pai != null){ //Não pode ser o raiz 
            if (this.last.pai.filhoDireito != this.last) this.last = this.last.pai;
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
    }

    public void removeMin() throws EFilaVazia {
        if (isEmpty()){
            throw new EFilaVazia("Não há elementos para retirar");
        }
        else{
            this.root.key = this.last.key;
            this.root.value = this.last.value;
            if (this.last.pai.filhoEsquerdo == this.last.filhoEsquerdo){
                this.last.pai.filhoEsquerdo = null;
                this.last = this.last.pai;
            }
            else{
                this.last.pai.filhoDireito = null;
                this.last= this.last.pai.filhoEsquerdo;
            } 
            downHeap();
        }
    }
    
    public void downHeap(){
        Node pos = this.root;
        while (pos.filhoEsquerdo.key < pos.key || pos.filhoDireito.key < pos.key){
            if (pos.filhoEsquerdo.key < pos.filhoDireito.key){
                Object valueantigo = pos.value;
                int keyantigo = pos.key;
                pos.key = pos.filhoEsquerdo.key;
                pos.value = pos.filhoEsquerdo.value;
                pos.filhoEsquerdo.key = keyantigo ;
                pos.filhoEsquerdo.value = valueantigo;
            }
            else{
                Object valueantigo = pos.value;
                int keyantigo = pos.key;
                pos.key = pos.filhoDireito.key;
                pos.value = pos.filhoDireito.value;
                pos.filhoDireito.key = keyantigo;
                pos.filhoDireito.value = valueantigo;
            }
        }
    }

    public Object min() throws EFilaVazia{
        if (this.root != null) return this.root.getValue();
        else{
            throw new EFilaVazia("Não existe elemetos nessa heap");
        }
    } 

    public int size(){
        return this.tamanho;   
    }

    public boolean isEmpty(){
        return this.root == null;
    }
    //Métodos de fila de prioridade com heap

}