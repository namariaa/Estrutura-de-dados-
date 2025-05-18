public class teste {
    public static void main(String [] args){
        ArvoreRN lista = new ArvoreRN();
        lista.insert(4);
        lista.insert(3);
        lista.insert(2);

        System.out.println(lista.root.valor + " " + lista.root.cor);
    }
}
