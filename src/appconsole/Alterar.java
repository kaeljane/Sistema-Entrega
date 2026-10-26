package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Entrega;
import modelo.Produto;
import util.Util;

public class Alterar {

	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager();

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

		Util.desconectar();
		System.out.println("fim do programa");
	}
}
