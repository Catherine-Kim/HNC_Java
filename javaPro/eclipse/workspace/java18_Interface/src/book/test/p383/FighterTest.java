package book.test.p383;

class Unit{
	int currentHP;
	int x;
	int y;
	
	Unit(){};
	
	Unit(int currentHP, int x, int y){
		this.currentHP = currentHP;
		this.x = x;
		this.y = y;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
}

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attack(int damage);
}

interface Fightable extends Movable, Attackable{ }

class Fighter extends Unit implements Fightable{
	Fighter(int currentHP, int x, int y){
		super(currentHP, x, y);
	}
	
	@Override
	public void move(int x, int y) {
		setX(getX() + x);
		setY(getY() + y);
		System.out.println("���� ��ġ�� (" + getX() + ", " + getY() + ") �Դϴ�.");
	}
	
	@Override
	public void attack(int damage) {
		setCurrentHP(getCurrentHP() - damage);
		System.out.println("������ " + damage +" �������� �������ϴ�.");
	}
}

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter(200, 0, 0);
		
		if(f instanceof Unit)
			System.out.println("Fighter�� Unit�� �ڼ���");
		if(f instanceof Fightable)
			System.out.println("Fighter�� Fightable �������̽��� ��������");
		if(f instanceof Movable)
			System.out.println("Fighter�� Movable �������̽��� ��������");
		if(f instanceof Attackable)
			System.out.println("Fighter�� Attackable �������̽��� ��������");
		if(f instanceof Object)
			System.out.println("Fighter�� Object�� �ڼ���");
		
		System.out.println("\n");
		f.move(55, 20);
		f.attack(150);
	}
}
