package boundary;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import entidade.Usuarios;

public class MenuPrincipal implements ActionListener {

	private JButton btnAddProd;
	private JButton btnPesqProd;
	private JButton btnAddUser;
	private JButton btnPesqUser;
	Usuarios user = new Usuarios();

	public MenuPrincipal() {
		JFrame janela = new JFrame("CadPro");
		JPanel painel = new JPanel(new GridLayout(5, 0));
		JLabel lblBemVindo = new JLabel("Bem Vindo Admin!");
		btnAddProd = new JButton("Adicionar Produtos");
		btnPesqProd = new JButton("Pesquisar Produtos");
		btnAddUser = new JButton("Adicionar Usuarios");
		btnPesqUser = new JButton("Pesquisar Usuarios");

		painel.add(lblBemVindo);
		painel.add(btnAddProd);
		painel.add(btnPesqProd);
		painel.add(btnAddUser);
		painel.add(btnPesqUser);
		btnAddProd.addActionListener(this);
		btnPesqProd.addActionListener(this);
		btnAddUser.addActionListener(this);
		btnPesqUser.addActionListener(this);

		janela.setContentPane(painel);
		janela.setVisible(true);
		janela.setSize(250, 150);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Adicionar Produtos".equals(e.getActionCommand())) {
			CadastrarProdutos cad = new CadastrarProdutos();
		} else if ("Pesquisar Produtos".equals(e.getActionCommand())) {
			PesquisarProdutos pesq = new PesquisarProdutos();

		} else if ("Adicionar Usuarios".equals(e.getActionCommand())) {
			CadastrarUsuarios cadU = new CadastrarUsuarios();
		} else if ("Pesquisar Usuarios".equals(e.getActionCommand())) {
			PesquisarUsuarios PesquisaUser = new PesquisarUsuarios();
		} 

	}
}
