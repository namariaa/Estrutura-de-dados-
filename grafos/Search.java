public class Search {
    public Verticie getVerticie(Grafo lista,String valor) throws EGrafo{
        for (Verticie v: lista.verticies){
            if (v.valor == valor) return v;
        }
        throw new EGrafo("Não existe esse véticie no grafo");
    }
}
