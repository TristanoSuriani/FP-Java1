package nl.suriani.fpjava1.app.functions;

import nl.suriani.fpjava1.lib.Consumer;

public class PrintConsumer implements Consumer {
	@Override
	public void consume(Object object) {
		System.out.println(object);
	}
}
