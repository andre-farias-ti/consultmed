package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Consulta;

public interface IConsulta {

	public void salvar(Consulta consulta);
	public void remover(Long idConsulta);
	public List<Consulta> listar();
	public void altetar(Consulta consulta);
	public Consulta buscarId(Long idConsulta);
	public void incluirConsulta();
}
