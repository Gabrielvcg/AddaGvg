package iterativoRecursivo;

import java.util.stream.LongStream;
import us.lsi.math.Math2;

public class EsPrimo {
	
	static Boolean esPrimoI(Long n) {
		long sqrt= (long)(Math.sqrt((double)n));
		long i=2l;
		Boolean ac=false;
		while(i<=sqrt && !ac) {
			ac=Math2.esDivisible(n, i);
			i++;
		}
		return !ac;
		
	}
	
	static Boolean esPrimoF(Long n) {
		LongStream s= LongStream.rangeClosed(2l,(long)(Math.sqrt((double)n)));
		return s.noneMatch(e->Math2.esDivisible(n, e));
	}
	
	static Boolean esPrimoR(Long n) {
		long sqrt= (long)(Math.sqrt((double)n));

		return !esPrimoAux(n,sqrt,2l,false);
	}
	static Boolean esPrimoAux(Long n,Long sqrt,Long i, Boolean ac) {
		if (i<=sqrt && !ac) {
			ac=esPrimoAux(n,sqrt,i+1,Math2.esDivisible(n, i));
		}
		return ac;
	}
	

	public static void main(String[] args) {
		System.out.println(esPrimoI(104729L));
		System.out.println(esPrimoF(104729L));
		System.out.println(esPrimoR(104729L));

	}

}