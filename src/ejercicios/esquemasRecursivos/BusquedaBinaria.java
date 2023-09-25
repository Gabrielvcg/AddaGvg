package esquemasRecursivos;

import java.util.ArrayList;
import java.util.List;

public class BusquedaBinaria {

	//Buscar en una lista ordenada si existe un elemento dado y si no 
	//devolver -1
	private static Boolean busquedaBinariaCentral(List<Integer> ls, Integer e) {
	    int i = 0;
	    int j = ls.size() - 1;

	    while (!(i-j==0)) {
	        int k = (i + j) / 2;
	        Integer elementoMedio = ls.get(k);

	        if (elementoMedio.equals(e)) {
	            return true; // Elemento encontrado
	        } else if (elementoMedio < e) {
	            i = k + 1;
	        } else {
	            j = k - 1;
	        }
	    }

	    return false; // Elemento no encontrado
	}
	
	public static boolean busquedaBinariaRecursiva(List<Integer> ls, Integer e) {
	    return busquedaBinariaRecursiva(ls, e, 0, ls.size() - 1);
	}

	private static boolean busquedaBinariaRecursiva(List<Integer> ls, Integer e, int i, int j) {
	    if (i > j) {
	        return false; // Elemento no encontrado
	    }

	    int k = (i + j) / 2;
	    Integer elementoMedio = ls.get(k);

	    if (elementoMedio.equals(e)) {
	        return true; // Elemento encontrado
	    } else if (elementoMedio < e) {
	        return busquedaBinariaRecursiva(ls, e, k + 1, j);
	    } else {
	        return busquedaBinariaRecursiva(ls, e, i, k - 1);
	    }
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  List<Integer> ls = new ArrayList<>();
			for(int i=0; i<=10000000; i++) {
				ls.add(i);
			}
			
			long startTimeS = System.currentTimeMillis();
			System.out.println(busquedaBinariaCentral( ls, 1000000));
			long endTimeS = System.currentTimeMillis();
			long durationS = endTimeS - startTimeS;
			System.out.println("Tiempo de ejecución: " + durationS + " milisegundos");

			long startTimeC = System.currentTimeMillis();
			System.out.println(busquedaBinariaRecursiva( ls, 1000000));
			long endTimeC = System.currentTimeMillis();
			long durationC = endTimeC - startTimeC;
			System.out.println("Tiempo de ejecución: " + durationC + " milisegundos");

	}

}
