package nl.suriani.fpjava1.app.functions;

import nl.suriani.fpjava1.lib.Function;

public class Times2 implements Function {
	@Override
	public Object apply(Object object) {
		if (object instanceof Integer) {
			return 2 * (Integer) object;
		}
		else throw new UnsupportedOperationException("Only for integers, sorry");
	}
}
