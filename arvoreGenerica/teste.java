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
        lista.insert(5, 2);
        lista.insert(2,9);
        lista.insert(5, 7);
        //lista.imprimiPos(lista.Root());
        System.out.println(lista.height(lista.Root()));
    }
}

/*
 5 
 1  2   7
    9
 */