package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Animal;
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
						cCandidato.getImputCidade().getText(), cCandidato.getImputCep().getText(), estado, num);
				Candidato c = new Candidato(cCandidato.getImputNome().getText(), cCandidato.getImputCpf().getText(),
						cCandidato.getImputEmail().getText(), cCandidato.getImputUsername().getText(),
						cCandidato.getImputSenha().getText(), cCandidato.getImputFone().getText(), endereco);
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
		if (e.getSource()== cCandidato.getAlterar()) {
			/*int index = Integer.parseInt(ca.getImputId().getText());
			Animal anim = BancoDados.animais.get(index - 1);
			try {
				int idade = Integer.parseInt(ca.getImputIdade().getText());
				float peso = Float.parseFloat(ca.getImputPeso().getText());
				// Alteração dos Dados
				anim.setNome(ca.getImputNome().getText());
				anim.setRaca(ca.getImputRaca().getText());
				anim.setSexo(ca.getSexoOption().getSelectedItem().toString());
				anim.setIdade(idade);
				anim.setPeso(peso);
				anim.setDescricao(ca.getImputDescricao().getText());
				anim.setId(Integer.parseInt(ca.getImputId().getText()));

				// Alterando e Limpando os dados da Tela
				JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!");
				ca.limparDados();
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"                    Para Realizar a Alteração\n"
								+ "O campo IDADE deve conter um número inteiro.\n"
								+ "O campo PESO deve conter um número inteiro ou real.");*/
		}
	}

}
