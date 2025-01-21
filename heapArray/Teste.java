import java.util.Scanner;

public class Teste{
    public static void main(String args []){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        filaPrioridade lista = new filaPrioridade(n);
        for (int i = 0; i < n; i++){
            int x = s.nextInt();
            lista.insert(i + 1, x);
        }
        
    }
}

