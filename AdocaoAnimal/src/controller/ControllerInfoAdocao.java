package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Adocao;
import view.DetalheAdocao;

public class ControllerInfoAdocao implements ActionListener {

	private Adocao adocao;
	private JButton mais;
	
	public ControllerInfoAdocao(Adocao adocao, JButton mais) {
		this.adocao = adocao;
		this.mais = mais;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mais) {
			new DetalheAdocao(adocao);
		}
	}

}
