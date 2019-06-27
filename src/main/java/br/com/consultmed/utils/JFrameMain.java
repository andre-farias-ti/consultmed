package br.com.consultmed.utils;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.consultmed.service.PacienteService;

public class JFrameMain extends JFrame {

	private static final long serialVersionUID = 1L;

	public JFrameMain() {
    	
        // setting up JFrame
        setLayout(new GridLayout(1, 1));
        setPreferredSize(new Dimension(420, 600));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JPanel panel = new JPanel( new GridLayout(6, 1) );
        
        JButton CadastrarCliente = new JButton("Cadastrar Paciente");
        CadastrarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

					PacienteService pacienteService = new PacienteService();
					pacienteService.cadastraPaciente();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(CadastrarCliente);
        
        JButton CadastrarAtendente = new JButton("Cadastrar Medico");
        CadastrarAtendente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(CadastrarAtendente);
        
        JButton cadastrarOS = new JButton("Realizar Consulta");
        cadastrarOS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(cadastrarOS);
        
        JButton resolverOS = new JButton("Resolver Orden de Serviço");
        resolverOS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(resolverOS);
        
        JButton cadastraTecnico = new JButton("Cadastra Tecnico");
        cadastraTecnico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(cadastraTecnico);
        
        JButton exibirHistorico = new JButton("Exibir Historico");
        exibirHistorico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(exibirHistorico);
        
        add(panel);


        pack();

    }
}
