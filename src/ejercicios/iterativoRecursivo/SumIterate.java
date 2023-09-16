package iterativoRecursivo;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SumIterate {

	static Double sumIterateI(Double a, Double b, Double c) {
		Double ac=0.;
		while(a<b) {
			ac=ac+a;
			a=a*c;
		}
		return ac;
	}
	
	
	static Double sumIterateF(Double a, Double b, Double c) {
		Double e0=a;
		Predicate<Double> g= e->e<b;
		UnaryOperator <Double> nx= e->e*c;
		return Stream.iterate(e0, g,nx).mapToDouble(x->x).sum();
		
	}
	
	static Double sumIterateR(Double a, Double b, Double c) {
		Double ac=0.;
		return sumIterateAux(a,b,c,ac);
	}
	
	static Double sumIterateAux(Double a, Double b, Double c,Double ac) {
		if(a<b) {
			
			ac=sumIterateAux(a*c,b,c,a+ac);
		}
		return ac;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumIterateI(1.,11.,2.));
		System.out.println(sumIterateF(1.,11.,2.));
		System.out.println(sumIterateR(1.,11.,2.));


	}

}
