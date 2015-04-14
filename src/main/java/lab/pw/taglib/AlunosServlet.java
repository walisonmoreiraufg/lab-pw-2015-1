package lab.pw.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/alunos")
public class AlunosServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		Aluno a = new Aluno();

		a.setMatricula("123");
		a.setNome("José Maria");
		a.setEmail("jose.maria@gmail.com");
		listaAlunos.add(a);

		Aluno b = new Aluno();
		b.setMatricula("456");
		b.setNome("Maria José");
		b.setEmail("maria.jose@gmail.com");
		listaAlunos.add(b);

		req.setAttribute("alunos", listaAlunos);
			
		req.getRequestDispatcher("jsp/taglib/alunos.jsp").forward(req, resp);

	}
}
