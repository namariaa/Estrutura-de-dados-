public class filaPrioridade{
    class Node{
        private Object key;
        private Object value;
        //Atributos 

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

    public filaPrioridade(){
        this.root = null;
        this.last = null;
    }
    //Construtor classe filaPrioridade

    public void insert(Object key, Object value){}

    public void removeMin(){}

    public Object min(){
        return this.root.getValue();
    } 

    public int size(){}

    public boolean isEmpty(){
        return last == null;
    }
    //Métodos de fila de prioridade com heap

}