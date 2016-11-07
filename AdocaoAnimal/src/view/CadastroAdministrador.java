package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.text.MaskFormatter;

import controller.ControllerAdministrador;

public class CadastroAdministrador extends TelaInterna {

	private JLabel titulo;
	private JLabel nome, cpf, rg;
	private JLabel usuario, senha;
	private JLabel email, fone;
	private JLabel cep, estado, cidade, bairro, rua, numero, complemento;
	private JTextField imputNome;
	private JTextField imputUsuario;
	private JTextField imputEmail;
	private JPasswordField senhaTF;
	private JComboBox<String> estados;
	private JFormattedTextField imputFone, imputCpf, imputCep, imputRg;
	private MaskFormatter maskCPF, maskFone, maskCEP, maskRG;
	private JTextField imputCidade, imputBairro, imputRua, imputNumero, imputComplemento;

	private JButton cadastrar;
	private JButton limpar;
	private JPanel painelTitulo;
	private JPanel painelLabels;
	private JPanel painelInput;
	private JPanel painelBotoes;

	private ControllerAdministrador ctrlAdm;

	public CadastroAdministrador() {
		super("Cadastrar Administrador", 400, 450);

		ctrlAdm = new ControllerAdministrador(this);

		setLayout(new BorderLayout());

		init();
		addEstados();
		add(BorderLayout.NORTH, painelTitulo);
		add(BorderLayout.WEST, painelLabels);
		add(BorderLayout.CENTER, painelInput);
		add(BorderLayout.SOUTH, painelBotoes);
		setLocation(310, 50);
	}

	public void init() {
		titulo = new JLabel("Cadastro de Administrador");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		cpf = new JLabel("CPF: ");
		rg = new JLabel("RG: ");
		nome = new JLabel("Nome: ");
		usuario = new JLabel("Usuario: ");
		email = new JLabel("Email: ");
		senha = new JLabel("Senha: ");
		fone = new JLabel("Fone:");
		cep = new JLabel("CEP:");
		estado = new JLabel("Estado:");
		cidade = new JLabel("Cidade:");
		bairro = new JLabel("Bairro:");
		rua = new JLabel("Rua:");
		numero = new JLabel("Número:");
		complemento = new JLabel("Complemento:");
		try {
			maskCPF = new MaskFormatter("###.###.###-##");
			imputCpf = new JFormattedTextField();
			maskCPF.install(imputCpf);
		} catch (Exception e) {
			System.out.println("Erro Máscara de CPF!!!");
		}
		try {
			maskRG = new MaskFormatter("#.###.###");
			imputRg = new JFormattedTextField();
			maskRG.install(imputRg);
		} catch (Exception e) {
			System.out.println("Erro Máscara de RG!!!");
		}
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

		imputNome = new JTextField();
		imputUsuario = new JTextField();
		imputEmail = new JTextField();
		senhaTF = new JPasswordField();
		estados = new JComboBox<>();
		imputCidade = new JTextField();
		imputBairro = new JTextField();
		imputRua = new JTextField();
		imputNumero = new JTextField();
		imputComplemento = new JTextField();
		cadastrar = new JButton("Cadastrar");
		limpar = new JButton("Limpar");

		cadastrar.addActionListener(ctrlAdm);
		limpar.addActionListener(ctrlAdm);

		painelTitulo = new JPanel();
		painelLabels = new JPanel();
		painelInput = new JPanel();
		painelBotoes = new JPanel();

		painelLabels.setLayout(new GridLayout(14, 1));
		painelInput.setLayout(new GridLayout(14, 1));
		painelBotoes.setLayout(new GridLayout(1, 2));

		painelTitulo.add(titulo);

		painelLabels.add(nome);
		painelLabels.add(rg);
		painelLabels.add(cpf);
		painelLabels.add(usuario);
		painelLabels.add(senha);
		painelLabels.add(email);
		painelLabels.add(fone);
		painelLabels.add(cep);
		painelLabels.add(estado);
		painelLabels.add(cidade);
		painelLabels.add(bairro);
		painelLabels.add(rua);
		painelLabels.add(numero);
		painelLabels.add(complemento);

		painelInput.add(imputNome);
		painelInput.add(imputRg);
		painelInput.add(imputCpf);
		painelInput.add(imputUsuario);
		painelInput.add(senhaTF);
		painelInput.add(imputEmail);
		painelInput.add(imputFone);
		painelInput.add(imputCep);
		painelInput.add(estados);
		painelInput.add(imputCidade);
		painelInput.add(imputBairro);
		painelInput.add(imputRua);
		painelInput.add(imputNumero);
		painelInput.add(imputComplemento);

		painelBotoes.add(cadastrar);
		painelBotoes.add(limpar);
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
		imputCpf.setText(null);
		imputRg.setText(null);
		imputNome.setText(null);
		imputUsuario.setText(null);
		imputEmail.setText(null);
		senhaTF.setText(null);
		imputBairro.setText(null);
		imputCep.setText(null);
		imputCidade.setText(null);
		imputComplemento.setText(null);
		estados.setSelectedIndex(0);
		imputNumero.setText(null);
		imputRua.setText(null);
		imputFone.setText(null);
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

	public JFormattedTextField getImputFone() {
		return imputFone;
	}

	public void setImputFone(JFormattedTextField imputFone) {
		this.imputFone = imputFone;
	}

	public JFormattedTextField getImputCpf() {
		return imputCpf;
	}

	public void setImputCpf(JFormattedTextField imputCpf) {
		this.imputCpf = imputCpf;
	}

	public JFormattedTextField getImputCep() {
		return imputCep;
	}

	public void setImputCep(JFormattedTextField imputCep) {
		this.imputCep = imputCep;
	}

	public JFormattedTextField getImputRg() {
		return imputRg;
	}

	public void setImputRg(JFormattedTextField imputRg) {
		this.imputRg = imputRg;
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

	public JTextField getImputNome() {
		return imputNome;
	}

	public void setImputNome(JTextField imputNome) {
		this.imputNome = imputNome;
	}

	public JTextField getImputUsuario() {
		return imputUsuario;
	}

	public void setImputUsuario(JTextField imputUsuario) {
		this.imputUsuario = imputUsuario;
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

}
