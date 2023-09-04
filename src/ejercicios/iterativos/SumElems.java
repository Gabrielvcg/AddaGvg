package iterativos;

import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;

public class SumElems {

	static Integer sumElemsI(List<Set<Integer>> ls) {
		Integer b=0;
		for (Set<Integer> s: ls) {
			for(Integer a: s) {
			b=b+a;
			}
		}
		return b;
	}
	
	static Integer sumElemsF(List<Set<Integer>> ls) {
		return ls.stream().flatMap(e->e.stream()).mapToInt(e->e).sum();
	}
	
	static Integer sumElemsR(List<Set<Integer>> ls) {
		return sumElemsAux(ls,0,0,0);
	}
	
	static Integer sumElemsAux(List<Set<Integer>> ls, Integer setIndex, Integer elementIndex, Integer partialSum) {
	    if (setIndex >= ls.size()) {
	        return partialSum; // Caso base: hemos recorrido todas las listas de conjuntos, devolvemos la suma parcial.
	    }

	    Set<Integer> currentSet = ls.get(setIndex);

	    if (elementIndex >= currentSet.size()) {
	        // Hemos recorrido todos los elementos en el conjunto actual,
	        // pasamos al siguiente conjunto.
	        return sumElemsAux(ls, setIndex + 1, 0, partialSum);
	    }

	    // Obtenemos el elemento actual del conjunto y lo sumamos al resultado parcial.
	    Integer currentElement = currentSet.toArray(new Integer[0])[elementIndex];
	    return sumElemsAux(ls, setIndex, elementIndex + 1, partialSum + currentElement);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> s1= Set.of(1,2,3,4,5);
		Set<Integer> s2= Set.of(6,7,8,9,10);
		Set<Integer> s3= Set.of(11,12,13,14,15);
		List<Set<Integer>> ls= List.of(s1,s2,s3);
		System.out.println(sumElemsI(ls));
		System.out.println(sumElemsF(ls));
		System.out.println(sumElemsR(ls));
	}

}
