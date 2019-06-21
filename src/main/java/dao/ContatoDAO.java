package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Contato;
import br.com.consultmed.utils.JPAUtils;

public class ContatoDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Contato contato) {
		this.factory.getTransaction().begin();
		this.factory.persist(contato);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idContato){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarContatoId(idContato));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Contato buscarContatoId(Long idContato) {
		this.factory.getTransaction().begin();
		Contato ContatoRemover = this.factory.find(Contato.class, idContato);
		return ContatoRemover;
	}
	
	public void editar(Contato contato) {
		this.factory.getTransaction().begin();
		this.factory.merge(contato);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Contato> contatos() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Contato c");
		List<Contato> lista = query.getResultList();
		this.factory.close();
		return lista;
	}
}
