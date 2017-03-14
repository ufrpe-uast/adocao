package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Adocao;
import view.DetalheAdocao;
import view.TelaAdocoes;

public class ControllerAdocao implements ActionListener {
	private TelaAdocoes tAdocao;

	public ControllerAdocao(TelaAdocoes tAdocao) {
		this.tAdocao = tAdocao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tAdocao.getVerCadastro()) {
			if (!tAdocao.getAdocoes().isSelectionEmpty()) {
				DetalheAdocao dAdocao = new DetalheAdocao(tAdocao.getAdocoes().getSelectedValue(), tAdocao.getAdm());
				tAdocao.setVisible(false);
				dAdocao.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(tAdocao, "Selecione um Cadastro de Adoção na Lista ");
			}
		}

	}
}
