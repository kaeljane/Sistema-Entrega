package modelo;

import java.util.ArrayList;
import util.GeradorID;


public class Entrega {
    private String id;
    private String data;
    private Entregador entregador;
    private ArrayList<Produto> listaProduto;

    public Entrega(String data, Entregador entregador) {
        this.id = GeradorID.getProximoIdEntrega();
        this.data = data;
        this.entregador = entregador;
        this.listaProduto = new ArrayList<>();

        entregador.adicionarEntrega(this);
    }

    public String getId() {
        return this.id;
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

    public void setData(String data) {
        this.data = data;
    }

    public void adicionarProduto(Produto produto) {
    	if (produto != null) {
    		this.listaProduto.add(produto);
    		produto.getListaEntrega().add(this);
    	}
    }

    public void removerProduto(Produto produto) {
    	if (produto != null) {
    		this.listaProduto.remove(produto);
    		produto.getListaEntrega().add(this);
    	}
    }
    
    @Override
    public String toString() {
        return "Entrega: id = " + id + ", data = " + data + 
               ", entregador = " + entregador.getNome() + 
               ", produtos = " + listaProduto;
    }
}