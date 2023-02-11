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
		
		// example of mapping
		List<Integer> positionOfLetterA = map(names, (String name) -> name.indexOf('a'));
		
		System.out.println("Names and positions of letter a:");
		for(int i = 0; i < positionOfLetterA.size(); i++) {
			System.out.println(names.get(i) + " " + positionOfLetterA.get(i));
		}
		
		// using method reference		
		List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), String::length);
		
		System.out.println("\nNumber of letters in the word:");
		for(Integer i:l) {
			System.out.println(i);
		}
		
		// default method of a Function - .andThen
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		int result = h.apply(1);
		System.out.println("\nTesting method:\n" + result);
		
		// IntFunction is also possible
		// ToIntFunction<T> - for an output
		// is it possible to map into a List? List doesn't take primitive types
		// how to use ToIntFunction<T> and IntToIntFunction?

	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for(T l:list) {
			result.add(f.apply(l));
		}
		return result;
	}
	

}
