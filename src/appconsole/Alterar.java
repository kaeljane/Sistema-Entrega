package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Entrega;
import modelo.EntregaExpressa;
import modelo.Entregador;
import modelo.Produto;
import util.Util;

public class Alterar {

	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager();

		// TESTE 1: Remover relacionamento entre Produto e Entrega
		String nomeProduto = "camisa vermelha";
		String dataEntrega = "13/10/2026";

		Query q1 = manager.query();
		q1.constrain(Produto.class);
		q1.descend("nome").constrain(nomeProduto);
		List<Produto> produtos = q1.execute();

		Query q2 = manager.query();
		q2.constrain(Entrega.class);
		q2.descend("data").constrain(dataEntrega);
		List<Entrega> entregas = q2.execute();

		if (produtos.isEmpty())
			System.out.println("produto inexistente: " + nomeProduto);
		else if (entregas.isEmpty())
			System.out.println("entrega inexistente: " + dataEntrega);
		else {
			Produto p = produtos.get(0);
			Entrega e = entregas.get(0);

			if (!p.getListaEntrega().contains(e))
				System.out.println("não existe relacionamento entre " + nomeProduto + " e a entrega de " + dataEntrega);
			else {
				e.removerProduto(p);            // tira o produto da entrega
				p.getListaEntrega().remove(e);  // tira a entrega do produto

				manager.store(e);
				manager.store(p);
				manager.commit();
				System.out.println("removeu o relacionamento entre " + nomeProduto + " e a entrega de " + dataEntrega);
			}
		}
		// TESTE 2: Alterar entregador e taxa extra de uma EntregaExpressa
		Query q3 = manager.query();
		q3.constrain(EntregaExpressa.class);
		q3.descend("data").constrain("14/10/2026");
		List<EntregaExpressa> expressas = q3.execute();
		
		Query q4 = manager.query();
		q4.constrain(Entregador.class);
		q4.descend("nome").constrain("lucas");
		List<Entregador> entregadores = q4.execute();
		
		if (!expressas.isEmpty() && !entregadores.isEmpty()) {
			EntregaExpressa ee = expressas.getFirst();
			Entregador antigo = ee.getEntregador();
			Entregador novo = entregadores.getFirst();
			
			antigo.removerEntrega(ee);
			novo.adicionarEntrega(ee);
			ee.setEntregador(novo);
			ee.setTaxaExtra(22.0);
			
			manager.store(antigo);
			manager.store(novo);
			manager.store(ee);
			manager.commit();
			System.out.println("transferiu EntregaExpressa (14/10/2026 para )" + novo.getNome() + " e atualizou taxa extra.");
			
		}
		

		Util.desconectar();
		System.out.println("fim do programa");
	}
}
