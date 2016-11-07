package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Administrador;
import model.BancoDados;
import view.DadosAdministrador;

public class ControllerDadosAdm implements ActionListener {
	private DadosAdministrador dadosAdm;
	private boolean condition = false;

	public ControllerDadosAdm(DadosAdministrador dadosAdm) {
		this.dadosAdm = dadosAdm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dadosAdm.getEditar()) {
			dadosAdm.getImputLogin().setEditable(true);
			dadosAdm.getImputSenha().setEditable(true);
			condition = true;
		} else if (e.getSource() == dadosAdm.getAlterar()) {
			if (condition) {
				for (Administrador adm : BancoDados.adms) {
					if (adm.equals(dadosAdm.getAdm())) {
						adm.setUsuario(dadosAdm.getImputLogin().getText());
						adm.setSenha(dadosAdm.getImputSenha().getText());
						JOptionPane.showMessageDialog(dadosAdm,
								"Sucesso, Alteração dos Dados de Acesso bem Sucedida. ");
						dadosAdm.getImputLogin().setEditable(false);
						dadosAdm.getImputSenha().setEditable(false);
						System.out.println("Login:" + dadosAdm.getAdm().getUsuario());
						System.out.println("Senha:" + dadosAdm.getAdm().getSenha());
					}
				}
			} else {
				JOptionPane.showMessageDialog(dadosAdm, "Desculpe, os campos de Login e Senha não foram editados");
			}
		}

	}

}
