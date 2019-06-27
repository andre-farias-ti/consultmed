package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Agendamento;

public interface IAgendamento {

	public void salvar(Agendamento agendamneto);
	public void remover(Long idAgendamento);
	public List<Agendamento> listar();
	public void altetar(Agendamento agendamento);
	public Agendamento buscarId(Long idAgendamento);
	public void incluirAgendamento();
}
