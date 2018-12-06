package entidade;

import java.util.List;

public class Produto {
	
	String nome;
	String codigo;
	float valor;
	Object Grupo;
	
	// Get e Set Nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// Get e Set Codigo
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	//Get e Set Valor 
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Object getGrupo() {
		return Grupo;
	}
	public void setGrupo(Object object) {
		Grupo = object;
	}

}
