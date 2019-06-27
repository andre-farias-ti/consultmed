package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Medico;
import br.com.consultmed.utils.JPAUtils;

public class MedicoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Medico medico) {
		this.factory.getTransaction().begin();
		this.factory.persist(medico);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idMedico){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarMedicoId(idMedico));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Medico buscarMedicoId(Long idMedico) {
		this.factory.getTransaction().begin();
		Medico meddico = this.factory.find(Medico.class, idMedico);
		return meddico;
	}
	
	public void editar(Medico medico) {
		this.factory.getTransaction().begin();
		this.factory.merge(medico);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Medico> medicos() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT m FROM Medico m");
		List<Medico> lista = query.getResultList();
		this.factory.close();
		return lista;
	}

}
