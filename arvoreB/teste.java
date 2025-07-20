public class teste {
    public static void main(String [] args){
        ArvoreB lista = new ArvoreB(2);
        lista.Insert(20);
        lista.Insert(10);
        lista.Insert(30);
        lista.Insert(40);
        lista.Insert(50);
        lista.Insert(5);
        lista.Insert(8);
        lista.Insert(2);
        lista.Insert(70);
        lista.Insert(1);
        lista.Insert(3);
        System.out.println(lista.root.chaves);
        System.out.println(lista.root.filhos.get(0).chaves);
        System.out.println(lista.root.filhos.get(1).chaves);
        System.out.println(lista.root.filhos.get(1).filhos.get(0).chaves);
        System.out.println(lista.root.filhos.get(1).filhos.size());
    }
}
