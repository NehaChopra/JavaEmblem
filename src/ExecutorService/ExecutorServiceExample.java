package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/*
 * https://www.baeldung.com/java-executor-service-tutorial
 * 
 * ExecutorService is a framework provided by the JDK which simplifies the execution of tasks in asynchronous mode. 
 * Generally speaking, ExecutorService automatically provides a pool of threads and API for assigning tasks to it.
 */
class ExecutorServiceExample {

	public static void main(String[] args) {

	}
}

/*
 * Factory Methods of the Executors Class:
 * The easiest way to create ExecutorService is to use one of the factory methods of the Executors class.
 * 
 * ExecutorService executor = Executors.newFixedThreadPool(10);
 * 
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
