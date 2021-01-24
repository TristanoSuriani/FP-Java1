package nl.suriani.fpjava1.lib;

public class LinkedList {
	private Node first;

	public LinkedList(Node first) {
		this.first = first;
	}

	public static LinkedList append(Object value, LinkedList linkedList) {
		if (linkedList.isEmpty()) {
			return new LinkedList(new Node(value));
		} else if (linkedList.rest().isEmpty()) {
			return list(linkedList.first.getValue(), value);
		} else {
			return cons(linkedList.first(),
					append(value, linkedList.rest()));
		}
	}

	public LinkedList append(Object value) {
		return append(value, this);
	}

	public static LinkedList empty() {
		return new LinkedList(null);
	}

	public static LinkedList copy(LinkedList linkedList) {
		if (linkedList.isEmpty()) {
			return empty();
		} else {
			return cons(linkedList.first(), linkedList.rest());
		}
	}

	public Node first() {
		return first;
	}

	public LinkedList rest() {
		if (isEmpty()) {
			return empty();
		} else {
			return new LinkedList(first.getNext());
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public static LinkedList cons(Node first, LinkedList rest) {
		if (first == null) {
			return rest;
		} else {
			return new LinkedList(new Node(first.getValue(), rest.first()));
		}
	}

	public static LinkedList list(Object o1, Object o2) {
		return cons(new Node(o1), new LinkedList(new Node(o2)));
	}

	public int length() {
		if (isEmpty()) {
			return 0;
		} else {
			return 1 + rest().length();
		}
	}
}
