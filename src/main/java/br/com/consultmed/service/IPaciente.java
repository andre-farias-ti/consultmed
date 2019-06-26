package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Paciente;

public interface IPaciente {

	public void salvar(Paciente paciente);
	public void remover(Long idPaciente);
	public List<Paciente> listar();
	public void altetar(Paciente paciente);
	public Paciente buscarId(Long idPciente);
}
