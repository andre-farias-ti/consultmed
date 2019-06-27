package br.com.consultmed.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "agendamento")
@Entity
public class Agendamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@OneToOne()
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;
	
	private Date dhAgenda;
	private Long situacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Date getDhAgenda() {
		return dhAgenda;
	}
	public void setDhAgenda(Date dhAgenda) {
		this.dhAgenda = dhAgenda;
	}
	public Long getSituacao() {
		return situacao;
	}
	public void setSituacao(Long situacao) {
		this.situacao = situacao;
	}
}
