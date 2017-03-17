package pizza.service;

import java.util.Vector;

import pizza.parent.Pizza;

public class PizzaService {
	public void allPizzaMake(Vector<Pizza> pizzaList){
		for(int i = 0; i < pizzaList.size(); i++){
			Pizza pizza = pizzaList.get(i);
			pizza.makePizza();
			System.out.println("-------------------------------------------------------");
	
		}
	}
}
