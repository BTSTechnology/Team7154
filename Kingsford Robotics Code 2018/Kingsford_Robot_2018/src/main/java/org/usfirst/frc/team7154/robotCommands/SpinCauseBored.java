package org.usfirst.frc.team7154.robotCommands;
// This is a class that I have decided to create that will 
// allow us to run code to the robot to make it spin and dance.
// Yes, I am very bored, and i have too much time on my hands. 
// >>>> Please stand by while this class in under my capable development. <<<<

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team7154.robotSubsystems.Drivetrain;
 public  class SpinCauseBored {
	private static SpinCauseBored ra = null;
	public static SpinCauseBored getInstance() {
		if (ra==null) {
			ra = new SpinCauseBored();
		}
		return ra;
	}
	static Drivetrain rdt;
	public SpinCauseBored() {			
		Auton.rdt = Drivetrain.getInstance();        
	}
	public void doWideSpinLeft(long duration, Drivetrain dt) {
		try {
			dt.setLeft(.5);
			dt.setRight(0);
			TimeUnit.SECONDS.sleep(duration);
			dt.setBoth(0);
		}catch(java.lang.NullPointerException | InterruptedException e) {
			System.err.println("Spin null pointer!");
		}
	}
	public void doWideSpinRight(int duration, Drivetrain dt) {
		try {
			dt.setLeft(0);
			dt.setRight(.5);
			TimeUnit.SECONDS.sleep(duration);
			dt.setBoth(0);
		}catch(java.lang.NullPointerException | InterruptedException e) {
			System.err.println("Spin null pointer!");
		}

	}
	public void doCenterSpinRight(long duration, Drivetrain dt){
		try {
			dt.setLeft(.5);
			dt.setRight(-.5);
			TimeUnit.SECONDS.sleep(duration);
			dt.setBoth(0);
		}catch(java.lang.NullPointerException | InterruptedException e) {
			System.err.println("Spin null pointer!");
		}
	}
	public void doCenterSpinLeft(long duration, Drivetrain dt){
		try {
			dt.setLeft(-.5);
			dt.setRight(.5);
			TimeUnit.SECONDS.sleep(duration);
			dt.setBoth(0);
		}catch(java.lang.NullPointerException | InterruptedException e) {
			System.err.println("Spin null pointer!");
		}
	}
	public void serpentine(long duration, Drivetrain dt) {
		long ehh = duration / 5;
		try {
			for(int i = (int) ehh; i >= 0; i--) {
				dt.setLeft(.25);				//Left
				dt.setRight(0.5);
				TimeUnit.SECONDS.sleep((long) .5);
				dt.setLeft(.5);						//Right
				dt.setRight(.25);
				TimeUnit.SECONDS.sleep((long) .5);
			}
			dt.setBoth(0);
		}catch(java.lang.NullPointerException | InterruptedException e) {
			System.err.println("Spin null pointer!");
		}
	}
//	public void clover(long duration, Drivetrain dt) {
//		int leaves = (int) (duration / 3);
//		dt.setBoth(.3);
//		for(int i = 0; i <= leaves; i++) {
//			try {
//				dt.setLeft(.2);
//				TimeUnit.MICROSECONDS.sleep(500);
//				dt.setBoth(.3);
//				TimeUnit.MICROSECONDS.sleep(250);
//				dt.setLeft(0);
//				TimeUnit.SECONDS.sleep(1);
//				dt.setBoth(.3);
//				TimeUnit.MICROSECONDS.sleep(500);
//				
//				
//			}catch(Exception e){
//				System.out.println(e.toString());
//			}
//		}
//		
//	}
}
