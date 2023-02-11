package testJavaInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("Vika");
		names.add("Vova");
		names.add("Marcel");
		names.add("Kennet");
		names.add("Rian");
		
		// print all elements of the list with capital letters
		performOperation(names, (String s) -> System.out.println(s.toUpperCase()));
		
		// increases all elements of an array to 50%
		performOperation(Arrays.asList(0.0, 150.0, 20.0, 32.5), (Double d) -> System.out.println(d *= 1.5));
	
		// use IntConsumer to specify a type and disable autoboxing
	}
	
	public static <T> void performOperation(List<T> list, Consumer<T> c) {
		for(T l:list) {
			c.accept(l);
		}
	}
}
