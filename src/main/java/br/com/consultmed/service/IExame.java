package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Exame;

public interface IExame {

	public void salvar(Exame exame);
	public void remover(Long idExame);
	public List<Exame> listar();
	public void altetar(Exame exame);
	public Exame buscarId(Long idExame);
}
