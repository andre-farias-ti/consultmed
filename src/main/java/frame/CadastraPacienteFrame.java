package frame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.consultmed.model.Contato;
import br.com.consultmed.model.Endereco;
import br.com.consultmed.model.Paciente;
import br.com.consultmed.model.Pessoa;
import br.com.consultmed.service.ContatosService;
import br.com.consultmed.service.EnderecoService;
import br.com.consultmed.service.PacienteService;
import br.com.consultmed.service.PessoaService;
import br.com.consultmed.utils.Constantes;

public class CadastraPacienteFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public CadastraPacienteFrame() {

        // setting up JFrame
        setLayout(new GridLayout(1, 1));
        setPreferredSize(new Dimension(400, 600));
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        JPanel principal = new JPanel( new GridLayout(2, 1) );
        
        JPanel panel = new JPanel( new GridLayout(12, 1) );
        
        panel.add( new JLabel("Nome do Paciente") );
        JTextField nome = new JTextField(50);
        panel.add( nome );
        panel.add( new JLabel("SEXO") );
        JTextField sexo = new JTextField(50);
        panel.add( sexo );
        
        panel.add( new JLabel("Data de nascimento") );
        JFormattedTextField dataNascimento = new JFormattedTextField();
        MaskFormatter maskDataNacimento;
        try {
        	maskDataNacimento = new MaskFormatter("##/##/####");
        	maskDataNacimento.install(dataNascimento); 
        } catch (ParseException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }  
        panel.add( dataNascimento );
        
        panel.add( new JLabel("Numero de CPF") );
        
        JFormattedTextField numeroCPF = new JFormattedTextField();
        MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("###.###.###-##");
			maskData.install(numeroCPF); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        panel.add( numeroCPF );
        panel.add( new JLabel("Telefone") );
        JTextField telefone = new JTextField(50);
        panel.add( telefone );
        panel.add( new JLabel("EMAIL") );
        JTextField email = new JTextField(50);
        panel.add( email );
        panel.add( new JLabel("RUA") );
        JTextField RUA = new JTextField(50);
        panel.add( RUA );
        panel.add( new JLabel("NUMERO") );
        JTextField numero = new JTextField(50);
        panel.add( numero );
        panel.add( new JLabel("BAIRRO") );
        JTextField bairro = new JTextField(50);
        panel.add( bairro );
        panel.add( new JLabel("CIDADE") );
        JTextField cidade = new JTextField(50);
        panel.add( cidade );
        panel.add( new JLabel("UF") );
        JTextField uf = new JTextField(50);
        panel.add( uf );
        
        panel.add( new JLabel("CEP") );
        JFormattedTextField cep = new JFormattedTextField();
        MaskFormatter maskCep;
		try {
			maskCep = new MaskFormatter("#####-###");
			maskCep.install(cep); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        panel.add( cep );
        
        principal.add(panel);
        
        JButton CadastrarCliente = new JButton("Cadastrar Paciente");
        CadastrarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Endereco endereco = new Endereco();
					endereco.setRua(RUA.getText());
					endereco.setBairro(bairro.getText());
					endereco.setCidade(cidade.getText());
					endereco.setEstado(uf.getText());
					endereco.setCEP(cep.getText());
					endereco.setNumero(numero.getText());
					
					EnderecoService enderecoService = new EnderecoService();
					enderecoService.salvar(endereco);
					
					Contato contato = new Contato();
					contato.setEmail(email.getText());
					contato.setTelefone(telefone.getText());
					
					ContatosService contatosService = new ContatosService();
					contatosService.salvar(contato);
					
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(nome.getText());
					pessoa.setCPF(numeroCPF.getText());
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					Date dataFormatada = formato.parse(dataNascimento.getText());
					pessoa.setDtNascimento(dataFormatada);
					pessoa.setSexo(sexo.getText());
					pessoa.setTipo(Constantes.TP_PESSOA_PACIENTE);
					pessoa.setContato(contato);
					pessoa.setEndereco(endereco);
					
					PessoaService pessoaService = new PessoaService();
					pessoaService.salvar(pessoa);
					pessoa.setEndereco(endereco);
					
					Paciente paciente = new Paciente();
					paciente.setPessoa(pessoa);

					PacienteService pacienteService = new PacienteService();
					pacienteService.salvar(paciente);
					
					JOptionPane.showMessageDialog(null, "Paciente Salvo!", null, 1);
					
					CadastraPacienteFrame.this.dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
        });
        
        principal.add( CadastrarCliente );
        
        
        add(principal);

        pack();

    }
	
}
