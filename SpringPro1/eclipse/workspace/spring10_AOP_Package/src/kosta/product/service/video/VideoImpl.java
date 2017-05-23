package kosta.product.service.video;

import kosta.product.service.Player;

public class VideoImpl implements Player{


	@Override
	public void start(int volume) {
		System.out.println("[Video] start() with volume" + volume + " from VideoImpl");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		System.out.println("[Video] stop() from VideoImpl");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int pause() {
		System.out.println("[Video] pause() from VideoImpl");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
