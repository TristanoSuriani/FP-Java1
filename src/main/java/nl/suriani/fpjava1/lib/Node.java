package nl.suriani.fpjava1.lib;

public class Node {
	private Object value;
	private Node next;

	public Node(Node other) {
		this.value = other.getValue();
		this.next = other.getNext();
	}

	public Node(Object value, Node next) {
		this.value = value;
		this.next = next;
	}

	public Node(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
