package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Adocao;

public class DetalheAdocao extends Tela {
	private Adocao adocao;

	public DetalheAdocao(Adocao adocao) {
		super("Detalhes da Adoção", 550, 500);

		this.adocao = adocao;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel anim = new JPanel();
		JPanel cand = new JPanel();

		JButton bot = new JButton("Aprovar Adoção");

		JLabel titleAnimal = new JLabel("Animal à ser Adotado:");
		titleAnimal.setFont(new Font("Arial", Font.BOLD, 18));
		titleAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		anim.setLayout(new GridLayout(7, 1));
		anim.setBackground(Color.WHITE);
		anim.add(titleAnimal);
		anim.add(new JLabel("Nome: " + adocao.getAnimal().getNome()));
		anim.add(new JLabel("Raça: " + adocao.getAnimal().getRaca()));
		anim.add(new JLabel("Sexo: " + adocao.getAnimal().getSexo()));
		anim.add(new JLabel("Idade: " + adocao.getAnimal().getIdade() + " anos"));
		anim.add(new JLabel("Peso: " + adocao.getAnimal().getPeso() + " kg"));
		anim.add(new JLabel("Descricao: " + adocao.getAnimal().getDescricao()));

		JLabel titleCandidato = new JLabel("Quem deseja Adotar:");
		titleCandidato.setFont(new Font("Arial", Font.BOLD, 18));
		titleCandidato.setHorizontalAlignment(SwingConstants.CENTER);
		cand.setLayout(new GridLayout(13, 1));
		cand.setBackground(Color.WHITE);
		cand.add(titleCandidato);
		cand.add(new JLabel("Nome: " + adocao.getCandidato().getNome()));
		cand.add(new JLabel("CPF: " + adocao.getCandidato().getCPF()));
		cand.add(new JLabel("Email: " + adocao.getCandidato().getEmail()));
		cand.add(new JLabel("Telefone: " + adocao.getCandidato().getTelefone()));
		cand.add(new JLabel("<html><h3>Informações de Endereço</h3></html>"));
		cand.add(new JLabel("Rua: " + adocao.getCandidato().getEndereco().getRua()));
		cand.add(new JLabel("Número: " + adocao.getCandidato().getEndereco().getNumero()));
		cand.add(new JLabel("Bairro: " + adocao.getCandidato().getEndereco().getBairro()));
		cand.add(new JLabel("Complemento: " + adocao.getCandidato().getEndereco().getComplemento()));
		cand.add(new JLabel("Cidade: " + adocao.getCandidato().getEndereco().getCidade()));
		cand.add(new JLabel("CEP: " + adocao.getCandidato().getEndereco().getCep()));
		cand.add(new JLabel("Estado: " + adocao.getCandidato().getEndereco().getEstado()));

		JScrollPane scrollAnim = new JScrollPane(anim);
		JScrollPane scrollCand = new JScrollPane(cand);
		add(BorderLayout.WEST, scrollAnim);
		add(BorderLayout.CENTER, scrollCand);
		add(BorderLayout.SOUTH,bot);

		setVisible(true);
	}

}
