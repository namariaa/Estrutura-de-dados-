# Estruturas de Dados e Estruturas Não Lineares
Este repositório reúne implementações desenvolvidas ao longo das disciplinas de Estrutura de Dados e Estruturas de Dados Não Lineares. O objetivo principal é consolidar o aprendizado por meio da prática, explorando diferentes abordagens e paradigmas para estruturas fundamentais da computação.

As implementações foram realizadas com foco didático, buscando refletir os conceitos teóricos abordados em sala de aula. Embora algumas estruturas não estejam completamente otimizadas ou finalizadas, todas funcionam de maneira satisfatória dentro dos limites propostos e oferecem uma base sólida para estudos futuros e aprimoramentos.

## Estruturas Implementadas
### Árvores
- Árvore Binária de Busca (BST): Implementação clássica com operações de inserção, remoção e busca.
- Árvore AVL: Estrutura balanceada com rotações automáticas para garantir altura logarítmica.
- Árvore Rubro-Negra (Red-Black Tree): Implementação baseada em propriedades de balanceamento por cores.
- Árvore B: Estrutura utilizada em sistemas de arquivos e bancos de dados, com múltiplos filhos por nó.
- Árvore Genérica: Estrutura base abstrata para construção de árvores especializadas, como a binária.

### Grafos
Representação por Lista de Adjacência Organização modular com separação em:

- Basics: inserção e remoção de vértices e arestas
- Utils: métodos utilitários
- Search: algoritmos de busca e caminhamento
- Exhibition: visualização e impressão
  
**Algoritmos de Caminhamento**
- Dijkstra
- A* (A-Star)
- BFS
- DFS

### Outras Estruturas
- Heap (com e sem array): Utilizado como base para fila de prioridade.
- Skip List: Estrutura probabilística com inserção eficiente.
- Tabela Hash: Implementação básica com tratamento de colisões.

#### **Observações**<br>
- Algumas estruturas estão em estágio experimental ou com funcionalidades limitadas.
- O foco principal foi a compreensão conceitual e a aplicação prática dos algoritmos.
- O código pode conter trechos que demandam refatoração ou melhorias de desempenho.

#### **Como Testar as Estruturas**
Para testar qualquer uma das estruturas implementadas, siga os passos abaixo:<br>

1. Clone o repositório Utilize o comando abaixo para clonar o projeto localmente:<br>
**git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/namariaa/Estrutura-de-dados-.git)**

2. Acesse o diretório da estrutura desejada Navegue até a pasta correspondente à estrutura que deseja testar. Por exemplo:<br>
**cd src/arvores/avl**

3. Compile o arquivo de teste Cada estrutura possui um arquivo Teste.java com exemplos de uso. Compile-o com:<br>
**javac Teste.java**
4. Execute o programa Após a compilação, execute o teste com:<br>
**java Teste** <br>
Esses arquivos de teste foram elaborados com o propósito de demonstrar o funcionamento básico das estruturas, permitindo observar inserções, buscas, remoções e outros comportamentos relevantes.
