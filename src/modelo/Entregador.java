package modelo;

import java.util.ArrayList;

import util.GeradorID;

public class Entregador {
	private int id;
	private String nome;
	private ArrayList<Entrega> listaEntrega;
	
	
	public Entregador(String nome) {
		// this.id = GeradorID.getProximoIdEntregador();
		this.nome = nome;
		this.listaEntrega = new ArrayList<>();
	}
	
	public void getId() {
		// return this.id;
	}
	
	public String getNome() {
		return this.nome;
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
        return "Entregador: id = " + id + ", nome = " + nome +  
               ", entregas = " + listaEntrega;
    }
	
	
}
