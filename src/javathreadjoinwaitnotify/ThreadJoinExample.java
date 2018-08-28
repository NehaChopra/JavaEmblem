package javathreadjoinwaitnotify;
import java.util.logging.Logger;

//https://www.baeldung.com/java-thread-join
/*
 * Like the wait() and notify() methods, join() is another mechanism of inter-thread synchronization.
 * 
 * When we invoke the join() method on a thread, the calling thread goes into a waiting state. It remains in a waiting state until the referenced thread terminates.
 * 
 * 
 */

class SampleThread extends Thread{
	public static Logger LOGGER = Logger.getLogger(SampleThread.class.getName());
	public int processingCount = 0;
	
	public SampleThread(int processingCount) {
		this.processingCount = processingCount;
		LOGGER.info("Thread Created");
	}
	
	@Override
	public void run() {
		 LOGGER.info("Thread " + this.getName() + " started");
		 while(processingCount > 0) {
			 try {
				 Thread.sleep(1000);
			 }catch(InterruptedException e) {
				 LOGGER.info("Thread " + this.getName() + " interrupted");
			 }
			 processingCount--; 
		 }
		 LOGGER.info("Thread " + this.getName() + " exiting");
	}
}
public class ThreadJoinExample {
	public static Logger LOGGER = Logger.getLogger(ThreadJoinExample.class.getName());
	public static void main(String[] args) {
		Thread t1 = new SampleThread(1);
		t1.start();
		LOGGER.info("Invoking join");
		try {
			t1.join();
		} catch (InterruptedException e) {
			LOGGER.info("Thread join interrupted");
		}
		LOGGER.info("Returned from join");
		LOGGER.info(t1.isAlive()+"");
		
		
		/*
		 * The join() method may also return if the referenced thread was interrupted.  In this case, the method throws an InterruptedException.
		 * Finally, if the referenced thread was already terminated or hasn’t been started, the call to join() method returns immediately.
		 */
		
		Thread t2 = new SampleThread(1);
		try {
			t2.join();
		} catch (InterruptedException e) {
			LOGGER.info("Thread join interrupted");//returns immediately
		}
	}
}


