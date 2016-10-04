package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.BancoDados;
import model.Candidato;
import model.Endereco;
import view.CadastroCandidato;

public class ControllerCandidato implements ActionListener {
	private CadastroCandidato cCandidato;
	private BancoDados bd = new BancoDados();

	public ControllerCandidato(CadastroCandidato cCandidato) {
		super();
		this.cCandidato = cCandidato;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cCandidato.getEnviarForm()) {
			try {
				int num = Integer.parseInt(cCandidato.getImputNumero().getText());
				String estado = (cCandidato.getEstados().getSelectedItem().toString());
				Endereco endereco = new Endereco(cCandidato.getImputRua().getText(),
						cCandidato.getImputComplemento().getText(), cCandidato.getImputBairro().getText(),
						cCandidato.getImputCidade().getText(), cCandidato.getImputCep().getText(),
						estado, num);
				Candidato c = new Candidato(cCandidato.getImputNome().getText(), cCandidato.getImputEmail().getText(),
						cCandidato.getImputUsername().getText(), cCandidato.getImputSenha().getText(),
						cCandidato.getImputFone().getText(), endereco);
				bd.getCandidatos().add(c);
				JOptionPane.showMessageDialog(null, "Enviado com Sucesso");
				limparDados();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "O campo número deve conter um número inteiro.");
			}
			System.out.println(bd.getCandidatos().get(0).getEndereco().getCidade());
			System.out.println(bd.getCandidatos().get(0).getEndereco().getEstado());

		} else if (e.getSource() == cCandidato.getLimparDados()) {
			limparDados();
		}
	}

	public void limparDados() {
		cCandidato.getImputBairro().setText(null);
		cCandidato.getImputCep().setText(null);
		cCandidato.getImputCidade().setText(null);
		cCandidato.getImputComplemento().setText(null);
		cCandidato.getImputEmail().setText(null);
		cCandidato.getEstados().setSelectedIndex(0);
		cCandidato.getImputNome().setText(null);
		cCandidato.getImputNumero().setText(null);
		cCandidato.getImputRua().setText(null);
		cCandidato.getImputSenha().setText(null);
		cCandidato.getImputUsername().setText(null);
		cCandidato.getImputFone().setText(null);
	}

}
