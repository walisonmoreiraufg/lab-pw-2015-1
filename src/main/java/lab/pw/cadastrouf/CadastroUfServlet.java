package lab.pw.cadastrouf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cadastro-uf")
public class CadastroUfServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op = req.getParameter("op");

		if (op == null) {
			req.getRequestDispatcher("cadastro-uf/cadastro-uf.jsp")
				.forward(req, resp);
		} else if (op.equals("carregar")) {
			Uf uf = new Uf();
			uf.setCodigo("1");
			uf.setNome("Goiás");
			req.setAttribute("uf", uf);

			req.getRequestDispatcher("cadastro-uf/cadastro-uf.jsp")
				.forward(req, resp);
		} else if (op.equals("excluir")) {
			Uf uf = new Uf();
			uf.setCodigo("1");
			uf.setNome("");
			req.setAttribute("uf", uf);

			req.getRequestDispatcher("cadastro-uf/cadastro-uf.jsp")
				.forward(req, resp);
		} else if (op.equals("salvar")) {
			Uf uf = new Uf();
			uf.setCodigo("1");
			uf.setNome("Goiás");

			req.setAttribute("uf", uf);
			req.getRequestDispatcher("cadastro-uf/cadastro-uf.jsp")
				.forward(req, resp);
		} else {
			req.getRequestDispatcher("cadastro-uf/cadastro-uf.jsp")
				.forward(req, resp);
		}
	}
}
