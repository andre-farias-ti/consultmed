package br.com.consultmed.utils;

import java.util.Date;

import javax.swing.JFrame;

import br.com.consultmed.model.Contato;
import br.com.consultmed.model.Endereco;
import br.com.consultmed.model.Paciente;
import br.com.consultmed.model.Pessoa;
import br.com.consultmed.service.ContatosService;
import br.com.consultmed.service.EnderecoService;
import br.com.consultmed.service.PacienteService;
import br.com.consultmed.service.PessoaService;

public class Main {

	public static void main(String[] args) {
		
		ContatosService contatosService = new ContatosService();
		
//		Contato contato = new Contato();
//		contato.setEmail("andrefariasti@gmai.com");
//		contato.setTelefone("83 99902759");
//		contato.setId(null);
		
//		Contato contato = contatosService.buscarId(2l);
//		
//		Endereco endereco = new Endereco();
//		endereco.setBairro("oitizeiro");
//		endereco.setCEP("58088785");
//		endereco.setCidade("João Pessoa");
//		endereco.setEstado("PB");
//		endereco.setRua("Pr jose sevrino de oliveira");
//		endereco.setNumero("111");
//		
//		EnderecoService enderecoService = new EnderecoService();
//		enderecoService.salvar(endereco);
//		
//		Pessoa pessoa = new Pessoa();
//		pessoa.setContato(contato);
//		pessoa.setEndereco(endereco);
//		pessoa.setNome("André Luis Farias da Silva");
//		pessoa.setSexo("M");
//		pessoa.setTipo(Contantes.TP_PESSOA_PACIENTE);
//		pessoa.setDtNascimento(new Date());
//		pessoa.setCPF("075.854.634-30");
//		
		PessoaService pessoaService = new PessoaService();
//		pessoaService.salvar(pessoa);
		
		Pessoa pessoa = pessoaService.buscarId(1l);
		
//		con.setEmail("JOSEfariasti@gmai.com");
//		
//		service.altetar(con);
		
		//service.salvar(contato);
		
		Paciente paciente = new Paciente();
		paciente.setPessoa(pessoa);
		
		PacienteService pacienteService = new PacienteService();
		pacienteService.salvar(paciente);
		
		JFrame frame = new JFrameMain();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
