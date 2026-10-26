package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Entrega;
import modelo.Produto;
import util.Util;

public class Deletar {
	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager();
		
		String busca = "caneca azul";
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(busca);
		List<Produto> resultados = q.execute();
		
		if (resultados.isEmpty()) System.out.println("inexistente " + busca);
		else {
			Produto p = resultados.getFirst();
			
			for (Entrega e : new java.util.ArrayList<>(p.getListaEntrega())) {
				e.removerProduto(p);
				manager.store(e);
			}
			
			p.getListaEntrega().clear();
			
			manager.delete(p);
			manager.commit();
			System.out.println("deletou " + busca);
		}
		Util.desconectar();
		System.out.println("fim do programa");
		
	}
}