package app;

import javax.swing.ImageIcon;

import model.Administrador;
import model.Adocao;
import model.Animal;
import model.BancoDados;
import model.Candidato;
import model.Endereco;
import view.ListaCandidatos;
import view.Menu;
import view.TelaInicial;

public class App {

	public static void main(String[] args) {

		BancoDados.addAdm(new Administrador("Admin", "admin", "a@admin.com", "admin"));
		BancoDados.addAdm(new Administrador("Jo�o", "joao", "joao@admin.com", "joao"));
		BancoDados.addAdm(new Administrador("Maria", "maria", "maria@admin.com", "maria"));
		BancoDados.addAdm(new Administrador("Ana", "ana", "ana@admin.com", "ana"));
		BancoDados.addAdm(new Administrador("Jos�", "jose", "jose@admin.com", "jose"));

		BancoDados.addAnims(
				new Animal(1, "Bob", "Vira-lata", "Macho", 5, 7, "Sem descri��o", new ImageIcon("resource/1.png")));
		BancoDados.addAnims(
				new Animal(2, "Ralf", "Vira-lata", "Macho", 4, 8, "Sem descri��o", new ImageIcon("resource/2.png")));
		BancoDados.addAnims(
				new Animal(3, "Bilu", "Vira-lata", "Macho", 3, 9, "Sem descri��o", new ImageIcon("resource/3.png")));
		BancoDados.addAnims(
				new Animal(4, "Bingo", "Vira-lata", "Macho", 2, 6, "Sem descri��o", new ImageIcon("resource/4.png")));
		BancoDados.addAnims(
				new Animal(5, "Gel�ia", "Vira-lata", "Macho", 1, 5, "Sem descri��o", new ImageIcon("resource/5.png")));
		BancoDados.addAnims(
				new Animal(6, "Bela", "Vira-lata", "F�mea", 5, 4, "Sem descri��o", new ImageIcon("resource/6.png")));
		BancoDados.addAnims(
				new Animal(7, "Cacau", "Vira-lata", "F�mea", 4, 4, "Sem descri��o", new ImageIcon("resource/7.png")));
		BancoDados.addAnims(
				new Animal(8, "Cendy", "Vira-lata", "F�mea", 3, 6, "Sem descri��o", new ImageIcon("resource/8.png")));
		BancoDados.addAnims(
				new Animal(9, "Mabel", "Vira-lata", "F�mea", 2, 12, "Sem descri��o", new ImageIcon("resource/9.png")));
		BancoDados.addAnims(new Animal(10, "Madona", "Vira-lata", "F�mea", 1, 10, "Sem descri��o",
				new ImageIcon("resource/10.png")));

		BancoDados.candidatos.add(new Candidato("Danilo", "11111111111", "danilo@", "081993242124",
				new Endereco("31 de Mar�o", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("Breno", "22222222222", "daniloMatheus@", "081998128449",
				new Endereco("31 de Mar�o", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("Jo�o", "33333333333", "daniloMatheus@", "081998128449",
				new Endereco("31 de Mar�o", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("Daniel", "44444444444", "daniloMatheus@", "081998128449",
				new Endereco("31 de Mar�o", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("Matheus", "55555555555", "daniloMatheus@", "081998128449",
				new Endereco("31 de Mar�o", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));

		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(0), BancoDados.candidatos.get(0)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(1), BancoDados.candidatos.get(1)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(2), BancoDados.candidatos.get(2)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(3), BancoDados.candidatos.get(3)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(4), BancoDados.candidatos.get(4)));
		TelaInicial telaInicio = new TelaInicial();
		ListaCandidatos listCand = new ListaCandidatos();
		listCand.setVisible(true);
	}

}
