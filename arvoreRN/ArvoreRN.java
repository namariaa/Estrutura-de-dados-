import java.util.ArrayList;
import java.util.ArrayList;

public class ArvoreRN {
    public static String rubro = "rubro";
    public static String negro = "negro";
    //Cores 

    public class Node{
        Node pai, filhoDireita, filhoEsquerda;
        int valor, tamanho;
        String cor;
        //Atributos
    }
    //The Node
    public Node root;
    //Root
    Node nulo;
    //Nó nulo
    ArrayList<ArrayList<Node>> arvore; 
    
    public ArvoreRN(){
        this.nulo = new Node();
        this.nulo.cor = negro;
        this.root = nulo;
        this.arvore = new ArrayList<>();
    }
    //Construtor

    public boolean isExternal(Node no){
        return (no.filhoDireita == nulo && no.filhoEsquerda == nulo);
    }

    public Node theRoot(){
        return this.root;
    }

    //Métodos gerais 

    // public void rebalancear(Node no, String tipo){ //Função que verifica se inserir ou removi
    //     if (tipo == "insert") tratarInsert(no);
    //     else tratarRemove(no);
    // }

    public void tratarInsert(Node noInserido){ //Onde vou verificar casos de inserção 
        //Definindo os parente 
        Node pai =  noInserido.pai;//Como essa verificação eu só faço quando não é nulo não preciso verificar s eo pai é nulo
        Node vozinho = pai.pai;
        Node tio = nulo;
        if (vozinho.filhoEsquerda != nulo){
            if (vozinho.filhoEsquerda == pai){
                if (vozinho.filhoDireita != nulo) tio = vozinho.filhoDireita;
                else tio = nulo;
            }
        }
            if (vozinho.filhoDireita != nulo){
                if (vozinho.filhoDireita == pai){
                    if (vozinho.filhoEsquerda != nulo) tio = vozinho.filhoEsquerda;
                    else tio = nulo;
                }
            }

        //Vamos verirficar os casos agora 
        if (pai.cor == negro){ //Caso 01  
            System.out.println("Tá de boa precisa fazer nada");
        }
        
        else if (vozinho.cor == negro && tio.cor == rubro && pai.cor == rubro){ //Caso 02
            if (vozinho != root && vozinho != nulo) vozinho.cor = rubro;
            tio.cor = negro; //Tio não pode ser nulo se não ele é considerado negro o que não entra no caso 
            pai.cor = negro;
            System.out.println("Caso 02 inserção");
        }

        else if (vozinho.cor == negro && tio.cor == negro && pai.cor == rubro){
            if (vozinho.filhoEsquerda == pai){
                    if (pai.filhoEsquerda == noInserido) rotacaoDireita(vozinho); //Verificar se é o 3A
                    if (pai.filhoDireita == noInserido) rotacaoDuplaDireita(vozinho); //Verifica se é 3C
            }
            else if (vozinho.filhoDireita == pai){ 
                if (pai.filhoDireita == noInserido) rotacaoEsquerda(vozinho); //Verifica se é 3B
                if (pai.filhoEsquerda == noInserido) rotacaoDuplaEsquerda(vozinho); //Verifica  se é 3D        
            }
            System.out.println("Caso 03 inserção");
        }
    }

    public void tratarRemove(Node noRemovido, Node sucessor){
        Node pai =  sucessor.pai;//Como essa verificação eu só faço quando não é nulo não preciso verificar s eo pai é nulo
        Node vozinho = pai.pai;
        Node irmao = pai.filhoEsquerda; 
        if (pai.filhoEsquerda == sucessor) irmao = pai.filhoDireita;
        Node sobrinhoDireito = irmao.filhoDireita;
        Node sobrinhoEsquerdo = irmao.filhoEsquerda;
        boolean direito = false;
        Node p = sucessor;
        while (p != theRoot()){
            if (p.pai == theRoot()) break;
            else p =p.pai;
        } 
        if (theRoot().filhoDireita == p) direito = true; // Para sabe se é ou não caso invertido
        if (direito){ //Caso invertido 
            sobrinhoDireito = irmao.filhoEsquerda;
            sobrinhoEsquerdo = irmao.filhoDireita;
        }

        //Vamos tratar os casos agora 
        if (noRemovido.cor == rubro && sucessor.cor == negro){ //Situação 01
            System.out.println("Tá tranqilo, esse é o caso 1 da remoção");
        }
        else if (noRemovido.cor == negro && sucessor.cor == rubro){ //Situação 2
            sucessor.cor = negro;
        }
        else if (noRemovido.cor == negro && sucessor.cor == negro){ //Situação 03
            situacao03(noRemovido, sucessor, irmao, pai, sobrinhoDireito, sobrinhoEsquerdo, vozinho);
        }
        else if (noRemovido.cor == rubro && sucessor.cor == negro){ //Situação 04
            sucessor.cor = rubro;
            //Chamar caso 03
            situacao03(noRemovido, sucessor, irmao, pai, sobrinhoDireito, sobrinhoEsquerdo, vozinho);
        }
        
    }

    public void situacao03(Node noRemovido, Node sucessor, Node irmao, Node pai, Node sobrinhoDireito, Node sobrinhoEsquerdo, Node vozinho){

        if (irmao.cor == rubro && pai.cor == negro){ //Caso 01
            rotacaoEsquerda(vozinho);
            irmao.cor = negro;
            pai.cor = rubro;
            tratarRemove(noRemovido, sucessor);
            //Não terminal chamar recursivamente envio os mesmo nós? 
        }
        else if (irmao.cor == negro && sobrinhoDireito.cor == negro && sobrinhoEsquerdo.cor == negro && pai.cor == negro){ //Caso 02A
            irmao.cor = rubro; 
            if (pai != theRoot()) tratarRemove(noRemovido, sucessor); //São os mesmo nós 
            //Se pai for raíz não é recursivo
        }
        else if (irmao.cor == negro && sobrinhoDireito.cor == negro && sobrinhoEsquerdo.cor == negro && pai.cor == rubro){ //Caso 02B
            irmao.cor = rubro;
            pai.cor = negro;
        }
        else if (irmao.cor == negro && sobrinhoEsquerdo.cor == rubro && sobrinhoDireito.cor == negro){ //Caso 03
            rotacaoDireita(irmao);
            String col = irmao.cor;
            irmao.cor = sobrinhoEsquerdo.cor;
            sobrinhoEsquerdo.cor = col;
        }
        else if (irmao.cor == negro && sobrinhoDireito.cor == rubro){
            rotacaoEsquerda(vozinho);
            irmao.cor = pai.cor;
            pai.cor = negro;
            sobrinhoDireito.cor = negro;
        }
    }

    public void insert(int v){
        Node novo = new Node();
        novo.valor = v;
        if (theRoot() == nulo){
            novo.filhoDireita = nulo;
            novo.filhoEsquerda = nulo;
            this.root = novo;
            novo.pai = nulo;
            novo.cor = negro; //Todo nó novo é 
        }
        else{
            Node p = this.root;
            while(p != nulo){
                if (p.valor < v){
                    if (p.filhoDireita == nulo) break;
                    p = p.filhoDireita;
                }
                else{
                    if (p.filhoEsquerda == nulo) break;
                    p = p.filhoEsquerda;
                }
            }
            novo.cor = rubro;
            novo.pai = p;
            if (p.valor > v) p.filhoEsquerda = novo;
            else p.filhoDireita = novo;
            novo.filhoDireita = nulo;
            novo.filhoEsquerda = nulo;
            
            //Agora vamos verificar os casos 
            System.out.println("inserido: " + novo.valor + " Pai: " + novo.pai.valor);
            tratarInsert(novo);
            System.out.println("inserido: " + novo.valor + " " + novo.cor + " Pai: " + novo.pai.valor + " " + novo.pai.cor);
        } 
    }

    //Os nos que as rotações recebem inicialmente é o "root"
    public void rotacaoEsquerda(Node no){ //No sempre vai ter filho direito se não não tem FB desbalanceado
        Node novoRoot = no.filhoDireita;//5
        Node antigoEsquerdo = no.filhoDireita.filhoEsquerda;//nulo
        Node antigoPaiRoot = no.pai;//6
        String antigaCorRoot = no.cor;
        novoRoot.filhoEsquerda = no;
        no.pai = novoRoot;
        novoRoot.pai = antigoPaiRoot; //O pai do antigo root vai ser pai do root atual
        if (antigoPaiRoot != nulo){ //Se ele não era o root ele tinha um pai
            if (antigoPaiRoot.filhoEsquerda != nulo){
                if (antigoPaiRoot.filhoEsquerda == no) antigoPaiRoot.filhoEsquerda = novoRoot;
                else antigoPaiRoot.filhoDireita = novoRoot;
            }
            else{
                if (antigoPaiRoot.filhoDireita == no) antigoPaiRoot.filhoDireita = novoRoot;
            }
        }
        no.filhoDireita = antigoEsquerdo;
        if (antigoEsquerdo != nulo) antigoEsquerdo.pai = no;
        no.cor = novoRoot.cor;
        novoRoot.cor = antigaCorRoot;
        if (no == theRoot()) root = novoRoot; //Se o nó era o root eu tenho que definir e não uma subarvore eu tenho que definir o novo root
    }

    public void rotacaoDireita(Node no){
        Node novoRoot = no.filhoEsquerda; //4
        Node antigoDireito = no.filhoEsquerda.filhoDireita; //5
        Node antigoPaiRoot = no.pai; //3
        String antigaCorRoot = no.cor; 
        novoRoot.filhoDireita = no;
        no.pai = novoRoot;
        novoRoot.pai = antigoPaiRoot;
        if (antigoPaiRoot != nulo){ //Se ele não era o root ele tinha um pai
            if (antigoPaiRoot.filhoEsquerda != nulo){
                if (antigoPaiRoot.filhoEsquerda == no) antigoPaiRoot.filhoEsquerda = novoRoot;
                else antigoPaiRoot.filhoDireita = novoRoot;
            }
            else{
                if (antigoPaiRoot.filhoDireita == no) antigoPaiRoot.filhoDireita = novoRoot;
            }
        }
        no.filhoEsquerda = antigoDireito;
        if (antigoDireito != nulo) antigoDireito.pai = no;
        no.cor = novoRoot.cor;
        novoRoot.cor = antigaCorRoot;
        if (no == theRoot()) root = novoRoot; //Se o nó era o root eu tenho que definir e não uma subarvore eu tenho que definir o novo root
    }

    public void rotacaoDuplaEsquerda(Node no){
        rotacaoDireita(no.filhoDireita);
        //Filho direita do nó é A e o filho da direita do filho da direita é o B
        rotacaoEsquerda(no);
    }

    public void rotacaoDuplaDireita(Node no){
        rotacaoEsquerda(no.filhoEsquerda);
        //Filho esquerda do nó é A e o filho da esquerda do filho da esquerda é o B
        rotacaoDireita(no);
    }

    public void remove(int v) throws EArvoreRN{
        Node no = buscar(v);
        if (no == nulo){
            throw new EArvoreRN("Não existe esse elemento");
        }
        else{
            Node sucessor;
            if (isExternal(no)){ //Quando ele é um nó folha 
                sucessor = no;
                if (no.pai.filhoDireita == no) no.pai.filhoDireita = nulo;
                else no.pai.filhoEsquerda = nulo;
            }
            else if ((no.filhoDireita == nulo && no.filhoEsquerda != nulo) || (no.filhoDireita != nulo && no.filhoEsquerda == nulo)){ //Só tem um filho
                Node mudar;
                if (no.filhoEsquerda != nulo) mudar = no.filhoEsquerda;
                else mudar = no.filhoDireita;
                sucessor =mudar;
                if (no.pai != nulo){
                    if (no.pai.filhoDireita != nulo){
                        if (no.pai.filhoDireita == no){
                            no.pai.filhoDireita = mudar;
                        }
                    }
                    if (no.pai.filhoDireita == nulo) no.pai.filhoEsquerda = mudar;
                }
                
                mudar.pai = no.pai;
                if (mudar.pai == nulo) root = mudar; //Se ele não tem pai é root isso se dá quando o que eu removo é root
            }
            else{ //Se ele tiver dois filhos 
                Node p = no.filhoDireita;
                Node antigo = no;
                while (p.filhoEsquerda != nulo){
                    p = p.filhoEsquerda;
                }
                if (no.filhoDireita.filhoEsquerda == nulo){ 
                    no.filhoDireita = nulo;
                } 
                else {
                    p.pai.filhoEsquerda = nulo;
                }
                sucessor = p;
                no.valor = p.valor; 
                if (no.pai == nulo) root = no; 
                no = antigo;
            }
            tratarRemove(no, sucessor);
            System.out.println("removido: " + no.valor + " " + no.cor + " Sucessor: " + sucessor.valor + " " + sucessor.cor);
        }
    }
    
    public Node buscar(int no){
        Node p = this.root;
        while (p != nulo){
            if (p.valor == no) break;
            else{
                if (p.valor > no) p = p.filhoEsquerda;
                else p = p.filhoDireita;
            }
        }
        return p;
    }

    public int largura(Node no){
        int cont = 0;
        while (no != nulo){
            if (no.pai != nulo){

                if (no.pai.filhoEsquerda != nulo){
                    if (no.pai.filhoEsquerda == no){
                        if (no.pai.pai != nulo){
                            if (no.pai.pai.filhoDireita == no.pai){
                                no = no.pai.pai.filhoEsquerda;
                                cont++;
                                continue;
                            }
                        }
                    }
                    else{
                        no = no.pai.filhoEsquerda;
                        cont++;
                        continue;
                    }
                }
                else{ 
                    if (no.pai.pai != nulo){
                        if (no.pai.pai.filhoDireita != nulo){
                            no = no.pai.pai.filhoDireita;
                            cont++;
                            continue;
                        }
                        if (no.pai.pai.filhoEsquerda != nulo){
                            no = no.pai.pai.filhoEsquerda;
                            cont++;
                            continue;
                        }
                    }
                }
            }
            break;
        }
        return cont;
    }

    public int depth(Node no){
        if (no == theRoot()) return 0;
        else return 1 + depth(no.pai);
    }

    public int height(Node no){
        if (isExternal(no)) return 0;
        else{
            int cont = 0;
            if (no.filhoDireita == nulo) cont += Math.max(cont, height(no.filhoEsquerda));
            else if (no.filhoEsquerda == nulo) cont += Math.max(cont, height(no.filhoDireita));
            else cont += Math.max(cont, (Math.max(height(no.filhoDireita), height(no.filhoEsquerda))));
            return 1 + cont;
        }
    }

    public void salvar(Node no){
        if (no != nulo){
            salvar(no.filhoEsquerda);
            salvar(no.filhoDireita);
            int profundidade = depth(no); 
            this.arvore.get(largura(no)).set(profundidade, no); 
        } 
    }

    public void exibir(){
        int altura = height(theRoot());
        //Preenche array e chama posteriomente função para salavar elementos na posiçõ correta 
        for (int i = 0; i < altura + 2; i++){
            ArrayList<Node> subsarvore = new ArrayList<>(altura + 1);
            this.arvore.add(subsarvore);
            for (int j = 0; j < altura + 1; j++){
                Node nulo = new Node();
                nulo.valor = -1;
                subsarvore.add(nulo);
            }
        }
        salvar(theRoot());
        for (int i = 0; i < altura + 2; i++){
            for (int j = 0; j < altura + 1; j++){
                if (arvore.get(i).get(j).valor != -1){
                    if (j == 0){
                        for (int p = 0; p < altura + 1; p++) System.out.print(" ");
                        System.out.println(arvore.get(i).get(j).valor);
                    }
                    else{
                        for (int p = 0; p < altura; p++) System.out.print(" ");
                        if (arvore.get(i).get(j).pai != nulo){
                            if (arvore.get(i).get(j).pai.filhoEsquerda != nulo){
                                if (arvore.get(i).get(j).pai.filhoEsquerda == arvore.get(i).get(j)) {
                                    System.out.print(arvore.get(i).get(j).valor);
                                }
                                else{
                                    System.out.println(arvore.get(i).get(j).valor);
                                    for (int p = 0; p < altura * 2 + 1; p++) System.out.print(" ");
                                }
                            }
                            else{
                                System.out.println(arvore.get(i).get(j).valor);
                                for (int p = 0; p < altura * 2 + 1; p++) System.out.print(" ");
                            }
                        }
                        else{
                            System.out.println(arvore.get(i).get(j).valor);
                            for (int p = 0; p < altura * 2 + 1; p++) System.out.print(" ");
                        }
                    } 
                }
            }
        }
    }
}

