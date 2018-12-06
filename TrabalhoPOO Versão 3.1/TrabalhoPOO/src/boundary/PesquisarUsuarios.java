package boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controle.ControleUsuarios;
import entidade.Usuarios;

public class PesquisarUsuarios implements ActionListener {

	private JButton btnPesqUser;
	private JTextField txtNome = new JTextField();;
	ControleUsuarios controle = new ControleUsuarios();
	private JTable table = new JTable(controle);

	public PesquisarUsuarios() {

		JFrame janela = new JFrame("Consulta de Usuarios");
		JPanel painel = new JPanel(new GridLayout(1,2));
		JScrollPane panTable = new JScrollPane();
		panTable.getViewport().add(table);
		JLabel lblNome = new JLabel("Nome Usuario");
		btnPesqUser = new JButton("Pesquisar");

		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(btnPesqUser);
		btnPesqUser.addActionListener(this);

		janela.getContentPane().add(painel,BorderLayout.NORTH);
		janela.getContentPane().add(panTable,BorderLayout.CENTER);
		janela.setVisible(true);
		janela.setSize(850, 450);
		janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}
 
	@Override
		public void actionPerformed(ActionEvent e) {
			if("Pesquisar".equals(e.getActionCommand()));
				List<Usuarios> lista = controle.pesquisarJTable(txtNome.getText());
					if (lista.size() > 0){
						Usuarios u = lista.get(0);
					}
					table.invalidate();
					table.revalidate();
					table.repaint();
			
		}
}
