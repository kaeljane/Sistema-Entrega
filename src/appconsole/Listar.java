package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;

import modelo.Entrega;
import modelo.EntregaExpressa;
import modelo.Entregador;
import modelo.Produto;
import util.Util;

public class Listar {

	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager() ;
		
		System.out.println("------------ PRODUTOS ------------");
		List<Produto> produtos = manager.query(Produto.class);
		for(Produto p : produtos) {
			System.out.println(p);
		}

		System.out.println("\n------------ ENTREGAS ------------");
		List<Entrega> entregas = manager.query(Entrega.class);
		for(Entrega e : entregas) {
			System.out.println(e);
		}
		
		System.out.println("\n------------ APENAS ENTREGAS EXPRESSAS ------------");
		List<EntregaExpressa> expressas = manager.query(EntregaExpressa.class);
		for (EntregaExpressa ee : expressas) {
			System.out.println(ee + " | Valor Total: R$ " + ee.getValor());
		}
		
		System.out.println("\n------------ ENTREGADORES ------------");
		List<Entregador> entregadores = manager.query(Entregador.class);
		for(Entregador er : entregadores) {
			System.out.println(er);
		}
	
		Util.desconectar();
		System.out.println("fim do programa");

	}

}