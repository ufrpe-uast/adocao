package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.Animal;
import model.BancoDados;
import view.CadastroCandidatoExterno;
import view.ListaAnimais;
import view.ListaAnimais;

public class ControllerAdocao implements ActionListener {
	private ListaAnimais listAnimais;
	private JList<Animal> animais;

	public ControllerAdocao(ListaAnimais listAnimais) {
		this.listAnimais = listAnimais;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == listAnimais.getAdotarAnimal()) {
			if (listAnimais.getAnimalRenderer().isCondition()) {
				CadastroCandidatoExterno cadastroCandExterno = new CadastroCandidatoExterno(
						listAnimais.getAnimalRenderer().getAnimalSelecionado());
				cadastroCandExterno.setVisible(true);
				listAnimais.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(listAnimais, "Error Nenhum Animal Selecionado!");
			}
		}
	}

}
