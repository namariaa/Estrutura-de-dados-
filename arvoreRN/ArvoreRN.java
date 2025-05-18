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
    
    public ArvoreRN(){
        this.root = null;
    }
    //Construtor

    public boolean isExternal(Node no){
        return (no.filhoDireita == null && no.filhoEsquerda == null);
    }

    public Node theRoot(){
        return this.root;
    }

    //Métodos gerais 

    public void rebalancear(Node no, String tipo){ //Função que verifica se inserir ou removi
        if (tipo == "insert") tratarInsert(no);
        else tratarRemove(no);
    }

    public void tratarInsert(Node noInserido){ //Onde vou verificar casos de inserção 
        //Definindo os parente 
        Node pai =  noInserido.pai;//Como essa verificação eu só faço quando não é null não preciso verificar s eo pai é null
        Node vozinho = null;
        Node tio = null;
        if (pai.pai != null){ //Meu pai não é orfão se ele for meu tio e avô não existem e são considerados negros
            vozinho = pai.pai;
            if (vozinho.filhoEsquerda != null){
                if (vozinho.filhoEsquerda == pai){
                    if (vozinho.filhoDireita != null) tio = vozinho.filhoDireita;
                    else tio = null;
                }
            }
            if (vozinho.filhoDireita != null){
                if (vozinho.filhoDireita == pai){
                    if (vozinho.filhoEsquerda != null) tio = vozinho.filhoEsquerda;
                    else tio = null;
                }
            }
        }

        //Vamos verirficar os casos agora 
        if (pai.cor == negro){ //Caso 01  
            System.out.println("Tá de boa precisa fazer nada");
        }
        else if (tio != null){ //Caso 02
            if ((vozinho == null || vozinho.cor == negro) && tio.cor == rubro && pai.cor == rubro){ //Condição do caso 02
                if (vozinho != null){
                    if (vozinho != root) vozinho.cor = rubro;
                }
                tio.cor = negro; //Tio não pode ser null se não ele é considerado negro o que não entra no caso 
                pai.cor = negro;
            }
        }

        else if ((vozinho == null || vozinho.cor == negro) && (tio == null || tio.cor == negro) && pai.cor == rubro){
            if (vozinho != null){ 
                if (vozinho.filhoEsquerda != null){ 
                    if (vozinho.filhoEsquerda == pai){
                        if (pai.filhoEsquerda != null){ //Verificar se é o 3A
                            if (pai.filhoEsquerda == noInserido) rotacaoDireita(noInserido);
                        }
                        if (pai.filhoDireita != null){ //Verifica se é 3C
                            if (pai.filhoDireita == noInserido) rotacaoDuplaEsquerda(noInserido);
                        }
                    }
                }

                if (vozinho.filhoDireita != null){ //Verifica se é 3B
                    if (vozinho.filhoDireita == pai){
                        if (pai.filhoDireita != null){
                            if (pai.filhoDireita == noInserido) rotacaoEsquerda(noInserido);
                        }
                        if (pai.filhoEsquerda != null){ //Verifica  se é 3D
                            if (pai.filhoEsquerda == noInserido) rotacaoDuplaDireita(noInserido);
                        }
                    }
                }
            }

        }
    }

    public void tratarRemove(Node noInserido){
        Node pai =  noInserido.pai;//Como essa verificação eu só faço quando não é null não preciso verificar s eo pai é null
        Node vozinho = null;
        Node irmao, sobrinhoDireito, sobrinhoEsquerdo = null;
        if (pai.filhoEsquerda != null){
            if (pai.filhoEsquerda == noInserido){ //Se sou filho esquerdo 
                if (pai.pai != null){ //Meu pai não é orfão se ele for meu irmao e avô não existem e são considerados negros
                    vozinho = pai.pai;
                    if (vozinho.filhoEsquerda != null){
                        if (vozinho.filhoEsquerda == pai){
                            if (vozinho.filhoDireita != null) irmao = vozinho.filhoDireita;
                            else irmao = null;
                        }
                    }
                    if (vozinho.filhoDireita != null){
                        if (vozinho.filhoDireita == pai){
                            if (vozinho.filhoEsquerda != null) irmao = vozinho.filhoEsquerda;
                            else irmao = null;
                        }
                    }
                }
            }
        }
        if (pai.filhoDireita != null){
            if (pai.filhoDireita == noInserido){//Se sou filho direito aqui vai cobrir casos espelhados 
                if (pai.filhoEsquerda != null){
                    irmao = pai.filhoEsquerda;
                    if (irmao.filhoEsquerda != null) sobrinhoDireito = irmao.filhoEsquerda;
                    if (irmao.filhoDireita != null) sobrinhoEsquerdo = irmao.filhoDireita;
                }
            }
        }
    }

    public void insert(int v){
        Node novo = new Node();
        novo.valor = v;
        if (theRoot() == null){
            novo.filhoDireita = null;
            novo.filhoEsquerda = null;
            this.root = novo;
            novo.pai = null;
            novo.cor = negro; //Todo nó novo é 
        }
        else{
            Node p = this.root;
            while(p != null){
                if (p.valor < v){
                    if (p.filhoDireita == null) break;
                    p = p.filhoDireita;
                }
                else{
                    if (p.filhoEsquerda == null) break;
                    p = p.filhoEsquerda;
                }
            }
            novo.pai = p;
            novo.cor = rubro;
            if (p.valor > v) p.filhoEsquerda = novo;
            else p.filhoDireita = novo;

            //Agora vamos verificar os casos 
            rebalancear(novo, "insert");
            System.out.println("inserido: " + novo.valor + " " + novo.cor + " Pai: " + novo.pai.valor + " " + novo.pai.cor);
        } 
    }

    //Os nos que as rotações recebem inicialmente é o "root"
    public void rotacaoEsquerda(Node no){ //No sempre vai ter filho direito se não não tem FB desbalanceado
        Node novoRoot = no.filhoDireita;
        Node antigoEsquerdo = no.filhoDireita.filhoEsquerda;
        Node antigoPaiRoot = no.pai;
        String antigaCorRoot = no.cor;
        novoRoot.filhoEsquerda = no;
        no.pai = novoRoot;
        novoRoot.pai = antigoPaiRoot; //O pai do antigo root vai ser pai do root atual
        if (antigoPaiRoot != null){ //Se ele não era o root ele tinha um pai
            if (antigoPaiRoot.filhoEsquerda != null){
                if (antigoPaiRoot.filhoEsquerda == no) antigoPaiRoot.filhoEsquerda = novoRoot;
                else antigoPaiRoot.filhoDireita = novoRoot;
            }
            else{
                if (antigoPaiRoot.filhoDireita == no) antigoPaiRoot.filhoDireita = novoRoot;
            }
        }
        no.filhoDireita = antigoEsquerdo;
        if (antigoEsquerdo != null) antigoEsquerdo.pai = no;
        no.cor = novoRoot.cor;
        novoRoot.cor = antigaCorRoot;
        if (no == theRoot()) root = novoRoot; //Se o nó era o root eu tenho que definir e não uma subarvore eu tenho que definir o novo root
    }

    public void rotacaoDireita(Node no){
        Node novoRoot = no.filhoEsquerda;
        Node antigoDireito = no.filhoEsquerda.filhoDireita;
        Node antigoPaiRoot = no.pai;
        String antigaCorRoot = no.cor;
        novoRoot.filhoDireita = no;
        no.pai = novoRoot;
        novoRoot.pai = antigoPaiRoot;
        if (antigoPaiRoot != null){ //Se ele não era o root ele tinha um pai
            if (antigoPaiRoot.filhoEsquerda != null){
                if (antigoPaiRoot.filhoEsquerda == no) antigoPaiRoot.filhoEsquerda = novoRoot;
                else antigoPaiRoot.filhoDireita = novoRoot;
            }
            else{
                if (antigoPaiRoot.filhoDireita == no) antigoPaiRoot.filhoDireita = novoRoot;
            }
        }
        no.filhoEsquerda = antigoDireito;
        if (antigoDireito != null) antigoDireito.pai = no;
        no.cor = novoRoot.cor;
        novoRoot.cor = antigaCorRoot;
        if (no == theRoot()) root = novoRoot; //Se o nó era o root eu tenho que definir e não uma subarvore eu tenho que definir o novo root
    }

    public void rotacaoDuplaEsquerda(Node no){
        rotacaoDireita(no.filhoDireita);
        //Filho direita do nó é A e o filho da direita do filho da direita é o B
        String antigaCorRoot = no.cor;
        Node novoRoot = no.filhoDireita;
        rotacaoEsquerda(no);
        no.cor = novoRoot.cor;
        novoRoot.cor = antigaCorRoot;
    }

    public void rotacaoDuplaDireita(Node no){
        rotacaoEsquerda(no.filhoEsquerda);
        //Filho esquerda do nó é A e o filho da esquerda do filho da esquerda é o B
        String antigaCorRoot = no.cor;
        Node novoRoot = no.filhoEsquerda;
        rotacaoDireita(no);
        no.cor = novoRoot.cor;
        novoRoot.cor = antigaCorRoot;
    }

    public void remove(int v) throws EArvoreRN{
        Node no = buscar(v);
        if (no == null){
            throw new EArvoreRN("Não existe esse elemento");
        }
        else{
            if (isExternal(no)){ //Quando ele é um nó folha 
                if (no.pai.filhoDireita == no) no.pai.filhoDireita = null;
                else no.pai.filhoEsquerda = null;
            }
            else if ((no.filhoDireita == null && no.filhoEsquerda != null) || (no.filhoDireita != null && no.filhoEsquerda == null)){ //Só tem um filho
                Node mudar;
                if (no.filhoEsquerda != null) mudar = no.filhoEsquerda;
                else mudar = no.filhoDireita;
                if (no.pai != null){
                    if (no.pai.filhoDireita != null){
                        if (no.pai.filhoDireita == no){
                            no.pai.filhoDireita = mudar;
                        }
                    }
                    if (no.pai.filhoDireita == null) no.pai.filhoEsquerda = mudar;
                }
                
                mudar.pai = no.pai;
                if (mudar.pai == null) root = mudar; //Se ele não tem pai é root isso se dá quando o que eu removo é root
                no = mudar; //Perigoso, mudei pois quando for chamar atualizar ele não reconhece no e dá null pois as alterações estão em mudar 
            }
            else{ //Se ele tiver dois filhos 
                Node p = no.filhoDireita;
                while (p.filhoEsquerda != null){
                    p = p.filhoEsquerda;
                }
                if (no.filhoDireita.filhoEsquerda == null){ 
                    no.filhoDireita = null;
                } 
                else {
                    p.pai.filhoEsquerda = null;
                }
                no.valor = p.valor; 
                if (no.pai == null) root = no; 
                no = p; 
            }
        }
    }

    public Node buscar(int no){
        Node p = this.root;
        while (p != null){
            if (p.valor == no) break;
            else{
                if (p.valor > no) p = p.filhoEsquerda;
                else p = p.filhoDireita;
            }
        }
        return p;
    }
}

