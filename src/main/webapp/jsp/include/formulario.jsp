<%@page import="lab.pw.Calculadora"%>
<%
Double op1 = Calculadora.toDouble(request.getParameter("op1"));

String operacao = request.getParameter("operacao");
operacao = operacao == null ? "" : operacao;

Double op2 = Calculadora.toDouble(request.getParameter("op2"));
%>
<form>
	Operador 1: <input type="text" name="op1" value="<%=op1%>"> <br>
	Operação: <input type="text" name="operacao" value="${param.operacao}">
	<br> Operador 2: <input type="text" name="op2"> <br>
	<button>Calcular</button>
</form>
