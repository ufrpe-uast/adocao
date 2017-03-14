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
import model.Animal;

public class CadastroCandidato extends TelaPadrao {
	private JLabel titulo, nome, cpf, email, fone;
	private JLabel cep, estado, cidade, bairro, rua, numero, complemento;
	private JTextField imputNome, imputEmail;
	private JFormattedTextField imputFone, imputCpf, imputCep;
	private MaskFormatter maskCPF, maskFone, maskCEP;
	private JTextField imputCidade, imputBairro, imputRua, imputNumero, imputComplemento;
	private JComboBox<String> estados;
	private JPanel painelLabels;
	private JPanel painelImputs;
	private JPanel painelBotoes;
	private JButton enviarForm, alterar, limparDados;
	private ControllerCandidato controllerForm;

	private Animal animal;

	public CadastroCandidato() {
		super("Enviar Proposta", 400, 400);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(50, 10));
		controllerForm = new ControllerCandidato(this);
		init();
		addComponents();
		add(BorderLayout.NORTH, titulo);
		add(BorderLayout.WEST, painelLabels);
		add(BorderLayout.CENTER, painelImputs);
		add(BorderLayout.SOUTH, painelBotoes);
	}

	public void init() {
		titulo = new JLabel("Formulário para Adoção");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		nome = new JLabel("Nome:");
		cpf = new JLabel("CPF:");
		email = new JLabel("Email:");
		fone = new JLabel("Fone:");
		cep = new JLabel("CEP:");
		estado = new JLabel("Estado:");
		cidade = new JLabel("Cidade:");
		bairro = new JLabel("Bairro:");
		rua = new JLabel("Rua:");
		numero = new JLabel("Número:");
		complemento = new JLabel("Complemento:");
		imputNome = new JTextField();
		imputCpf = new JFormattedTextField();
		try {
			maskCPF = new MaskFormatter("###.###.###-##");
			imputCpf = new JFormattedTextField();
			maskCPF.install(imputCpf);
		} catch (Exception e) {
			System.out.println("Erro Máscara de CPF!!!");
		}
		imputEmail = new JTextField();
		try {
			maskFone = new MaskFormatter("+55 (##) # ####-####");
			imputFone = new JFormattedTextField();
			maskFone.install(imputFone);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Erro Máscara de Fone!!!");
		}
		try {
			maskCEP = new MaskFormatter("#####-###");
			imputCep = new JFormattedTextField();
			maskCEP.install(imputCep);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Erro máscara do CEP!!!");
		}

		estados = new JComboBox<>();
		addEstados();

		imputCidade = new JTextField();
		imputBairro = new JTextField();
		imputRua = new JTextField();
		imputNumero = new JTextField();
		imputComplemento = new JTextField();

		enviarForm = new JButton("Enviar");
		enviarForm.addActionListener(controllerForm);
		alterar = new JButton("Alterar");
		alterar.addActionListener(controllerForm);
		alterar.setEnabled(false);
		limparDados = new JButton("Limpar Dados");
		limparDados.addActionListener(controllerForm);

		painelBotoes = new JPanel();
		painelLabels = new JPanel();
		painelImputs = new JPanel();

	}

	public void addComponents() {
		painelLabels.setLayout(new GridLayout(11, 1));

		painelLabels.add(nome);
		painelLabels.add(cpf);
		painelLabels.add(email);
		painelLabels.add(fone);
		painelLabels.add(cep);
		painelLabels.add(estado);
		painelLabels.add(cidade);
		painelLabels.add(bairro);
		painelLabels.add(rua);
		painelLabels.add(numero);
		painelLabels.add(complemento);

		painelImputs.setLayout(new GridLayout(11, 1));
		painelImputs.add(imputNome);
		painelImputs.add(imputCpf);
		painelImputs.add(imputEmail);
		painelImputs.add(imputFone);
		painelImputs.add(imputCep);
		painelImputs.add(estados);
		painelImputs.add(imputCidade);
		painelImputs.add(imputBairro);
		painelImputs.add(imputRua);
		painelImputs.add(imputNumero);
		painelImputs.add(imputComplemento);

		painelBotoes.setLayout(new GridLayout(1, 3));
		painelBotoes.add(enviarForm);
		painelBotoes.add(alterar);
		painelBotoes.add(limparDados);

	}

	public void addEstados() {
		estados.addItem("Acre");
		estados.addItem("Alagoas");
		estados.addItem("Amapá");
		estados.addItem("Amazonas");
		estados.addItem("Bahia");
		estados.addItem("Ceará");
		estados.addItem("Distrito Federal");
		estados.addItem("Espírito Santo");
		estados.addItem("Goiás");
		estados.addItem("Maranhão");
		estados.addItem("Mato Grosso");
		estados.addItem("Mato Grosso do Sul");
		estados.addItem("Minas Gerais");
		estados.addItem("Pará");
		estados.addItem("Paraíba");
		estados.addItem("Paraná");
		estados.addItem("Pernambuco");
		estados.addItem("Piauí");
		estados.addItem("Rio de Janeiro");
		estados.addItem("Rio Grande do Norte");
		estados.addItem("Rio Grande do Sul");
		estados.addItem("Rondônia");
		estados.addItem("Roraima");
		estados.addItem("Santa Catarina");
		estados.addItem("São Paulo");
		estados.addItem("Sergipe");
		estados.addItem("Tocantins");
	}

	public void limparDados() {
		imputBairro.setText(null);
		imputCpf.setText(null);
		imputCep.setText(null);
		imputCidade.setText(null);
		imputComplemento.setText(null);
		imputEmail.setText(null);
		estados.setSelectedIndex(0);
		imputNome.setText(null);
		imputNumero.setText(null);
		imputRua.setText(null);
		imputFone.setText(null);
	}

	public String retiraCaracteres(String str) {
		if (str != null) {

			return str.replaceAll("[^0123456789]", "");

		} else {

			return "";

		}
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

	public JFormattedTextField getImputCpf() {
		return imputCpf;
	}

	public void setEnviarForm(JButton enviarForm) {
		this.enviarForm = enviarForm;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public JButton getAlterar() {
		return alterar;
	}

	public void setAlterar(JButton alterar) {
		this.alterar = alterar;
	}

	public void setImputCpf(JFormattedTextField imputCpf) {
		this.imputCpf = imputCpf;
	}
}
