package util;

public class GeradorID {
	
	private static int idProduto = 0;
	private static int idEntrega = 0;
	private static int idEntregador = 0;
	
	public static String getProximoIdProduto() {
		idProduto++;
		return "P" + idProduto;
	}
	
	public static String getProximoIdEntrega() {
		idEntrega++;
		return "E" + idEntrega;
	}
	
	public static String getProximoIdEntregador() {
		idEntregador++;
		return "ER" + idEntregador;
	}
}