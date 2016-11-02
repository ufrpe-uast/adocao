package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Administrador;
import model.BancoDados;
import view.CadastroAdministrador;

public class ControllerAdministrador implements ActionListener {
	
	private CadastroAdministrador ca;
	
	public ControllerAdministrador(CadastroAdministrador ca) {
		this.ca = ca;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ca.getCadastrar()) {
			boolean existe = false;
			Administrador adm = new Administrador(ca.getNomeTF().getText(), 
					ca.getUsuarioTF().getText(), ca.getEmailTF().getText(),
					ca.getSenhaTF().getText());
			
			for(Administrador a: BancoDados.adms) {
				if(a.getUsuario().equalsIgnoreCase(adm.getUsuario()))
					existe = true;
				else
					existe = false;				
			}
			
			if(existe) {
				JOptionPane.showMessageDialog(null, "Esse usuário já existe");
				System.out.println("Usuario ja existe");
			}
			else {
				BancoDados.adms.add(adm);
				JOptionPane.showMessageDialog(null, "Administrador cadastrado com sucesso!");
				limpar();
			}
		}
		else if(e.getSource() == ca.getLimpar()) {
			limpar();
		}
	}
	
	public boolean admExiste(Administrador adm) {
		for(Administrador a: BancoDados.adms) {
			return (a.getUsuario().equalsIgnoreCase(adm.getUsuario())) ? true : false;
		}
		return false;
	}
	public void limpar(){
		ca.getNomeTF().setText(null);
		ca.getUsuarioTF().setText(null);
		ca.getEmailTF().setText(null);
		ca.getSenhaTF().setText(null);
	}

}
