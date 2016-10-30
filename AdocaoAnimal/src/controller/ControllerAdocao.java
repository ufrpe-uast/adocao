package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Animal;
import model.BancoDados;
import view.CadastroCandidatoExterno;
import view.ListaAnimais;

public class ControllerAdocao implements ActionListener {

	private Animal animal;
	private JButton adotar;
	
	public ControllerAdocao(Animal animal, JButton adotar) {
		this.animal = animal;
		this.adotar = adotar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adotar) {
			new CadastroCandidatoExterno(animal).setVisible(true);
//			JOptionPane.showMessageDialog(null, "Adotado: "+animal.getNome());
			System.out.println(BancoDados.adocoes);
		}
	}

	
	
}
