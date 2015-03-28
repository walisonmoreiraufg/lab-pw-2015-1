<html>
	<head>
		<title>Sessão 3</title>
	</head>
	<body>
		<h1>Sessão 3</h1>
		<%
			session.invalidate();
		%>
		<h2>A sessão morreu!</h2>
		<%
			application.removeAttribute("usuario");
		%>
		<h2>A aplicação (application) está vazia!</h2>
	</body>
</html>
		