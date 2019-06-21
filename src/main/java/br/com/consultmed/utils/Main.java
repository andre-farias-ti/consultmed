package br.com.consultmed.utils;

import javax.swing.JFrame;

import br.com.consultmed.service.ContatosService;

public class Main {

	public static void main(String[] args) {
		
		ContatosService service = new ContatosService();
		
		JFrame frame = new JFrameMain();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
