package org.usfirst.frc.team7154.robotCommands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team7154.robotSubsystems.Drivetrain;

public class Auton {
	private static Auton ra = null;
	public static Auton getInstance() {
		if (ra==null) {
			ra = new Auton();
		}
		return ra;
	}

	static Drivetrain rdt;
	public Auton() {
		Auton.rdt = Drivetrain.getInstance();        
	}
	public static void doAutonomous (){
		try {
			rdt.setLeft(.5);
			rdt.setRight(.5);
			TimeUnit.SECONDS.sleep(5);
			rdt.setBoth(0);
		}catch(java.lang.NullPointerException | InterruptedException e) {
			System.err.println("Auton null pointer!");
		}
	}

}

