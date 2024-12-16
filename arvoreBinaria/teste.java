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
        lista.remove(7);
        lista.remove(8);
        lista.remove(4);
        lista.imprimePre(lista.theRoot());
    }
}