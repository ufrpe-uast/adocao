package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Animal;
import model.BancoDados;
import model.Candidato;
import model.Endereco;
import view.CadastroCandidato;
import view.CadastroCandidatoExterno;

public class ControllerCandidato implements ActionListener {
	private CadastroCandidato cCandidato;
	private CadastroCandidatoExterno cCandidatoExt;
	private BancoDados bd = new BancoDados();

	public ControllerCandidato(CadastroCandidato cCandidato) {
		super();
		this.cCandidato = cCandidato;
	}

	public ControllerCandidato(CadastroCandidatoExterno cCandidato) {
		super();
		this.cCandidatoExt = cCandidato;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cCandidato.getEnviarForm()) {
			try {
				int num = Integer.parseInt(cCandidato.getImputNumero().getText());
				String estado = (cCandidato.getEstados().getSelectedItem().toString());
				Endereco endereco = new Endereco(cCandidato.getImputRua().getText(),
						cCandidato.getImputComplemento().getText(), cCandidato.getImputBairro().getText(),
						cCandidato.getImputCidade().getText(), cCandidato.getImputCep().getText(), estado, num);
				Candidato c = new Candidato(cCandidato.getImputNome().getText(), cCandidato.getImputCpf().getText(),
						cCandidato.getImputEmail().getText(),cCandidato.getImputFone().getText(), endereco);
				bd.getCandidatos().add(c);
				JOptionPane.showMessageDialog(null, "Enviado com Sucesso");
				cCandidato.limparDados();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "O campo número deve conter um número inteiro.");
			}
			System.out.println(bd.getCandidatos().get(0).getEndereco().getCidade());
			System.out.println(bd.getCandidatos().get(0).getEndereco().getEstado());

		} else if (e.getSource() == cCandidato.getLimparDados()) {
			cCandidato.limparDados();
		}
		if (e.getSource() == cCandidato.getAlterar()) {
			for (int i = 0; i < BancoDados.candidatos.size(); i++) {
				Candidato cand = BancoDados.candidatos.get(i);
				String numCpf = cCandidato.retiraCaracteres(cCandidato.getImputCpf().getText());

				if (cand.getCPF().equalsIgnoreCase(numCpf)) {
					try {
						int num = Integer.parseInt(cCandidato.getImputNumero().getText());
						cand.setCPF(cCandidato.getImputCpf().getText());
						cand.setNome(cCandidato.getImputNome().getText());
						cand.setEmail(cCandidato.getImputEmail().getText());
						cand.setTelefone(cCandidato.getImputFone().getText());
						Endereco end = new Endereco(cCandidato.getImputRua().getText(),
								cCandidato.getImputComplemento().getText(), cCandidato.getImputBairro().getText(),
								cCandidato.getImputCidade().getText(), cCandidato.getImputCep().getText(),
								cCandidato.getEstados().getName(), num);
						cand.setEndereco(end);
						// Alterando e Limpando os dados da Tela
						JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!");
						cCandidato.limparDados();
					} catch (NumberFormatException e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "                    Para Realizar a Alteração\n"
								+ "O campo NUMERO deve conter um número inteiro.\n");
					}

				}
			}
		}

	}

}
