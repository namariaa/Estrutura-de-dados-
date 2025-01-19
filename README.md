# Estrutura de dados lineares
Esse repositório foi criado com o objetivo de armazenar e documentar os códigos feitos na disciplina de estrutura de dados do terceiro período do curso.

## Fila de prioridade 
Armazena um par chave-valor (chave é onde ele deve ser inserido, ou seja, a prioridade dele que é definida a depender da necessidade).
- Comparador: Garante que os elementos sejam implementados de acordo com suas prioridades. em suma, ele serve para saber o exato local onde deve ser inserido o novo elementos
- Ordenação com fila de prioridade: Basicamente o método retira todos os elementos de S retirando sempre o primeiro e vai inserindo em P, posteirormente ao S ficar sem elementos ele reorganiza em S os elmentos de P removnedo o de menor chave e inserido por último em S.
  Ex: S = {3 , 1, 2} e P = {} --> S = {} e P = {1, 2 , 3} --> S = {1,2,3} e P = {}. Para saber aonde inserir em P é necessário levar em consideração o comparador.
OBS: Quando implementamos um insert e remove com a sequência ordenada ou não seu desempenho se altera. Enquanto, com uma sequência não ordenada a inserção é O(1) e o removeMin e min executam em O(N) pois precisa percorrer toda a sequência para encontrar a menor chave e com ele em sequência é ao contrário

Para a implementação da fila de prioridade será utilizado a **heap** que é uma árvore binária na qual a chave do pai deve ser menor que a chave dos filhos e os valores devem ser inseridos da esquerda para a direita 
  
