package lab.pw.jdbc;

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

@WebServlet(value = "/bancodados")
public class BancoDados extends HttpServlet {

	private Connection conexao;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String op1 = req.getParameter("op1");

			if (op1 == null) {
				resp.getOutputStream().print("ERRO");
			} else if (op1.equals("conectar")) {
				conectar();
				resp.getOutputStream().print("Conexão realizada com sucesso.");
			} else if (op1.equals("criar")) {
				criar();
				resp.getOutputStream().print("Tabela criada com sucesso.");
			} else {
				resp.getOutputStream().print("op1 = " + op1);
			}
		} catch (Throwable e) {
			resp.getOutputStream().print("Ôpa! Deu erro.");
			e.printStackTrace();
		}
	}

	private void conectar() throws SQLException {
		// URL de conexão com o banco de dados Derby.
		String url = "jdbc:derby:db;create=true";
		// URL de conexão com o banco de dados Derby em memória.
		// String url = "jdbc:derby:memory:banco-de-dados;create=true";
		// URL equivalente em MySQL.
		// String url = "jdbc:mysql://localhost/banco-de-dados";
			// Abrir uma conexão com o banco de dados.
		conexao = DriverManager.getConnection(url);
	}

	private void criar() throws SQLException {
		String sql = ""
				+ "create table usuario ("
				+ "  id bigint not null,"
				+ "  nome varchar(50) not null,"
				+ "  identificacao varchar(50) not null,"
				+ "  senha varchar(50) not null,"
				+ "  constraint pk_usuario primary key (id) "
				+ ")";
		// Criar a tabela de usuário.
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		stmt.close();
	}

}
