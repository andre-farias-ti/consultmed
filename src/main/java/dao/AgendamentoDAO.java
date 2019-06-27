package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Agendamento;
import br.com.consultmed.model.Paciente;
import br.com.consultmed.utils.JPAUtils;

public class AgendamentoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Agendamento agendamento) {
		this.factory.getTransaction().begin();
		this.factory.persist(agendamento);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idAgendamneto){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarAgendamentoId(idAgendamneto));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Agendamento buscarAgendamentoId(Long idAgendamneto) {
		this.factory.getTransaction().begin();
		Agendamento agendamento = this.factory.find(Agendamento.class, idAgendamneto);
		return agendamento;
	}
	
	public void editar(Agendamento agendamento) {
		this.factory.getTransaction().begin();
		this.factory.merge(agendamento);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Agendamento> agendamentos() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT a FROM Agendamento a");
		List<Agendamento> lista = query.getResultList();
		this.factory.close();
		return lista;
	}
	
	public Agendamento AgendamentPorPaciente(Paciente paciente) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT a FROM Agendamento a WHERE id_paciente = :id");
		query.setParameter("id", paciente.getId());
		Agendamento result = (Agendamento) query.getSingleResult();
		this.factory.close();
		return result;
	}
}
