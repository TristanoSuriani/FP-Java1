package nl.suriani.fpjava1.app;

import nl.suriani.fpjava1.app.functions.GreaterThan3;
import nl.suriani.fpjava1.app.functions.Max;
import nl.suriani.fpjava1.app.functions.PrintConsumer;
import nl.suriani.fpjava1.app.functions.Sum;
import nl.suriani.fpjava1.app.functions.Times2;
import nl.suriani.fpjava1.lib.BiFunction;
import nl.suriani.fpjava1.lib.Consumer;
import nl.suriani.fpjava1.lib.F;
import nl.suriani.fpjava1.lib.Function;
import nl.suriani.fpjava1.lib.LinkedList;
import nl.suriani.fpjava1.lib.Optional;
import nl.suriani.fpjava1.lib.Predicate;

public class App {
	public static void main(String[] args) {
		LinkedList linkedList = LinkedList.newEmptyList()
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

		// It sums every elements of the list (1 2 3)
		BiFunction sum = new Sum();
		Integer sumOfIntegers = (Integer) F.reduce(0, sum, linkedList);
		System.out.println(sumOfIntegers);
		// It prints 6

		// Find the max in an unordered list using reduce.
		LinkedList unorderedList = LinkedList.newEmptyList()
				.append(new Integer(15))
				.append(new Integer(1))
				.append(new Integer(3))
				.append(new Integer(2))
				.append(new Integer(16))
				.append(new Integer(18))
				.append(new Integer(2))
				.append(new Integer(2));

		BiFunction max = new Max();
		Integer biggestNumber = (Integer) F.reduce(Integer.MIN_VALUE, max, unorderedList);
		System.out.println(biggestNumber);

		if (biggestNumber != 18)
			throw new AssertionError();
		// It prints 18
	}
}
