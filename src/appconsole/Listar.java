package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;

import modelo.Produto;
import modelo.Entrega;
import modelo.Entregador;
import util.Util;

public class Listar {

	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager() ;
		
		System.out.println("------------ PRODUTOS ------------");
		List<Produto> resultados1 = manager.query(Produto.class);
		for(Produto p : resultados1) {
			System.out.println(p);
		}

		System.out.println("\n------------ ENTREGAS ------------");
		List<Entrega> resultados2 = manager.query(Entrega.class);
		for(Entrega e : resultados2) {
			System.out.println(e);
		}
		
		System.out.println("\n------------ ENTREGADORES ------------");
		List<Entregador> resultados3 = manager.query(Entregador.class);
		for(Entregador er : resultados3) {
			System.out.println(er);
		}
	
		Util.desconectar();
		System.out.println("fim do programa");

	}

}