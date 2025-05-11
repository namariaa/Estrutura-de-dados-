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
        //Fique mudando a ordem dos 3 e todas devem dá o root 20 com fb 0
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
        lista.insert(50);
        lista.insert(30);
        lista.insert(70);
        lista.insert(10);
        lista.insert(40);
        lista.insert(60);
        lista.insert(80);
        lista.remove(80);
        lista.remove(70);
        System.out.println(lista.theRoot().valor + " " + lista.theRoot().fb);
        // O resultado deve ser 50 1
    }
}
