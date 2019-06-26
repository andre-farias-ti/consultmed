package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Paciente;
import br.com.consultmed.utils.JPAUtils;

public class PacienteDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Paciente paciente) {
		this.factory.getTransaction().begin();
		this.factory.persist(paciente);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idPaciente){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPacienteId(idPaciente));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Paciente buscarPacienteId(Long idPaciente) {
		this.factory.getTransaction().begin();
		Paciente paciente = this.factory.find(Paciente.class, idPaciente);
		return paciente;
	}
	
	public void editar(Paciente paciente) {
		this.factory.getTransaction().begin();
		this.factory.merge(paciente);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Paciente> pacientes() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT p FROM Paciente p");
		List<Paciente> lista = query.getResultList();
		this.factory.close();
		return lista;
	}

}
