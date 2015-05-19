package lab.pw.jdbc.transacao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/transacao")
public class Transacao extends HttpServlet {

	private Connection conexao;
	
	@Override
	public void init() throws ServletException {
		try {
			criar();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String op = req.getParameter("op");

			if (op == null) {
				resp.getOutputStream().print("ERRO");
			} else if (op.equals("transferir")) {
				int valor = Integer.parseInt(req.getParameter("valor"));
				int contaOrigem = Integer.parseInt(req.getParameter("contaOrigem"));
				int contaDestino = Integer.parseInt(req.getParameter("contaDestino"));
				transferir(valor, contaOrigem, contaDestino);
				resp.getOutputStream().print("Transferência realizada com sucesso.");
			} else {
				resp.getOutputStream().print("op = " + op);
			}
		} catch (Throwable e) {
			resp.getOutputStream().print("Ôpa! Deu erro.");
			e.printStackTrace();
		}
	}

	private void transferir(int valor, int contaOrigem, int contaDestino) throws SQLException {
		String url = "jdbc:derby:db;create=true";
		conexao = DriverManager.getConnection(url);
		//Abrir transação.
		conexao.setAutoCommit(false);
		try {
			Statement stmt = conexao.createStatement();
			stmt.executeUpdate("update conta "
					+ "set saldo = (saldo - " + valor + ") "
					+ "where numero = " + contaOrigem);

			if (valor > 10) {
				throw new RuntimeException("Valor não permitido.");
			}
			
			stmt.executeUpdate("update conta "
					+ "set saldo = (saldo + " + valor + ") "
					+ "where numero = " + contaDestino);
			//Fechando transação efetivando comandos.
			conexao.commit();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			//Fechando transação descartando comandos.
			conexao.rollback();
		}
	}

	private void criar() throws SQLException {
		String sql = ""
				+ "create table conta ("
				+ "  numero bigint not null,"
				+ "  saldo bigint not null,"
				+ "  constraint pk_conta primary key (numero) "
				+ ")";
		String url = "jdbc:derby:db;create=true";
		conexao = DriverManager.getConnection(url);
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		stmt.close();
	}

}
