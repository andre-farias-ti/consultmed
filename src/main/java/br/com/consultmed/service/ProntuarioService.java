package br.com.consultmed.service;

import java.util.List;

import javax.swing.JFrame;

import br.com.consultmed.model.Prontuario;
import dao.ProntuarioDAO;
import frame.CadastroMedicoFrame;

public class ProntuarioService implements IProntuario {
	
	private ProntuarioDAO service = new ProntuarioDAO();

	@Override
	public void salvar(Prontuario prontuario) {
		this.service.salvar(prontuario);
	}

	@Override
	public void remover(Long idProntuario) {
		this.service.remover(idProntuario);
	}

	@Override
	public List<Prontuario> listar() {
		return this.service.prontuarios();
	}

	@Override
	public void altetar(Prontuario prontuario) {
		this.service.editar(prontuario);
	}

	@Override
	public Prontuario buscarId(Long idProntuario) {
		return this.service.buscarProntuarioId(idProntuario);
	}

	@Override
	public void IncluirProntuario() {
		JFrame frame = new CadastroMedicoFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
		
	}

}
