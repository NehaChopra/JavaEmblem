package RunnablevsCallable;
/*
 * https://www.baeldung.com/java-runnable-callable
 * 
 * Runnable is the core interface provided for representing multi-threaded tasks and Callable is an improved version of Runnable that was added in Java 1.5.
 * 
 * Execution Mechanism:
 * Both interfaces are designed to represent a task that can be executed by multiple threads. Runnable tasks can be run using the Thread class or ExecutorService
 * whereas Callables can be run only using the latter.
 * 
 * Return Values:
 * 
 * 
 * 
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * The Callable interface is a generic interface containing a single call() method – which returns a generic value V:
 * 
 * public interface Callable<V> {
    V call() throws Exception;
    }
    
    
    Exception Handling:
    Callable’s call() method contains “throws Exception” clause so we can easily propagate checked exceptions further:
    
    In case of running a Callable using an ExecutorService, the exceptions are collected in the Future object, 
    which can be checked by making a call to the Future.get() method. This will throw an ExecutionException – which wraps the original exception:
    
 * 
 */

class FactorialTask implements Callable<Integer>{

	int number;
	
	private static ExecutorService executorService;
	
	public FactorialTask(int number) {
		this.number = number;
	}
	
	@Override
	public Integer call() throws Exception {
		int fact = 1;
		for(int count = number ; count > 1; count --) {
			fact = fact * count;
		}
		return fact;
	}
	
	public static void testExample() throws InterruptedException, ExecutionException{
	   FactorialTask task = new FactorialTask(5);
	   executorService = Executors.newSingleThreadExecutor();
	   Future<Integer> future = executorService.submit(task);
	 
	   System.out.println(future.get().intValue());
	}
	
	public static void main(String []args) throws InterruptedException, ExecutionException {
		testExample();
	}
}

