package nl.suriani.fpjava1.app.functions;

import nl.suriani.fpjava1.lib.Predicate;

public class GreaterThan3 implements Predicate {
	@Override
	public boolean test(Object object) {
		if (object instanceof Integer) {
			return (Integer) object > 3;
		} else throw new UnsupportedOperationException("Only for integers, sorry");
	}
}
