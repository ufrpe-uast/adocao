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
		if(e.getSource() == ca.getCadastrar()) {
			try {
				
				int idade = Integer.parseInt(ca.getImputIdade().getText());
				float peso = Float.parseFloat(ca.getImputPeso().getText());
				
				Animal anim = new Animal(ca.getImputNome().getText(), ca.getImputRaca().getText(),
						ca.getSexoOption().getSelectedItem().toString(),
						idade, 
						peso, ca.getImputDescricao().getText());
				bd.getAnimais().add(anim);
				
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "O campo idade deve conter um n�mero inteiro.\n"
						+ "O campo peso deve conter um n�mero inteiro ou real.");
			}
			
			System.out.println(bd.getAnimais().get(0).getNome());
			System.out.println(bd.getAnimais().get(0).getRaca());
			System.out.println(bd.getAnimais().get(0).getSexo());
			System.out.println(bd.getAnimais().get(0).getIdade());
			System.out.println(bd.getAnimais().get(0).getPeso());
			System.out.println(bd.getAnimais().get(0).getDescricao());
			
			JOptionPane.showMessageDialog(null, "Animal Cadastrado com Sucesso");
		}
		else if(e.getSource() == ca.getLimpar()) {
			ca.getImputNome().setText(null);
			ca.getImputRaca().setText(null);
			ca.getImputIdade().setText(null);
			ca.getImputPeso().setText(null);
			ca.getImputDescricao().setText(null);
		}
		else if (e.getSource() == ca.getAdicionarFoto()) {
			ca.setImagemAnimal(ca.selectFile());
			JOptionPane.showMessageDialog(null, "Imagem Selecionada!");
		}
	}

}
