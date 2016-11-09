package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import model.Adocao;
import model.Animal;
import model.BancoDados;
import model.Candidato;

public class ListaCandidatos extends TelaInterna {
	private JList<Candidato> candidatos;

	public ListaCandidatos() {
		super("Candidatos", 600, 500);
		setLayout(new BorderLayout());
		add(createMainPanel(), BorderLayout.CENTER);
		setLocation(210, 25);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.add(new JScrollPane(candidatos = createListCandidatos()), BorderLayout.CENTER);
		return panel;
	}

	public JList<Candidato> createListCandidatos() {
		DefaultListModel<Candidato> model = new DefaultListModel<>();
		for (Candidato candidato : BancoDados.candidatos) {
			model.addElement(candidato);
		}
		JList<Candidato> list = new JList<Candidato>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return list;
	}

	public JList<Candidato> getCandidatos() {
		return candidatos;
	}

}
