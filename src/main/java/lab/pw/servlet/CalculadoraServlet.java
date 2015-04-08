package lab.pw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/calculadora")
public class CalculadoraServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String op1 = req.getParameter("op1");
		
		if (op1 == null) {
			//Repassa para o JSP.
			req.getRequestDispatcher("servlet/calculadora-inicio.jsp")
				.forward(req, resp);
		} else {
			//Regras de negócio.
			Double r = 20.5;
			//...
			
			req.setAttribute("result", r);
			
			//req.setAttribute("result", 1.1);
			
			//req.getSession().setAttribute("result", 1.2);
			
			//getServletContext().setAttribute("result", 1.3);
			
			//Repassa para o JSP.
			req.getRequestDispatcher("servlet/calculadora-resultado.jsp")
				.forward(req, resp);
		}
		
		

	}
}
