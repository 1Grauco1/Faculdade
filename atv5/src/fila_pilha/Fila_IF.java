package fila_pilha;

public interface Fila_IF {
	public void enqueue(Integer novoElemento);
	public Integer dequeue();
    public boolean isEmpty();
    public boolean isFull();
    public Integer peek();
    public Integer[] toArray();
}
