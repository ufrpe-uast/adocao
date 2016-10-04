package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerCandidato;

public class CadastroCandidato extends Tela {
	private JLabel titulo, nome, email, fone, username, senha;
	private JLabel cep, estado, cidade, bairro, rua, numero, complemento;
	private JTextField imputNome, imputEmail, imputUsername;
	private JFormattedTextField imputFone, imputCep;
	private MaskFormatter maskFone, maskCEP;
	private JPasswordField imputSenha;
	private JTextField imputCidade, imputBairro, imputRua, imputNumero, imputComplemento;
	private JComboBox<String> estados;
	private JPanel painelLabels;
	private JPanel painelImputs;
	private JPanel painelBotoes;
	private JButton enviarForm, limparDados;
	private ControllerCandidato controllerCandidato;

	public CadastroCandidato() {
		super("Enviar Formul�rio", 400, 350);

		setLayout(new BorderLayout(50, 10));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		controllerCandidato = new ControllerCandidato(this);
		init();
		addComponents();
		add(BorderLayout.NORTH, titulo);
		add(BorderLayout.WEST, painelLabels);
		add(BorderLayout.CENTER, painelImputs);
		add(BorderLayout.SOUTH, painelBotoes);

	}

	public void init() {
		titulo = new JLabel("Formul�rio para Ado��o");
		titulo.setFont(new Font("Times", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		nome = new JLabel("Nome:");
		email = new JLabel("Email:");
		fone = new JLabel("Fone:");
		username = new JLabel("Username:");
		senha = new JLabel("Senha:");
		cep = new JLabel("CEP:");
		estado = new JLabel("Estado:");
		cidade = new JLabel("Cidade:");
		bairro = new JLabel("Bairro:");
		rua = new JLabel("Rua:");
		numero = new JLabel("N�mero:");
		complemento = new JLabel("Complemento:");
		imputNome = new JTextField();
		imputEmail = new JTextField();
		try {
			maskFone = new MaskFormatter("+55 (##) # ####-####");
			imputFone = new JFormattedTextField();
			maskFone.install(imputFone);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Erro M�scara de Fone!!!");
		}
		imputUsername = new JTextField();
		imputSenha = new JPasswordField();
		try {
			maskCEP = new MaskFormatter("#####-###");
			imputCep = new JFormattedTextField();
			maskCEP.install(imputCep);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Erro m�scara do CEP!!!");
		}

		estados = new JComboBox<>();
		addEstados();
		
		
		imputCidade = new JTextField();
		imputBairro = new JTextField();
		imputRua = new JTextField();
		imputNumero = new JTextField();
		imputComplemento = new JTextField();

		enviarForm = new JButton("Enviar");
		enviarForm.addActionListener(controllerCandidato);
		limparDados = new JButton("Limpar Dados");
		limparDados.addActionListener(controllerCandidato);

		painelBotoes = new JPanel();
		painelLabels = new JPanel();
		painelImputs = new JPanel();

	}

	public void addComponents() {
		painelLabels.setLayout(new GridLayout(12, 1));

		painelLabels.add(nome);
		painelLabels.add(email);
		painelLabels.add(fone);
		painelLabels.add(username);
		painelLabels.add(senha);
		painelLabels.add(cep);
		painelLabels.add(estado);
		painelLabels.add(cidade);
		painelLabels.add(bairro);
		painelLabels.add(rua);
		painelLabels.add(numero);
		painelLabels.add(complemento);

		painelImputs.setLayout(new GridLayout(12, 1));
		painelImputs.add(imputNome);
		painelImputs.add(imputEmail);
		painelImputs.add(imputFone);
		painelImputs.add(imputUsername);
		painelImputs.add(imputSenha);
		painelImputs.add(imputCep);
		painelImputs.add(estados);
		painelImputs.add(imputCidade);
		painelImputs.add(imputBairro);
		painelImputs.add(imputRua);
		painelImputs.add(imputNumero);
		painelImputs.add(imputComplemento);

		painelBotoes.setLayout(new GridLayout(1, 2));
		painelBotoes.add(enviarForm);
		painelBotoes.add(limparDados);

	}
	public void addEstados(){
		estados.addItem("Acre");
		estados.addItem("Alagoas");
		estados.addItem("Amap�");
		estados.addItem("Amazonas");
		estados.addItem("Bahia");
		estados.addItem("Cear�");
		estados.addItem("Distrito Federal");
		estados.addItem("Esp�rito Santo");
		estados.addItem("Goi�s");
		estados.addItem("Maranh�o");
		estados.addItem("Mato Grosso");
		estados.addItem("Mato Grosso do Sul");
		estados.addItem("Minas Gerais");
		estados.addItem("Par�");
		estados.addItem("Para�ba");
		estados.addItem("Paran�");
		estados.addItem("Pernambuco");
		estados.addItem("Piau�");
		estados.addItem("Rio de Janeiro");
		estados.addItem("Rio Grande do Norte");
		estados.addItem("Rio Grande do Sul");
		estados.addItem("Rond�nia");
		estados.addItem("Roraima");
		estados.addItem("Santa Catarina");
		estados.addItem("S�o Paulo");
		estados.addItem("Sergipe");
		estados.addItem("Tocantins");
	}

	public JButton getEnviarForm() {
		return enviarForm;
	}

	public JButton getLimparDados() {
		return limparDados;
	}

	public JTextField getImputNome() {
		return imputNome;
	}

	public void setImputNome(JTextField imputNome) {
		this.imputNome = imputNome;
	}

	public JTextField getImputEmail() {
		return imputEmail;
	}

	public void setImputEmail(JTextField imputEmail) {
		this.imputEmail = imputEmail;
	}

	public JTextField getImputUsername() {
		return imputUsername;
	}

	public void setImputUsername(JTextField imputUsername) {
		this.imputUsername = imputUsername;
	}

	public JPasswordField getImputSenha() {
		return imputSenha;
	}

	public void setImputSenha(JPasswordField imputSenha) {
		this.imputSenha = imputSenha;
	}


	public JComboBox<String> getEstados() {
		return estados;
	}

	public void setEstados(JComboBox<String> estados) {
		this.estados = estados;
	}

	public JTextField getImputCidade() {
		return imputCidade;
	}

	public void setImputCidade(JTextField imputCidade) {
		this.imputCidade = imputCidade;
	}

	public JTextField getImputBairro() {
		return imputBairro;
	}

	public void setImputBairro(JTextField imputBairro) {
		this.imputBairro = imputBairro;
	}

	public JTextField getImputRua() {
		return imputRua;
	}

	public void setImputRua(JTextField imputRua) {
		this.imputRua = imputRua;
	}

	public JTextField getImputNumero() {
		return imputNumero;
	}

	public void setImputNumero(JTextField imputNumero) {
		this.imputNumero = imputNumero;
	}

	public JTextField getImputComplemento() {
		return imputComplemento;
	}

	public void setImputComplemento(JTextField imputComplemento) {
		this.imputComplemento = imputComplemento;
	}

	public JFormattedTextField getImputFone() {
		return imputFone;
	}

	public void setImputFone(JFormattedTextField imputFone) {
		this.imputFone = imputFone;
	}

	public JFormattedTextField getImputCep() {
		return imputCep;
	}

	public void setImputCep(JFormattedTextField imputCep) {
		this.imputCep = imputCep;
	}

}
