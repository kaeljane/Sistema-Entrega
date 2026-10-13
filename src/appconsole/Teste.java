package appconsole;

import modelo.Produto;
import modelo.Entrega;
import modelo.Entregador;

public class Teste {

	public static void main(String[] args) {
		Produto p = new Produto("caneca azul", 330);
		Produto p1 = new Produto("camisa vermelha", 100);
		Produto p2 = new Produto("caneca snoopy", 110);
		Entregador er = new Entregador("otávio");
		Entrega e = new Entrega("12/10/2026", er);
		
		System.out.println("OBJETOS CRIADOS:\n");
				
		System.out.println("PRODUTO: CANECA AZUL");
		System.out.println(p);
		System.out.println("\n");
		
		System.out.println("PRODUTO: CAMISA VERMELHA");
		System.out.println(p1);
		System.out.println("\n");
		
		System.out.println("PRODUTO: CANECA SNOOPY");
		System.out.println(p2);
		System.out.println("\n");
		
		System.out.println("ENTREGADOR: OTÁVIO");
		System.out.println(er);
		System.out.println("\n");
		
		System.out.println("ENTREGA: 12/10/2026");
		System.out.println(e);
		System.out.println("\n");

		System.out.println("ADICIONANDO PRODUTOS NA ENTREGA 12/10/2026:\n");
		e.adicionarProduto(p);
		e.adicionarProduto(p1);
		System.out.println("LISTA DOS PRODUTOS NA ENTREGA 12/10/2026: " + e.getListaProduto() + "\n");
		System.out.println("LISTA DAS ENTREGAS DO PRODUTO CANECA AZUL: " + p.getListaEntrega() + "\n");
		System.out.println("LISTA DAS ENTREGAS DO PRODUTO CAMISA VERMELHA: " + p1.getListaEntrega() + "\n");
		
		System.out.println("REMOVENDO CANECA AZUL DA ENTREGA 12/10/2026:");
		e.removerProduto(p1);
		System.out.println("ENTREGA 12/10/2026: ");
		System.out.println(e.getListaProduto());
		System.out.println("PRODUTO CANECA AZUL: ");
		System.out.println(p.getListaEntrega());
		System.out.println("\n");
		
		System.out.println("ADICIONANDO ENTREGA NO PRODUTO CANECA SNOOPY:");
		p2.adicionarEntrega(e);
		System.out.println("ENTREGA 12/10/2026: ");
		System.out.println(e.getListaProduto());
		System.out.println("PRODUTO CANECA SNOOPY: ");
		System.out.println(p2.getListaEntrega());
		
		
	}

}
