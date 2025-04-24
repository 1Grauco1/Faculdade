import java.util.ArrayList;
import java.util.List;

public class LinkedList implements LinkedList_IF {
	private No head;    // Referência para o primeiro nó
	private No tail;    // Referência para o último nó
	private int size;   // Contador de elementos

	// Construtor - inicializa lista vazia
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// Verifica se lista está vazia
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	// Retorna tamanho da lista
	@Override
	public int size() {
		return size;
	}

	// Busca elemento na lista
	@Override
	public No search(Integer elemento) {
		No aux = head;
		while (aux != null) {
			if (aux.getDado().equals(elemento)) {
				return aux;
			}
			aux = aux.proxNo;
		}
		return null;
	}

	// Insere elemento mantendo ordenação
	@Override
	public void insert(Integer novoElemento) {
		No novoNo = new No(novoElemento);

		if (isEmpty()) {
			head = novoNo;
			tail = novoNo;
		} else if(novoElemento <= head.getDado()) {
			novoNo.proxNo = head;
			head.antNo = novoNo;
			head = novoNo;
		} else if(novoElemento >= tail.getDado()) {
			novoNo.antNo = tail;
			tail.proxNo = novoNo;
			tail = novoNo;
		} else {
			No aux = head;
			while (aux != null && aux.getDado() < novoElemento) {
				aux = aux.proxNo;
			}
			novoNo.proxNo = aux;
			novoNo.antNo = aux.antNo;
			aux.antNo.proxNo = novoNo;
			aux.antNo = novoNo;
		}
		size++;
	}

	// Remove elemento específico
	@Override
	public void remove(Integer elemento) {
		if (isEmpty()) return;

		No aux = head;
		while (aux != null && !aux.getDado().equals(elemento)) {
			aux = aux.proxNo;
		}

		if (aux == null) return;

		if (aux == head) {
			removeInicio();
		} else if (aux == tail) {
			removeFinal();
		} else {
			aux.antNo.proxNo = aux.proxNo;
			aux.proxNo.antNo = aux.antNo;
		}
		size--;
	}

	// Remove primeiro elemento
	@Override
	public void removeInicio() {
		if (isEmpty()) return;

		No removed = head;
		head = head.proxNo;
		if (head != null) {
			head.antNo = null;
		} else {
			tail = null;
		}
		removed.proxNo = null;
		size--;
	}

	// Remove último elemento
	@Override
	public void removeFinal() {
		if (isEmpty()) return;

		No removed = tail;
		tail = tail.antNo;
		if (tail != null) {
			tail.proxNo = null;
		} else {
			head = null;
		}
		removed.antNo = null;
		size--;
	}

	// Converte lista para array
	@Override
	public No[] toArray() {
		No[] array = new No[size];
		No aux = head;
		int i = 0;
		while (aux != null) {
			array[i++] = aux;
			aux = aux.proxNo;
		}
		return array;
	}

	// Imprime elementos
	public void printL() {
		No aux = head;
		while (aux != null) {
			System.out.println(aux.getDado());
			aux = aux.proxNo;
		}
	}

	// Remove última ocorrência de elemento
	public void removeLastOccurrence(Integer elemento) {
		No aux = tail;
		if(!isEmpty()) {
			while(aux != null && aux.getDado() != elemento) {
				aux = aux.antNo;
			}
			if (aux == null) return;

			if (aux == head) {
				removeInicio();
			} else if (aux == tail) {
				removeFinal();
			} else {
				aux.proxNo.antNo = aux.antNo;
				aux.antNo.proxNo = aux.proxNo;
				size--;
			}
		}
	}

	// Retorna maior elemento
	public int returnMaior() {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		int maior = head.getDado();
		No aux = head.proxNo;
		while (aux != null) {
			if (aux.getDado() > maior) {
				maior = aux.getDado();
			}
			aux = aux.proxNo;
		}
		return maior;
	}

	// Retorna menor elemento
	public int returnMenor() {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		int menor = head.getDado();
		No aux = head.proxNo;
		while (aux != null) {
			if (aux.getDado() < menor) {
				menor = aux.getDado();
			}
			aux = aux.proxNo;
		}
		return menor;
	}

	// Verifica duplicatas
	public boolean duplicatas() {
		No aux1 = head;
		while(aux1 != null && aux1.proxNo != null) {
			No aux2 = aux1.proxNo;
			while(aux2 != null) {
				if(aux2.getDado().equals(aux1.getDado())) {
					return true;
				}
				aux2 = aux2.proxNo;
			}
			aux1 = aux1.proxNo;
		}
		return false;
	}

	// Retorna elementos em ordem inversa
	public List<Integer> percorreInverso() {
		List<Integer> listaInversa = new ArrayList<>();
		No aux = tail;
		while (aux != null) {
			listaInversa.add(aux.getDado());
			aux = aux.antNo;
		}
		return listaInversa;
	}
}