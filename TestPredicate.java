package testJavaInterfaces;

import java.util.ArrayList;
import java.util.List;
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

}
