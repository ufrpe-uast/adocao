package controller;

import java.awt.Color;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.Administrador;
import model.BancoDados;
import model.Candidato;
import model.Sessao;
import view.CadastroCandidato;
import view.DadosAdministrador;
import view.ListaAnimais;
import view.ListaAnimais;
import view.TelaInicial;

public class ControllerInicial implements MouseListener, ActionListener {
	private TelaInicial telaInicial;

	public ControllerInicial(TelaInicial telaInicial) {
		this.telaInicial = telaInicial;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int cont = 0;
		if (e.getSource() == telaInicial.getRecuperar()) {
			String cpf = retiraCaracteres(JOptionPane.showInputDialog(telaInicial, "Digite seu CPF:"));

			for (Administrador adm : BancoDados.adms) {
				String cpfCand = retiraCaracteres(adm.getCpf());
				System.out.println(cpf);
				System.out.println(cpfCand);
				if (cpfCand.equals(cpf)) {
					DadosAdministrador dadosAdm = new DadosAdministrador(adm);
					dadosAdm.setVisible(true);
					cont++;
				}
			}
			if ((cont == 0) && (cpf != "")) {
				JOptionPane.showMessageDialog(null, "Administrador não Encontrado", "Recuperar Senha",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public String retiraCaracteres(String str) {
		if (str != null) {

			return str.replaceAll("[^0123456789]", "");

		} else {

			return "";

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == telaInicial.getRecuperar()) {
			telaInicial.getRecuperar().setForeground(Color.BLUE);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == telaInicial.getRecuperar()) {
			telaInicial.getRecuperar().setForeground(Color.BLACK);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaInicial.getEntrar()) {
			int cont = 0;
			for (int i = 0; i < BancoDados.adms.size(); i++) {
				Administrador adm = BancoDados.adms.get(i);
				if (telaInicial.getImputLogin().getText().equals(adm.getUsuario())
						&& (telaInicial.getImputSenha().getText().equals(adm.getSenha()))) {
					view.Menu menu = new view.Menu(telaInicial, new Sessao(adm));
					telaInicial.getImputLogin().setText(null);
					telaInicial.getImputSenha().setText(null);
					telaInicial.setVisible(false);
					JOptionPane.showMessageDialog(menu, "Bem Vindo, Login Efetuado com Sucesso");
					cont++;
				}
			}
			if (cont == 0) {
				JOptionPane.showMessageDialog(telaInicial, "Login ou Senha Incorretos");
				telaInicial.getImputLogin().setText(null);
				telaInicial.getImputSenha().setText(null);
			}

		}
		if (e.getSource() == telaInicial.getConsultarAnimais()) {
			ListaAnimais listaAnimais = new ListaAnimais();
			listaAnimais.setVisible(true);
		}

	}

}
