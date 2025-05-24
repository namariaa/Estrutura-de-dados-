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
    
    public ArvoreRN(){
        this.nulo = new Node();
        this.nulo.cor = negro;
        this.root = nulo;
    }
    //Construtor

    public boolean isExternal(Node no){
        return (no.filhoDireita == nulo && no.filhoEsquerda == nulo);
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
        }

        else if (vozinho.cor == negro && tio.cor == negro && pai.cor == rubro){
            System.out.println(pai.filhoEsquerda == noInserido);
            if (vozinho.filhoEsquerda == pai){
                    if (pai.filhoEsquerda == noInserido) rotacaoDireita(vozinho); //Verificar se é o 3A
                    if (pai.filhoDireita == noInserido) rotacaoDuplaDireita(vozinho); //Verifica se é 3C
            }
            else if (vozinho.filhoDireita == pai){ 
                if (pai.filhoDireita == noInserido) rotacaoEsquerda(vozinho); //Verifica se é 3B
                if (pai.filhoEsquerda == noInserido) rotacaoDuplaEsquerda(vozinho); //Verifica  se é 3D        
            }
        }
    }

    public void tratarRemove(Node noInserido){
        Node pai =  noInserido.pai;//Como essa verificação eu só faço quando não é nulo não preciso verificar s eo pai é nulo
        Node vozinho = nulo;
        Node irmao, sobrinhoDireito, sobrinhoEsquerdo = nulo;
        if (pai.filhoEsquerda != nulo){
            if (pai.filhoEsquerda == noInserido){ //Se sou filho esquerdo 
                if (pai.pai != nulo){ //Meu pai não é orfão se ele for meu irmao e avô não existem e são considerados negros
                    vozinho = pai.pai;
                    if (vozinho.filhoEsquerda != nulo){
                        if (vozinho.filhoEsquerda == pai){
                            if (vozinho.filhoDireita != nulo) irmao = vozinho.filhoDireita;
                            else irmao = nulo;
                        }
                    }
                    if (vozinho.filhoDireita != nulo){
                        if (vozinho.filhoDireita == pai){
                            if (vozinho.filhoEsquerda != nulo) irmao = vozinho.filhoEsquerda;
                            else irmao = nulo;
                        }
                    }
                }
            }
        }
        if (pai.filhoDireita != nulo){
            if (pai.filhoDireita == noInserido){//Se sou filho direito aqui vai cobrir casos espelhados 
                if (pai.filhoEsquerda != nulo){
                    irmao = pai.filhoEsquerda;
                    if (irmao.filhoEsquerda != nulo) sobrinhoDireito = irmao.filhoEsquerda;
                    if (irmao.filhoDireita != nulo) sobrinhoEsquerdo = irmao.filhoDireita;
                }
            }
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
        Node novoRoot = no.filhoEsquerda;
        Node antigoDireito = no.filhoEsquerda.filhoDireita;
        Node antigoPaiRoot = no.pai;
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
        String antigaCorRoot = no.cor;
        Node novoRoot = no.filhoDireita;
        rotacaoEsquerda(no);
        System.out.println("no: " + root.valor);
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
        if (no == nulo){
            throw new EArvoreRN("Não existe esse elemento");
        }
        else{
            if (isExternal(no)){ //Quando ele é um nó folha 
                if (no.pai.filhoDireita == no) no.pai.filhoDireita = nulo;
                else no.pai.filhoEsquerda = nulo;
            }
            else if ((no.filhoDireita == nulo && no.filhoEsquerda != nulo) || (no.filhoDireita != nulo && no.filhoEsquerda == nulo)){ //Só tem um filho
                Node mudar;
                if (no.filhoEsquerda != nulo) mudar = no.filhoEsquerda;
                else mudar = no.filhoDireita;
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
                no = mudar; //Perigoso, mudei pois quando for chamar atualizar ele não reconhece no e dá nulo pois as alterações estão em mudar 
            }
            else{ //Se ele tiver dois filhos 
                Node p = no.filhoDireita;
                while (p.filhoEsquerda != nulo){
                    p = p.filhoEsquerda;
                }
                if (no.filhoDireita.filhoEsquerda == nulo){ 
                    no.filhoDireita = nulo;
                } 
                else {
                    p.pai.filhoEsquerda = nulo;
                }
                no.valor = p.valor; 
                if (no.pai == nulo) root = no; 
                no = p; 
            }
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
}

