public class teste {
    public static void main(String[] args){
        ArvoreAVL lista = new ArvoreAVL();
        //Tetes 01
        // lista.insert(1);
        // lista.insert(2);
        // lista.insert(3);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // lista.remove(2);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // lista.remove(3);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // Resultado deve ser respectivivamente 2 0 -> 3 1 -> 1 0
        //Tetes 02
        // lista.insert(10);
        // lista.insert(20);
        // lista.insert(30);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        //Fique mudando a ordem dos 3 e quase todas devem dá o root 20 com fb 0
        //Teste 03
        // lista.insert(20);
        // lista.insert(10);
        // lista.insert(30);
        // lista.insert(25);
        // lista.insert(40);
        // lista.remove(20);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 25 -1
        //Teste 04
        // lista.insert(10);
        // lista.insert(5);
        // lista.insert(1);
        // lista.remove(5);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 10 1
        //Teste 05
        // lista.insert(10);
        // try {
        //     lista.remove(99);
        // } catch (EArvoreAVL e) {
        //     System.out.println("Deu bom");
        // }
        //Teste 06
        // lista.insert(50);
        // lista.insert(30);
        // lista.insert(70);
        // lista.insert(10);
        // lista.insert(40);
        // lista.insert(60);
        // lista.insert(80);
        // lista.remove(80);
        // lista.remove(70);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 50 1
        //Teste 07
        // lista.insert(10);
        // lista.insert(5);
        // lista.insert(15);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 10 0
        //Teste 08
        // lista.insert(10);
        // lista.insert(20);
        // lista.insert(30);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 20 0
        //Teste 09
        // lista.insert(30);
        // lista.insert(20);
        // lista.insert(10);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 20 0
        //Teste 10 
        // lista.insert(10);
        // lista.insert(30);
        // lista.insert(20);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 20 0
        //Teste 11
        // lista.insert(30);
        // lista.insert(10);
        // lista.insert(20);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 20 0
        //Teste 12
        // lista.insert(10);
        // lista.insert(5);
        // lista.insert(15);
        // lista.remove(5);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 10 -1
        //Teste 13
        // lista.insert(10);
        // lista.insert(5);
        // lista.insert(3);
        // lista.remove(5);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 10 1
        //Teste 14
        // lista.insert(20);
        // lista.insert(10);
        // lista.insert(30);
        // lista.insert(25);
        // lista.insert(40);
        // lista.remove(30);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 20 -1
        //Teste 15
        // lista.insert(20);
        // lista.insert(10);
        // lista.insert(30);
        // lista.remove(20);
        // System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 30 1
        //Teste 16
        lista.insert(70);
        lista.insert(90);
        lista.insert(50);
        lista.insert(80);
        lista.insert(60);
        lista.insert(100);
        lista.insert(40);
        lista.insert(55);
        // lista.remove(50);
        System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // 70 0
    }
}
