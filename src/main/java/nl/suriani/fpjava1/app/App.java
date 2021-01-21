package nl.suriani.fpjava1.app;

import nl.suriani.fpjava1.app.functions.GreaterThan3;
import nl.suriani.fpjava1.app.functions.PrintConsumer;
import nl.suriani.fpjava1.app.functions.Times2;
import nl.suriani.fpjava1.lib.Consumer;
import nl.suriani.fpjava1.lib.F;
import nl.suriani.fpjava1.lib.Function;
import nl.suriani.fpjava1.lib.LinkedList;
import nl.suriani.fpjava1.lib.Optional;
import nl.suriani.fpjava1.lib.Predicate;

public class App {
	public static void main(String[] args) {
		LinkedList linkedList = LinkedList.empty()
				.append(new Integer(1))
				.append(new Integer(2))
				.append(new Integer(3));

		System.out.println(linkedList.length());
		// Prints: 3

		Function times2 = new Times2();
		Predicate greaterThan3 = new GreaterThan3();
		Consumer print = new PrintConsumer();

		// Print all the numbers greater than 3 which are the double of the numbers 1, 2, 3
		F.forEach(print,
				F.filter(greaterThan3,
						F.map(times2, linkedList)));
		// Prints: 4 6

		// Print a value (5) if not null and bigger than 3
		F.forEach(print,
				F.filter(greaterThan3,
					Optional.of(new Integer(5)).toLinkedList()));
		// Prints: 5

		// Print a value (3) if not null and bigger than 3
		F.forEach(print,
				F.filter(greaterThan3,
						Optional.of(new Integer(3)).toLinkedList()));
		// It doesn't print any value.
	}
}
