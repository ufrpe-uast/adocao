package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.ControllerAdocao;
import model.Adocao;
import model.BancoDados;
import model.Relatorio;

public class TelaRelatorioAdocao extends TelaInterna {
	JPanel panelAprovadas, panelReprovadas, panelEmAnalise;
	JTabbedPane pane;
	JTable tabelaAprovadas;
	private JList<Relatorio> relatorios;

	public TelaRelatorioAdocao() {
		super("Ado��es", 670, 400);
		setLayout(new BorderLayout());
		pane = new JTabbedPane();
		panelAprovadas = new JPanel();
		panelAprovadas = createMainPanel("Aprovada");
		panelReprovadas = new JPanel();
		panelReprovadas = createMainPanel("Reprovada");
		panelEmAnalise = new JPanel();
		panelEmAnalise = createMainPanel("EmAnalise");
		pane.add(panelAprovadas, "Aprovadas");
		pane.add(panelEmAnalise, "Em Anal�se");
		pane.add(panelReprovadas, "Reprovadas");
		add(pane);
		setLocation(175, 20);

	}

	private JPanel createMainPanel(String status) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(new JScrollPane(relatorios = createListRelatorio(status)), BorderLayout.CENTER);
		return panel;
	}

	public JList<Relatorio> createListRelatorio(String status) {
		DefaultListModel<Relatorio> model = new DefaultListModel<>();
		for (Relatorio relatorio : BancoDados.relatorios) {
			if (relatorio.getAdocao().getStatus().equalsIgnoreCase(status)) {
				model.addElement(relatorio);
			}
		}
		JList<Relatorio> list = new JList<Relatorio>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return list;
	}
}
