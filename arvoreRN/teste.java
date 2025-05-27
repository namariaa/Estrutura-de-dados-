public class teste {
    public static void main(String [] args){
        ArvoreRN lista = new ArvoreRN();
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);
        lista.insert(6);
        lista.insert(7);
        lista.insert(8);
        lista.exibir();
        System.out.println(lista.root.valor + " " + lista.root.cor);
    }
}
