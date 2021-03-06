package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Animal;
import model.BancoDados;
import view.CadastroAnimal;

public class ControllerAnimal implements ActionListener {

	private CadastroAnimal ca;

	public ControllerAnimal(CadastroAnimal ca) {
		this.ca = ca;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ca.getCadastrar()) {
			try {
				int idade = Integer.parseInt(ca.getImputIdade().getText());
				float peso = Float.parseFloat(ca.getImputPeso().getText());
				if (ca.isAddFoto()) {
					Animal anim = new Animal(Integer.parseInt(ca.getImputId().getText()), ca.getImputNome().getText(),
							ca.getImputRaca().getText(), ca.getSexoOption().getSelectedItem().toString(), idade, peso,
							ca.getImputDescricao().getText(), ca.getImagemAnimal());
					System.out.println(anim.getId());
					BancoDados.animais.add(anim);
					JOptionPane.showMessageDialog(ca, "Animal Cadastrado com Sucesso");
					ca.limparDados();
					ca.setContatorCadastro(1);
					ca.getImputId().setText(Integer.toString(ca.getContatorCadastro()));
					ca.setAddFoto(false);
				} else {
					JOptionPane.showMessageDialog(ca, "Falha no Cadastro, Adicione uma foto para o Animal");
				}

			} catch (NumberFormatException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"O campo idade deve conter um n�mero inteiro.\n"
								+ "O campo peso deve conter um n�mero inteiro ou real.\n"
								+ "Selecione uma Foto para este Animal");
			}

		} else if (e.getSource() == ca.getAlterar()) {

			int index = Integer.parseInt(ca.getImputId().getText());
			Animal anim = BancoDados.animais.get(index - 1);
			try {

				int idade = Integer.parseInt(ca.getImputIdade().getText());
				float peso = Float.parseFloat(ca.getImputPeso().getText());
				// Altera��o dos Dados
				anim.setNome(ca.getImputNome().getText());
				anim.setRaca(ca.getImputRaca().getText());
				anim.setSexo(ca.getSexoOption().getSelectedItem().toString());
				anim.setIdade(idade);
				anim.setPeso(peso);
				anim.setDescricao(ca.getImputDescricao().getText());
				anim.setId(Integer.parseInt(ca.getImputId().getText()));
				JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!");
				ca.limparDados();

			} catch (NumberFormatException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"                    Para Realizar a Altera��o\n"
								+ "O campo IDADE deve conter um n�mero inteiro.\n"
								+ "O campo PESO deve conter um n�mero inteiro ou real.");
			}

		} else if (e.getSource() == ca.getLimpar()) {
			ca.limparDados();

		} else if (e.getSource() == ca.getAdicionarFoto()) {
			ca.setImagemAnimal(ca.selectFile());
		}
	}

}
