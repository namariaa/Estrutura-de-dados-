import java.util.ArrayList;

public class Verticie {
    public String valor; //Nome que eu vou dá ao vérticie
    public ArrayList<Aresta> ligados = new ArrayList<>();

    public Verticie(String valor){
        this.valor = valor;
    }
}
