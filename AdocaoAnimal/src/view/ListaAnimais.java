package view;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.ControllerAdocao;
import model.Animal;
import model.BancoDados;

public class ListaAnimais extends Tela {
	private JList<Animal> listAnimal;
	private JButton adotarAnimal;
	private ControllerAdocao ca;
	private AnimalRenderer animalRenderer;
	
	public ListaAnimais() {
		super("Animais Cadastrados", 550, 600);
		animalRenderer = new AnimalRenderer();
		setLayout(new BorderLayout());
		add(createMainPanel(), BorderLayout.CENTER);
		ca = new ControllerAdocao(this);
		adotarAnimal = new JButton("Adotar Animal");
		adotarAnimal.addActionListener(ca);
		add(adotarAnimal, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(new JScrollPane(listAnimal = createListAnimais()), BorderLayout.CENTER);
		return panel;
	}

	public JList<Animal> createListAnimais() {
		DefaultListModel<Animal> model = new DefaultListModel<>();
		for (Animal animal : BancoDados.animais) {
			model.addElement(animal);
		}
		JList<Animal> list = new JList<Animal>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(animalRenderer);
		return list;
	}

	public JButton getAdotarAnimal() {
		return adotarAnimal;
	}

	public void setAdotarAnimal(JButton adotarAnimal) {
		this.adotarAnimal = adotarAnimal;
	}

	public AnimalRenderer getAnimalRenderer() {
		return animalRenderer;
	}
}
