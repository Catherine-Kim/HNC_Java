package kosta.product.service.tv;

import kosta.product.service.Player;

public class TVImpl implements Player{


	@Override
	public void start(int volume) {
		System.out.println("[TV] start() with volume" + volume + " from TVImpl");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		System.out.println("[TV] stop() from TVImpl");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int pause() {
		System.out.println("[TV] pause() from TVImpl");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
