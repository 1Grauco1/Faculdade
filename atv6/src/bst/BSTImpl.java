package bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTImpl implements BST_IF {
	
	private Node root; //nó raiz
	
	public BSTImpl() {

	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	// ALTURA
	@Override
	public int height() {
		return height(root);
	}

	private int height(Node no){
		return no == null ? 0 : no.getHeight();
	}

	private int getBalance(Node no){
		return no == null ? 0 : height(no.getLeft()) - height(no.getRight());
	}

	private void updateHeight(Node no){
		no.setHeight(1 + Math.max(height(no.getLeft()), height(no.getRight())));
	}

	// ROTAÇÕES
	private Node rotateRight(Node y){
		Node x= y.getLeft();
		Node pivot= x.getRight();

		x.setRight(y);
		y.setLeft(pivot);

		updateHeight(y);
		updateHeight(x);

		return x;
	}

	private Node rotateLeft(Node x){
		Node y= x.getRight();
		Node pivot= y.getLeft();

		y.setLeft(x);
		x.setRight(y);

		updateHeight(x);
		updateHeight(y);

		return y;
	}

	private Node rebalance(Node no){
		int balance= getBalance(no);
		if(balance > 1){
			if(getBalance(no.getLeft()) < 0){
				no.setLeft(rotateLeft(no.getLeft())); //caso LR
			}
			return rotateRight(no); //caso LL
		}

		if(balance < -1){
			if(getBalance(no.getRight()) > 0){
				no.setRight(rotateRight(no.getRight())); // caso RL
			}
			return rotateLeft(no); // caso RR
		}

		return no;
	}

	// PADRÃO

	@Override
	public Node search(Integer value) {
		return searchRecursive(root, value);
	}

	private Node searchRecursive(Node no, int value){
		if(no == null || no.getValue() == value) return no;

		if(value < no.getValue()){
			return searchRecursive(no.getLeft(), value);
		}
		else{
			return searchRecursive(no.getRight(), value);
		}
	}
	@Override
	public void insert(Integer value) {
		root= insertRecursive(root, value);
	}

	private Node insertRecursive(Node no, int value){
		if(no == null) return new Node(value);

		if(value < no.getValue()){
			no.setLeft(insertRecursive(no.getLeft(), value));
		}else if(value > no.getValue()){
			no.setRight(insertRecursive(no.getRight(), value));
		}
		else return no;

		updateHeight(no);
		return rebalance(no);
	}

	@Override
	public Node maximum(Node node) {
		if(node == null) return null;
		while(node.getRight() != null){
			node= node.getRight();
		}
		return node;
	}

	@Override
	public Node minimum(Node node) {
		if(node == null) return null;
		while(node.getLeft() != null){
			node= node.getLeft();
		}
		return node;
	}

	@Override
	public Node predecessor(Node node) {
		if (node.getLeft() != null)
			return maximum(node.getLeft());

		Node p = root;
		Node pred = null;
		while (p != null) {
			if (node.getValue() > p.getValue()) {
				pred = p;
				p = p.getRight();
			} else {
				p = p.getLeft();
			}
		}
		return pred;
	}

	@Override
	public Node sucessor(Node node) {
		if (node.getRight() != null)
			return minimum(node.getRight());

		Node p = root;
		Node succ = null;
		while (p != null) {
			if (node.getValue() < p.getValue()) {
				succ = p;
				p = p.getLeft();
			} else {
				p = p.getRight();
			}
		}
		return succ;
	}

	@Override
	public void remove(Integer value) {
		root = removeRecursive(root, value);
	}

	private Node removeRecursive(Node no, int value) {
		if (no == null) return null;

		if (value < no.getValue()) {
			no.setLeft(removeRecursive(no.getLeft(), value));
		}else if (value > no.getValue()) {
			no.setRight(removeRecursive(no.getRight(), value));
		}
		else {
			// Um ou nenhum filho
			if (no.getLeft() == null)
				return no.getRight();
			else if (no.getRight() == null)
				return no.getLeft();

			Node temp = minimum(no.getRight());
			no.setRight(removeRecursive(no.getRight(), temp.getValue()));
		}

		updateHeight(no);
		return rebalance(no);
	}


	//Percusos

	@Override
	public Integer[] preOrder() {
		List<Integer> list = new ArrayList<>();
		preOrder(root, list);
		return list.toArray(new Integer[0]);
	}

	private void preOrder(Node node, List<Integer> list) {
		if (node != null) {
			list.add(node.getValue());
			preOrder(node.getLeft(), list);
			preOrder(node.getRight(), list);
		}
	}

	@Override
	public Integer[] order() {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		return list.toArray(new Integer[0]);
	}

	private void inOrder(Node node, List<Integer> list) {
		if (node != null) {
			inOrder(node.getLeft(), list);
			list.add(node.getValue());
			inOrder(node.getRight(), list);
		}
	}

	@Override
	public Integer[] postOrder() {
		List<Integer> list = new ArrayList<>();
		postOrder(root, list);
		return list.toArray(new Integer[0]);
	}

	private void postOrder(Node node, List<Integer> list) {
		if (node != null) {
			postOrder(node.getLeft(), list);
			postOrder(node.getRight(), list);
			list.add(node.getValue());
		}
	}

	@Override
	public int size() {
		return sizeRecursive(root);
	}

	private int sizeRecursive(Node node) {
		if (node == null)
			return 0;
		return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
	}
	
	/**
	 * Método de brinde! Não modificar!
	 * Este método implementa uma busca em largura usando uma fila.
	 * @return
	 */
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Node> queue = new LinkedList<Node>();
        
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                
                list.add(current.getValue());
                
                if(current.getLeft() != null) 
                    queue.addLast(current.getLeft());
                if(current.getRight() != null) 
                    queue.addLast(current.getRight());   
            }
        }
        return list;
    }

}
