public class Teste {
    public static void main(String [] args) {
        Grafo lista = new Grafo();
        lista.insertVertex("A");
        lista.insertVertex("B");
        lista.insertVertex("C");
        lista.insertVertex("D");
        Verticie v1 = lista.getVerticie(lista, "A");
        Verticie v2 = lista.getVerticie(lista, "C");
        Verticie v3 = lista.getVerticie(lista, "D");
        lista.insertEdge(45, v1, v2, false);
        lista.insertEdge(80, v1, v3, true);
        lista.removeVertex(v2);
        lista.showAll(lista);
    }
}
