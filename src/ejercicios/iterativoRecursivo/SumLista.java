package iterativoRecursivo;

import java.util.List;
import java.util.stream.IntStream;

public class SumLista {

	/*En esta clase pasaremos un algoritmo de sumar una lista determinada
	 * de iterativo a funcional, y a recursivo, donde i será el iterador,
	 * b el acumulador y existirá predicado que actue como condición de parada
	*/
	
	private static Integer sumListaI(List<Integer> ls) {
		Integer i=0;
		Integer b=0;
		while (i<ls.size()) {
			b=b+ls.get(i);
			i++;
		}
		return b;
	}
	
	private static Integer sumListaF(List<Integer> ls) {
		Integer b=0;
		b=ls.stream().reduce(0, (e1, e2) -> e1 + e2 );
		return b;
				
	}
	//opcion 2 del funcional 
	private static Integer sumListaF2(List<Integer> ls) {
		IntStream s = IntStream.range(0, ls.size());
		IntStream s2= s.map(i-> ls.get(i));
		return s2.sum();
				
	}
	
	static Integer sumListaR(List<Integer> ls) {
		return sumListaAux(0,0,ls);
		}
	static Integer sumListaAux(Integer i, Integer b, List<Integer> ls) {
		if(i<ls.size()){
			Integer e = ls.get(i);
			b = sumListaAux(i+1,b+e,ls);
			} 	
		return b;
			}


	
	
	public static void main(String[] args) {
		List<Integer> ls= List.of(1,2,3,4,5,6,7,8,9);
		System.out.println(sumListaI(ls));
		System.out.println(sumListaF(ls));
		System.out.println(sumListaF2(ls));
		System.out.println(sumListaR(ls));

	}

}
