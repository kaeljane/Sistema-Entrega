package modelo;

import util.GeradorID;

public class Entrega {
    private String id;
    private String endereco;
    private String status;
    private Produto produto;
    private Entregador entregador;

    public Entrega(Produto produto, Entregador entregador, String endereco) {
        this.id = GeradorID.getProximoIdEntrega();
        this.produto = produto;
        this.entregador = entregador;
        this.endereco = endereco;
        this.status = "PENDENTE";

        produto.adicionarEntrega(this);
        entregador.adicionarEntrega(this);
    }

    public String getId() {
        return this.id;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getStatus() {
        return this.status;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public Entregador getEntregador() {
        return this.entregador;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}