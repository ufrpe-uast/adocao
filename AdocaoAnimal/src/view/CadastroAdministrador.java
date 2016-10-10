package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControllerAdministrador;

public class CadastroAdministrador extends Tela {

	private JLabel titulo;
	private JLabel nomeLabel;
	private JLabel usuarioLabel;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	
	private JTextField nomeTF;
	private JTextField usuarioTF;
	private JTextField emailTF;
	private JPasswordField senhaTF;
	
	private JButton cadastrar;
	private JButton limpar;
	
	private JPanel painelTitulo;
	private JPanel painelLabels;
	private JPanel painelInput;
	private JPanel painelBotoes;
	
	private ControllerAdministrador ctrlAdm;
	
	public CadastroAdministrador() {
		super("Cadastro Administrador", 400, 350);
		
		ctrlAdm = new ControllerAdministrador(this);
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		init();
		
		add(BorderLayout.NORTH, painelTitulo);
		add(BorderLayout.WEST, painelLabels);
		add(BorderLayout.CENTER, painelInput);
		add(BorderLayout.SOUTH, painelBotoes);
	}
	
	public void init() {
		titulo = new JLabel("Cadastro de Administradores");
		titulo.setFont(new Font("", Font.BOLD, 20)); // fonte Times causando lentidao
		
		nomeLabel = new JLabel("Nome: ");
		usuarioLabel = new JLabel("Usuario: ");
		emailLabel = new JLabel("Email: ");
		senhaLabel = new JLabel("Senha: ");
		
		nomeTF = new JTextField();
		usuarioTF = new JTextField();
		emailTF = new JTextField();
		senhaTF = new JPasswordField();
		
		cadastrar = new JButton("Cadastrar");
		limpar = new JButton("Limpar");
		
		cadastrar.addActionListener(ctrlAdm);
		limpar.addActionListener(ctrlAdm);
		
		painelTitulo = new JPanel();
		painelLabels = new JPanel();
		painelInput = new JPanel();
		painelBotoes = new JPanel();
		
		painelLabels.setLayout(new GridLayout(10, 1));
		painelInput.setLayout(new GridLayout(10, 1));
		painelBotoes.setLayout(new FlowLayout());
		
		painelTitulo.add(titulo);
		
		painelLabels.add(nomeLabel);
		painelLabels.add(usuarioLabel);
		painelLabels.add(emailLabel);
		painelLabels.add(senhaLabel);
		
		painelInput.add(nomeTF);
		painelInput.add(usuarioTF);
		painelInput.add(emailTF);
		painelInput.add(senhaTF);
		
		painelBotoes.add(cadastrar);
		painelBotoes.add(limpar);
	}

	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	public JLabel getUsarioLabel() {
		return usuarioLabel;
	}

	public void setUsarioLabel(JLabel usarioLabel) {
		this.usuarioLabel = usarioLabel;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}

	public JLabel getSenhaLabel() {
		return senhaLabel;
	}

	public void setSenhaLabel(JLabel senhaLabel) {
		this.senhaLabel = senhaLabel;
	}

	public JTextField getNomeTF() {
		return nomeTF;
	}

	public void setNomeTF(JTextField nomeTF) {
		this.nomeTF = nomeTF;
	}

	public JTextField getUsuarioTF() {
		return usuarioTF;
	}

	public void setUsuarioTF(JTextField usuarioTF) {
		this.usuarioTF = usuarioTF;
	}

	public JTextField getEmailTF() {
		return emailTF;
	}

	public void setEmailTF(JTextField emailTF) {
		this.emailTF = emailTF;
	}

	public JTextField getSenhaTF() {
		return senhaTF;
	}

	public void setSenhaTF(JPasswordField senhaTF) {
		this.senhaTF = senhaTF;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getUsuarioLabel() {
		return usuarioLabel;
	}

	public void setUsuarioLabel(JLabel usuarioLabel) {
		this.usuarioLabel = usuarioLabel;
	}

	public JPanel getPainelTitulo() {
		return painelTitulo;
	}

	public void setPainelTitulo(JPanel painelTitulo) {
		this.painelTitulo = painelTitulo;
	}

	public JButton getCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(JButton cadastrar) {
		this.cadastrar = cadastrar;
	}

	public JButton getLimpar() {
		return limpar;
	}

	public void setLimpar(JButton limpar) {
		this.limpar = limpar;
	}

	public JPanel getPainelLabels() {
		return painelLabels;
	}

	public void setPainelLabels(JPanel painelLabels) {
		this.painelLabels = painelLabels;
	}

	public JPanel getPainelInput() {
		return painelInput;
	}

	public void setPainelInput(JPanel painelInput) {
		this.painelInput = painelInput;
	}

	public JPanel getPainelBotoes() {
		return painelBotoes;
	}

	public void setPainelBotoes(JPanel painelBotoes) {
		this.painelBotoes = painelBotoes;
	}

}
