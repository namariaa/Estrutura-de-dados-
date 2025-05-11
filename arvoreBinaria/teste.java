import java.util.Scanner;

public class teste{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArvoreBinaria lista = new ArvoreBinaria();
        for (int i = 0; i < n; i++){
            int x = s.nextInt();
            lista.insert(x);
        }
        //lista.imprimePre(lista.theRoot());
        //lista.inverter(lista.theRoot().getFilhoD(),lista.theRoot().getFilhoE());
        //lista.imprimePre(lista.theRoot());
        System.out.println(lista.depth(lista.theRoot()));
        System.out.println(lista.height(lista.theRoot()));
    }
}