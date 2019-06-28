package frame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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

import br.com.consultmed.model.Agendamento;
import br.com.consultmed.model.Consulta;
import br.com.consultmed.model.Exame;
import br.com.consultmed.model.Medico;
import br.com.consultmed.model.Paciente;
import br.com.consultmed.model.Prontuario;
import br.com.consultmed.service.AgendamentoService;
import br.com.consultmed.service.ConsultaService;
import br.com.consultmed.service.ExameService;
import br.com.consultmed.service.MedicoService;
import br.com.consultmed.service.PacienteService;
import br.com.consultmed.service.ProntuarioService;
import br.com.consultmed.utils.Constantes;

public class IncluirConsultaFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public IncluirConsultaFrame() {

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
        
        panel.add( new JLabel("   Com Exame:") );
        JCheckBox checkExame = new JCheckBox();
        panel.add(checkExame);
        
	    panel.add( new JLabel("   Descrição do Exame:") );
	    JTextField exameLabel = new JTextField(50);
	    panel.add( exameLabel );
	      
	    panel.add( new JLabel("   Descrição da Consulta:") );
	    JTextField descricao = new JTextField(50);
	    panel.add( descricao );
        
        principal.add(panel);
        
        JButton CadastrarConsulta = new JButton("Incluir Consulta");
        CadastrarConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Object selectPciente = comboPaciente.getSelectedItem();
					Paciente PacienteFinal = null;
					for(Paciente p : listaPciente) {
						if(p.getPessoa().getNome().equals(selectPciente)) {
							PacienteFinal = p;
						}
					}
					
					Object selectMedico = comboMedico.getSelectedItem();
					Medico medicoFinal = null;
					for(Medico m : listaMedico) {
						if(m.getPessoa().getNome().equals(selectMedico)) {
							medicoFinal = m;
						}
					}

					Consulta consulta = new Consulta();
					consulta.setMedico(medicoFinal);
					
					AgendamentoService agendamentoService = new AgendamentoService();
					Agendamento agendamento = agendamentoService.buscarAgendPaciente(PacienteFinal);
					
					if(null != agendamento) {
						consulta.setAgendamento(agendamento);
						consulta.setTsAtualizacao(new Date());
						consulta.setSituacao(Constantes.SITUACAO_CONSULTA_REALIZADA);
						consulta.setMedico(medicoFinal);
						
						ConsultaService consultaService = new ConsultaService();
						consultaService.salvar(consulta);
						
						if (checkExame.isSelected()) {

							Exame exame = new Exame();
							exame.setConsulta(consulta);
							exame.setTipoExame(exameLabel.getText());

							ExameService exameService = new ExameService();
							exameService.salvar(exame);
						}
						
						Prontuario prontuario = new Prontuario();
						prontuario.setDescricao(descricao.getText());
						prontuario.setPaciente(PacienteFinal);
						prontuario.setTsAtualizacao(new Date());
						prontuario.setConsulta(consulta);
						
						ProntuarioService prontuarioService = new ProntuarioService();
						prontuarioService.salvar(prontuario);
						
						JOptionPane.showMessageDialog(null, "Consulta Salva!", null, 1);
						
						IncluirConsultaFrame.this.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "SEM AGENDAMENTO!", null, 1);
						
						IncluirConsultaFrame.this.dispose();
					}
					
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
