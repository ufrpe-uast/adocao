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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cce.getEnviarForm()) {
			// Adicionando os valores da tela ao objeto.
			Candidato cand = new Candidato(cce.getImputNome().getText(), cce.getImputCpf().getText(),
					cce.getImputEmail().getText(), cce.getImputFone().getText(),
					new Endereco(cce.getImputRua().getText(), cce.getImputComplemento().getText(),
							cce.getImputBairro().getText(), cce.getImputCidade().getText(), cce.getImputCep().getText(),
							cce.getEstados().getSelectedItem().toString(),
							Integer.parseInt(cce.getImputNumero().getText())));
			// Add novo candidato , e adocao.
			BancoDados.addCand(cand);
			BancoDados.addAdocao(new Adocao(cce.getAnimal(), cand));
			JOptionPane.showMessageDialog(null, "Proposta enviada com sucesso");
			cce.limparDados();
			cce.setVisible(false);
		}
		if (e.getSource() == cce.getAlterar()) {
			String numCpf = cce.retiraCaracteres(cce.getImputCpf().getText());
			for (int i = 0; i < BancoDados.candidatos.size(); i++) {
				Candidato cand = BancoDados.candidatos.get(i);
				String cpfCand = cce.retiraCaracteres(cand.getCPF());
				if (cpfCand.equalsIgnoreCase(numCpf)) {
					try {
						int num = Integer.parseInt(cce.getImputNumero().getText());
						cand.setCPF(cce.getImputCpf().getText());
						cand.setNome(cce.getImputNome().getText());
						cand.setEmail(cce.getImputEmail().getText());
						cand.setTelefone(cce.getImputFone().getText());
						Endereco end = new Endereco(cce.getImputRua().getText(), cce.getImputComplemento().getText(),
								cce.getImputBairro().getText(), cce.getImputCidade().getText(),
								cce.getImputCep().getText(), cce.getEstados().getSelectedItem().toString(), num);
						cand.setEndereco(end);
						// Alterando e Limpando os dados da Tela
						JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!");
						cce.limparDados();
					} catch (NumberFormatException e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "                    Para Realizar a Alteração\n"
								+ "O campo NUMERO deve conter um número inteiro.\n");
					}
				}
			}
		}

		if (e.getSource() == cce.getLimparDados())
			cce.limparDados();
	}

}
