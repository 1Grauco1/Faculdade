package fila_pilha;

public class Pilha implements Pilha_IF{

	NoPilha head;
	int max_size;
	int size;

	public Pilha(int max_size) {
		this.head= new NoPilha();
		this.max_size = max_size;
	}

	@Override
	public Integer pop() { // usado pra remover e retornar um item da lista (padrão= ultimo);
		if(isEmpty()) {
			throw new RuntimeException("Pilha vazia"); //Exceção caso pilha vazia
		}
		Integer dado= head.getDado(); //Armazena o dado
		head= head.proxNo; // Atualiza o topo
		size--; // Diminui o tamanho
		return dado;
	}

	//Adiciona um novo elemento
	@Override
	public void push(Integer novoElemento) {
		NoPilha novo= new NoPilha(novoElemento);
		novo.proxNo= head; // O novo nó aponta para o antigo topo
		head= novo; // Atualiza o topo para o novo nó
		size++;
	}

	//Verifica se a pilha está vazia;
	@Override
	public boolean isEmpty() {
        return head == null; // true ou false;
    }

	//Verifica se a pilha estpa cheia
	@Override
	public boolean isFull() {
		return size == max_size; // true ou false;
	}

	@Override
	public Integer top() {
		return head.getDado();//retorna o topo da lista
	}

	@Override
	public Integer[] toArray() {
		NoPilha aux= head; //aux recebe o topo
		Integer[] array= new Integer[size]; // Alocação do array de elementos
		for(int i= 0; i < size; i++){
			array[i]= aux.getDado(); // array[i] recebe elemento i da pilha
			aux= aux.proxNo; // Atualiza aux
		}
		return array;
	}

	public void printP(){
		NoPilha aux= head;
		for (int i = 0; i < size; i++) {
			System.out.println(aux.getDado() + " ");
			aux= aux.proxNo;
		}
	}

}
