package task2;

public class Race {

	private int rank = 1;
	
	public synchronized void getReadyToRace() throws InterruptedException{	//
		this.wait();		// cars leave at the same time more or less...
	}
	
	public synchronized void startRace(){
		this.notifyAll();
	}
	
	public synchronized int crossFinishLine(){		// rank value increases everytime a driver crosses finish line
		return rank++;
	}
	
}