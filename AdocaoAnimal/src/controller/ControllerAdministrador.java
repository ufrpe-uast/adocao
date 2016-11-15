package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Administrador;
import model.BancoDados;
import model.Endereco;
import view.CadastroAdministrador;

public class ControllerAdministrador implements ActionListener {

	private CadastroAdministrador ca;

	public ControllerAdministrador(CadastroAdministrador ca) {
		this.ca = ca;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ca.getCadastrar()) {
			boolean existe = false;
			
			if(ca.getImputNome().getText().equalsIgnoreCase("") || ca.getImputBairro().getText().equalsIgnoreCase("")
					|| ca.getImputCep().getText().equalsIgnoreCase("") || ca.getImputCidade().getText().equalsIgnoreCase("")
					|| ca.getImputComplemento().getText().equalsIgnoreCase("") || ca.getImputCpf().getText().equalsIgnoreCase("")
					|| ca.getImputEmail().getText().equalsIgnoreCase("") || ca.getImputFone().getText().equalsIgnoreCase("")
					|| ca.getImputNumero().getText().equalsIgnoreCase("") || ca.getImputRg().getText().equalsIgnoreCase("")
					|| ca.getImputRua().getText().equalsIgnoreCase("") || ca.getImputUsuario().getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
				return;
			}
			
			Endereco endereco = new Endereco(ca.getImputRua().getText(), ca.getImputComplemento().getText(),
					ca.getImputBairro().getText(), ca.getImputCidade().getText(), ca.getImputCep().getText(),
					ca.getEstados().getSelectedItem().toString(), Integer.parseInt(ca.getImputNumero().getText()));
			Administrador adm = new Administrador(ca.getImputCpf().getText(), ca.getImputRg().getText(),
					ca.getImputNome().getText(), ca.getImputEmail().getText(), ca.getImputUsuario().getText(),
					ca.getSenhaTF().getText(), ca.getImputFone().getText(), endereco);

			for (Administrador a : BancoDados.adms) {
				if (a.getUsuario().equalsIgnoreCase(adm.getUsuario()))
					existe = true;
				else
					existe = false;
			}

			if (existe) {
				JOptionPane.showMessageDialog(null, "Esse usuário já existe");
				System.out.println("Usuario ja existe");
			} else {
				BancoDados.adms.add(adm);
				JOptionPane.showMessageDialog(null, "Administrador cadastrado com sucesso!");
				ca.limparDados();
			}
		} else if (e.getSource() == ca.getLimpar()) {
			ca.limparDados();
		}
	}

	public boolean admExiste(Administrador adm) {
		for (Administrador a : BancoDados.adms) {
			return (a.getUsuario().equalsIgnoreCase(adm.getUsuario())) ? true : false;
		}
		return false;
	}
}
