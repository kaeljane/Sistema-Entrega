package modelo;

public class EntregaExpressa extends Entrega {
	private double taxaextra;
	
	public EntregaExpressa(String data, Entregador entregador, Produto produto, double valor, double taxaextra) {
		super(data, entregador, produto, valor);
		this.taxaextra = taxaextra;
	}
	
	public double getTaxaExtra() {
		return this.taxaextra;
	}

	public void setTaxaExtra(double taxaExtra) {
		this.taxaextra = taxaExtra;
	}
	
	@Override
	public double getValor() {
		return super.getValor() + this.taxaextra;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " | taxa extra = " + taxaextra;
	}

}
