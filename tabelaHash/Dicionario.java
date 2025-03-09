package tabelaHash;

public class Dicionario {
   private int tamanho;
   private int [][] dicionario;
   private int capacidade;
   //Atributos

   public Dicionario(int n){
      this.tamanho = 0;
      this.capacidade = n;
      this.dicionario = new int[capacidade][2];
      for (int i = 0; i < capacidade; i++) {
         dicionario[i][0] = -1001; 
         dicionario[i][1] = -1001; 
     }
   }
   //Construtor

   public void increase(){
      int capacidadeAnterior = this.capacidade;
      this.capacidade *= 2;
      this.capacidade = primo(this.capacidade); //Para ser um número primo para ficar eficiente para o hashing duplo
      int [][] diciMaior = new int[capacidade][2];
      for (int i = 0; i < this.capacidade; i++) {
         diciMaior[i][0] = -1001; 
         diciMaior[i][1] = -1001; 
     }
      for (int i = 0; i < capacidadeAnterior; i++){
         if (dicionario[i][0] != -1001 && dicionario[i][0] != -1000){
            int pos = hashCode(dicionario[i][0]); 
            if (diciMaior[pos][0] != -1001) pos = hashingDuplo(dicionario[i][0]); //Hashing duplo
            while (diciMaior[pos][0] != -1001){
               pos = (pos + 1) % (this.capacidade - 1); //Array circular
            }  //Linear probing 
            // System.out.println("Nova posição: " + pos + " Elemento: " + dicionario[i][0] + " Cpacidade: " + this.capacidade);
            diciMaior[pos][0] = this.dicionario[i][0];
            diciMaior[pos][1] = this.dicionario[i][1];
         }
      }
      dicionario = diciMaior;
   }

   public int primo(int key){
      int cont = 1;
      while(true){
         for (int i = key / 2; i > 0; i--){
            if (key % i == 0) cont++;
         }
         if (cont == 2){
            return key;
         }
         else{
            cont = 1;
            key += 1;
         }
      }
   }

   public int hashCode(int key){ //Cria uma função de dispersão Função usada: ((a⋅k+b)modp)modN
      return ((3 * key + 42) % primo(key)) % this.capacidade;
   }

   public int hashingDuplo(int key){ //Função usada: (i + jd(k)) mod N
      return (2 + this.tamanho * hashCode(key)) % this.capacidade;
   }

   public int findElement(int key) throws EDicionarioVazio{ //se o dicionário tem um item com chave k, retorna o elemento, senão, retorna NO_SUCH_KEY
      int pos = hashCode(key); 
      if (this.dicionario[pos][0] != key) pos = hashingDuplo(key); //Hashing duplo
      int elementoInicial = this.dicionario[pos][0];
      int posInicial = pos;
      while (this.dicionario[pos][0] != key){
         pos = (pos + 1) % (this.capacidade - 1); //Array circular
         if (pos == posInicial && elementoInicial == this.dicionario[pos][0]) break; //Caso não exista ele para 
      }  //Linear probing 
      if (this.dicionario[pos][0] == key) return this.dicionario[pos][1];
      
      throw new EDicionarioVazio("NO_SUCH_KEY");
   }

   public void insertItem(int key, int valor){
      if ((double) this.tamanho / (double) this.capacidade > 0.5) increase();
      int pos = hashCode(key); 
      if (this.dicionario[pos][0] != key) { //Caso a mesma chave seja colocada para a mesma posição, evita repetição de key pois sobrescreve o valor
         this.tamanho++;
         if (this.dicionario[pos][0] != -1001 && this.dicionario[pos][0] != -1000) pos = hashingDuplo(key); //Hashing duplo
         while (this.dicionario[pos][0] != -1001 && this.dicionario[pos][0] != -1000){
            pos = (pos + 1) % (this.capacidade - 1); //Array circular
         }  //Linear probing 
      }
      this.dicionario[pos][0] = key;
      this.dicionario[pos][1] = valor;
      // System.out.println("pos:" + pos + " inserido: " + this.dicionario[pos][0] + " key: " + key);
   }

   public int removeElement(int key) throws EDicionarioVazio{ //Se existe um item com chave k, remove e retornasenão retorna NO_SUCH_KEY
      if (!isEmpty()){
         int find = findElement(key); //Ele mesmo lança a excessão se não existir
         int pos = hashCode(key); 
         if (this.dicionario[pos][0] != key) pos = hashingDuplo(key); //Hashing duplo
         while (this.dicionario[pos][0] != key){
            pos = (pos + 1) % (this.capacidade - 1); //Array circular
         }  //Linear probing 
         int antigo = this.dicionario[pos][1];
         this.dicionario[pos][0] = -1000;
         this.dicionario[pos][1] = -1000;
         this.tamanho--;
         return antigo;
      }
      else{
         throw new EDicionarioVazio("Array vazio");
      }
   }

   public int size(){
      return this.tamanho;
   }

   public boolean isEmpty(){
      return this.tamanho == 0;
   }

}
