package appconsole;

import modelo.Produto;
import modelo.Entrega;
import modelo.Entregador;

public class Teste {

	public static void main(String[] args) {
		System.out.println("Criação dos objetos\n");
		Produto p = new Produto("caneca azul", 330);
		Produto p1 = new Produto("camisa vermelha", 100);
		Entregador er = new Entregador("otávio");
		Entrega e = new Entrega("12/10/2026", er);
		
		System.out.println(p);
		System.out.println(p1);
		System.out.println(er);
		System.out.println(e);
		
		e.adicionarProduto(p);
		e.adicionarProduto(p1);
		System.out.println("Lista dos produtos: " + e.getListaProduto());
		System.out.println("Lista das entregas: " + p.getListaEntrega());
		System.out.println("Lista das entregas: " + p1.getListaEntrega());
		
		Produto p2 = new Produto("caneca snoopy", 110);
		System.out.println(p2);
		
		e.adicionarProduto(p2);
		e.removerProduto(p1);
		System.out.println(e);
		System.out.println(p);
		
		Entregador er1 = new Entregador("márcia");
		Entrega e1 = new Entrega("13/10/2026", er1);
		System.out.println(er1);
		p.adicionarEntrega(e1);
		System.out.println(e1);
		System.out.println(p);
		
	}

}
