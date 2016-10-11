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
				int contador = BancoDados.animais.size()+1;
				System.out.println(contador);
				String id = "0" + BancoDados.animais.size()+1;
				System.out.println(id);
				int idade = Integer.parseInt(ca.getImputIdade().getText());
				float peso = Float.parseFloat(ca.getImputPeso().getText());
				
				Animal anim = new Animal(Integer.parseInt(id)+1,ca.getImputNome().getText(), ca.getImputRaca().getText(),
						ca.getSexoOption().getSelectedItem().toString(),
						idade, 
						peso, ca.getImputDescricao().getText());
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
			ca.getImputId().setText("0"+Integer.toString(BancoDados.animais.size()+1));
		}
		else if(e.getSource() == ca.getLimpar()) {
			limparDados();
		}
		else if (e.getSource() == ca.getAdicionarFoto()) {
			ca.setImagemAnimal(ca.selectFile());
			JOptionPane.showMessageDialog(null, "Imagem Selecionada!");
		}
	}
	public void limparDados(){
		ca.getImputNome().setText(null);
		ca.getImputRaca().setText(null);
		ca.getImputIdade().setText(null);
		ca.getImputPeso().setText(null);
		ca.getImputDescricao().setText(null);
	}

}
