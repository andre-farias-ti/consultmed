package frame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.consultmed.model.Medico;
import br.com.consultmed.model.Paciente;
import br.com.consultmed.service.MedicoService;
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
        
        JPanel panel = new JPanel( new GridLayout(5, 1) );
        
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
        
        MedicoService medicoService = new MedicoService();
        List<Medico> listaMedico = medicoService.listar();
        
        //Carregando medico
        Vector vetorMedico = new Vector();
        for(Medico m : listaMedico) {
        	vetorMedico.addElement(m.getPessoa().getNome());
        }
        
        panel.add( new JLabel("   Medico:") );
        JComboBox comboMedico = new JComboBox(vetorMedico);
        panel.add(comboMedico);
        
        panel.add( new JLabel("   Com Agendamento:") );
        JCheckBox checkAgend = new JCheckBox();
        panel.add(checkAgend);
        
	    panel.add( new JLabel("   Exame:") );
	    JTextField exame = new JTextField(50);
	    panel.add( exame );
	      
	    panel.add( new JLabel("   Descrição da Consulta:") );
	    JTextField descricao = new JTextField(50);
	    panel.add( descricao );
        
        principal.add(panel);
        
        JButton CadastrarConsulta = new JButton("Incluir Agendamento");
        CadastrarConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(checkAgend.isSelected()) {
						///
					}
					
					Object select = comboPaciente.getSelectedItem();
					
					Paciente pp = null;
					for(Paciente p : listaPciente) {
						if(p.getPessoa().getNome().equals(select)) {
							pp = p;
						}
					}
					
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
