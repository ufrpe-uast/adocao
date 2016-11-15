package app;

import javax.swing.ImageIcon;

import controller.ControllerAdministrador;
import model.Administrador;
import model.Adocao;
import model.Animal;
import model.BancoDados;
import model.Candidato;
import model.Endereco;
import tests.TestAdocao;
import tests.TestAnimal;
import tests.TestCadastroAnimal;
import tests.TestCadastroCandidato;
import tests.TestCandidato;
import tests.TestControllerAdm;
import view.ListaCandidatos;
import view.Menu;
import view.TelaInicial;

public class App {

	public static void main(String[] args) {

		Endereco endereco = new Endereco("31 de Março", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464);
		BancoDados.addAdm(new Administrador("111.111.111-11", "1.111.111", "Admin", "a@admin.com", "admin", "admin",
				"(81)9 9321-2428", endereco));
		BancoDados.addAdm(new Administrador("222.222.222-22", "1.111.111", "João", "joao@admin.com", "joao", "joao",
				"(81)9 9321-2428", endereco));
		BancoDados.addAdm(new Administrador("333.333.333-33", "1.111.111", "Maria", "maria@admin.com", "maria", "maria",
				"(81)9 9321-2428", endereco));
		BancoDados.addAdm(new Administrador("444.444.444-44", "1.111.111", "Ana", "ana@admin.com", "ana", "ana",
				"(81)9 9321-2428", endereco));
		BancoDados.addAdm(new Administrador("555.555.555-55", "1.111.111", "José", "jose@admin.com", "jose", "jose",
				"(81)9 9321-2428", endereco));

		BancoDados.addAnims(
				new Animal(1, "Bob", "Vira-lata", "Macho", 5, 7, "Sem descrição", new ImageIcon("resource/1.png")));
		BancoDados.addAnims(
				new Animal(2, "Ralf", "Vira-lata", "Macho", 4, 8, "Sem descrição", new ImageIcon("resource/2.png")));
		BancoDados.addAnims(
				new Animal(3, "Bilu", "Vira-lata", "Macho", 3, 9, "Sem descrição", new ImageIcon("resource/3.png")));
		BancoDados.addAnims(
				new Animal(4, "Bingo", "Vira-lata", "Macho", 2, 6, "Sem descrição", new ImageIcon("resource/4.png")));
		BancoDados.addAnims(
				new Animal(5, "Geléia", "Vira-lata", "Macho", 1, 5, "Sem descrição", new ImageIcon("resource/5.png")));
		BancoDados.addAnims(
				new Animal(6, "Bela", "Vira-lata", "Fêmea", 5, 4, "Sem descrição", new ImageIcon("resource/6.png")));
		BancoDados.addAnims(
				new Animal(7, "Cacau", "Vira-lata", "Fêmea", 4, 4, "Sem descrição", new ImageIcon("resource/7.png")));
		BancoDados.addAnims(
				new Animal(8, "Cendy", "Vira-lata", "Fêmea", 3, 6, "Sem descrição", new ImageIcon("resource/8.png")));
		BancoDados.addAnims(
				new Animal(9, "Mabel", "Vira-lata", "Fêmea", 2, 12, "Sem descrição", new ImageIcon("resource/9.png")));
		BancoDados.addAnims(new Animal(10, "Madona", "Vira-lata", "Fêmea", 1, 10, "Sem descrição",
				new ImageIcon("resource/10.png")));
		
		BancoDados.candidatos.add(new Candidato("Danilo", "666.666.666-66", "danilo@", "(87)9 9321-2428",
				new Endereco("31 de Março", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("Breno", "777.777.777-77", "daniloMatheus@", "(87)9 9321-2428",
				new Endereco("31 de Março", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("João", "888.888.888-88", "daniloMatheus@", "(87)9 9321-2428",
				new Endereco("31 de Março", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("Daniel", "999.999.999-99", "daniloMatheus@", "(87)9 9321-2428",
				new Endereco("31 de Março", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		BancoDados.candidatos.add(new Candidato("Matheus", "101.010.101.01", "daniloMatheus@", "(87)9 9321-2428",
				new Endereco("31 de Março", "Apt", "Bomba", "Serra Talhada", "55190000", "Pernambuco", 464)));
		
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(0), BancoDados.candidatos.get(0)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(1), BancoDados.candidatos.get(1)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(2), BancoDados.candidatos.get(2)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(3), BancoDados.candidatos.get(3)));
		BancoDados.adocoes.add(new Adocao(BancoDados.animais.get(4), BancoDados.candidatos.get(4)));
		
		TelaInicial telaInicio = new TelaInicial();
		ListaCandidatos listCand = new ListaCandidatos();
		listCand.setVisible(true);
		
		/* testes unitarios */
		/*
		TestControllerAdm.testAdmExiste();
		TestAdocao.AdocaoString();
		TestAnimal.TestAnimal();
		TestCandidato.TestCandidato();
		TestCadastroAnimal.TestFile();
		TestCadastroCandidato.TestRetChars();
		*/
	}

}
