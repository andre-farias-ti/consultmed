package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Exame;
import br.com.consultmed.utils.JPAUtils;

public class ExameDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Exame exame) {
		this.factory.getTransaction().begin();
		this.factory.persist(exame);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idExame){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarExameId(idExame));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Exame buscarExameId(Long idExame) {
		this.factory.getTransaction().begin();
		Exame exame = this.factory.find(Exame.class, idExame);
		return exame;
	}
	
	public void editar(Exame exame) {
		this.factory.getTransaction().begin();
		this.factory.merge(exame);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Exame> exames() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT e FROM Exame e");
		List<Exame> lista = query.getResultList();
		this.factory.close();
		return lista;
	}
}
