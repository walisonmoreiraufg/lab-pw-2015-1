<html>
	<head>
		<title>Sessão 2</title>
	</head>
	<body>
		<h1>Sessão 2</h1>
		<h1>Na sessão: <%
			String usuario = (String) session.getAttribute("usuario");
			out.print(usuario);
		%></h1>
		<h1>Na aplicação: <%
			usuario = (String) application.getAttribute("usuario");
			out.print(usuario);
		%></h1>
	</body>
</html>
		