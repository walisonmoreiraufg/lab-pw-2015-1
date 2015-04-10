<%@page import="java.util.Date"%>

<%@include file="funcoes.jsp"%>

<html>
<head>
<title>Calculadora</title>
</head>
<body>
	<h1>
		Calculadora -	<%=new Date()%></h1>

		<%@include file="formulario.jsp"%>

		<%@include file="resultado.jsp"%>

</body>
</html>
