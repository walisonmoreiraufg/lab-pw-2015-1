<html>
	<head>
		<title>Cadastro de UF</title>
	</head>
	<body>
		<h1>Cadasto de UF</h1>
		<form action="cadastro-uf">
			Código: <input type="text" name="codigo" value="${uf.codigo}">
			<br>
			Nome: <input type="text" name="nome" value="${uf.nome}">
			<br>
			<button name="op" value="carregar">Carregar</button>
			<button name="op" value="excluir">Excluir</button>
			<button name="op" value="salvar">Salvar</button>
		</form>
	</body>
</html>
		