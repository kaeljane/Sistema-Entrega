package modelo;

import java.util.ArrayList;

public class Produto {
	private int id;
	private String nome;
	private double peso_gramas;
	private ArrayList<Entrega> listaEntrega;
	
	public Produto(String nome, double peso) {
		this.nome = nome;
		this.peso_gramas = peso;
		this.listaEntrega = new ArrayList<>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getPeso() {
		return this.peso_gramas;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPeso(double peso) {
		this.peso_gramas = peso;
	}
	
	public ArrayList<Entrega> getListaEntrega() {
		return this.listaEntrega;
	}

	public void adicionarEntrega(Entrega entrega) {
		this.listaEntrega.add(entrega);
		entrega.getListaProduto().add(this);
	}
	
	public void removerEntrega(Entrega entrega) {
		this.listaEntrega.remove(entrega);
		entrega.getListaProduto().remove(this);
	}
	
	@Override
	public String toString() {
	    String datas = "";
	    for (Entrega e : listaEntrega) {
	        datas += e.getId() + " ";
	    }
	    return "Produto [id = " + id + ", nome = " + nome + ", peso = " + peso_gramas + "g] | Entregas: " + datas;
	}
}
