package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.Animal;

public class AnimalRenderer extends JPanel implements ListCellRenderer<Animal> {
	private JLabel lbId = new JLabel();
	private JLabel lbName = new JLabel();
	private JLabel lbSexo = new JLabel();
	private JLabel lbRaca = new JLabel();
	private JLabel lbIdade = new JLabel();
	private JLabel lbPeso = new JLabel();
	private JLabel lbDescricao = new JLabel();
	private JLabel lbIcon = new JLabel();
	private boolean condition;
	private Animal animalSelecionado;

	public AnimalRenderer() {
		setLayout(new BorderLayout());
		setSize(250, 100);
		JPanel panelText = new JPanel(new GridLayout(0, 1));
		JPanel dados = new JPanel(new GridLayout(0, 1));
		dados.add(new JLabel("ID:"));
		dados.add(new JLabel("Nome:"));
		dados.add(new JLabel("Sexo:"));
		dados.add(new JLabel("Raca:"));
		dados.add(new JLabel("Idade:"));
		dados.add(new JLabel("Peso:"));
		dados.add(new JLabel("Descrição:"));
		panelText.setBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)));
		lbIcon.setBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)));
		panelText.add(lbId);
		panelText.add(lbName);
		panelText.add(lbSexo);
		panelText.add(lbRaca);
		panelText.add(lbIdade);
		panelText.add(lbPeso);
		panelText.add(lbDescricao);
		add(lbIcon, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
		// add(dados, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Animal> listAnimal, Animal animal, int index,
			boolean isSelected, boolean elementoFocalizado) {
		ImageIcon imagem = new ImageIcon("resource/" + animal.getNomeImagem());
		ImageIcon imagemRedimensionada = new ImageIcon(
				imagem.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT));
		lbIcon.setIcon(imagemRedimensionada);
		lbId.setText("ID:  " + Integer.toString(animal.getId()));
		lbId.setForeground(Color.BLUE);
		lbName.setText("Nome:  " + animal.getNome());
		lbSexo.setText("Sexo:  " + animal.getSexo());
		lbRaca.setText("Raça:  " + animal.getRaca());
		lbIdade.setText("Idade:  " + Integer.toString(animal.getIdade()) + " Anos");
		lbPeso.setText("Peso:  " + Float.toString(animal.getPeso()) + " Kg");
		lbDescricao.setText("Descrição:  " + animal.getDescricao());

		// set Opaque to change background color of JLabel
		lbIcon.setOpaque(true);
		lbId.setOpaque(true);
		lbName.setOpaque(true);
		lbSexo.setOpaque(true);
		lbRaca.setOpaque(true);
		lbIdade.setOpaque(true);
		lbPeso.setOpaque(true);
		lbDescricao.setOpaque(true);

		if (isSelected) {
			this.condition = true;
			this.animalSelecionado = animal;
			lbName.setBackground(listAnimal.getSelectionBackground());
			lbId.setBackground(listAnimal.getSelectionBackground());
			lbIcon.setBackground(listAnimal.getSelectionBackground());
			lbSexo.setBackground(listAnimal.getSelectionBackground());
			lbRaca.setBackground(listAnimal.getSelectionBackground());
			lbIdade.setBackground(listAnimal.getSelectionBackground());
			lbPeso.setBackground(listAnimal.getSelectionBackground());
			lbDescricao.setBackground(listAnimal.getSelectionBackground());
		} else {
			this.condition = false;
			lbName.setBackground(listAnimal.getBackground());
			lbName.setBackground(listAnimal.getBackground());
			lbId.setBackground(listAnimal.getBackground());
			lbIcon.setBackground(listAnimal.getBackground());
			lbSexo.setBackground(listAnimal.getBackground());
			lbRaca.setBackground(listAnimal.getBackground());
			lbIdade.setBackground(listAnimal.getBackground());
			lbPeso.setBackground(listAnimal.getBackground());
			lbDescricao.setBackground(listAnimal.getBackground());
		}

		return this;
	}

	public Animal getAnimalSelecionado() {
		return animalSelecionado;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}
}
