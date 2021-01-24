package nl.suriani.fpjava1.lib;

public class F {
	public static LinkedList map (Function function, LinkedList linkedList) {
		if (linkedList.isEmpty()) {
			return linkedList;
		} else {
			return new LinkedList(
					new Node(function.apply(linkedList.first().getValue()),
						map(function, linkedList.rest()).first()));
		}
	}

	public static void forEach(Consumer consumer, LinkedList linkedList) {
		if (!linkedList.isEmpty()) {
			consumer.consume(linkedList.first().getValue());
			forEach(consumer, linkedList.rest());
		}
	}

	public static LinkedList filter(Predicate predicate, LinkedList linkedList) {
		if (linkedList.isEmpty()) {
			return linkedList;
		} else {
			return LinkedList.cons((predicate.test(linkedList.first().getValue()) ?
						new Node(linkedList.first().getValue()) :
						null),
					filter(predicate, linkedList.rest()));
		}
	}

	public static Object reduce(Object identity, BiFunction function, LinkedList linkedList) {
		if (linkedList.isEmpty()) {
			return identity;
		} else {
			return reduce(function.apply(identity, linkedList.first().getValue()),
					function,
					linkedList.rest());
		}
	}
}
