package lab.pw.cadastrouf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cadastro-uf")
public class CadastroUfServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		try {
			String sql = ""
					+ "create table uf ("
					+ "  codigo varchar(50),"
					+ "  nome varchar(50),"
					+ "  constraint pk_uf primary key (codigo) "
					+ ")";
			String url = "jdbc:derby:db;create=true";
			Connection conexao = DriverManager.getConnection(url);
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String op = req.getParameter("op");

			if (op == null) {
				chamarJsp(req, resp);
			} else if (op.equals("carregar")) {
				carregarUf(req, resp);
			} else if (op.equals("excluir")) {
				excluirUf(req, resp);
			} else if (op.equals("salvar")) {
					salvarUf(req, resp);
			} else {
				chamarJsp(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void excluirUf(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String codigo = req.getParameter("codigo");

		String url = "jdbc:derby:db;create=true";
		Connection conexao = DriverManager.getConnection(url);
		Statement stmt = conexao.createStatement();
		stmt.executeUpdate("delete from uf where codigo = '" + codigo + "'");
		
		Uf uf = new Uf();
		uf.setCodigo(codigo);
		uf.setNome("");

		req.setAttribute("uf", uf);

		chamarJsp(req, resp);
	}

	private void carregarUf(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String codigo = req.getParameter("codigo");

		String url = "jdbc:derby:db;create=true";
		Connection conexao = DriverManager.getConnection(url);
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery("select nome from uf where codigo = '" + codigo + "'");

		Uf uf = new Uf();
		uf.setCodigo(codigo);

		if (rs.next()) {
			String nome = rs.getString("nome");
			uf.setNome(nome);
		} else {
			uf.setNome("");
		}

		req.setAttribute("uf", uf);

		chamarJsp(req, resp);
	}

	private void salvarUf(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		String codigo = req.getParameter("codigo");
		String nome = req.getParameter("nome");

		String url = "jdbc:derby:db;create=true";
		Connection conexao = DriverManager.getConnection(url);
		Statement stmt = conexao.createStatement();
		stmt.executeUpdate("insert into uf (codigo, nome) values ('"
			+ codigo + "', '" + nome + "')");
		
		Uf uf = new Uf();
		uf.setCodigo(codigo);
		uf.setNome(nome);

		req.setAttribute("uf", uf);

		chamarJsp(req, resp);
	}

	private void chamarJsp(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("cadastro-uf/cadastro-uf.jsp")
			.forward(req, resp);
	}
}
