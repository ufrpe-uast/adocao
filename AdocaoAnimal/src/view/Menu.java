package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends Tela {
	private JMenuBar menu;
	private JMenu sistema;
	private JMenu editar;
	private JMenu cadastro;
	private JMenu visualizar;
	private JMenu ajuda;
	private JMenuItem conta;
	private JMenuItem sair;
	private JMenuItem editarAnimal;
	private JMenuItem editarCandidato;
	private JMenuItem cadastrarAnimal;
	private JMenuItem cadastrarAdministrador;
	private JMenuItem cadastrarCandidato;
	private JMenuItem visualizarAnimais;
	private JMenuItem visualizarCandidatos;
	private JMenuItem visualizarAdocoes;

	public Menu() {
		super("Bem Vindo", 1020, 600);
		init();
		addMenus();
		actionMenuItem();
		setJMenuBar(menu);
		setLayout(null);
		setVisible(true);

	}

	public void init() {
		menu = new JMenuBar();

		sistema = new JMenu("Sistema");
		editar = new JMenu("Editar");
		cadastro = new JMenu("Cadastrar");
		visualizar = new JMenu("Visualizar");
		ajuda = new JMenu("Ajuda");

		conta = new JMenuItem("Seus Dados");
		sair = new JMenuItem("Sair do Sistema");

		editarAnimal = new JMenuItem("Alterar Animal");
		editarCandidato = new JMenuItem("Alterar Candidato");

		cadastrarAnimal = new JMenuItem("Cadastrar Animal");
		cadastrarAdministrador = new JMenuItem("Cadastrar Administrador");
		cadastrarCandidato = new JMenuItem("Cadastrar Candidato");

		visualizarAnimais = new JMenuItem("Animais");
		visualizarCandidatos = new JMenuItem("Candidatos");
		visualizarAdocoes = new JMenuItem("Adoções");
	}

	public void addMenus() {
		sistema.add(conta);
		sistema.add(sair);

		editar.add(editarAnimal);
		editar.add(editarCandidato);

		visualizar.add(visualizarAnimais);
		visualizar.add(visualizarCandidatos);
		visualizar.add(visualizarAdocoes);

		cadastro.add(cadastrarAnimal);
		cadastro.add(cadastrarCandidato);

		menu.add(sistema);
		menu.add(editar);
		menu.add(cadastro);
		menu.add(visualizar);
		menu.add(ajuda);
	}

	public void actionMenuItem() {
		this.cadastrarAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cadastrarAnimal) {
					CadastroAnimal cadastrarAnimal = new CadastroAnimal();
					cadastrarAnimal.setVisible(true);
				}
			}
		});
	}
}
