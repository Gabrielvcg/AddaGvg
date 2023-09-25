package esquemasRecursivos;

import java.util.ArrayList;
import java.util.List;

public class ElemEnLista {

	private static Boolean elemEnListaSufija(List<Integer>ls, Integer e) {
		Integer i=0;
		boolean b= ls.get(i).equals(e);
		while(i<ls.size() && !b) {
			b=ls.get(i).equals(e);
			i++;
		}
		return b;
	}
	
	private static Boolean elemEnListaCentral(List<Integer>ls, Integer e) {
		Integer i=0;
		Integer j=ls.size()-1;
		boolean b= ls.get(i).equals(e);
		boolean c= ls.get(j).equals(e);
		while(i<ls.size() && !b && !c) {
			b=ls.get(i).equals(e);
			c=ls.get(j).equals(e);
			i++;
			j--;
		}
		return b? b: c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        List<Integer> ls = new ArrayList<>();
		for(int i=0; i<=10000000; i++) {
			ls.add(i);
		}
		
		long startTimeS = System.currentTimeMillis();
		System.out.println(elemEnListaSufija(ls, 9900000));
		long endTimeS = System.currentTimeMillis();
		long durationS = endTimeS - startTimeS;
		System.out.println("Tiempo de ejecución: " + durationS + " milisegundos");

		long startTimeC = System.currentTimeMillis();
		System.out.println(elemEnListaCentral(ls, 9900000));
		long endTimeC = System.currentTimeMillis();
		long durationC = endTimeC - startTimeC;
		System.out.println("Tiempo de ejecución: " + durationC + " milisegundos");
	


	}

}
