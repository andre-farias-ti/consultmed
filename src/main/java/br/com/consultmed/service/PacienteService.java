package br.com.consultmed.service;

import java.util.List;

import javax.swing.JFrame;

import br.com.consultmed.model.Paciente;
import dao.PacienteDAO;
import frame.CadastraPacienteFrame;

public class PacienteService implements IPaciente {

	private PacienteDAO service = new PacienteDAO();

	@Override
	public void salvar(Paciente paciente) {
		this.service.salvar(paciente);
	}

	@Override
	public void remover(Long idPaciente) {
		this.service.remover(idPaciente);
	}

	@Override
	public List<Paciente> listar() {
		return this.service.pacientes();
	}

	@Override
	public void altetar(Paciente paciente) {
		this.service.editar(paciente);
	}

	@Override
	public Paciente buscarId(Long paciente) {
		return this.service.buscarPacienteId(paciente);
	}

	@Override
	public void cadastraPaciente() {
		JFrame frame = new CadastraPacienteFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
		
	}
}
