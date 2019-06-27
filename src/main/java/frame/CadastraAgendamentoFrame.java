package frame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import br.com.consultmed.model.Agendamento;
import br.com.consultmed.model.Paciente;
import br.com.consultmed.service.AgendamentoService;
import br.com.consultmed.service.PacienteService;

public class CadastraAgendamentoFrame extends JFrame {

private static final long serialVersionUID = 1L;
	
	public CadastraAgendamentoFrame() {

        // setting up JFrame
        setLayout(new GridLayout(1, 1));
        setPreferredSize(new Dimension(500, 600));
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        JPanel principal = new JPanel( new GridLayout(2, 1) );
        
        JPanel panel = new JPanel( new GridLayout(2, 1) );
        
        //Caregando Pacientes
        PacienteService pacienteService = new PacienteService();
        List<Paciente> listaPciente = pacienteService.listar();
        
        Vector vetorPaciente = new Vector();
        for(Paciente p : listaPciente) {
        	vetorPaciente.addElement(p.getPessoa().getNome());
        }
        
        panel.add( new JLabel("   Paciente:") );
        JComboBox comboPaciente = new JComboBox(vetorPaciente);
        panel.add(comboPaciente);
        
        panel.add( new JLabel("Data e Hora:") );
        JFormattedTextField data = new JFormattedTextField();
        MaskFormatter maskDataHora;
        try {
        	maskDataHora = new MaskFormatter("##/##/#### ##:##");
        	maskDataHora.install(data); 
        } catch (ParseException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }  
        panel.add( data );
        
        principal.add(panel);
        
        JButton CadastrarConsulta = new JButton("Incluir Agendamento");
        CadastrarConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Object pacienteSelect = comboPaciente.getSelectedItem();
					Paciente pacienteFinal = null;
					for(Paciente p : listaPciente) {
						if(p.getPessoa().getNome().equals(pacienteSelect)) {
							pacienteFinal = p;
						}
					}
					
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
					Date dataFormatada = formato.parse(data.getText());
					
					Agendamento agendamento = new Agendamento();
					agendamento.setPaciente(pacienteFinal);
					agendamento.setDhAgenda(dataFormatada);
					agendamento.setSituacao(1l);
					
					AgendamentoService agendamentoService = new AgendamentoService();
					agendamentoService.salvar(agendamento);
					
					JOptionPane.showMessageDialog(null, "Agendamento Salvo!", null, 1);
					
					CadastraAgendamentoFrame.this.dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        principal.add( CadastrarConsulta );
        
        
        add(principal);

        pack();
    }
}
