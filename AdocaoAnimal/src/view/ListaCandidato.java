package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Animal;
import model.BancoDados;
import model.Candidato;

public class ListaCandidato extends TelaInterna {

	public ListaCandidato() {
		super("Candidatos", 900, 500);
		setLayout(new FlowLayout());
		setLocation(60, 25);
		for (Candidato cand : BancoDados.candidatos) {
			JPanel pan = new JPanel();
			pan.setSize(200, 200);
			pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			pan.add(new JLabel("<html>" + "<p> Nome: " + cand.getNome() + "</p>" + "<p> CPF: " + cand.getCPF() + "</p>"
					+ "<p> Email: " + cand.getEmail() + "</p>" + "<p> Fone: " + cand.getTelefone() + "</p>"
					+ "<p> Endereço: " + cand.getEndereco().getRua() + "," + cand.getEndereco().getNumero() + "-"
					+ cand.getEndereco().getComplemento() + " </p>" + "<p>" + cand.getEndereco().getBairro() + "/"
				+ cand.getEndereco().getCidade() +"-"+cand.getEndereco().getEstado() + "</p>" + "<p>"
					+ cand.getEndereco().getCep() + "</p>" + "</html>"));
			this.add(pan);
		}
	}

}
