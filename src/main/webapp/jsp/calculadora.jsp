<%@page import="java.util.Date"%>
<%@page import="lab.pw.Calculadora"%>
<%
Double op1 = Calculadora.toDouble(request.getParameter("op1"));

String operacao = request.getParameter("operacao");
operacao = operacao == null ? "" : operacao;

Double op2 = Calculadora.toDouble(request.getParameter("op2"));

//Double resultado = calcular(op1, operacao, op2);

Double resultado = Calculadora.calcular(op1, operacao, op2);
%>

<%!public Double calcular(Double op1, String operacao, Double op2) {
	Double result = 0.0;
	if (operacao.equals("+")) {
		result = op1 + op2;
	} else if (operacao.equals("-")) {
		result = op1 - op2;
	} else if (operacao.equals("*")) {
		result = op1 * op2;
	} else if (operacao.equals("/")) {
		result = op1 / op2;
	}
	return result;
}%>
<html>
	<head>
		<title>Calculadora</title>
	</head>
	<body>
		<h1>Calculadora - <%=new Date()%></h1>
		<form>
			Operador 1: <input type="text" name="op1" value="<%=op1%>">
			<br>
			Operação: <input type="text" name="operacao" value="${param.operacao}">
			<br>
			Operador 2: <input type="text" name="op2">
			<br>
			<button>Calcular</button>
		</form>
		
		<h1>Resultado = <%=resultado%></h1>
	</body>
</html>
		