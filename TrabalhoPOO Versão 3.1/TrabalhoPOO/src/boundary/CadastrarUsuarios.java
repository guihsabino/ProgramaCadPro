package boundary;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controle.ControleUsuarios;
import entidade.Produto;
import entidade.Usuarios;

public class CadastrarUsuarios implements ActionListener {

	private JButton btnCadastrar;
	private JButton btnExcluir;
	private JButton btnPesq;
	private JButton btnAlterar;
	private JFrame janela;
	private JTextField txtNome;
	private JTextField txtCelular;
	private JTextField txtTelefone;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtEndereco;
	private JTextField txtLoginVendedor;
	private JPasswordField txtSenhaVendedor;
	ControleUsuarios control = new ControleUsuarios();

	public CadastrarUsuarios() {

		janela = new JFrame("Cadastrar Novo Vendedor");
		JPanel painel = new JPanel();
		JLabel lblCadastro = new JLabel("Cadastro de Vendedores");
		JLabel lblNome = new JLabel("Nome do Vendedor: ");
		JLabel lblCelular = new JLabel("Celular do Vendedor: ");
		JLabel lblTelefone = new JLabel("Telefone do Vendedor: ");
		JLabel lblCPF = new JLabel("CPF do Vendedor: ");
		JLabel lblRG = new JLabel("RG do Vendedor: ");
		JLabel lblEndereco = new JLabel("Endereco do Vendedor: ");
		JLabel lblLoginVendedor = new JLabel("Login desejado no Sistema: ");
		JLabel lblSenhaVendedor = new JLabel("Senha desejada no Sistema: ");
		txtNome = new JTextField(40);
		txtCelular = new JTextField(11);
		txtTelefone = new JTextField(10);
		txtCPF = new JTextField(11);
		txtRG = new JTextField(9);
		txtEndereco = new JTextField(80);
		txtLoginVendedor = new JTextField(40);
		txtSenhaVendedor = new JPasswordField(15);
		btnCadastrar = new JButton("Cadastrar Usuario");
		btnExcluir = new JButton("Excluir Usuario");
		btnPesq = new JButton("Pesquisar Vendedor");
		btnAlterar = new JButton("Alterar Vendedor");

		// Conectando os elementos
		painel.add(lblCadastro);
		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(lblCelular);
		painel.add(txtCelular);
		painel.add(lblTelefone);
		painel.add(txtTelefone);
		painel.add(lblCPF);
		painel.add(txtCPF);
		painel.add(lblRG);
		painel.add(txtRG);
		painel.add(lblEndereco);
		painel.add(txtEndereco);
		painel.add(lblLoginVendedor);
		painel.add(txtLoginVendedor);
		painel.add(lblSenhaVendedor);
		painel.add(txtSenhaVendedor);
		painel.add(btnCadastrar);
		painel.add(btnExcluir);
		painel.add(btnPesq);
		painel.add(btnAlterar);
		btnCadastrar.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnPesq.addActionListener(this);
		btnAlterar.addActionListener(this);
		janela.setContentPane(painel);

		// Editando Layout dos objetos
		lblCadastro.setBounds(210, 1, 200, 40);
		lblNome.setBounds(4, 4, 150, 100);
		txtNome.setBounds(146, 46, 320, 20);
		lblCelular.setBounds(4, 40, 150, 100);
		txtCelular.setBounds(146, 80, 100, 20);
		lblTelefone.setBounds(4, 70, 150, 100);
		txtTelefone.setBounds(146, 110, 100, 20);
		lblCPF.setBounds(4, 100, 150, 100);
		txtCPF.setBounds(146, 140, 100, 20);
		lblRG.setBounds(4, 130, 150, 100);
		txtRG.setBounds(146, 170, 100, 20);
		lblEndereco.setBounds(4, 160, 150, 100);
		txtEndereco.setBounds(146, 200, 320, 20);
		lblLoginVendedor.setBounds(4, 190, 170, 100);
		txtLoginVendedor.setBounds(166, 230, 130, 20);
		lblSenhaVendedor.setBounds(4, 220, 170, 100);
		txtSenhaVendedor.setBounds(167, 260, 130, 20);
		btnCadastrar.setBounds(10, 300, 150, 40);
		btnExcluir.setBounds(170, 300, 130, 40);
		btnPesq.setBounds(310, 300, 150, 40);
		btnAlterar.setBounds(470, 300, 150, 40);

		lblCadastro.setFont(new Font("Comic Sans", Font.PLAIN, 18));

		painel.setLayout(null);

		// Tornando a janela vísivel
		janela.setSize(660, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if ("Cadastrar Usuario".equals(e.getActionCommand())) {
			Usuarios user = new Usuarios();
			user.setNome(txtNome.getText());
			user.setCelular(txtCelular.getText());
			user.setTelefone(txtTelefone.getText());
			user.setCPF(txtCPF.getText());
			user.setRG(txtRG.getText());
			user.setEndereco(txtEndereco.getText());
			user.setLoginVendedor(txtLoginVendedor.getText());
			user.setSenhaVendedor(txtSenhaVendedor.getText());
			control.adicionar(user);
			limparcampo();

		} else if ("Excluir Usuario".equals(e.getActionCommand())) {
			control.remover(txtCPF.getText());
		} else if ("Pesquisar Vendedor".equals(e.getActionCommand())) {
			Usuarios user = control.pesquisar(txtNome.getText());
			txtNome.setText(user.getNome());
			txtCelular.setText(user.getCelular());
			txtTelefone.setText(user.getTelefone());
			txtCPF.setText(user.getCPF());
			txtRG.setText(user.getRG());
			txtEndereco.setText(user.getEndereco());
			txtLoginVendedor.setText(user.getLoginVendedor());
			txtSenhaVendedor.setText(user.getSenhaVendedor());

		} else if ("Alterar Vendedor".equals(e.getActionCommand())) {
			Usuarios user = new Usuarios();
			user.setNome(txtNome.getText());
			user.setCelular(txtCelular.getText());
			user.setTelefone(txtTelefone.getText());
			user.setCPF(txtCPF.getText());
			user.setRG(txtRG.getText());
			user.setEndereco(txtEndereco.getText());
			user.setLoginVendedor(txtLoginVendedor.getText());
			user.setSenhaVendedor(txtSenhaVendedor.getText());
			control.salvar(txtCPF.getText(), user);

		}
	}

	public void limparcampo() {
		txtNome.setText("");
		txtCelular.setText("");
		txtCPF.setText("");
		txtEndereco.setText("");
		txtLoginVendedor.setText("");
		txtSenhaVendedor.setText("");
		txtRG.setText("");
		txtTelefone.setText("");
	}

}
