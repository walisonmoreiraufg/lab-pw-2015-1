package lab.pw;

public class Calculadora {
	public static Double calcular(Double op1, String operacao, Double op2) {
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
	}
	
	public static Double toDouble(String n) {
		Double r = 0.0;
		try {
			r = n == null ? 0.0 : Double.parseDouble(n);
		} catch(Exception e) {
			//Deu não!
		}
		return r;
	}
}
