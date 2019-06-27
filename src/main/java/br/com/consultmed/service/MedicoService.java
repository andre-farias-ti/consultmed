package br.com.consultmed.service;

import java.util.List;

import javax.swing.JFrame;

import br.com.consultmed.model.Medico;
import dao.MedicoDAO;
import frame.CadastroMedicoFrame;

public class MedicoService implements IMedico{

	private MedicoDAO service = new MedicoDAO();

	@Override
	public void salvar(Medico medico) {
		this.service.salvar(medico);
	}

	@Override
	public void remover(Long idMedico) {
		this.service.remover(idMedico);
	}

	@Override
	public List<Medico> listar() {
		return this.service.medicos();
	}

	@Override
	public void altetar(Medico medico) {
		this.service.editar(medico);
	}

	@Override
	public Medico buscarId(Long idMedico) {
		return this.service.buscarMedicoId(idMedico);
	}

	@Override
	public void cadastraMedico() {
		JFrame frame = new CadastroMedicoFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
		
	}
}
