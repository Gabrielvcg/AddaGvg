package iterativoRecursivo;

import java.util.stream.IntStream;

public class SumRange {

	static Integer sumRangeI(Integer a, Integer b) {
		
		Integer ac=0;
		while(a<b) {
			ac=ac+a;
			a++;
		}
		return ac;
	}
	
	static Integer sumRangeF(Integer a, Integer b) {
		
		Integer s = IntStream.range(a, b).sum();
		return s;
	}
	
	static Integer sumRangeR(Integer a, Integer b) {
		return sumRangeAux(a,b,0);
	}
		
	
	static Integer sumRangeAux(Integer a, Integer b,Integer ac) {
		if (a<b) {
			ac= sumRangeAux(a+1,b,ac+a);
		}
		return ac;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumRangeI(0,9));
		System.out.println(sumRangeF(0,9));
		System.out.println(sumRangeR(0,9));
	}

}
