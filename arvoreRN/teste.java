package arvoreRN;

public class teste {
    public static void main(String [] args){
        ArvoreRN lista = new ArvoreRN();
        lista.insert(4);
        System.out.println(lista.root.valor + " " + lista.root.cor);
    }
}
