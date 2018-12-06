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
import entidade.Usuarios;
import boundary.TelaLogin;

public class UsuariosDao {
	private static String url = "jdbc:mariadb://localhost:3306/CADPRO";
	private static String user = "root";
	private static String pass = "";

	public UsuariosDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Conectado com o Banco! ");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void adicionarUsuario(Usuarios u) {
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "insert into usuarios (nome,celular,telefone,cpf,rg,endereco,loginvendedor,senhavendedor)"
					+ " values ('" + u.getNome() + "','" + u.getCelular() + "','" + u.getTelefone() + "','" + u.getCPF()
					+ "','" + u.getRG() + "','" + u.getEndereco() + "','" + u.getLoginVendedor() + "','"
					+ u.getSenhaVendedor() + "' );";
			int i = stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Adicionado o Usuario: \n " + u.getNome() + " \n com sucesso!");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remover(String CPF) {
		try {
			Connection con;
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM usuarios WHERE cpf = '" + CPF + "'";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Usuario Deletado com Sucesso");
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuarios login(String loginvendedor, String senhavendedor) {
		Usuarios usuario = null;
		try {
			Connection con;
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM usuarios 	WHERE  loginvendedor = '" + loginvendedor
					+ "' and senhavendedor = '" + senhavendedor + "'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				usuario = new Usuarios();
				usuario.setNome(rs.getString("NOME"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	public Usuarios pesquisar(String txtNome) {
		Usuarios u = new Usuarios();
		try {
			Connection con;
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM usuarios 	WHERE nome like '%" + txtNome + "%'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				u.setNome(rs.getString("nome"));
				u.setCelular(rs.getString("celular"));
				u.setTelefone(rs.getString("telefone"));
				u.setCPF(rs.getString("cpf"));
				u.setRG(rs.getString("rg"));
				u.setEndereco(rs.getString("endereco"));
				u.setLoginVendedor(rs.getString("loginvendedor"));
				u.setSenhaVendedor(rs.getString("senhavendedor"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;

	}

	public void salvar(String CPF, Usuarios c) {

		Connection con;
		try {
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "UPDATE usuarios SET nome = '" + c.getNome() + "',celular ='" + c.getCelular()
					+ "',telefone = '" + c.getTelefone() + "',cpf ='" + c.getCPF() + "',rg ='" + c.getRG()
					+ "',endereco ='" + c.getEndereco() + "',loginvendedor ='" + c.getLoginVendedor()
					+ "',senhavendedor ='"+c.getSenhaVendedor()+"' where cpf = '" + CPF + "';";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Registro Alterado !");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public List<Usuarios> pesquisarJTable(String txtNome) {
	List<Usuarios>  lista  = new ArrayList();
	try {
		Connection con;
		con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		String query = "SELECT * FROM usuarios 	WHERE nome like '%" + txtNome + "%'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Usuarios u = new Usuarios();
			u.setNome(rs.getString("nome"));
			u.setCelular(rs.getString("celular"));
			u.setTelefone(rs.getString("telefone"));
			u.setCPF(rs.getString("cpf"));
			u.setRG(rs.getString("rg"));
			u.setEndereco(rs.getString("endereco"));
			u.setLoginVendedor(rs.getString("loginvendedor"));
			lista.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lista;
}
}