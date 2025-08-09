import java.util.ArrayList;
import java.util.Scanner;

public class Teste3 {
    public static void main(String [] args){
        //Tenho quebotar direitnho em um array list 
        ArrayList<ArrayList<Integer>> euLi = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String lido = s.nextLine();
            if (lido.isEmpty()) break;
            else{
                ArrayList<Integer> line = new ArrayList<>();
                for (int i = 0; i < lido.length(); i++) {
                    line.add(Character.getNumericValue(lido.charAt(i)));
                }
                euLi.add(line);
            } 
        }
        Estrela lista = new Estrela(euLi);
        lista.AEstrela();
        
        lista.exibir();
    }
}
