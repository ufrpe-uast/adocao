package view;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ControllerMenu;

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
	private ControllerMenu cMenu;
	private CadastroAnimal telaCadAnimal;
	private CadastroCandidato telaCadCandidato;
	private CadastroAdministrador telaCadAdm;
	private ListaAnimais telaListarAnimal;
	private ListaCandidato telaListarCandidato;
	private JDesktopPane desktop;
	

	public Menu() {
		super("Bem Vindo", 1020, 600);
		init();
		addMenus();
		setJMenuBar(menu);
		setContentPane(desktop);
		setLayout(null);
		setVisible(true);

	}

	public void init() {
		cMenu = new ControllerMenu(this);
		menu = new JMenuBar();
		desktop = new JDesktopPane();
		sistema = new JMenu("Sistema");
		editar = new JMenu("Editar");
		cadastro = new JMenu("Cadastrar");
		visualizar = new JMenu("Visualizar");
		ajuda = new JMenu("Ajuda");

		conta = new JMenuItem("Seus Dados");
		conta.addActionListener(cMenu);
		sair = new JMenuItem("Sair do Sistema");
		sair.addActionListener(cMenu);

		editarAnimal = new JMenuItem("Alterar Animal");
		editarAnimal.addActionListener(cMenu);
		editarCandidato = new JMenuItem("Alterar Candidato");
		editarCandidato.addActionListener(cMenu);

		cadastrarAnimal = new JMenuItem("Cadastrar Animal");
		cadastrarAnimal.addActionListener(cMenu);
		cadastrarAdministrador = new JMenuItem("Cadastrar Administrador");
		cadastrarCandidato = new JMenuItem("Cadastrar Candidato");
		cadastrarCandidato.addActionListener(cMenu);

		cadastrarAdministrador = new JMenuItem("Cadastrar Administrador");
		cadastrarAdministrador.addActionListener(cMenu);

		visualizarAnimais = new JMenuItem("Animais");
		visualizarAnimais.addActionListener(cMenu);
		visualizarCandidatos = new JMenuItem("Candidatos");
		visualizarCandidatos.addActionListener(cMenu);
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
		cadastro.add(cadastrarAdministrador);

		menu.add(sistema);
		menu.add(editar);
		menu.add(cadastro);
		menu.add(visualizar);
		menu.add(ajuda);
		
	}

	public JMenuItem getSair() {
		return sair;
	}

	public JMenuItem getEditarAnimal() {
		return editarAnimal;
	}

	public JMenuItem getEditarCandidato() {
		return editarCandidato;
	}

	public JMenuItem getCadastrarAnimal() {
		return cadastrarAnimal;
	}

	public JMenuItem getCadastrarAdministrador() {
		return cadastrarAdministrador;
	}

	public JMenuItem getCadastrarCandidato() {
		return cadastrarCandidato;
	}

	public JMenuItem getVisualizarAnimais() {
		return visualizarAnimais;
	}

	public JMenuItem getVisualizarCandidatos() {
		return visualizarCandidatos;
	}

	public JMenuItem getVisualizarAdocoes() {
		return visualizarAdocoes;
	}

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	public JMenu getSistema() {
		return sistema;
	}

	public void setSistema(JMenu sistema) {
		this.sistema = sistema;
	}

	public JMenu getEditar() {
		return editar;
	}

	public void setEditar(JMenu editar) {
		this.editar = editar;
	}

	public JMenu getCadastro() {
		return cadastro;
	}

	public void setCadastro(JMenu cadastro) {
		this.cadastro = cadastro;
	}

	public JMenu getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(JMenu visualizar) {
		this.visualizar = visualizar;
	}

	public JMenu getAjuda() {
		return ajuda;
	}

	public void setAjuda(JMenu ajuda) {
		this.ajuda = ajuda;
	}

	public JMenuItem getConta() {
		return conta;
	}

	public void setConta(JMenuItem conta) {
		this.conta = conta;
	}

	public ControllerMenu getcMenu() {
		return cMenu;
	}

	public void setcMenu(ControllerMenu cMenu) {
		this.cMenu = cMenu;
	}

	public void setSair(JMenuItem sair) {
		this.sair = sair;
	}

	public void setEditarAnimal(JMenuItem editarAnimal) {
		this.editarAnimal = editarAnimal;
	}

	public void setEditarCandidato(JMenuItem editarCandidato) {
		this.editarCandidato = editarCandidato;
	}

	public void setCadastrarAnimal(JMenuItem cadastrarAnimal) {
		this.cadastrarAnimal = cadastrarAnimal;
	}

	public void setCadastrarAdministrador(JMenuItem cadastrarAdministrador) {
		this.cadastrarAdministrador = cadastrarAdministrador;
	}

	public void setCadastrarCandidato(JMenuItem cadastrarCandidato) {
		this.cadastrarCandidato = cadastrarCandidato;
	}

	public void setVisualizarAnimais(JMenuItem visualizarAnimais) {
		this.visualizarAnimais = visualizarAnimais;
	}

	public void setVisualizarCandidatos(JMenuItem visualizarCandidatos) {
		this.visualizarCandidatos = visualizarCandidatos;
	}

	public void setVisualizarAdocoes(JMenuItem visualizarAdocoes) {
		this.visualizarAdocoes = visualizarAdocoes;
	}

	public CadastroAnimal getTelaCadAnimal() {
		return telaCadAnimal;
	}

	public void setTelaCadAnimal(CadastroAnimal telaCadAnimal) {
		this.telaCadAnimal = telaCadAnimal;
	}

	public CadastroCandidato getTelaCadCandidato() {
		return telaCadCandidato;
	}

	public void setTelaCadCandidato(CadastroCandidato telaCadCandidato) {
		this.telaCadCandidato = telaCadCandidato;
	}

	public CadastroAdministrador getTelaCadAdm() {
		return telaCadAdm;
	}

	public void setTelaCadAdm(CadastroAdministrador telaCadAdm) {
		this.telaCadAdm = telaCadAdm;
	}

	public ListaAnimais getTelaListarAnimal() {
		return telaListarAnimal;
	}

	public void setTelaListarAnimal(ListaAnimais telaListarAnimal) {
		this.telaListarAnimal = telaListarAnimal;
	}

	public ListaCandidato getTelaListarCandidato() {
		return telaListarCandidato;
	}

	public void setTelaListarCandidato(ListaCandidato telaListarCandidato) {
		this.telaListarCandidato = telaListarCandidato;
	}

	public JDesktopPane getDesktop() {
		return desktop;
	}

	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}
}
