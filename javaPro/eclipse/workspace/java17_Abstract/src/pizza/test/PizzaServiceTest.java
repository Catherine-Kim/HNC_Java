package pizza.test;

import java.util.Vector;

import pizza.child.BulgogiPizza;
import pizza.child.CheesePizza;
import pizza.child.PineApplePizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceTest {
	public static void main(String[] args) {
		PizzaService ps = new PizzaService();
		
		Vector<Pizza> manyPizza = new Vector<Pizza>(); // default size : 10
		
		manyPizza.add(new BulgogiPizza(27000, "Pizza Hut"));
		manyPizza.add(new PineApplePizza(15000, "Pizza Hut"));
		manyPizza.add(new CheesePizza(20000, "Pizza Hut"));
		manyPizza.add(new PotatoPizza(18000, "Pizza Hut"));
		manyPizza.add(new BulgogiPizza(16000, "Alvolo Pizza"));
		manyPizza.add(new CheesePizza(25000, "Alvolo Pizza"));
		manyPizza.add(new PotatoPizza(22000, "Alvolo Pizza"));
		manyPizza.add(new PineApplePizza(11000, "Alvolo Pizza"));
		
		System.out.println("Vector 안에 추가된 Pizza의 수 :: " + manyPizza.size());	// 4
		System.out.println("전체 Vector의 개수 :: " + manyPizza.capacity());			// 10
		System.out.println("Pizza Information :: " + manyPizza);					// toString()
		
		System.out.println("\nPizza들 정보 ::");
		ps.allPizzaMake(manyPizza);		
		
	}
}
