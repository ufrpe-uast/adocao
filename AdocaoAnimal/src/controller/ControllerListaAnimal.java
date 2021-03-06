package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.Animal;
import model.BancoDados;
import view.CadastroCandidato;
import view.ListaAnimais;
import view.ListaAnimais;

public class ControllerListaAnimal implements ActionListener {
	private ListaAnimais listAnimais;
	private JList<Animal> animais;

	public ControllerListaAnimal(ListaAnimais listAnimais) {
		this.listAnimais = listAnimais;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == listAnimais.getAdotarAnimal()) {
			if (listAnimais.getAnimalRenderer().isCondition()) {
				CadastroCandidato cadastroCandExterno = new CadastroCandidato();
				cadastroCandExterno.setAnimal(listAnimais.getAnimalRenderer().getAnimalSelecionado());
				cadastroCandExterno.setVisible(true);
				listAnimais.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(listAnimais, "Desculpe, Nenhum Animal foi Selecionado!");
			}
		}
	}

}
