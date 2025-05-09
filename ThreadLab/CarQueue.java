import java.util.Random;
import java.util.PriorityQueue;

public class CarQueue {
	public PriorityQueue<Integer> directionQ = new PriorityQueue<Integer>();
	
	public CarQueue() {
		for(int i = 0; i < 6; i++) {
			System.out.println("Adding");
			addToQueue();
			System.out.println("Added, now size is " + directionQ.size());
		}
	}
	
	
	public void addToQueue()
	   {
	      class addToQueueRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               Random rand = new Random();
	            	   directionQ.add((int)rand.nextInt(4));
	            	   Thread.sleep(1000);
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new addToQueueRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
	
	public int deleteQueue() {
		int d = directionQ.remove();
		System.out.println("Size is currently " + directionQ.size() + ". Bout to remove " + d);
		return d;
	}

}
