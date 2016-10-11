package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControllerAnimal;

public class CadastroAnimal extends TelaInterna {
	private JLabel titulo, id, nome, raca, sexo, idade, peso, descricao;
	private ImageIcon imagemAnimal;
	private JTextField imputId,imputNome, imputRaca, imputIdade, imputPeso;
	private JComboBox<String> sexoOption;
	private JPanel painel, painel2, painel3;
	private JTextArea imputDescricao;
	private JButton cadastrar, limpar, adicionarFoto;

	private ControllerAnimal controllerAnimal;

	public CadastroAnimal() {
		super("Cadastrar Animal", 550, 270);

		controllerAnimal = new ControllerAnimal(this);

		init();
		setLayout(new BorderLayout(10, 30));
		painel.setLayout(new GridLayout(7, 1));
		painel3.setLayout(new GridLayout(7, 1));
		painel2.setLayout(new GridLayout(1, 1));
		painel.add(id);
		painel3.add(imputId);
		painel.add(nome);
		painel3.add(imputNome);
		painel.add(raca);
		painel3.add(imputRaca);
		painel.add(sexo);
		painel3.add(sexoOption);
		painel.add(idade);
		painel3.add(imputIdade);
		painel.add(peso);
		painel3.add(imputPeso);
		painel.add(descricao);
		painel3.add(imputDescricao);
		painel2.add(cadastrar);
		painel2.add(limpar);

		add(BorderLayout.NORTH, titulo);
		add(BorderLayout.WEST, painel);
		add(BorderLayout.EAST, adicionarFoto);
		add(BorderLayout.CENTER, painel3);
		add(BorderLayout.SOUTH, painel2);

		cadastrar.addActionListener(controllerAnimal);
		limpar.addActionListener(controllerAnimal);
		adicionarFoto.addActionListener(controllerAnimal);
		setLocation(235, 160);
		setVisible(true);
	}

	public void init() {
		titulo = new JLabel("Dados do Animal:");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		painel = new JPanel();
		painel2 = new JPanel();
		painel3 = new JPanel();
		id = new JLabel("Id:");
		imputId = new JTextField();
		imputId.setEditable(false);
		nome = new JLabel("Nome:");
		imputNome = new JTextField(20);
		raca = new JLabel("Raça:");
		imputRaca = new JTextField(20);
		sexo = new JLabel("Sexo:");
		sexoOption = new JComboBox<>();
		sexoOption.addItem("Fêmea");
		sexoOption.addItem("Macho");
		idade = new JLabel("Idade:(Anos)");
		imputIdade = new JTextField(20);
		peso = new JLabel("Peso:");
		imputPeso = new JTextField(20);
		descricao = new JLabel("Descrição:");
		imputDescricao = new JTextArea();
		imagemAnimal = new ImageIcon();
		adicionarFoto = new JButton("Adicionar Foto");
		cadastrar = new JButton("Cadastrar");
		limpar = new JButton("Limpar Dados");

	}

	public ImageIcon selectFile() {
		ImageIcon conteudo = null;
		String caminho = null;
		try {
			JFileChooser jFileChooser = new JFileChooser();
			int ok = jFileChooser.showOpenDialog(null);
			if (ok == JFileChooser.APPROVE_OPTION) {
				caminho = jFileChooser.getCurrentDirectory().getPath() + jFileChooser.getSelectedFile().getName();
				conteudo = new ImageIcon(caminho);
			} else {
				jFileChooser.cancelSelection();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conteudo;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getNome() {
		return nome;
	}

	public void setNome(JLabel nome) {
		this.nome = nome;
	}

	public JLabel getRaca() {
		return raca;
	}

	public void setRaca(JLabel raca) {
		this.raca = raca;
	}

	public JLabel getSexo() {
		return sexo;
	}

	public void setSexo(JLabel sexo) {
		this.sexo = sexo;
	}

	public JLabel getIdade() {
		return idade;
	}

	public void setIdade(JLabel idade) {
		this.idade = idade;
	}

	public JLabel getPeso() {
		return peso;
	}

	public void setPeso(JLabel peso) {
		this.peso = peso;
	}

	public JLabel getDescricao() {
		return descricao;
	}

	public void setDescricao(JLabel descricao) {
		this.descricao = descricao;
	}

	public ImageIcon getImagemAnimal() {
		return imagemAnimal;
	}

	public void setImagemAnimal(ImageIcon imagemAnimal) {
		this.imagemAnimal = imagemAnimal;
	}

	public JTextField getImputNome() {
		return imputNome;
	}

	public void setImputNome(JTextField imputNome) {
		this.imputNome = imputNome;
	}

	public JTextField getImputRaca() {
		return imputRaca;
	}

	public void setImputRaca(JTextField imputRaca) {
		this.imputRaca = imputRaca;
	}

	public JTextField getImputIdade() {
		return imputIdade;
	}

	public void setImputIdade(JTextField imputIdade) {
		this.imputIdade = imputIdade;
	}

	public JTextField getImputPeso() {
		return imputPeso;
	}

	public void setImputPeso(JTextField imputPeso) {
		this.imputPeso = imputPeso;
	}

	public JComboBox<String> getSexoOption() {
		return sexoOption;
	}

	public void setSexoOption(JComboBox<String> sexoOption) {
		this.sexoOption = sexoOption;
	}

	public JPanel getPainel() {
		return painel;
	}

	public JLabel getId() {
		return id;
	}

	public void setId(JLabel id) {
		this.id = id;
	}

	public JTextField getImputId() {
		return imputId;
	}

	public void setImputId(JTextField imputId) {
		this.imputId = imputId;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
	}

	public JPanel getPainel2() {
		return painel2;
	}

	public void setPainel2(JPanel painel2) {
		this.painel2 = painel2;
	}

	public JPanel getPainel3() {
		return painel3;
	}

	public void setPainel3(JPanel painel3) {
		this.painel3 = painel3;
	}

	public JTextArea getImputDescricao() {
		return imputDescricao;
	}

	public void setImputDescricao(JTextArea imputDescricao) {
		this.imputDescricao = imputDescricao;
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

	public JButton getAdicionarFoto() {
		return adicionarFoto;
	}

	public void setAdicionarFoto(JButton adicionarFoto) {
		this.adicionarFoto = adicionarFoto;
	}
}
