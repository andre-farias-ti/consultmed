package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultmed.model.Endereco;
import br.com.consultmed.model.Pessoa;
import br.com.consultmed.utils.JPAUtils;

public class PessoaDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Pessoa pessoa) {
		this.factory.getTransaction().begin();
		this.factory.persist(pessoa);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idPessoa){
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPessoaId(idPessoa));
		this.factory.getTransaction().begin();
		this.factory.close();
	}
	
	public Pessoa buscarPessoaId(Long idPessoa) {
		this.factory.getTransaction().begin();
		Pessoa pessoa = this.factory.find(Pessoa.class, idPessoa);
		return pessoa;
	}
	
	public void editar(Pessoa pessoa) {
		this.factory.getTransaction().begin();
		this.factory.merge(pessoa);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Pessoa> pessoas() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT p FROM Pessoa p");
		List<Pessoa> lista = query.getResultList();
		this.factory.close();
		return lista;
	}
}
