package kosta.product.service.audio;

import kosta.product.service.Player;

public class AudioImpl implements Player{


	@Override
	public void start(int volume) {
		System.out.println("[Audio] start() with volume" + volume + " from AudioImpl");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		System.out.println("[Audio] stop() from AudioImpl");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int pause() {
		System.out.println("[Audio] pause() from AudioImpl");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
