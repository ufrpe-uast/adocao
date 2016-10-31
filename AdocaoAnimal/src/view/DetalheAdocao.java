package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adocao;

public class DetalheAdocao extends Tela {

	private Adocao adocao;
	
	public DetalheAdocao(Adocao adocao) {
		super("Detalhes da Adoção", 600, 600);
		
		this.adocao = adocao;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		JLabel titulo = new JLabel("Detalhes da Adoção");
		titulo.setFont(new Font("", Font.BOLD, 30));
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, titulo);
		
		JPanel anim = new JPanel();
		JPanel cand = new JPanel();
		JButton bot = new JButton("Aprovar Adoção");
		
		anim.setLayout(new GridLayout(7, 1));
		anim.add(new JLabel("<html><h2>Informações do Animal</h2></html>"));
		anim.add(new JLabel("Nome: "+adocao.getAnimal().getNome()));
		anim.add(new JLabel("Raça: "+adocao.getAnimal().getRaca()));
		anim.add(new JLabel("Sexo: "+adocao.getAnimal().getSexo()));
		anim.add(new JLabel("Idade: "+adocao.getAnimal().getIdade()+" anos"));
		anim.add(new JLabel("Peso: "+adocao.getAnimal().getPeso()+" kg"));
		anim.add(new JLabel("Descricao: "+adocao.getAnimal().getDescricao()));
		
		cand.setLayout(new GridLayout(13, 1));
		cand.add(new JLabel("<html><h2>Informações do Candidato</h2></html>"));
		cand.add(new JLabel("Nome: "+adocao.getCandidato().getNome()));
		cand.add(new JLabel("CPF: "+adocao.getCandidato().getCPF()));
		cand.add(new JLabel("Email: "+adocao.getCandidato().getEmail()));
		cand.add(new JLabel("Telefone: "+adocao.getCandidato().getTelefone()));
		cand.add(new JLabel("<html><h4>Informações de Endereço</h4></html>"));
		cand.add(new JLabel("Rua: "+adocao.getCandidato().getEndereco().getRua()));
		cand.add(new JLabel("Número: "+adocao.getCandidato().getEndereco().getNumero()));
		cand.add(new JLabel("Bairro: "+adocao.getCandidato().getEndereco().getBairro()));
		cand.add(new JLabel("Complemento: "+adocao.getCandidato().getEndereco().getComplemento()));
		cand.add(new JLabel("Cidade: "+adocao.getCandidato().getEndereco().getCidade()));
		cand.add(new JLabel("CEP: "+adocao.getCandidato().getEndereco().getCep()));
		cand.add(new JLabel("Estado: "+adocao.getCandidato().getEndereco().getEstado()));
		
		add(BorderLayout.WEST, anim);
		add(BorderLayout.EAST, cand);
		add(BorderLayout.SOUTH, bot);
		
		setVisible(true);
	}

}
