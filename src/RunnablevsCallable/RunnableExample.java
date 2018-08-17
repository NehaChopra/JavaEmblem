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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/*
 * The Runnable interface is a functional interface and has a single run() method which doesn’t accept any parameters and does not return any values.
 * This is suitable for situations where we are not looking for a result of the thread execution, for example, incoming events logging:
 * 
 * 
 * Exception Handling:
 * Since the method signature does not have the “throws” clause specified, there is no way to propagate further checked exceptions.
 */

class EventLoggingTask implements Runnable{

	private Logger logger = Logger.getLogger(EventLoggingTask.class.getName());
	
	ExecutorService executorService;
	
	@Override
	public void run() {
		logger.info("Logging a Message............!!");
		/*
		 * In this example, the thread will just read a message from the queue and log it in a log file.
		 */
	}
	
	public void executeTask() {
	    executorService = Executors.newSingleThreadExecutor();
	    Future future = executorService.submit(new EventLoggingTask());
	    /*
	     * In this case, the Future object will not hold any value.
	     */
	    executorService.shutdown();
	}
}

