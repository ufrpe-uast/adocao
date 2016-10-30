package app;

import model.Administrador;
import model.Animal;
import model.BancoDados;
import model.Candidato;
import model.Endereco;
import view.Menu;
import view.TelaInicial;

public class App {

	public static void main(String[] args) {
		BancoDados.addAdm(new Administrador("Admin", "admin", "a@admin.com", "admin"));
		BancoDados.addAdm(new Administrador("João", "joao", "joao@admin.com", "joao"));
		BancoDados.addAdm(new Administrador("Maria", "maria", "maria@admin.com", "maria"));
		BancoDados.addAdm(new Administrador("Ana", "ana", "ana@admin.com", "ana"));
		BancoDados.addAdm(new Administrador("José", "jose", "jose@admin.com", "jose"));
		
		BancoDados.addCand(new Candidato("Usuario", "11111111111",
				"dbsajk@gmail.com", "usuario", "usuario", "(11)1111111", 
				new Endereco("Rua aaa", "dhsak", "jdska", "jdsal", 
						"11111111", "PE", 10)));
		
		BancoDados.addAnims(new Animal(0, "Jacaré", "Pitbull", "Masculino", 18, 60, "Sem descrição"));
		BancoDados.addAnims(new Animal(1, "Pitu", "Vira-lata", "Masculino", 5, 20, "Sem descrição"));
		
		TelaInicial telaInicio = new TelaInicial();
	}
	
}
