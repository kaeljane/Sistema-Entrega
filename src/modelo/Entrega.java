package modelo;

import java.util.ArrayList;
import util.GeradorID;

public class Entrega {
    private String id;
    private String data;
    private String Entregador entregador;
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
        this.listaProduto.add(produto);
        produto.adicionarEntrega(this);
    }

    public void removerProduto(Produto produto) {
        this.listaProduto.remove(produto);
        produto.removerEntrega(this);
    }
}