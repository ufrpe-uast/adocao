package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ControllerDadosAdm;
import model.Administrador;

public class DadosAdministrador extends TelaPadrao {
	private JLabel dados, login, senha;
	private JTextField imputLogin, imputSenha;
	private JButton editar, alterar;
	private Administrador adm;
	private ControllerDadosAdm cDados;

	public DadosAdministrador(Administrador adm) {
		super("Sua Conta", 400, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.adm = adm;
		this.dados = imprimirDados();
		cDados = new ControllerDadosAdm(this);
		login = new JLabel("Seu Login:");
		senha = new JLabel("Sua Senha:");
		imputLogin = new JTextField();
		imputLogin.setText(adm.getUsuario());
		imputLogin.setEditable(false);
		imputSenha = new JTextField();
		imputSenha.setText(adm.getSenha());
		imputSenha.setEditable(false);
		editar = new JButton("Editar");
		editar.addActionListener(cDados);
		alterar = new JButton("Atualizar");
		alterar.addActionListener(cDados);

		JPanel panelAcesso = new JPanel();
		panelAcesso.setLayout(new GridLayout(3, 3));
		panelAcesso.add(login);
		panelAcesso.add(imputLogin);
		panelAcesso.add(senha);
		panelAcesso.add(imputSenha);
		panelAcesso.add(editar);
		panelAcesso.add(alterar);
		JPanel panelDados = new JPanel();
		panelDados.setLayout(new BorderLayout());
		panelDados.add(new JScrollPane(dados), BorderLayout.CENTER);
		add(panelDados, BorderLayout.CENTER);
		add(panelAcesso, BorderLayout.SOUTH);
	}

	public JLabel imprimirDados() {
		JLabel label;
		label = new JLabel(new String("<html>" + "<p><h3> Informações do Administrador" + "</h3></p>" + "<p> Nome:   "
				+ adm.getNome() + "</p>" + "<p> CPF:   " + adm.getCpf() + "</p>" + "<p> RG:   " + adm.getRg() + "</p>"
				+ "<p> Email:   " + adm.getEmail() + "</p>" + "<p> Fone:   " + adm.getFone() + "</p>"
				+ "<p><h3>Endereço Residencial: " + "</h3></p>" + "<p> CEP:   " + adm.getEndereco().getCep() + "</p>"
				+ "<p> Logradouro:   " + adm.getEndereco().getRua() + "</p>" + "<p> Número:   "
				+ adm.getEndereco().getNumero() + "</p>" + "<p> Complemento:   " + adm.getEndereco().getComplemento()
				+ " </p>" + "<p> Bairro:   " + adm.getEndereco().getBairro() + "</p>" + "<p> UF:   "
				+ adm.getEndereco().getEstado() + "</p>" + "<p> Cidade:   " + adm.getEndereco().getCidade() + "</p>"
				+ "</html>"));
		return label;
	}

	public JButton getEditar() {
		return editar;
	}

	public JButton getAlterar() {
		return alterar;
	}

	public JTextField getImputLogin() {
		return imputLogin;
	}

	public void setImputLogin(JTextField imputLogin) {
		this.imputLogin = imputLogin;
	}

	public JTextField getImputSenha() {
		return imputSenha;
	}

	public void setImputSenha(JTextField imputSenha) {
		this.imputSenha = imputSenha;
	}

	public Administrador getAdm() {
		return adm;
	}

}
