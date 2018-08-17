import java.util.logging.Logger;

//https://www.baeldung.com/java-thread-join
/*
 *The join() method will keep waiting if the referenced thread is blocked or is taking too long to process. 
 *This can become an issue as the calling thread will become non-responsive. To handle these situations,
 * we use overloaded versions of the join() method that allow us to specify a timeout period.
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
public class ThreadJoinTimeoutsExample {
	public static Logger LOGGER = Logger.getLogger(ThreadJoinTimeoutsExample.class.getName());
	public static void main(String[] args) {
		Thread t1 = new SampleThread(1);
		t1.start();
		LOGGER.info("Invoking join");
		try {
			t1.join(1000);
			/*
			 * In this case, the calling thread waits for roughly 1 second for the thread t3 to finish. 
			 * If the thread t3 does not finish in this time period, the join() method returns control to the calling method.
			 * 
			 * 
			 * public final void join(long millis) throws InterruptedException
			 * Waits at most millis milliseconds for this thread to die. A timeout of 0 means to wait forever.”
			 * 
			 * “public final void join(long millis,int nanos) throws InterruptedException
			 * Waits at most millis milliseconds plus nanos nanoseconds for this thread to die.”
			 */
		} catch (InterruptedException e) {
			LOGGER.info("Thread join interrupted");
		}
		LOGGER.info("Returned from join");
		LOGGER.info(t1.isAlive()+"");
		
	}
}

/*
 * In addition to waiting until termination, calling the join() method has a synchronization effect. join() creates a happens-before relationship:
 * 
 * All actions in a thread happen-before any other thread successfully returns from a join() on that thread.”
 * 
 * 
 * This means that when a thread t1 calls t2.join(), then all changes done by t2 are visible in t1 on return.
 * However, if we do not invoke join() or use other synchronization mechanisms, we do not have any guarantee
 * that changes in the other thread will be visible to the current thread even if the other thread has completed.
 * 
 * Hence, even though the join() method call to a thread in the terminated state returns immediately, we still need to call it in some situations.
 */


