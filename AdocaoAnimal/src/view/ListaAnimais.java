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

public class ListaAnimais extends TelaInterna {
	
	public ListaAnimais() {
		super("Animais", 900, 500);
		
		setLayout(new FlowLayout());
		setLocation(60, 25);
		for(Animal anim: BancoDados.animais) {
			JPanel pan = new JPanel();
			pan.setSize(100, 100);
			pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			pan.add(new JLabel("<html>"
					+ "<p> ID: "+anim.getId()+"</p>"
					+ "<p> Nome: "+anim.getNome()+"</p>"
					+ "<p> Raça: "+anim.getRaca()+"</p>"
					+ "<p> Sexo: "+anim.getSexo()+"</p>"
					+ "<p> Idade: "+anim.getIdade()+" anos </p>"
					+ "<p> Peso: "+anim.getPeso()+" kg </p>"
					+ "<p> Descrição: "+anim.getDescricao()+"</p>"
					+ "</html>"));
			pan.add(new JButton("Adotar"));
			
			this.add(pan);
		}
	}
}
