package tests;

import controller.ControllerAdministrador;
import model.Administrador;
import model.Endereco;
import view.CadastroAdministrador;

public class TestControllerAdm {
	public static void testAdmExiste() {
		CadastroAdministrador cca = new CadastroAdministrador();
		ControllerAdministrador ca = new ControllerAdministrador(cca);
		
		try {
			Endereco endereco = new Endereco("31 de Março", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464);
			ca.admExiste(new Administrador("111.111.111-11", "1.111.111", "Admin", "a@admin.com", "admin", "admin",
				"(81)9 9321-2428", endereco));
		} catch(AssertionError e) {
			e.printStackTrace();
		}
	}
}
