package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Adocao;
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
			definirStatus();
		}
	}

	public void definirStatus() {
		if (dAdocao.getRadioAprovada().isSelected()) {
			verificaStatus("Aprovada");
		} else if (dAdocao.getRadioEmAnalise().isSelected()) {
			verificaStatus("EmAnalise");
		} else if (dAdocao.getRadioReprovada().isSelected()) {
			verificaStatus("Reprovada");
		}
	}

	public void verificaStatus(String status) {
		int cont = 0;
		for (int i = 0; i < BancoDados.relatorios.size(); i++) {
			Relatorio relatorio = BancoDados.relatorios.get(i);
			if (dAdocao.getAdocao().equals(relatorio.getAdocao())) {
				int resposta = JOptionPane.showConfirmDialog(null, "Alterar novamente o status da ado��o?",
						"Alterar Status", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					relatorio.getAdocao().setStatus(status);
					cont++;
				}

			}
		}
		if (cont == 0) {
			dAdocao.getAdocao().setStatus(status);
			BancoDados.relatorios.add(new Relatorio(dAdocao.getAdocao(), dAdocao.getAdm()));
			JOptionPane.showMessageDialog(null, "Status definido com Sucesso!");
			dAdocao.getGrupoRadio().clearSelection();
		}
	}
}
