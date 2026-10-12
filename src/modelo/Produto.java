package modelo;

import java.util.ArrayList;
import util.GeradorID;

public class Produto {
	private String id;
	private String nome;
	private double peso;
	private ArrayList<Entrega> listaEntrega;
	
	public Produto(String nome, double peso) {
		this.id = GeradorID.getProximoIdProduto();
		this.nome = nome;
		this.peso = peso;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
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
}
