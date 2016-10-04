package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Animal;
import model.BancoDados;

public class ListaAnimais extends Tela {
	
	public ListaAnimais() {
		super("Lista de Animais", 1020, 600);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		for(Animal anim: BancoDados.animais) {
			JPanel pan = new JPanel();
//			pan.setSize(100, 100);
			pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			pan.add(new JLabel("<html>"
					+ "<p> Nome: "+anim.getNome()+"</p>"
					+ "<p> Ra�a: "+anim.getRaca()+"</p>"
					+ "<p> Sexo: "+anim.getSexo()+"</p>"
					+ "<p> Idade: "+anim.getIdade()+" anos </p>"
					+ "<p> Peso: "+anim.getPeso()+" kg </p>"
					+ "<p> Descri��o: "+anim.getDescricao()+"</p>"
					+ "</html>"));
			pan.add(new JButton("Adotar"));
			
			this.add(pan);
		}
	}

}
