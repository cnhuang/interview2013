package ds;

public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> parent;

	public static <T> Node<T> Create(T[] datum) {

		Node<T> head = null;
		Node<T> node = null;
		Node<T> next = null;

		for (T data : datum) {
			next = new Node<T>(data);
			if (node != null)
				node.next = next;
			else
				head = next;
			node = next;
		}

		return head;
	}

	public Node(T data) {
		this.data = data;
	}

	public Node() {
	}

	public String toString() {
		String str = String.valueOf(data);

		if (next != null) {
			str += "->" + next.toString();
		}

		return str;
	}
}
