package lab.pw.jpa;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Para salvar um aluno.
//http://localhost:9090/lab-pw/jpa?op=salvarAluno&id=1&nome=Joao
	
//Para carregar um aluno.
//http://localhost:9090/lab-pw/jpa?op=carregarAluno&id=1
	
@WebServlet(value = "/jpa")
public class Jpa extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String op = req.getParameter("op");

			if (op == null) {
				resp.getOutputStream().print("ERRO");
			} else if (op.equals("salvarAluno")) {
				Long id = Long.parseLong(req.getParameter("id"));
				String nome = req.getParameter("nome");
				salvarAluno(id, nome);
				resp.getOutputStream().print("Aluno salvo com sucesso.");
			} else if (op.equals("carregarAluno")) {
				Long id = Long.parseLong(req.getParameter("id"));
				carregarAluno(id);
				resp.getOutputStream().print("Aluno carregado com sucesso.");
			} else {
				resp.getOutputStream().print("op = " + op);
			}
		} catch (Throwable e) {
			resp.getOutputStream().print("Ôpa! Deu erro.");
			e.printStackTrace();
		}
	}

	private void salvarAluno(Long id, String nome) {
		EntityManager em = null;
		EntityManagerFactory emf = null;
		try {
		    emf = Persistence.createEntityManagerFactory("alunos");

		    //Obter conexão com o banco de dados.
		    em = emf.createEntityManager();

		    em.getTransaction().begin();

		    Aluno aluno = new Aluno();
		    aluno.setId(id);
		    aluno.setNome(nome);

		    em.persist(aluno);

		    em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			if (em != null) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}

	private void carregarAluno(Long id) {
		EntityManager em = null;
		EntityManagerFactory emf = null;
		try {
		    emf = Persistence.createEntityManagerFactory("alunos");

		    em = emf.createEntityManager();
		    
		    em.getTransaction().begin();

		    Aluno aluno = em.find(Aluno.class, id);
		    
		    System.out.println("Aluno: " + aluno.getNome());

		    em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			if (em != null) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

}
