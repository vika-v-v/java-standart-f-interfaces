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
		
		// simple use of the lambda
		System.out.println("Names with 'e' in it:");
		List<String> namesWithE = filter(names, (String name) -> name.contains("e"));
		for(String s:namesWithE) {
			System.out.println(s);
		}
		
		System.out.println("\nShort names:");
		
		// putting functional interface on a variable
		Predicate<String> shortName = (String s) -> s.length() <= 4;
		
		List<String> shortNames = filter(names, shortName);
		for(String s:shortNames) {
			System.out.println(s);
		}
		
		// predicates provide .negate .and and .or methods
		
		System.out.println("\nLong names:");
		List<String> longNames = filter(names, shortName.negate());
		for(String s:longNames) {
			System.out.println(s);
		}
		
		// filtering for complex names
		// a name is thought to be complex if it contains of more than 4 letters or has repeating letters
		Predicate<String> nameWithRepeatingLetter = (String s) -> stringWithRepeatingChars(s);
		List<String> complexNames = filter(names, nameWithRepeatingLetter.or(shortName.negate()));
		
		System.out.println("\nComplex names:");
		for(String s:complexNames) {
			System.out.println(s);
		}
		
		System.out.println("\nCheck:");
		System.out.println(check(2, (int i) -> i % 2 == 0));
		
		// DoublePredicate also possible
		
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
	
	public static boolean stringWithRepeatingChars(String str) {
		String s = str.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

}
