package fila_pilha;

public class Fila implements Fila_IF{

	NoFila head;
	NoFila tail;
	private final int MAX_SIZE;
	int size;

	public Fila (int max_size) {
		this.MAX_SIZE = max_size;
		NoFila head= null;
    }

	//Adiciona um elemento na fila
	@Override
	public void enqueue(Integer novoElemento) {//adiciona elemento a fila
		NoFila novo = new NoFila(novoElemento);
		if(isEmpty()){
			head = tail = novo; //inicial e final da fila recebem o novo elemento
		}
		else {
			tail.proxNo= novo;
			tail= novo;//atualiza final da fila
		}
		size++;
	}

	@Override
	public Integer dequeue() { //retorna ee remove o primeiro elemento da fila
		if (isEmpty()) {
			throw new RuntimeException("Fila vazia");// exceção caso lista vazia
		}
		Integer dado = head.getDado();
		head = head.proxNo;

		if (head == null) { // se a fila == null após remoção
			tail = null; // final vazio
		}
		size--;
		return dado;
	}

	@Override
	public boolean isEmpty() {
		return head == null; // true ou false
	}

	@Override
	public boolean isFull() {
		return size == MAX_SIZE; // true ou false
	}

	@Override
	public Integer peek() {
		return head.getDado(); //retorna o primeiro elemento da fila
	}

	@Override
	public Integer[] toArray() {
		NoFila aux= head;
		Integer[] array = new Integer[size]; // cria array de inteiros
		for (int i = 0; i < size; i++) {
			array[i] = aux.getDado(); // armazena o item da fila na posição i do array
			aux = aux.proxNo; //atualiza pra prox posição
		}
		return array;
	}

	public void printF(){
		NoFila aux= head;
		for (int i = 0; i < size; i++) {
			System.out.print(aux.getDado() + " ");
			aux= aux.proxNo;
		}
	}
}
