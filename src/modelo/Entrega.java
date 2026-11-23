package modelo;

import java.util.ArrayList;

public class Entrega {
	private int id;
    private String data;
    private Entregador entregador;
    private ArrayList<Produto> listaProduto;
    private double valor;

    public Entrega(String data, Entregador entregador, Produto produto, double valor) {
        this.data = data;
        this.entregador = entregador;
        this.listaProduto = new ArrayList<>();
        this.valor = valor;

        entregador.adicionarEntrega(this);
        this.adicionarProduto(produto);
        
    }

    public String getData() {
        return this.data;
    }

    public Entregador getEntregador() {
        return this.entregador;
    }
    
    public ArrayList<Produto> getListaProduto () {
        return this.listaProduto;
    } 
    
	public int getId() {
		return id;
	} 
	
	public double getValor() {
		return this.valor;
	}
	
    public void setData(String data) {
        this.data = data;
    }

    public void setEntregador(Entregador e) {
        this.entregador = e;
    }
    
    public void adicionarProduto(Produto produto) {
    	this.listaProduto.add(produto);
    	produto.getListaEntrega().add(this);
    }

    public void removerProduto(Produto produto) {
    	this.listaProduto.remove(produto);
    	produto.getListaEntrega().remove(this);
    }
    
	public void setValor(double valor) {
		this.valor = valor;
	}
    
    @Override
    public String toString() {
        String nomes = "";
        for (Produto p : listaProduto) {
            nomes += p.getId() + " ";
        }
        return "Entrega [id = " + id + ", data = " + data + ", valor = " + valor + "] -> Entregador: " + entregador.getId() + " | Produtos: " + nomes;
    }
}