public class ArvoreB {
    public class Node {
        int[] chaves;
        Node[] filhos;
    }

    Node root;
    int ordem;

    public ArvoreB(int ordem) {
        this.ordem = ordem;
        this.root = null;
    }

    public Node Busca(int valor) {
        Node r = this.root;
        while (r.filhos != null) {
            for (int i = 0; i < r.chaves.length; i++) {
                if (r.chaves[i] == valor)
                    break;
                if (r.chaves[i + 1] != null) {
                    if (r.chaves[i + 1] > valor) {
                        r = r.filhos[i + 1];
                    }

                }
            }
        }
    }
}