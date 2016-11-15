package tests;

import model.Adocao;
import model.BancoDados;

public class TestAdocao {
	
	public static void AdocaoString() {		
		try {
			Adocao adocao = BancoDados.adocoes.get(0);
			System.out.println(adocao.toString());
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
}
