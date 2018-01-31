package task2;

public class Main {
	
public static void main(String[] args) {
	
	Race race = new Race();
	Checkpoint check = new Checkpoint();
	
	// Creation of new drivers
	Thread t1 = new Thread(new Car("Sebastian Loeb", race, check));
	Thread t2 = new Thread(new Car("Colin McRae", race, check));
	Thread t3 = new Thread(new Car("Petter Solberg", race, check));
	Thread t4 = new Thread(new Car("Sebastien Ogier", race, check));
	Thread t5 = new Thread(new Car("Richard Burns", race, check));
	
	
	
	try {			// start of race
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		System.out.println("Cars line up...");
		Thread.sleep(1000);
		System.out.println("Ready...");
		Thread.sleep(1000);
		System.out.println("Set...");
		Thread.sleep(1000);
		System.out.println("GO!!!");
		
		race.startRace();			// calls notifyAll() method
		
		
	} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
	

	
}

}
