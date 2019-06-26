package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Endereco;
import br.com.consultmed.utils.JPAUtils;

public class EnderecoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Endereco endereco) {
		this.factory.getTransaction().begin();
		this.factory.persist(endereco);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idendereco){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarEnderecoId(idendereco));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Endereco buscarEnderecoId(Long idEndereco) {
		this.factory.getTransaction().begin();
		Endereco endereco = this.factory.find(Endereco.class, idEndereco);
		return endereco;
	}
	
	public void editar(Endereco endereco) {
		this.factory.getTransaction().begin();
		this.factory.merge(endereco);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Endereco> enderecos() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT e FROM Endereco e");
		List<Endereco> lista = query.getResultList();
		this.factory.close();
		return lista;
	}
}
