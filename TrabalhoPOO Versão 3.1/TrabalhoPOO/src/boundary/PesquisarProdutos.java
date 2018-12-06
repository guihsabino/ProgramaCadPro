package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.ProdutosDao;
import controle.ControleProdutos;
import entidade.Produto;

public class PesquisarProdutos implements ActionListener {
	
	private JButton btnPesquisar;
	private JTextField txtNome = new JTextField(50);
	ControleProdutos controle = new ControleProdutos();
	private JTable table1 = new JTable(controle);
	
	public PesquisarProdutos(){
				
				JFrame janela = new JFrame("Pesquisa de Produtos");
				JPanel painelPesquisa = new JPanel(new GridLayout(1,2));
				JScrollPane panTable = new JScrollPane();
				panTable.getViewport().add(table1);				
				JLabel lblNome = new JLabel("  Nome do Produto:");
				btnPesquisar = new JButton("Pesquisar");
						
				painelPesquisa.add(lblNome);
				painelPesquisa.add(txtNome);
				painelPesquisa.add(btnPesquisar);
				btnPesquisar.addActionListener(this);
				
				// adicionado ao painelTabela
				
				//painelTabela.add(tblPesquisa);
				
				janela.getContentPane().add(painelPesquisa,BorderLayout.NORTH);
				janela.getContentPane().add(panTable,BorderLayout.CENTER);
				janela.setVisible(true);
				janela.setSize(850,450);
				janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Pesquisar".equals(e.getActionCommand()));
			List<Produto> lista = controle.pesquisarJtable(txtNome.getText());
			if (lista.size() > 0){
				Produto p = lista.get(0);
				
							
			}
		table1.invalidate();
		table1.revalidate();
		table1.repaint();
		
	}

}
