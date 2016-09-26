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

public class CadastroAnimal extends Tela {
	private JLabel titulo, nome, raca, sexo, idade, peso, descricao;
	private ImageIcon imagemAnimal;
	private JTextField imputNome, imputRaca, imputIdade, imputPeso;
	private JComboBox<String> sexoOption;
	private JPanel painel, painel2, painel3;
	private JTextArea imputDescricao;
	private JButton cadastrar, limpar, adicionarFoto;

	public CadastroAnimal() {
		super("Cadastrar Animal", 550, 270);

		init();
		setLayout(new BorderLayout(50, 30));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		painel.setLayout(new GridLayout(6, 1));
		painel3.setLayout(new GridLayout(6, 1));
		painel2.setLayout(new GridLayout(1, 1));

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

		setVisible(true);
	}

	public void init() {
		titulo = new JLabel("Dados do Animal:");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		painel = new JPanel();
		painel2 = new JPanel();
		painel3 = new JPanel();

		nome = new JLabel("Nome:");
		imputNome = new JTextField(20);
		raca = new JLabel("Raça:");
		imputRaca = new JTextField(20);
		sexo = new JLabel("Sexo:");
		sexoOption = new JComboBox<>();
		sexoOption.addItem("Fêmea");
		sexoOption.addItem("Macho");
		idade = new JLabel("Idade:");
		imputIdade = new JTextField(20);
		peso = new JLabel("Peso:");
		imputPeso = new JTextField(20);
		descricao = new JLabel("Descrição:");
		imputDescricao = new JTextArea();
		imagemAnimal = new ImageIcon();
		adicionarFoto = new JButton("Adicionar Foto");
		adicionarFoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == adicionarFoto) {
					imagemAnimal = selectFile();
				}
			}
		});
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cadastrar) {
					JOptionPane.showMessageDialog(null, "Animal Cadastrado com Sucesso");
				}
			}
		});
		limpar = new JButton("Limpar Dados");
		limpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == limpar) {
					imputNome.setText(null);
					imputRaca.setText(null);
					imputIdade.setText(null);
					imputPeso.setText(null);
				}
			}
		});

	}

	private ImageIcon selectFile() {
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
}
