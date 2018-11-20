package Java8Features.IterableInterfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class forEachMethod {

	/*
	 * default void	forEach(Consumer<? super T> action) in interface
	 * Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
	 * 
	 * public interface Collection<E> extends Iterable<E>
	 * Collection interface has extends Iterable which has for each method available to all collection object.
	 * 
	 */
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		for(int index=0; index<10; index++) {
			stringList.add("List "+index);
		}
		
		/*
		 * Using Iterator
		 */
		Iterator<String> itr = stringList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		/*
		 * forEach method helps in having the logic for iteration and business logic at separate place resulting in higher separation of concern and cleaner code.
		 * 
		 * @FunctionalInterface
		 * public interface Consumer<T>
		 */
		stringList.forEach(
				new Consumer<String>() {
					@Override
					public void accept(String t) {
						System.out.println(t);
					}
				}
		);
	}
}
