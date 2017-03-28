package thread.synchro.step5;

class MegaBoxUser implements Runnable {
	private boolean seat = false; // ���� ��

	@Override
	public void run() {
		// MegaBox user�� �ϴ� �� : �������� �����ǰ� �ִ� �¼��� ����
		try {
			reserve();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// �ش� Ŭ�������� �� �޼ҵ带 ȣ���ϱ� ������ private�� ����
	// private�� �پ��ִٴ� ���� �� �޼ҵ尡 ��ó ��򰡿��� ȣ��ȴٴ� ��
	private synchronized void reserve() throws InterruptedException {
		// 1. �����ϴ� ����� �ϴ� �������� �̸��� ���� ����
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + "���� �����Ϸ� ���̽��ϴ�.");

		// 2. �¼��� ����ٸ� ���Ÿ� �Ѵ�.
		synchronized (this) {
			if (!seat) {
				Thread.sleep(2000);
				System.out.println(threadName + "���� �¼� ���Ű� ���������� �̷�������ϴ�.");
				seat = true;
			} else {
				System.out.println("�̹� ���õ� �¼��Դϴ�. �ٸ� �¼��� ã������");
			}
		}
	}
}

public class MegaboxProcessTest {
	public static void main(String[] args) {
		MegaBoxUser user = new MegaBoxUser();
		Thread t1 = new Thread(user, "User1"); // Thread�� ������ ��, �̸��� ���� ���� �� ����
		Thread t2 = new Thread(user, "User2");

		t1.start();
		t2.start();
	}
}
