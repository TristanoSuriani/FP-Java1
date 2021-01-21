package nl.suriani.fpjava1.app.functions;

import nl.suriani.fpjava1.lib.BiFunction;

public class Max implements BiFunction {
	@Override
	public Object apply(Object o1, Object o2) {
		if (!(o1 instanceof Integer && o2 instanceof Integer)) {
			throw new UnsupportedOperationException("Only for integers, sorry...");
		} else {
			if ((Integer) o1 > (Integer) o2) {
				return o1;
			} else {
				return o2;
			}
		}
	}
}
