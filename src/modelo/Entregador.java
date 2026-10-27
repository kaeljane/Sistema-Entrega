package modelo;

import java.util.ArrayList;

public class Entregador {
	private int id;
	private String nome;
	private ArrayList<Entrega> listaEntrega;
	
	
	public Entregador(String nome) {
		this.nome = nome;
		this.listaEntrega = new ArrayList<>();
	}

	public String getNome() {
		return this.nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Entrega> getListaEntrega() {
		return this.listaEntrega;
	}
	
	public void adicionarEntrega(Entrega entrega) {
		this.listaEntrega.add(entrega);
	}
	
	public void removerEntrega(Entrega entrega) {
		this.listaEntrega.remove(entrega);
	}
	
	@Override
	public String toString() {
	    String entregas = "";
	    for (Entrega e : listaEntrega) {
	        entregas += e.getId();
	    }

	    return "Entregador [id = " + id + ", nome = " + nome + "] -> Entregas: " + entregas;
	}
	
	
}
