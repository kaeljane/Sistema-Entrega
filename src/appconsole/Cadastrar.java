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

		Entrega e = new Entrega("12/10/2026", er, p);    
		Entrega e1 = new Entrega("13/10/2026", er1, p2); 

		e.adicionarProduto(p1);  
		e1.adicionarProduto(p1); 
		
		//*************************************************
		//Persistir objetos no banco de dados  
		//*************************************************
		manager.store(p);
		manager.store(p1);
		manager.store(p2);
		
		manager.store(er);
		manager.store(er1);

		manager.store(e);
		manager.store(e1);
		manager.commit();
		
		Util.desconectar();
		System.out.println("cadastrou.");
		System.out.println("fim do programa");

	}

}
