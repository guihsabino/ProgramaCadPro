package controle;



import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.ProdutosDao;
import entidade.Produto;

public class ControleProdutos implements TableModel{
	ProdutosDao pDao = new ProdutosDao();
	public List<Produto> lista = new ArrayList<>();
	
	public ControleProdutos(){
		
	}

	public void adicionar(Produto l) {
		pDao.adicionar(l);

	}

	public Produto pesquisar(String txtNome) {
		return pDao.pesquisar(txtNome);

	}

	public void remover(String CPF) {
		pDao.remover(CPF);
	}

	public void salvar(String codigo, Produto p) {
		pDao.salvar(codigo, p);
	}
	
	public List<Produto> pesquisarJtable(String txtNome){
		lista = pDao.pesquisarJtable(txtNome);
		return lista;		
	}
	

	@Override
	public void addTableModelListener(TableModelListener p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return Float.class;
		case 3 : return String.class;
		
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex){
		case 0 : return "Nome do Produto";
		case 1 : return "Codigo do Produto";
		case 2 : return "Valor Unitario";
		case 3 : return "Grupo de Produtos";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return lista.size() ;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Produto p = lista.get(rowIndex);
			switch (columnIndex) {
			case 0 : return p.getNome();
			case 1 : return p.getCodigo();
			case 2 : return p.getValor();
			case 3 : return p.getGrupo();
			}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener p) {		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			}

}
