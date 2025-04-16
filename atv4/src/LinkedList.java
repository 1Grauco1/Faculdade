public class LinkedList implements LinkedList_IF {
	private No head;
	private No tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return size;
	}

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

	@Override
	public void insert(Integer novoElemento) {
		No novoNo = new No(novoElemento);

		if (isEmpty()) {
			head = novoNo;
			tail = novoNo;
		} else if (novoElemento <= head.getDado()) {
			novoNo.proxNo = head;
			head.antNo = novoNo;
			head = novoNo;
		} else if (novoElemento >= tail.getDado()) {
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
			size--;
		}
	}

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

	public void printL() {
		No aux = head;
		while (aux != null) {
			System.out.println(aux.getDado());
			aux = aux.proxNo;
		}
	}
}