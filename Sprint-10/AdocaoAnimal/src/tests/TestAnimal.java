package tests;

import model.Animal;
import model.BancoDados;

public class TestAnimal {

	public static void TestAnimal() {
		try {
			Animal animal = BancoDados.animais.get(0);
			System.out.println(animal.toString());
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
}
