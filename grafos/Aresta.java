public class Aresta {
    int valor;
    Verticie v1;
    Verticie v2;
    boolean direcionada;

    public Aresta(int valor, Verticie v1, Verticie v2, boolean direcionada){
        this.valor = valor;
        this.v1 = v1;
        this.v2 = v2;
        this.direcionada = direcionada;
    }
}
