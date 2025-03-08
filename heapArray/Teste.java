import java.util.Scanner;

public class Teste{
    public static void main(String args []){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        filaPrioridade lista = new filaPrioridade(n);
        for (int i = 0; i < n; i++){
            int x = s.nextInt();
            lista.insert(x, i + 1);
        }
        lista.insert(3,80);
        lista.insert(6, 7);
        lista.removeMin();
        lista.removeMin();
        System.out.println(lista.size());
        System.out.println(lista.min());
        
    }
}

