package task2;

import java.util.Random;

public class Car implements Runnable {
	
	private String name;
	private Race race;
	private Checkpoint check;
	private Random rdm = new Random(System.currentTimeMillis());
	
	public Car(String name, Race race, Checkpoint check) {
		this.name = name;
		this.race = race;
		this.check = check;
	}
	
	public long raceLap() throws InterruptedException{				// how long it takes to do 1 lap
		
		long duration = Math.abs(this.rdm.nextLong() %4000) +1000;
		Thread.sleep(duration);
		return duration;
	}
	
	public void run(){
		try{
			
			this.race.getReadyToRace();
			System.out.println(this.name + " has crossed the start line");
			
			for (int i = 1; i <=3; i++) {
				long time = this.raceLap();
				System.out.println("\n" + name + " has reached checkpoint " + i + " in " + (double)time/1000 + " minutes");	//put minutes to be more realistic of a race
			
			time = this.check.reFuel();
			System.out.println(name + " has refuelled for " + (double)time/1000 + " seconds and has now left checkpoint " + i);
			
			System.out.println();
			}
			
			int place = this.race.crossFinishLine();
			System.out.println(name + " finishes in position " + place);

			
		}
		catch (InterruptedException e) {
			System.out.println("Oh no!");
		}
	}
	

}