package br.com.consultmed.utils;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.consultmed.service.AgendamentoService;
import br.com.consultmed.service.ConsultaService;
import br.com.consultmed.service.MedicoService;
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
        
        JButton CadastrarAtendente = new JButton("Cadastrar Médico");
        CadastrarAtendente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					MedicoService medicoService = new MedicoService();
					medicoService.cadastraMedico();

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(CadastrarAtendente);
        
        JButton cadastrarOS = new JButton("Incluir Consulta");
        cadastrarOS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ConsultaService consultaService = new ConsultaService();
					consultaService.incluirConsulta();

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(cadastrarOS);
        
        JButton resolverOS = new JButton("Incluir Agendamento");
        resolverOS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

					AgendamentoService agendamentoService = new AgendamentoService();
					agendamentoService.incluirAgendamento();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        panel.add(resolverOS);
        
        JButton cadastraTecnico = new JButton("Cancelar Agendamento");
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
        
        JButton exibirHistorico = new JButton("Reagendar Consulta");
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
