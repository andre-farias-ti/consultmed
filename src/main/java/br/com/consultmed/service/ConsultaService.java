package br.com.consultmed.service;

import java.util.List;

import javax.swing.JFrame;

import br.com.consultmed.model.Consulta;
import dao.ConsultaDAO;
import frame.IncluirConsultaFrame;

public class ConsultaService implements IConsulta{

	private ConsultaDAO service = new ConsultaDAO();

	@Override
	public void salvar(Consulta consulta) {
		this.service.salvar(consulta);
	}

	@Override
	public void remover(Long idConsulta) {
		this.service.remover(idConsulta);
	}

	@Override
	public List<Consulta> listar() {
		return this.service.consultas();
	}

	@Override
	public void altetar(Consulta consulta) {
		this.service.editar(consulta);
	}

	@Override
	public Consulta buscarId(Long idConsulta) {
		return this.service.buscarConsultaId(idConsulta);
	}

	@Override
	public void incluirConsulta() {
		JFrame frame = new IncluirConsultaFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
		
	}
}
