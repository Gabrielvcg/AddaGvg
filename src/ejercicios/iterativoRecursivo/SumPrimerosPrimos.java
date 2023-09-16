package iterativoRecursivo;

import java.util.stream.Stream;

import us.lsi.math.Math2;

public class SumPrimerosPrimos {
	
	static Long sumPrimerosPrimosI(Integer n) {
		Long ac=0l;
		Integer i=0;
		Long p=2l;
		while(i<n) {
			ac=ac+p;
			p=Math2.siguientePrimo(p);
			i++;
		}
		return ac;
	}
	
	static Long sumPrimerosPrimosF(Integer n) {
		return Stream.iterate(2, e->true, e->Math2.siguientePrimo(e))
				.limit(n).mapToLong(e->e.longValue()).sum();
	}
	
	static Long sumPrimerosPrimosR(Integer n) {
		return sumPrimerosPrimosAux(n,2l,0,0l);
		
	}

	static Long sumPrimerosPrimosAux(Integer n, Long p, Integer i,Long ac) {
		if(i<n) {
			ac=sumPrimerosPrimosAux(n,Math2.siguientePrimo(p),i+1,ac+p);
		}
		return ac;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTimeI = System.currentTimeMillis();
		System.out.println(sumPrimerosPrimosI(1000));
		long endTimeI = System.currentTimeMillis();
		long durationI = endTimeI - startTimeI;
		System.out.println("Tiempo de ejecución: " + durationI + " milisegundos");
		
		long startTimeF = System.currentTimeMillis();
		System.out.println(sumPrimerosPrimosF(1000));
		long endTimeF = System.currentTimeMillis();
		long durationF = endTimeF - startTimeF;
		System.out.println("Tiempo de ejecución: " + durationF + " milisegundos");
		
		//NO SE PUEDE PONER MUCHO PUES HAY DESBORDAMIENTO DE PILA
		long startTimeR = System.currentTimeMillis();
		System.out.println(sumPrimerosPrimosR(1000));
		long endTimeR = System.currentTimeMillis();
		long durationR = endTimeR - startTimeR;
		System.out.println("Tiempo de ejecución: " + durationR + " milisegundos");
		
	}

}
