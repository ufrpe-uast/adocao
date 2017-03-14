package tests;

import model.BancoDados;
import model.Candidato;

public class TestCandidato {

	public static void TestCandidato() {
		try {
			Candidato candid = BancoDados.candidatos.get(0);
			System.out.println(candid.toString());
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
}
