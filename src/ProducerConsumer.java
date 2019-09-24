import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
	
    Random random = new Random();
	Object lock = new Object();
    Queue<Integer> queue = new LinkedList<Integer>();
    private int limit = 10;
    
	
	public void produce() {
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized(lock) {
				
				if(queue.size() == limit) {
					
				    try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				      
				}
				
				Integer value = random.nextInt(100);
				queue.offer(value);
				
				System.out.println("Producer is producing: " + value);
				System.out.println("Queue size : " + queue.size());
				
				lock.notify();
			}
			
		}
		
	}
	
	
	public void consume() {
		
		while(true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized(lock) {
					
					if(queue.size() == 0) {
						
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					Integer  value = queue.poll();
					System.out.println("Consumer is consuming : " +value);
					System.out.println("Queue size: " + queue.size());
					
					lock.notify();
					
					
					
					
		     }
				
		}
		
	}
	
	
	
}
