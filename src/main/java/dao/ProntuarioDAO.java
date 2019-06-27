package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Prontuario;
import br.com.consultmed.utils.JPAUtils;

public class ProntuarioDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Prontuario prontuario) {
		this.factory.getTransaction().begin();
		this.factory.persist(prontuario);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idProntuario){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarProntuarioId(idProntuario));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Prontuario buscarProntuarioId(Long idProntuario) {
		this.factory.getTransaction().begin();
		Prontuario prontuario = this.factory.find(Prontuario.class, idProntuario);
		return prontuario;
	}
	
	public void editar(Prontuario prontuario) {
		this.factory.getTransaction().begin();
		this.factory.merge(prontuario);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Prontuario> prontuarios() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT p FROM Prontuario p");
		List<Prontuario> lista = query.getResultList();
		this.factory.close();
		return lista;
	}
}
