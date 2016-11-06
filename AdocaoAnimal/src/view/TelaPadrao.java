package view;

import javax.swing.JFrame;

public class TelaPadrao extends JFrame {
	public TelaPadrao(String titulo, int Largura, int Altura) {
		super(titulo);
		editarJanela(Largura, Altura);
	}

	public void editarJanela(int Largura, int Altura) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Largura, Altura);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
}
