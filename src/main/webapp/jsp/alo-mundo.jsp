<html>
	<head>
		<title>Alô Mundo!</title>
	</head>
	<body>
		<h1>Alô Mundo!</h1>
		<h1><%
			int i = 0;
			String nome = request.getParameter("nome");
			out.print("Alô " + nome +
					"! Hoje é " + new java.util.Date());
		%></h1>
		<h1>
			<script>
				document.write("Aqui é HTML gerado pelo JS!");
			</script>
		</h1>
		<form>
			Nome: <input type="text" name="nome">
			<button>Submit</button>
  		<button type="reset">Reset</button>
			<button type="button" onclick="alert('Faz nada!')">Faz nada</button>
 		</form>
	</body>
</html>
		