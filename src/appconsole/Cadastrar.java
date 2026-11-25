package appconsole;

import com.db4o.ObjectContainer;

import modelo.Entrega;
import modelo.EntregaExpressa;
import modelo.Entregador;
import modelo.Produto;
import util.Util;

public class Cadastrar {

	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager();	//gerenciador da persistencia de objetos
		
		// Produtos
		Produto p1 = new Produto("caneca azul", 330);
		Produto p2 = new Produto("camisa vermelha", 100);
		Produto p3 = new Produto("caneca snoopy", 110);
		Produto p4 = new Produto("teclado mecanico", 850);
		
		// Entregadores
		Entregador er1 = new Entregador("otávio");
		Entregador er2 = new Entregador("kaeljane");
		Entregador er3 = new Entregador("lucas");
		
		// Entrega normais (agora passando o valor)
		Entrega e1 = new Entrega("12/10/2026", er1, p1, 20.0);
		e1.adicionarProduto(p2);
		
		Entrega e2 = new Entrega("13/10/2026", er2, p3, 25.0); 
		e2.adicionarProduto(p2); // add mesmo
		
		// Entregas Expressas (subclasse nova: valor + taxaextra)
		EntregaExpressa ee1 = new EntregaExpressa("14/10/2026", er2, p4, 40.0, 15.0);
		ee1.adicionarProduto(p1);
		
		EntregaExpressa ee2 = new EntregaExpressa("15/10/2026", er3, p2, 30.0, 12.5);
		
		//Persistir objetos no banco de dados  
		manager.store(p1);
		manager.store(p2);
		manager.store(p3);
		manager.store(p4);
		
		manager.store(er1);
		manager.store(er2);
		manager.store(er3);

		manager.store(e1);
		manager.store(e2);
		manager.store(ee1);
		manager.store(ee2);
		manager.commit();
		
		Util.desconectar();
		System.out.println("cadastrou tudo (incluindo EntregaExpressa).");
		System.out.println("fim do programa");

	}

}
