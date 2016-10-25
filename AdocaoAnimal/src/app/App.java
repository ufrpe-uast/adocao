package app;

import model.Administrador;
import model.Animal;
import model.BancoDados;
import view.Menu;
import view.TelaInicial;

public class App {

	public static void main(String[] args) {
		BancoDados.addAdm(new Administrador("Admin", "admin", "a@admin.com", "admin"));
		BancoDados.addAdm(new Administrador("João", "joao", "joao@admin.com", "joao"));
		BancoDados.addAdm(new Administrador("Maria", "maria", "maria@admin.com", "maria"));
		BancoDados.addAdm(new Administrador("Ana", "ana", "ana@admin.com", "ana"));
		BancoDados.addAdm(new Administrador("José", "jose", "jose@admin.com", "jose"));
		
		BancoDados.addAnims(new Animal(0, "Jacaré", "Pitbull", "Masculino", 18, 60, "Sem descrição"));
		BancoDados.addAnims(new Animal(1, "Pitu", "Vira-lata", "Masculino", 5, 20, "Sem descrição"));
		
		TelaInicial telaInicio = new TelaInicial();
	}
	
}
