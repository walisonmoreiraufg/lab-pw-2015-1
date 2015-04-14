<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Alunos</title>
	</head>
	<body>
		<h1>Alunos</h1>
		<h2>Com TagLib</h2>
		<table border="1">
			<thead>
				<tr>
					<th>Matrícula</th>
					<th>Nome</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>				
				<c:forEach var="aluno" items="${alunos}">
					<tr>
						<td>
							<c:choose>
					      <c:when test="${aluno.matricula == '123'}">
					      	<b>${aluno.matricula}</b>
					      </c:when>
					      <c:otherwise>pizzas.
      						${aluno.matricula}
					      </c:otherwise>
							</c:choose>
						</td>
						<td>${aluno.nome}</td>
						<td>${aluno.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
		