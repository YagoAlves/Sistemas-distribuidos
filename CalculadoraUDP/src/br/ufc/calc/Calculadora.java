package br.ufc.calc;

public class Calculadora {
	
	public String calcula (String dados) {
		
		String aux[] = dados.split(";");
		int n1 = Integer.parseInt(aux[1]);
		int n2 = Integer.parseInt(aux[1]);
		String resultado = "";
		
		if (aux[0].equals("Soma"))
			resultado = "Resultado : " + Calculadora.this.soma(n1,n2);
		if (aux[0].equals("Subtracao"))
			resultado = "Resultado : " + Calculadora.this.subtracao(n1,n2);
		if (aux[0].equals("Multiplicacao"))
			resultado = "Resultado : " + Calculadora.this.multiplicacao(n1,n2);
		if (aux[0].equals("Divisao")) 
			resultado = "Resultado : " + Calculadora.this.divisao(n1,n2);

		return resultado;

	}

	public int soma (int n1, int n2){
		return n1+n2;
	}
	
	public int subtracao (int n1, int n2){
		return n1-n2;
	}
	
	public int multiplicacao (int n1, int n2){
		return n1*n2;
	}
	
	public float divisao (float n1, float n2){
		return n1/n2;
	}
	
	
}
