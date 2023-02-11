package testJavaInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class TestPredicate {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Vika");
		names.add("Vova");
		names.add("Marcel");
		names.add("Kennet");
		names.add("Rian");
		
		List<String> namesWithE = filter(names, (String name) -> name.contains("e"));
		for(String s:namesWithE) {
			System.out.println(s);
		}
		
		List<String> shortNames = filter(names, (String name) -> name.length() <= 4);
		for(String s:shortNames) {
			System.out.println(s);
		}
		
		System.out.println(check(2, (int i) -> i % 2 == 0));
		
		// gives error because IntPredicate disables autoboxing
		// System.out.println(check(2, (Integer i) -> i % 2 == 0));
		
		// gives an error. Autoboxing doesn't work?
		// System.out.println(checkGeneric(2, (int i) -> i % 2 == 0));
		

	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for(T t:list) {
			if(p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}
	
	public static boolean check(int a, IntPredicate p) {
		return p.test(a);
	}
	
	public static <T> boolean checkGeneric(T a, Predicate<T> p) {
		return p.test(a);
	}

}
