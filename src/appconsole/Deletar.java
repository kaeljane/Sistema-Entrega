package appconsole;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Entrega;
import modelo.EntregaExpressa;
import modelo.Entregador;
import modelo.Produto;
import util.Util;

public class Deletar {
	public static void main(String[] args) {
		Util.conectar();
		ObjectContainer manager = Util.getManager();
		
		// TESTE 1: Deletar um Produto ("caneca azul")
		String buscaProduto = "caneca azul";
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(buscaProduto);
		List<Produto> resultados = q.execute();
		
		if (resultados.isEmpty()) System.out.println("produto inexistente " + buscaProduto);
		else {
			Produto p = resultados.getFirst();
			
			for (Entrega e : new java.util.ArrayList<>(p.getListaEntrega())) {
				e.removerProduto(p);
				manager.store(e);
			}
			
			p.getListaEntrega().clear();
			
			manager.delete(p);
			manager.commit();
			System.out.println("deletou produto: " + buscaProduto);
		}
		
		// TESTE 2: Deletar uma EntregaExpressa ("15/10/2026")
		String dataExpressa = "15/10/2026";
		Query q2 = manager.query();
		q2.constrain(EntregaExpressa.class);
		q2.descend(dataExpressa);
		List<EntregaExpressa> resultadosExpressa = q2.execute();
		
		if (resultadosExpressa.isEmpty()) {
			System.out.println("entrega expressa inexistente: " + dataExpressa);
		}
		else {
			EntregaExpressa ee = resultadosExpressa.getFirst();
			Entregador er = ee.getEntregador();
			
			// Desvincula do entregador
			if (er != null) {
				er.removerEntrega(ee);
				manager.store(er);
			}
			
			// Desvincula de todos os produtos
			for (Produto p : new ArrayList<>(ee.getListaProduto())) {
				ee.removerProduto(p);
				manager.store(p);
			}
			
			manager.delete(ee);
			manager.commit();
			System.out.println("deletou entrega expressa de: " + dataExpressa);
		}
		
		Util.desconectar();
		System.out.println("fim do programa");
		
	}
}