package nl.suriani.fpjava1.lib;

public class Optional {
	private Object value;

	private Optional(Object value) {
		this.value = value;
	}

	public static Optional of(Object value) {
		return new Optional(value);
	}

	public boolean isPresent() {
		return value != null;
	}

	public Object get() {
		return value;
	}

	public LinkedList toLinkedList() {
		return new LinkedList(new Node(value));
	}
}
