package controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.UsuariosDao;
import entidade.Usuarios;

public class ControleUsuarios implements TableModel{
	UsuariosDao uDao = new UsuariosDao();
	public List<Usuarios> lista = new ArrayList();
	
	
	public ControleUsuarios(){	
	}
	
	public void adicionar(Usuarios u) {
		uDao.adicionarUsuario(u);
		
	}
	
	public Usuarios pesquisar(String nome){
		return uDao.pesquisar(nome);
		
	}
	
	public void remover(String CPF) {
		uDao.remover(CPF);
	}
	
	public void salvar(String CPF, Usuarios c){
		uDao.salvar(CPF, c);
	}
	
	
	
	public Usuarios login(String text, String text2) {
		return uDao.login(text,text2);		
		
	}
	
	public List<Usuarios> pesquisarJTable(String txtNome){
		lista = uDao.pesquisarJTable(txtNome);
		return lista;
	}

	@Override
	public void addTableModelListener(TableModelListener u) {
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return String.class;
		case 5 : return String.class;
		case 6 : return String.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex){
		case 0 : return "Nome do Usuario";
		case 1 : return "Celular de Contato";
		case 2 : return "Telefone Fixo";
		case 3 : return "CPF";
		case 4 : return "RG";
		case 5 : return "Endereço";
		case 6 : return "Login no Sistema";
		
		
	}
		return "";
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	 Usuarios u = lista.get(rowIndex);
	 switch (columnIndex){
		case 0 : return u.getNome();
		case 1 : return u.getCelular();
		case 2 : return u.getTelefone();
		case 3 : return u.getCPF();
		case 4 : return u.getRG();
		case 5 : return u.getEndereco();
		case 6 : return u.getLoginVendedor();
		
	}
	 return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener u) {
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}
	
}

