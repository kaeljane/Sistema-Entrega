package appconsole;

import com.db4o.ObjectContainer;

import modelo.Produto;
import modelo.Entrega;
import modelo.Entregador;
import util.Util;

public class Cadastrar {

	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager();	//gerenciador da persistencia de objetos
		
		Produto p = new Produto("caneca azul", 330);
		Produto p1 = new Produto("camisa vermelha", 100);
		Produto p2 = new Produto("caneca snoopy", 110);
		Entregador er = new Entregador("otávio");
		Entregador er1 = new Entregador("kaeljane");
		Entrega e = new Entrega("12/10/2026", er);
		Entrega e1 = new Entrega("13/10/2026", er1);
		
		e.adicionarProduto(p);
		e.adicionarProduto(p1);
		p2.adicionarEntrega(e);
		p1.adicionarEntrega(e1);
		
		
		//*************************************************
		//Persistir objetos no banco de dados  
		//*************************************************
		manager.store(e);
		manager.commit();
		manager.store(e1);
		manager.commit();
		
		Util.desconectar();
		System.out.println("cadastrou.");
		System.out.println("fim do programa");

	}

}
