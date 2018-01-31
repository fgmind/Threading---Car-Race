package task2;

import java.util.Random;

public class Checkpoint {		// this will geenrate a random number between 1 and 3 seconds for pit stop
	
	private Random rdm = new Random(System.currentTimeMillis());
	
	public synchronized long reFuel() throws InterruptedException{		// synchronized is used to ensure other cars wait their turn
		
		long duration = Math.abs(this.rdm.nextLong() % 2000) +1000;
		Thread.sleep(duration);
		return duration;
	}

}