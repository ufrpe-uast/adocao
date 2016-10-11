package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Animal;
import model.BancoDados;
import view.CadastroAnimal;

public class ControllerAnimal implements ActionListener {

	private CadastroAnimal ca;
	private BancoDados bd = new BancoDados();

	public ControllerAnimal(CadastroAnimal ca) {
		this.ca = ca;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ca.getCadastrar()) {
			try {
				int idade = Integer.parseInt(ca.getImputIdade().getText());
				float peso = Float.parseFloat(ca.getImputPeso().getText());

				Animal anim = new Animal(Integer.parseInt(ca.getImputId().getText()), ca.getImputNome().getText(),
						ca.getImputRaca().getText(), ca.getSexoOption().getSelectedItem().toString(), idade, peso,
						ca.getImputDescricao().getText());
				System.out.println(anim.getId());
				bd.getAnimais().add(anim);

			} catch (NumberFormatException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "O campo idade deve conter um número inteiro.\n"
						+ "O campo peso deve conter um número inteiro ou real.");
			}

			System.out.println(bd.getAnimais().get(0).getNome());
			System.out.println(bd.getAnimais().get(0).getRaca());
			System.out.println(bd.getAnimais().get(0).getSexo());
			System.out.println(bd.getAnimais().get(0).getIdade());
			System.out.println(bd.getAnimais().get(0).getPeso());
			System.out.println(bd.getAnimais().get(0).getDescricao());

			JOptionPane.showMessageDialog(null, "Animal Cadastrado com Sucesso");
			limparDados();
			ca.setContatorCadastro(1);
			ca.getImputId().setText(Integer.toString(ca.getContatorCadastro()));

		} else if (e.getSource() == ca.getAlterar()) {

			int index = Integer.parseInt(ca.getImputId().getText());
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
				limparDados();
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"                    Para Realizar a Alteração\n"
								+    "O campo IDADE deve conter um número inteiro.\n"
								+ "O campo PESO deve conter um número inteiro ou real.");
			}

		} else if (e.getSource() == ca.getLimpar()) {
			limparDados();

		} else if (e.getSource() == ca.getAdicionarFoto()) {
			ca.setImagemAnimal(ca.selectFile());
		}
	}

	public void limparDados() {
		ca.getImputId().setText(null);
		ca.getImputNome().setText(null);
		ca.getImputRaca().setText(null);
		ca.getImputIdade().setText(null);
		ca.getImputPeso().setText(null);
		ca.getImputDescricao().setText(null);
	}

}
