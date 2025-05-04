package esmagalhaes.fateczl.edu.lista;

public class ListaGenerica<T> {
	private Node<T> primeiro;

	public ListaGenerica() {
		this.primeiro = null;
	}

	public boolean isEmpty() {
		return primeiro == null;
	}

	public int size() {
		int cont = 0;
		Node<T> aux = primeiro;
		while (aux != null) {
			cont++;
			aux = aux.proximo;
		}
		return cont;
	}

	public void addFirst(T valor) {
		Node<T> elemento = new Node<T>(valor);
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	public void addLast(T valor) throws Exception {
		if (isEmpty()) {
			addFirst(valor);
		} else {
			Node<T> elemento = new Node<>(valor);
			Node<T> ultimo = getNode(size() - 1);
			ultimo.proximo = elemento;
		}
	}

	public void addValor(T valor, int pos) throws Exception {
		if (pos < 0 || pos > size()) {
			throw new Exception("Posição inválida");
		}
		if (pos == 0) {
			addFirst(valor);
		} else if (pos == size()) {
			addLast(valor);
		} else {
			Node<T> elemento = new Node<>(valor);
			Node<T> anterior = getNode(pos - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	public void removeFirst() {
		if (isEmpty()) {
			throw new IllegalStateException("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new IllegalStateException("Lista Vazia");
		}
		if (size() == 1) {
			removeFirst();
		} else {
			Node<T> penultimo = getNode(size() - 2);
			penultimo.proximo = null;
		}
	}

	public void remove(int pos) throws Exception {
		if (isEmpty()) {
			throw new IllegalStateException("Lista Vazia");
		}
		if (pos < 0 || pos >= size()) {
			throw new IndexOutOfBoundsException("Posição inválida");
		}
		if (pos == 0) {
			removeFirst();
		} else {
			Node<T> anterior = getNode(pos - 1);
			Node<T> atual = anterior.proximo;
			anterior.proximo = atual.proximo;
		}
	}

	private Node<T> getNode(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		if (pos < 0 || pos >= size()) {
			throw new IndexOutOfBoundsException("Posição inválida");
		}
		Node<T> auxiliar = primeiro;
		for (int i = 0; i < pos; i++) {
			auxiliar = auxiliar.proximo;
		}
		return auxiliar;
	}

	public T get(int pos) throws Exception {
		return getNode(pos).dado;
	}

}
