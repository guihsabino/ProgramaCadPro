package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidade.Produto;

public class ProdutosDao {
	private static String url = "jdbc:mariadb://localhost:3306/CADPRO";
	private static String user = "root";
	private static String pass = "";

	public ProdutosDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Conectado com o Banco! ");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adicionar(Produto l) {
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "insert into produtos (nome_produto,codigo,valor,grupo)" + " values ('" + l.getNome() + "','"
					+ l.getCodigo() + "','" + l.getValor() + "','" + l.getGrupo() + "');";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,
					"Adicionado o Produto com o nome: \n " + l.getNome() + " \n com sucesso!");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Produto pesquisar(String txtNome) {
		Produto p = new Produto();
		try {
			Connection con;
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM produtos 	WHERE nome_produto like '%" + txtNome + "%'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				p.setNome(rs.getString("nome_produto"));
				p.setCodigo(rs.getString("codigo"));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				p.setGrupo(rs.getString("grupo"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}

	public void remover(String codigo) {
		try {
			Connection con;
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM produtos WHERE codigo = '" + codigo + "'";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Produto Deletado com sucesso");
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvar(String codigo, Produto c) {
	
		
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "UPDATE produtos SET nome_produto = '" + c.getNome() + "',codigo ='" + c.getCodigo()
			+ "',valor = '" + c.getValor() + "',grupo ='" + c.getGrupo() + "' where codigo = '" + codigo
			+ "';";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,	"Produto Alterado !");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	public List<Produto> pesquisarJtable(String txtNome) {
		
		List<Produto> lista = new ArrayList();

		try {
			Connection con;
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM produtos 	WHERE nome_produto like '%" + txtNome + "%'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Produto p = new Produto();
				p.setNome(rs.getString("nome_produto"));
				p.setCodigo(rs.getString("codigo"));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				p.setGrupo(rs.getString("grupo"));
				
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

}
