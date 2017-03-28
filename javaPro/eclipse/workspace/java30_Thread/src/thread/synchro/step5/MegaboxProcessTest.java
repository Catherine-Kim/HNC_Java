package thread.synchro.step5;

class MegaBoxUser implements Runnable {
	private boolean seat = false; // 예매 전

	@Override
	public void run() {
		// MegaBox user가 하는 일 : 공용으로 제공되고 있는 좌석을 예매
		try {
			reserve();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 해당 클래스에서 이 메소드를 호출하기 때문에 private을 붙임
	// private이 붙어있다는 것은 이 메소드가 근처 어딘가에서 호출된다는 것
	private synchronized void reserve() throws InterruptedException {
		// 1. 예매하는 기능을 하는 쓰레드의 이름을 직접 리턴
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + "님이 예매하러 오셨습니다.");

		// 2. 좌석이 비었다면 예매를 한다.
		synchronized (this) {
			if (!seat) {
				Thread.sleep(2000);
				System.out.println(threadName + "님의 좌석 예매가 성공적으로 이루어졌습니다.");
				seat = true;
			} else {
				System.out.println("이미 선택된 좌석입니다. 다른 좌석을 찾으시지");
			}
		}
	}
}

public class MegaboxProcessTest {
	public static void main(String[] args) {
		MegaBoxUser user = new MegaBoxUser();
		Thread t1 = new Thread(user, "User1"); // Thread를 생성할 때, 이름도 같이 넣을 수 있음
		Thread t2 = new Thread(user, "User2");

		t1.start();
		t2.start();
	}
}
