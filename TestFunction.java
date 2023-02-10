package testJavaInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestFunction {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Vika");
		names.add("Vova");
		names.add("Marcel");
		names.add("Kennet");
		names.add("Rian");
		
		List<Integer> positionOfLetterA = map(names, (String name) -> name.indexOf('a'));
		for(int i = 0; i < positionOfLetterA.size(); i++) {
			System.out.println(names.get(i) + " " + positionOfLetterA.get(i));
		}
		
		List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
		for(Integer i:l) {
			System.out.println(i);
		}

	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for(T l:list) {
			result.add(f.apply(l));
		}
		return result;
	}

}
