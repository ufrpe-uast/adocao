package controller;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.Administrador;
import model.Candidato;
import view.ListaAnimais;
import view.TelaInicial;

public class ControllerInicial implements MouseListener, ActionListener{
	private TelaInicial telaInicial;
	public static Administrador adm;
	private Candidato usr;

	public ControllerInicial(TelaInicial telaInicial, Administrador adm, Candidato usr) {
		this.telaInicial = telaInicial;
		this.adm = adm;
		this.usr = usr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == telaInicial.getRecuperar()) {
			String cpf = JOptionPane.showInputDialog(telaInicial, "Digite seu CPF:");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==telaInicial.getEntrar()) {
			// login admin
			if(usr == null) {
				if (telaInicial.getImputLogin().getText().equalsIgnoreCase(adm.getUsuario())&&
						(telaInicial.getImputSenha().getText().equalsIgnoreCase(adm.getUsuario()))) {
						if (telaInicial.getAdm().isSelected()) {
							view.Menu menu = new view.Menu(telaInicial);
							telaInicial.getImputLogin().setText(null);
							telaInicial.getImputSenha().setText(null);
							telaInicial.getAdm().setSelected(false);
							telaInicial.setVisible(false);
							JOptionPane.showMessageDialog(menu, "Bem Vindo, Login Efetuado com Sucesso");
						}
						else if (telaInicial.getUsuario().isSelected()) {
							JOptionPane.showMessageDialog(telaInicial, "Login de Administrador, Insira um Login de Usuário Válido.");
						}
						else{
							JOptionPane.showMessageDialog(telaInicial, "Selecione um Tipo de Acesso");
						}
				}
				else {
					JOptionPane.showMessageDialog(telaInicial, "Login ou Senha Incorretos");
					telaInicial.getImputLogin().setText(null);
					telaInicial.getImputSenha().setText(null);
				}
			}
			
			// login usuario
			if(adm == null) {
				if (telaInicial.getImputLogin().getText().equalsIgnoreCase(adm.getUsuario())&&
						(telaInicial.getImputSenha().getText().equalsIgnoreCase(adm.getUsuario()))) {
						if (telaInicial.getAdm().isSelected()) {
							view.Menu menu = new view.Menu(telaInicial);
							telaInicial.getImputLogin().setText(null);
							telaInicial.getImputSenha().setText(null);
							telaInicial.getAdm().setSelected(false);
							telaInicial.setVisible(false);
							JOptionPane.showMessageDialog(menu, "Bem Vindo, Login Efetuado com Sucesso");
						}
						else if (telaInicial.getUsuario().isSelected()) {
							JOptionPane.showMessageDialog(telaInicial, "Login de Administrador, Insira um Login de Usuário Válido.");
						}
						else{
							JOptionPane.showMessageDialog(telaInicial, "Selecione um Tipo de Acesso");
						}
				}
				else {
					JOptionPane.showMessageDialog(telaInicial, "Login ou Senha Incorretos");
					telaInicial.getImputLogin().setText(null);
					telaInicial.getImputSenha().setText(null);
				}
			}
		}
		if (e.getSource()==telaInicial.getConsultarAnimais()) {
			view.Menu menu = new view.Menu(telaInicial);
			menu.setTelaListarAnimal(new ListaAnimais());
			menu.getTelaListarAnimal().setVisible(true);
			menu.getDesktop().add(menu.getTelaListarAnimal());
		}
	}

}
