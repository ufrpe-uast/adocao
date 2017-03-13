package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.BancoDados;
import model.Relatorio;
import view.DetalheAdocao;

public class ControllerDetalheAdocao implements ActionListener {
	private DetalheAdocao dAdocao;

	public ControllerDetalheAdocao(DetalheAdocao dAdocao) {
		this.dAdocao = dAdocao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dAdocao.getDefinirButton()) {
			if (dAdocao.getAdocao().getStatus().equals("")) {
				definirStatus();
			} else {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar o status da ado��o?",
						"Alterar Status", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					definirStatus();
				}
			}
		}
	}

	public void definirStatus() {
		if (dAdocao.getRadioAprovada().isSelected()) {
			dAdocao.getAdocao().setStatus("Aprovada");
			BancoDados.relatorios.add(new Relatorio(dAdocao.getAdocao(), dAdocao.getAdm()));
			JOptionPane.showMessageDialog(null, "Status definido com Sucesso!");
			dAdocao.getGrupoRadio().clearSelection();
		} else if (dAdocao.getRadioEmAnalise().isSelected()) {
			dAdocao.getAdocao().setStatus("EmAnalise");
			BancoDados.relatorios.add(new Relatorio(dAdocao.getAdocao(), dAdocao.getAdm()));
			JOptionPane.showMessageDialog(null, "Status definido com Sucesso!");
			dAdocao.getGrupoRadio().clearSelection();
		} else if (dAdocao.getRadioReprovada().isSelected()) {
			dAdocao.getAdocao().setStatus("Reprovada");
			JOptionPane.showMessageDialog(null, "Status definido com Sucesso!");
			BancoDados.relatorios.add(new Relatorio(dAdocao.getAdocao(), dAdocao.getAdm()));
			dAdocao.getGrupoRadio().clearSelection();
		}
	}
}
