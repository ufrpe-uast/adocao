package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.ControllerDetalheAdocao;
import model.Administrador;
import model.Adocao;

public class DetalheAdocao extends TelaPadrao {
	private Adocao adocao;
	private JRadioButton radioAprovada, radioReprovada, radioEmAnalise;
	private ButtonGroup grupoRadio;
	private JPanel panelRadios, panelStatus, cand, anim;
	private JButton definirButton;
	private JLabel titleAnimal, titleCandidato;
	private JScrollPane scrollAnim, scrollCand;
	private ControllerDetalheAdocao cDetalheAdocao;
	private Administrador adm;

	public DetalheAdocao(Adocao adocao, Administrador adm) {
		super("Detalhes da Ado��o", 560, 500);
		this.adocao = adocao;
		this.adm = adm;
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		addComp();
		setVisible(true);
	}

	public ButtonGroup getGrupoRadio() {
		return grupoRadio;
	}

	public void init() {
		cDetalheAdocao = new ControllerDetalheAdocao(this);
		anim = new JPanel();
		anim.setLayout(new GridLayout(7, 1));
		anim.setBackground(Color.WHITE);
		cand = new JPanel();
		cand.setLayout(new GridLayout(13, 1));
		cand.setBackground(Color.WHITE);
		panelStatus = new JPanel();
		panelStatus.setLayout(new BorderLayout());
		panelRadios = new JPanel();
		panelRadios.setLayout(new GridLayout(1, 3));
		radioAprovada = new JRadioButton("Aprovada");
		radioAprovada.setBackground(Color.GREEN);
		radioReprovada = new JRadioButton("Reprovada");
		radioReprovada.setBackground(Color.RED);
		radioEmAnalise = new JRadioButton("Em An�lise");
		radioEmAnalise.setBackground(Color.YELLOW);
		definirButton = new JButton("Definir Adoc�o");
		definirButton.addActionListener(cDetalheAdocao);
		grupoRadio = new ButtonGroup();
		titleAnimal = new JLabel("Animal � ser Adotado:");
		titleAnimal.setFont(new Font("Arial", Font.BOLD, 18));
		titleAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		titleCandidato = new JLabel("Quem deseja Adotar:");
		titleCandidato.setFont(new Font("Arial", Font.BOLD, 18));
		titleCandidato.setHorizontalAlignment(SwingConstants.CENTER);
		scrollAnim = new JScrollPane(anim);
		scrollCand = new JScrollPane(cand);

	}

	public void addComp() {
		anim.add(titleAnimal);
		anim.add(new JLabel("Nome: " + adocao.getAnimal().getNome()));
		anim.add(new JLabel("Ra�a: " + adocao.getAnimal().getRaca()));
		anim.add(new JLabel("Sexo: " + adocao.getAnimal().getSexo()));
		anim.add(new JLabel("Idade: " + adocao.getAnimal().getIdade() + " anos"));
		anim.add(new JLabel("Peso: " + adocao.getAnimal().getPeso() + " kg"));
		anim.add(new JLabel("Descricao: " + adocao.getAnimal().getDescricao()));
		grupoRadio.add(radioAprovada);
		grupoRadio.add(radioReprovada);
		grupoRadio.add(radioEmAnalise);
		panelRadios.add(radioAprovada);
		panelRadios.add(radioEmAnalise);
		panelRadios.add(radioReprovada);
		panelStatus.add(panelRadios, BorderLayout.CENTER);
		panelStatus.add(definirButton, BorderLayout.SOUTH);
		cand.add(titleCandidato);
		cand.add(new JLabel("Nome: " + adocao.getCandidato().getNome()));
		cand.add(new JLabel("CPF: " + adocao.getCandidato().getCPF()));
		cand.add(new JLabel("Email: " + adocao.getCandidato().getEmail()));
		cand.add(new JLabel("Telefone: " + adocao.getCandidato().getTelefone()));
		cand.add(new JLabel("<html><h3>Endere�o Residencial</h3></html>"));
		cand.add(new JLabel("Rua: " + adocao.getCandidato().getEndereco().getRua()));
		cand.add(new JLabel("N�mero: " + adocao.getCandidato().getEndereco().getNumero()));
		cand.add(new JLabel("Bairro: " + adocao.getCandidato().getEndereco().getBairro()));
		cand.add(new JLabel("Complemento: " + adocao.getCandidato().getEndereco().getComplemento()));
		cand.add(new JLabel("Cidade: " + adocao.getCandidato().getEndereco().getCidade()));
		cand.add(new JLabel("CEP: " + adocao.getCandidato().getEndereco().getCep()));
		cand.add(new JLabel("Estado: " + adocao.getCandidato().getEndereco().getEstado()));
		add(BorderLayout.WEST, scrollAnim);
		add(BorderLayout.CENTER, scrollCand);
		add(BorderLayout.SOUTH, panelStatus);
	}

	public JButton getDefinirButton() {
		return definirButton;
	}

	public Adocao getAdocao() {
		return adocao;
	}

	public JRadioButton getRadioAprovada() {
		return radioAprovada;
	}

	public JRadioButton getRadioReprovada() {
		return radioReprovada;
	}

	public JRadioButton getRadioEmAnalise() {
		return radioEmAnalise;
	}

	public Administrador getAdm() {
		return adm;
	}
}
