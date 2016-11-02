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
		BancoDados.addAnims(new Animal(1, "Bob", "Vira-lata", "Macho", 5, 7, "Sem descrição", "1.png"));
		BancoDados.addAnims(new Animal(2, "Ralf", "Vira-lata", "Macho", 4, 8, "Sem descrição", "2.png"));
		BancoDados.addAnims(new Animal(3, "Bilu", "Vira-lata", "Macho", 3, 9, "Sem descrição", "3.png"));
		BancoDados.addAnims(new Animal(4, "Bingo", "Vira-lata", "Macho", 2, 6, "Sem descrição", "4.png"));
		BancoDados.addAnims(new Animal(5, "Geléia", "Vira-lata", "Macho",1, 5, "Sem descrição", "5.png"));
		BancoDados.addAnims(new Animal(6, "Bela", "Vira-lata", "Fêmea", 5, 4, "Sem descrição", "6.png"));
		BancoDados.addAnims(new Animal(7, "Cacau", "Vira-lata", "Fêmea", 4, 4, "Sem descrição", "7.png"));
		BancoDados.addAnims(new Animal(8, "Cendy", "Vira-lata", "Fêmea", 3, 6, "Sem descrição", "8.png"));
		BancoDados.addAnims(new Animal(9, "Mabel", "Vira-lata", "Fêmea", 2, 12, "Sem descrição", "9.png"));
		BancoDados.addAnims(new Animal(10, "Madona", "Vira-lata", "Fêmea", 1, 10, "Sem descrição", "10.png"));

		TelaInicial telaInicio = new TelaInicial();
	}

}
