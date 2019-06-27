package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Consulta;
import br.com.consultmed.utils.JPAUtils;

public class ConsultaDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Consulta consulta) {
		this.factory.getTransaction().begin();
		this.factory.persist(consulta);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idConsulta){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarConsultaId(idConsulta));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Consulta buscarConsultaId(Long idConsulta) {
		this.factory.getTransaction().begin();
		Consulta consulta = this.factory.find(Consulta.class, idConsulta);
		return consulta;
	}
	
	public void editar(Consulta consulta) {
		this.factory.getTransaction().begin();
		this.factory.merge(consulta);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Consulta> consultas() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Consulta c");
		List<Consulta> lista = query.getResultList();
		this.factory.close();
		return lista;
	}
}
