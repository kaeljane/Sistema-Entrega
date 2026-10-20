package util;

import javax.swing.JOptionPane;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import modelo.Produto;
import modelo.Entrega;
import modelo.Entregador;

public class Util {
	private static ObjectContainer manager;
	private static String ip="localhost";

	public static void conectar() {
		if (manager != null)
			return; // ja tem uma conexao
		
		try {
			conectarBancoLocal(); // banco local (pasta do projeto)
			// ativar controle de IDs autom�ticos
			GeradorID.ativar(manager); // ativa gera��o de IDs autom�ticos para as classes com atributo "int id"
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco " + ip + "\n" + e.getMessage());
			System.exit(0);
		}
	}

	private static void conectarBancoLocal() {
		if (manager != null)
			return; // ja tem uma conexao

		// ---------------------------------------------------------------
		// configurar, criar e abrir banco local (pasta do projeto)
		// ---------------------------------------------------------------
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0); // mensagens na tela 0(desliga),1,2,3...

		// habilitar cascata na altera��o, remo��o e leitura
		config.common().objectClass(Produto.class).cascadeOnDelete(false);
		config.common().objectClass(Produto.class).cascadeOnUpdate(true);
		config.common().objectClass(Produto.class).cascadeOnActivate(true);
		config.common().objectClass(Entrega.class).cascadeOnDelete(false);
		config.common().objectClass(Entrega.class).cascadeOnUpdate(true);
		config.common().objectClass(Entrega.class).cascadeOnActivate(true);
		config.common().objectClass(Entregador.class).cascadeOnDelete(false);
		config.common().objectClass(Entregador.class).cascadeOnUpdate(true);
		config.common().objectClass(Entregador.class).cascadeOnActivate(true);
		config.common().activationDepth(Integer.MAX_VALUE); // profundidade de ativacao para acessar os objetos

		// conexao local
		// --------------
		try {
			manager = Db4oEmbedded.openFile(config, "banco.db4o");
			System.out.println("banco conectado. ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco local \n" + e.getMessage());
			System.exit(0);
		}
	}

	public static void desconectar() {
		if (manager != null) {
			manager.close();
			manager = null;
		}
	}

	public static ObjectContainer getManager() {
		return manager;
	}

	public static String getIP() {
		return ip;
	}

}// fim da classe Util
