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
		BancoDados.addAdm(new Administrador("Jo�o", "joao", "joao@admin.com", "joao"));
		BancoDados.addAdm(new Administrador("Maria", "maria", "maria@admin.com", "maria"));
		BancoDados.addAdm(new Administrador("Ana", "ana", "ana@admin.com", "ana"));
		BancoDados.addAdm(new Administrador("Jos�", "jose", "jose@admin.com", "jose"));
		BancoDados.addAnims(new Animal(1, "Bob", "Vira-lata", "Macho", 5, 7, "Sem descri��o", "1.png"));
		BancoDados.addAnims(new Animal(2, "Ralf", "Vira-lata", "Macho", 4, 8, "Sem descri��o", "2.png"));
		BancoDados.addAnims(new Animal(3, "Bilu", "Vira-lata", "Macho", 3, 9, "Sem descri��o", "3.png"));
		BancoDados.addAnims(new Animal(4, "Bingo", "Vira-lata", "Macho", 2, 6, "Sem descri��o", "4.png"));
		BancoDados.addAnims(new Animal(5, "Gel�ia", "Vira-lata", "Macho",1, 5, "Sem descri��o", "5.png"));
		BancoDados.addAnims(new Animal(6, "Bela", "Vira-lata", "F�mea", 5, 4, "Sem descri��o", "6.png"));
		BancoDados.addAnims(new Animal(7, "Cacau", "Vira-lata", "F�mea", 4, 4, "Sem descri��o", "7.png"));
		BancoDados.addAnims(new Animal(8, "Cendy", "Vira-lata", "F�mea", 3, 6, "Sem descri��o", "8.png"));
		BancoDados.addAnims(new Animal(9, "Mabel", "Vira-lata", "F�mea", 2, 12, "Sem descri��o", "9.png"));
		BancoDados.addAnims(new Animal(10, "Madona", "Vira-lata", "F�mea", 1, 10, "Sem descri��o", "10.png"));

		TelaInicial telaInicio = new TelaInicial();
	}

}
