package br.com.consultmed.service;

import java.util.List;

import javax.swing.JFrame;

import br.com.consultmed.model.Agendamento;
import dao.AgendamentoDAO;
import frame.CadastraAgendamentoFrame;

public class AgendamentoService implements IAgendamento{

	private AgendamentoDAO service = new AgendamentoDAO();

	@Override
	public void salvar(Agendamento Agendamento) {
		this.service.salvar(Agendamento);
	}

	@Override
	public void remover(Long idAgendamento) {
		this.service.remover(idAgendamento);
	}

	@Override
	public List<Agendamento> listar() {
		return this.service.agendamentos();
	}

	@Override
	public void altetar(Agendamento agendamento) {
		this.service.editar(agendamento);
	}

	@Override
	public Agendamento buscarId(Long idAgendamento) {
		return this.service.buscarAgendamnetoId(idAgendamento);
	}

	@Override
	public void incluirAgendamento() {
		JFrame frame = new CadastraAgendamentoFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
		
	}
}
