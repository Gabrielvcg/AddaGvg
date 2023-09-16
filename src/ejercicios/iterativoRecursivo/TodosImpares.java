package iterativoRecursivo;

import java.util.List;

import us.lsi.math.Math2;

public class TodosImpares {

	static Boolean todosImparesI(List<Integer> ls) {
		Integer i=0;
		Boolean b=false;
		while(i<ls.size() && !b) {
			b=Math2.esDivisible(ls.get(i), 2);
			i++;
		}
		return !b;
	}
	
	static Boolean todosImparesF(List<Integer> ls) {
		return ls.stream().allMatch(e->!Math2.esDivisible(e,2));
	}
	
	static Boolean todosImparesR(List<Integer> ls) {
		return todosImparesAux(ls,0,false);
	}
	
	static Boolean todosImparesAux(List<Integer> ls, Integer i, Boolean b) {
		if(i<ls.size() && !b) {
			b=todosImparesAux(ls, i+1, Math2.esDivisible(ls.get(i), 2));
		}
		return !b;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls=List.of(1,3,5,7,9,11);
		System.out.println(todosImparesI(ls));
		System.out.println(todosImparesF(ls));
		System.out.println(todosImparesR(ls));
		
	}

}
