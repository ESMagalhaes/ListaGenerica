package esmagalhaes.fateczl.edu.lista;

public class Node<T> {
	T dado;
	Node<T> proximo;

	public Node(T dado) {
		this.dado = dado;
		this.proximo = null;
	}
}