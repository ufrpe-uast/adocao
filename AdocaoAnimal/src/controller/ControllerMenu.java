package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CadastroAnimal;
import view.Menu;

public class ControllerMenu implements ActionListener {
	private Menu menu;

	public ControllerMenu(Menu menu) {
		super();
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu.getCadastrarAnimal()) {
			CadastroAnimal cadastrarAnimal = new CadastroAnimal();
			cadastrarAnimal.setVisible(true);
		}
		else if (e.getSource()==menu.getSair()) {
			System.exit(0);
		}
	}
}