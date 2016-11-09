package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controller.ControllerAdocao;
import model.Adocao;
import model.Animal;
import model.BancoDados;

public class TelaAdocoes extends TelaInterna {
	private JList<Adocao> adocoes;
	private ControllerAdocao cia;
	private JButton verCadastro;

	public TelaAdocoes() {
		super("Adoções", 550, 400);
		setLayout(new BorderLayout());
		cia = new ControllerAdocao(this);
		verCadastro = new JButton("Visualizar Todas as Informações");
		verCadastro.addActionListener(cia);
		add(createMainPanel(), BorderLayout.CENTER);
		add(verCadastro, BorderLayout.SOUTH);
		setLocation(230, 20);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(new JScrollPane(adocoes = createListAdocoes()), BorderLayout.CENTER);
		return panel;
	}

	public JList<Adocao> createListAdocoes() {
		DefaultListModel<Adocao> model = new DefaultListModel<>();
		for (Adocao adocao : BancoDados.adocoes) {
			model.addElement(adocao);
		}
		JList<Adocao> list = new JList<Adocao>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return list;
	}

	public JButton getVerCadastro() {
		return verCadastro;
	}

	public void setVerCadastro(JButton verCadastro) {
		this.verCadastro = verCadastro;
	}

	public JList<Adocao> getAdocoes() {
		return adocoes;
	}
}
