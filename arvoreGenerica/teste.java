import java.util.Scanner;

public class teste{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArvoreGenerica lista = new ArvoreGenerica();
        for (int i = 0; i < n; i++){
            int x = s.nextInt();
            lista.insertRoot(x);
        }
    }
}