package tests;

import view.CadastroCandidato;

public class TestCadastroCandidato {

	public static void TestRetChars() {
		try {
			CadastroCandidato cc = new CadastroCandidato();
			cc.retiraCaracteres("111");
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
}
