package tests;

import java.io.File;

import view.CadastroAnimal;

public class TestCadastroAnimal {

	public static void TestFile() {
		try {
			CadastroAnimal ca = new CadastroAnimal();
			ca.selectFile();
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

}
