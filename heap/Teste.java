import java.util.Scanner;

public class Teste{
    public static void main(String args []){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        filaPrioridade lista = new filaPrioridade();
        for (int i = 1; i <= n; i++){
            int x = s.nextInt();
            lista.insert(i + 1, x);
        }
        lista.insert(0, 80);
        lista.insert(6, 7);
        lista.insert(1, 9);
        lista.removeMin();
        lista.removeMin();
        System.out.println(lista.min());
        System.out.println(lista.isHeap(lista.theRoot()));
        
    }
}

