public class ArvoreAVL{
    public class Node{
        Node pai, filhoDireita, filhoEsquerda;
        int valor, tamanho, fb;
        //Atributos
    }
    //The Node
    public Node root;
    //Root

    public ArvoreAVL(){
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

    public void insert(int v){
        Node novo = new Node();
        novo.valor = v;
        novo.fb = 0;
        if (theRoot() == null){
            novo.filhoDireita = null;
            novo.filhoEsquerda = null;
            this.root = novo;
            novo.pai = null;
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
            if (p.valor > v) p.filhoEsquerda = novo;
            else p.filhoDireita = novo;
            //Chamar para atualizar o FB passando o nó que acabei de inserir 
            int incremento = 1;
            if (novo.pai.filhoDireita != null){ 
                if (novo.pai.filhoDireita == novo){ //Se ele foi inserido na direita o incremento fica negativo
                    incremento = -1;
                }
            }
            if (novo.pai.fb + incremento != 0) atualizarFB(novo.pai, incremento,"insert"); //Caso o nó tem um filho direito e insiro um esquerdo e vice-versa e ele fica 0 não muda acima
            else novo.pai.fb += incremento;
        } 
    }

    public void atualizarFB(Node no, int incremento, String tipo){ //no é nó que eu acabei de inserir 
        if (no != theRoot()){
            while (no != null){ //Vou pegando o pai e atualizando seu FB
                System.out.println("Incremento:" + incremento);
                no.fb += incremento;
                System.out.println("entarda:" + no.valor + " " + no.fb);
                if (no.fb == -2){ //Chama rotações esquerdas aqui
                        if (no.filhoDireita != null){
                            if (no.filhoDireita.fb == 1) rotacaoDuplaEsquerda(no);
                            else rotacaoEsquerda(no); //Sinais não opostos é simples 
                        }
                        else rotacaoEsquerda(no); //Quando ele não tem filho para conferir sinal é simples

                        //Atualizar com formula após rotações no vai começar a ser o antigoRoot que é B e o pai dele o A 
                        no.fb = no.fb + 1 - Math.min(no.pai.fb, 0);
                        no.pai.fb = no.pai.fb + 1 + Math.max(no.fb, 0);
                        if (no.pai != null && no.pai != theRoot()) no = no.pai;
                        else break;
                    }
                else if (no.fb == 2){ //Rotações direitas vão ser chamadas aqui
                        if (no.filhoEsquerda != null){
                            if (no.filhoEsquerda.fb == -1) rotacaoDuplaDireita(no);
                            else rotacaoDireita(no); 
                        }
                        else rotacaoDireita(no);
                        
                        //Atualizar com formula após rotações no vai começar a ser o antigoRoot que é B e o pai dele o A 
                        no.fb = no.fb - 1 - Math.max(no.pai.fb, 0);
                        no.pai.fb = no.pai.fb - 1 + Math.min(no.fb, 0);
                        if (no.pai != null && no.pai != theRoot()) no = no.pai;
                        else break;
                }
                else{
                    if (no.pai != null){ //Mudar o valor do incremento dependendo se for filho direito ou esquerdo 
                        boolean change = false;
                        if (tipo == "insert"){
                            if (no.pai.filhoEsquerda != null){
                                if (no.pai.filhoEsquerda == no && incremento == -1) {
                                    incremento = 1;
                                    if (no.pai.pai == null){
                                        no.pai.fb += incremento;
                                        if (no.pai.fb == 2){
                                            no = no.pai;
                                            incremento = 0; // Pois já mudei o valor do root mas precisa fazer o laço novamente para testar se precisa de rotação por isso zero para não mudar o valor
                                            continue; //Agora vou precisar apenas fazer rotações 
                                        }
                                        else break;
                                    }
                                    no = no.pai;
                                    change= true;
                                }
                            }
                            if (no.pai.filhoDireita != null){
                                if (no.pai.filhoDireita == no && incremento == 1){
                                    incremento = -1; 
                                    if (no.pai.pai == null){
                                        no.pai.fb += incremento;
                                        if (no.pai.fb == -2){
                                            no = no.pai;
                                            incremento = 0; // Pois já mudei o valor do root mas precisa fazer o laço novamente para testar se precisa de rotação por isso zero para não mudar o valor
                                            continue; //Agora vou precisar apenas fazer rotações 
                                        }
                                        else break;
                                    } 
                                    no = no.pai;
                                    change= true;
                                }
                            }
                        }
                        else{
                            if (no.pai.filhoEsquerda != null){
                                if (no.pai.filhoEsquerda == no && incremento == 1) {
                                    incremento = -1;
                                    if (no.pai.pai == null){
                                        no.pai.fb += incremento;
                                        if (no.pai.fb == -2){
                                            no = no.pai;
                                            incremento = 0; // Pois já mudei o valor do root mas precisa fazer o laço novamente para testar se precisa de rotação por isso zero para não mudar o valor
                                            continue; //Agora vou precisar apenas fazer rotações 
                                        }
                                        else break;
                                    }
                                    no = no.pai;
                                    change= true;
                                }
                            }
                            if (no.pai.filhoDireita != null){
                                if (no.pai.filhoDireita == no && incremento == -1){
                                    incremento = 1; 
                                    if (no.pai.pai == null){
                                        no.pai.fb += incremento;
                                        if (no.pai.fb == 2){
                                            no = no.pai;
                                            incremento = 0; // Pois já mudei o valor do root mas precisa fazer o laço novamente para testar se precisa de rotação por isso zero para não mudar o valor
                                            continue; //Agora vou precisar apenas fazer rotações 
                                        }
                                        else break;
                                    } 
                                    no = no.pai;
                                    change= true;
                                }
                            }
                        }
                        if (!change) no = no.pai;
                    }
                    else break;
                }  
                }
        }
        else no.fb += incremento; //Se for o root já o laço não roda e nó não atualiza
    }

    //Os nos que as rotações recebem inicialmente é o "root"
    public void rotacaoEsquerda(Node no){ //No sempre vai ter filho direito se não não tem FB desbalanceado
        Node novoRoot = no.filhoDireita;
        Node antigoEsquerdo = no.filhoDireita.filhoEsquerda;
        Node antigoPaiRoot = no.pai;
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
        if (no == theRoot()) root = novoRoot; //Se o nó era o root eu tenho que definir e não uma subarvore eu tenho que definir o novo root
    }

    public void rotacaoDireita(Node no){
        Node novoRoot = no.filhoEsquerda;
        Node antigoDireito = no.filhoEsquerda.filhoDireita;
        Node antigoPaiRoot = no.pai;
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
        if (no == theRoot()) root = novoRoot; //Se o nó era o root eu tenho que definir e não uma subarvore eu tenho que definir o novo root
    }

    public void rotacaoDuplaEsquerda(Node no){
        rotacaoDireita(no.filhoDireita);
        //Filho direita do nó é A e o filho da direita do filho da direita é o B
        //Como tem duas rotações preciso usar a formula duas vezes uma para a direita e a outra para a esquerda
        no.filhoDireita.filhoDireita.fb = no.filhoDireita.filhoDireita.fb - 1 - Math.max(no.filhoDireita.fb, 0);
        no.filhoDireita.fb = no.filhoDireita.fb - 1 + Math.min(no.filhoDireita.filhoDireita.fb, 0);
        rotacaoEsquerda(no);
    }

    public void rotacaoDuplaDireita(Node no){
        rotacaoEsquerda(no.filhoEsquerda);
        //Filho esquerda do nó é A e o filho da esquerda do filho da esquerda é o B
        no.filhoEsquerda.filhoEsquerda.fb = no.filhoEsquerda.filhoEsquerda.fb + 1 - Math.min(no.filhoEsquerda.fb, 0);
        no.filhoEsquerda.fb = no.filhoEsquerda.fb + 1 + Math.max(no.filhoEsquerda.filhoEsquerda.valor, 0);
        rotacaoDireita(no);
    }

    public void remove(int v) throws EArvoreAVL{
        Node no = buscar(v);
        if (no == null){
            throw new EArvoreAVL("Não existe esse elemento");
        }
        else{
            boolean direito = false;
            if (no.pai != null){
                if (no.pai.filhoDireita == no) direito = true; //Se ele for filho direito, isso vai ajudar na função de atualizar
            }
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
                if (no.filhoDireita.filhoEsquerda == null){ //Se o nó que vai substituir é o filho direito do root
                    no.filhoDireita = null;
                    direito = true; //Pois caso o root seja substituido pelo seu filho direito eu só somo +1 pois o lado direito é diminuido
                } 
                else {
                    p.pai.filhoEsquerda = null;
                    direito = false;
                }
                no.valor = p.valor; 
                if (no.pai == null) root = no; //Se ele não tem pai é root
                no = p; //Pois caso eu remova o root o que tenho que partir atualizando a partir do que removi
            }
            int incremento = 1;
            if (!direito && no != theRoot()) incremento = -1; 
            if (direito && no != theRoot() && no.pai.filhoDireita == null && no.pai.fb == 0) no.pai.fb += 1; //Caso eu apague um filho direito mas ele ainda tem um filho esquerdo que a altura também é 1 ai não faz diferença para o pai
            else if (!direito && no != theRoot() && no.pai.filhoEsquerda == null && no.pai.fb == 0) no.pai.fb -= 1;
            else{
                if (no != theRoot()) atualizarFB(no.pai, incremento, "remove");
                else{
                    if (no.filhoDireita == null && no.filhoEsquerda == null) atualizarFB(no, 0, "remove");
                    else atualizarFB(no, incremento, "remove");
                }
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

    
    // public int depth(Node no){
    //     if (no == theRoot()) return 0;
    //     else return 1 + depth(no.getPai());
    // }

    // public int height(Node no){
    //     if (isExternal(no)) return 0;
    //     else{
    //         int cont = 0;
    //         if (no.filhoDireita == null) cont += Math.max(cont, height(no.filhoEsquerda));
    //         else if (no.filhoEsquerda == null) cont += Math.max(cont, height(no.filhoDireita));
    //         else cont += Math.max(cont, (Math.max(height(no.filhoDireita), height(no.filhoEsquerda))));
    //         return 1 + cont;
    //     }
    // }

}