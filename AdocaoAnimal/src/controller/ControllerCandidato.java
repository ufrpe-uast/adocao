package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Adocao;
import model.Animal;
import model.BancoDados;
import model.Candidato;
import model.Endereco;
import view.CadastroCandidato;

public class ControllerCandidato implements ActionListener {

	private CadastroCandidato cce;
	private Animal animal;

	public ControllerCandidato(CadastroCandidato cce) {
		this.cce = cce;
		this.animal = animal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cce.getEnviarForm()) {
			//Adicionando os valores da tela ao objeto.
			Candidato cand = new Candidato(cce.getImputNome().getText(), cce.getImputCpf().getText(),
					cce.getImputEmail().getText(), cce.getImputFone().getText(),
					new Endereco(cce.getImputRua().getText(), cce.getImputComplemento().getText(),
							cce.getImputBairro().getText(), cce.getImputCidade().getText(), cce.getImputCep().getText(),
							cce.getEstados().getSelectedItem().toString(),
							Integer.parseInt(cce.getImputNumero().getText())));
			//Add novo candidato , e adocao.
			BancoDados.addCand(cand);
			BancoDados.addAdocao(new Adocao(cce.getAnimal(), cand));
			JOptionPane.showMessageDialog(null, "Proposta enviada com sucesso");
			cce.limparDados();
			cce.setVisible(false);
		}
		if (e.getSource() == cce.getLimparDados())
			cce.limparDados();
	}

}
