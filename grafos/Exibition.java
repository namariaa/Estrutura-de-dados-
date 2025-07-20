public class Exibition {
    public void showAll(Grafo lista){
        for (Verticie v: lista.verticies){
            if (v.ligados.size() > 0){
                for (Aresta a: v.ligados){
                    if (a.direcionada && a.v1 == v){
                        System.out.println(v.valor + " -> " + a.v2.valor);
                    }
                    else if (a.direcionada && a.v1 != v){
                        System.out.println(v.valor + " <- " + a.v1.valor);
                    }
                    else if (!a.direcionada && a.v1 == v){
                        System.out.println(v.valor + " -- " + a.v2.valor);
                    }
                    else{
                        System.out.println(v.valor + " -- " + a.v1.valor);
                    }
                }
            }
            else{
                System.out.println(v.valor + " :( ");
            }
        }
    }
}
