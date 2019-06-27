package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Medico;

public interface IMedico {
	
	public void salvar(Medico medico);
	public void remover(Long idMedico);
	public List<Medico> listar();
	public void altetar(Medico medico);
	public Medico buscarId(Long idMedico);
	public void cadastraMedico();

}
