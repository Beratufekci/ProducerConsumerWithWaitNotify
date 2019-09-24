
public class Main {

	public static void main(String[] args) {
		
	    ProducerConsumer pc = new ProducerConsumer();
	    
	    Thread producer = new Thread(new Runnable() {
	    	
	    	public void run() {
	    		
	    		pc.produce();
	    		
	    	}
	    });
	    
	    Thread consumer = new Thread(new Runnable() {
	    	
	    	public void run() {
	    		
	    		pc.consume();
	    		
	    	}
	    });
	    
	    producer.start();
	    consumer.start();
	    
	    try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    

	}

}
