package tabelaHash;
import java.util.Scanner;

public class Teste {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Dicionario dicionario = new Dicionario(n);
        
        // Teste 1: Inserção de chaves repetidas
        System.out.println("=== Teste 1: Inserção de chaves repetidas ===");
        dicionario.insertItem(10, 100);
        dicionario.insertItem(10, 200); // Deve sobrescrever o valor anterior
        System.out.println("Valor da chave 10: " + dicionario.findElement(10)); // Deve retornar 200

        // Teste 2: Busca em tabela vazia
        System.out.println("\n=== Teste 2: Busca em tabela vazia ===");
        Dicionario dicionarioVazio = new Dicionario(5); // Cria um dicionário vazio

        // Teste 3: Remoção de todos os elementos
        System.out.println("\n=== Teste 3: Remoção de todos os elementos ===");
        dicionario.insertItem(20, 200);
        dicionario.insertItem(30, 300);
        System.out.println("Tamanho do dicionário antes da remoção: " + dicionario.size()); // Deve retornar 3
        System.out.println("Elemento removido (chave 10): " + dicionario.removeElement(10)); // Deve retornar 200
        System.out.println("Elemento removido (chave 20): " + dicionario.removeElement(20)); // Deve retornar 200
        System.out.println("Elemento removido (chave 30): " + dicionario.removeElement(30)); // Deve retornar 300
        System.out.println("Tamanho do dicionário após remoção de todos os elementos: " + dicionario.size()); // Deve retornar 0

        // Teste 4: Inserção após redimensionamento
        System.out.println("\n=== Teste 4: Inserção após redimensionamento ===");
        dicionario.insertItem(40, 400);
        dicionario.insertItem(50, 500);
        dicionario.insertItem(60, 600); // Deve causar redimensionamento
        System.out.println("Valor da chave 40: " + dicionario.findElement(40)); // Deve retornar 400
        System.out.println("Valor da chave 50: " + dicionario.findElement(50)); // Deve retornar 500
        System.out.println("Valor da chave 60: " + dicionario.findElement(60)); // Deve retornar 600
        System.out.println("Tamanho do dicionário após redimensionamento: " + dicionario.size()); // Deve retornar 3

        // Teste 5: Inserção e remoção com colisões
        System.out.println("\n=== Teste 5: Inserção e remoção com colisões ===");
        dicionario.insertItem(70, 700);
        dicionario.insertItem(80, 800);
        dicionario.insertItem(90, 900);
        System.out.println("Valor da chave 70: " + dicionario.findElement(70)); // Deve retornar 700
        System.out.println("Valor da chave 80: " + dicionario.findElement(80)); // Deve retornar 800
        System.out.println("Valor da chave 90: " + dicionario.findElement(90)); // Deve retornar 900
        System.out.println("Elemento removido (chave 70): " + dicionario.removeElement(70)); // Deve retornar 700
        System.out.println("Elemento removido (chave 80): " + dicionario.removeElement(80)); // Deve retornar 800
        System.out.println("Elemento removido (chave 90): " + dicionario.removeElement(90)); // Deve retornar 900
        System.out.println("Tamanho do dicionário após remoção: " + dicionario.size()); // Deve retornar 3

        // Teste 6: Verificação de fator de carga e redimensionamento
        System.out.println("\n=== Teste 6: Verificação de fator de carga e redimensionamento ===");
        dicionario.insertItem(100, 1000);
        dicionario.insertItem(110, 1100);
        dicionario.insertItem(120, 1200); // Deve causar redimensionamento
        System.out.println("Valor da chave 100: " + dicionario.findElement(100)); // Deve retornar 1000
        System.out.println("Valor da chave 110: " + dicionario.findElement(110)); // Deve retornar 1100
        System.out.println("Valor da chave 120: " + dicionario.findElement(120)); // Deve retornar 1200
        System.out.println("Tamanho do dicionário após redimensionamento: " + dicionario.size()); // Deve retornar 6

        // System.out.println(dicionario.size());
    }
}
