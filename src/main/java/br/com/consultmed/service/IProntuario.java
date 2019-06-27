package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Prontuario;

public interface IProntuario {

	public void salvar(Prontuario prontuario);
	public void remover(Long idProntuario);
	public List<Prontuario> listar();
	public void altetar(Prontuario prontuario);
	public Prontuario buscarId(Long idProntuario);
	public void IncluirProntuario();
}
