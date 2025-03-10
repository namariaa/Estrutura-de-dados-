package skiplist;
import java.util.Scanner;

public class Teste {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Skip lista = new Skip(n);
        for (int i = 0; i < n; i++){
            int x = s.nextInt();
            lista.insert(x);
        }
        System.out.println(lista.size());
    }
}
