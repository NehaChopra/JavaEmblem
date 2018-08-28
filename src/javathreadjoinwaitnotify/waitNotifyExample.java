package javathreadjoinwaitnotify;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

//https://www.baeldung.com/java-wait-notify

/*
 * Sender-Receiver Synchronization Problem
 * The Sender is supposed to send a data packet to the Receiver
 * The Receiver cannot process the data packet until the Sender is finished sending it
 * Similarly, the Sender mustn’t attempt to send another packet unless the Receiver has already processed the previous packet
 */

class Data{
	private String packet;
	private boolean transfer = true;
	public static Logger LOGGER = Logger.getLogger(Data.class.getName());
	
	public synchronized void send(String packet) {
		while(!transfer) {
			try {
				wait();
			}catch(InterruptedException e) {
				LOGGER.info("Thread interrupted "+e);
			}
		}
		transfer = false;
		this.packet = packet;
		notifyAll();
	}
	
	public synchronized String recieve() {
		while(transfer) {
			try {
				wait();
			}catch(InterruptedException e) {
				LOGGER.info("Thread interrupted "+e);
			}
		}
		transfer = true;	
		notifyAll();
		return this.packet;
	}
}

class Sender implements Runnable{
	private Data data;
	public static Logger LOGGER = Logger.getLogger(Sender.class.getName());
	
	public Sender(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		String packets[] = {
	          "First packet",
	          "Second packet",
	          "Third packet",
	          "Fourth packet",
	          "End"
	        };
		
		for(String packet: packets) {
			data.send(packet);
			try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        } catch (InterruptedException e)  {
      	  LOGGER.info("Thread interrupted "+ e); 
        }
		}
	}
}

class Receiver implements Runnable{
	private Data data;
	public static Logger LOGGER = Logger.getLogger(Receiver.class.getName());
	
	public Receiver(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		 for(String receivedMessage = data.recieve();
	          !"End".equals(receivedMessage);
	          receivedMessage = data.recieve()
	        ) {
	             
	            System.out.println(receivedMessage);
	            }
		 
			try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        } catch (InterruptedException e)  {
      	  LOGGER.info("Thread interrupted "+ e); 
        }
		 
	}
}	

public class waitNotifyExample {

	public static void main(String[] args) {
		Data data = new Data();
		Thread sender = new Thread(new Sender(data));
		Thread receiver = new Thread(new Receiver(data));
		
		sender.start();
		receiver.start();
		
	}
}
