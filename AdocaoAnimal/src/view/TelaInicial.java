package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout.Group;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerInicial;
import model.Administrador;
import model.BancoDados;
import model.Candidato;

public class TelaInicial extends Tela {
	private JLabel labelLogo, login, senha, recuperar;
	private JTextField imputLogin;
	private JPasswordField imputSenha;
	private JButton entrar, consultarAnimais;
	private JPanel painel1;
	private ControllerInicial cInicial;
	private ListaAnimais listaAnimais;
	private JDesktopPane desktop;

	public TelaInicial() {
		super("AdotDog 1.0", 1020, 600);
		setLayout(null);
		desktop = new JDesktopPane();
		setContentPane(desktop);
		cInicial = new ControllerInicial(this);

		labelLogo = new JLabel(new ImageIcon("resource/logoInicioSistema.png"));
		labelLogo.setBounds(395, 100, 250, 175);

		recuperar = new JLabel("Esqueceu sua Senha ?");
		recuperar.setBounds(350, 375, 150, 50);
		recuperar.setToolTipText("Click para Recuperar sua Senha");
		recuperar.addMouseListener(cInicial);

		consultarAnimais = new JButton(new ImageIcon("resource/botaoAnimais.png"));
		consultarAnimais.setBounds(750, 500, 250, 50);
		consultarAnimais.addActionListener(cInicial);

		painel1 = new JPanel();
		painel1.setLayout(new GridLayout(3, 3));
		painel1.setBounds(350, 280, 350, 70);

		login = new JLabel("Login:");
		imputLogin = new JTextField();
		senha = new JLabel("Senha:");
		imputSenha = new JPasswordField();
		entrar = new JButton(new ImageIcon("resource/botaoLogin.png"));
		entrar.setBounds(350, 350, 350, 30);
		entrar.addActionListener(cInicial);

		painel1.add(login);
		painel1.add(senha);
		painel1.add(imputLogin);
		painel1.add(imputSenha);
		painel1.add(recuperar);
		getContentPane().setBackground(Color.WHITE);
		add(consultarAnimais);
		add(labelLogo);
		add(painel1);
		add(entrar);
		// add(recuperar);
		setVisible(true);
	}

	public JLabel getRecuperar() {
		return recuperar;
	}

	public void setRecuperar(JLabel recuperar) {
		this.recuperar = recuperar;
	}

	public JButton getEntrar() {
		return entrar;
	}

	public JButton getConsultarAnimais() {
		return consultarAnimais;
	}

	public JTextField getImputLogin() {
		return imputLogin;
	}

	public void setImputLogin(JTextField imputLogin) {
		this.imputLogin = imputLogin;
	}

	public JPasswordField getImputSenha() {
		return imputSenha;
	}

	public void setImputSenha(JPasswordField imputSenha) {
		this.imputSenha = imputSenha;
	}

	public ListaAnimais getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(ListaAnimais listaAnimais) {
		this.listaAnimais = listaAnimais;
	}

	public JDesktopPane getDesktop() {
		return desktop;
	}

}
