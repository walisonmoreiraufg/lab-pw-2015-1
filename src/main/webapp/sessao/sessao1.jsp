<html>
	<head>
		<title>Sessão 1</title>
	</head>
	<body>
		<h1>Sessão 1</h1>
		<h1><%
			String nome = request.getParameter("nome");
		
			session.setAttribute("usuario", nome);
			
			application.setAttribute("usuario", nome);
			
		%></h1>
		<form>
			Nome: <input type="text" name="nome">
			<button>Submit</button>
 		</form>
	</body>
</html>
		