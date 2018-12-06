package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controle.ControleUsuarios;
import entidade.Usuarios;

public class TelaLogin implements ActionListener {

	private JButton btnLogin;
	private JButton btnSair;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	
	//private JButton btnRecSenha;
	private ImageIcon logo = new ImageIcon(getClass().getResource("logoCadPro.png"));
	private JFrame janela;
	ControleUsuarios control = new ControleUsuarios();
	

	public TelaLogin() {
		janela = new JFrame("Login - CadPro");
		JPanel painel = new JPanel(new GridLayout(3, 0));
		JLabel logotipo = new JLabel(logo);
		JLabel lblLogin = new JLabel("LOGIN");
		JLabel lblUsuario = new JLabel("Usuario: ");
		txtLogin = new JTextField(40);
		JLabel lblSenha = new JLabel("Senha: ");
		txtSenha = new JPasswordField(20);
		btnLogin = new JButton("Login");
		btnSair = new JButton("Sair do Sistema");
		//btnRecSenha = new JButton("Recuperar Senha");

		painel.add(logotipo);
		painel.add(lblLogin);
		painel.add(lblUsuario);
		painel.add(lblSenha);
		painel.add(txtLogin);
		painel.add(txtSenha);
		painel.add(btnLogin);
		painel.add(btnSair);
		btnLogin.addActionListener(this);
		btnSair.addActionListener(this);
		//btnRecSenha.addActionListener(this);
		
		painel.setLayout(null);
		                 //linha,colu,alt,larg
		logotipo.setBounds(100, 6, 250, 80);
		lblLogin.setBounds(200, 90, 250, 80);
		lblUsuario.setBounds(200, 140, 250, 80);
		txtLogin.setBounds(150, 200, 150, 20);
		lblSenha.setBounds(200, 210, 250, 80);
		txtSenha.setBounds(150, 270, 150, 20);
		btnLogin.setBounds(80, 320, 100, 20);
		btnSair.setBounds(230, 320, 160, 20);
		
		lblLogin.setFont(new Font("Comic Sans", Font.PLAIN, 18));
		logotipo.setBorder(new LineBorder(Color.black));

		janela.setContentPane(painel);
		janela.setVisible(true);
		janela.setSize(450, 430);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}

	public void actionPerformed(ActionEvent e) {
		if ("Login".equals(e.getActionCommand())) {
			Usuarios u = control.login(txtLogin.getText(),txtSenha.getText());
			 if(u == null){ 
				 JOptionPane.showMessageDialog(null,"Erro,Login ou senha incorretos");
				}
			 
			 else {				
				if (txtLogin.getText().equals("root")){
					MenuPrincipal menu = new MenuPrincipal();
				} else {
					PesquisarProdutos pesqprodutos = new PesquisarProdutos();
				}
			 }
			
		} else if ("Sair do Sistema".equals(e.getActionCommand())) {
			System.exit(0);
		}
	}
}
