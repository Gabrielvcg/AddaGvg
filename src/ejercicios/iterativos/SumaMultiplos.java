package iterativos;

import java.util.stream.IntStream;

public class SumaMultiplos {
	
	
	static Integer sumaMultiplosI(Integer a, Integer b, Integer m) {
		Integer ac=0;
		while(a<b) {
			if(a%m==0) {
				ac=ac+a;
			}
			a++;
		}
		return ac;
	}
	
	static Integer sumaMultiplosF(Integer a, Integer b, Integer m) {
		Integer s= IntStream.range(a, b).filter(e->e%m==0).map(x->x).sum();
		return s;
	}
	static Integer sumaMultiplosR(Integer a, Integer b, Integer m) {
	    return sumaMultiplosAux(a, b, m, 0);
	}

	static Integer sumaMultiplosAux(Integer a, Integer b, Integer m, Integer ac) {
	    if (a < b) {
	        if (a % m == 0) {
	        	ac= sumaMultiplosAux(a + 1, b, m, ac + a);
	        } else {
	            ac= sumaMultiplosAux(a + 1, b, m, ac);
	        }
	    }
	    return ac;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumaMultiplosI(0,9,2));
		System.out.println(sumaMultiplosF(0,9,2));
		System.out.println(sumaMultiplosR(0,9,2));

	}

}
