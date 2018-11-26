package org.usfirst.frc.team7154.robotSubsystems;


import org.usfirst.frc.team7154.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class KCubeIntake {
	private static KCubeIntake kCubeIntake = null;
	private KController Controller;	
	private SpeedController right;
	private SpeedController left;
	private SpeedController top;
	private DigitalInput topLimitSwitch;
	private DigitalInput bottomLimitSwitch;

	private boolean interrupt;
	boolean isTrue;
	enum state{
		LAUNCHING,
		INPUTTING,
		STOPPED
	}
	state s;
	public static KCubeIntake getInstance() { //Returns current Drivetrain if there isn't one or makes a new one if there isn't
		if (kCubeIntake==null) {
			kCubeIntake = new KCubeIntake();
		}
		return kCubeIntake;
	}
	public KCubeIntake(KController Controller){

		this.Controller = Controller;                 		//Makes local controller refer to the robot's controller.
		//This was originally done to make sure that there was only
		//one controller object.
	} 
	public KCubeIntake() {
		this.Controller = KController.getInstance();
		right = new WPI_TalonSRX (RobotMap.KRIGHTINSPARK);
		left = new WPI_TalonSRX (RobotMap.KLEFTINSPARK);
		//top = new Spark (RobotMap.KTHROWSPARK);
		topLimitSwitch = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH);
		bottomLimitSwitch = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH);


	}
	public void periodic() {
		contIntake();
//		System.out.println(topLimitSwitch.get());
//		if(topLimitSwitch.get() || bottomLimitSwitch.get()) {
//			interrupt = true;
//		}else
//			interrupt = false;
	}
	public void contIntake(){
		if(Controller.KInput()) s = state.INPUTTING;
		else if(Controller.KLaunch())s = state.LAUNCHING;
		else s = state.STOPPED;
		if(s == state.LAUNCHING) setBoth(.5);
		else if(s == state.INPUTTING) setBoth(-.5);
		else setBoth(0);
		if(topLimitSwitch.get() && bottomLimitSwitch.get())
			setTop(Controller.Thrower()-Controller.Reset());
		else if(topLimitSwitch.get())
			setTop(-Controller.Reset());
		else if(bottomLimitSwitch.get())
			setTop(Controller.Thrower());
	}
	public void setLeft(double newSpeed) {
		//inverts the output of the motor given that the inverted speed is checked out
		try {
			left.set(newSpeed);
		}catch(java.lang.NullPointerException e){
			System.err.println("Left speed cannot be set!");{
			}
		}
	}
	public void setRight(double newSpeed) {
		//inverts the output of the motor given that the inverted speed is checked out
		try {
			right.set(newSpeed);
		}catch(java.lang.NullPointerException e){
			System.err.println("Right speed cannot be set!");{

			}
		}
	}
	public void setTop(double newSpeed) {
		//inverts the output of the motor given that the inverted speed is checked out
		
			try {
				top.set(newSpeed);
			}catch(java.lang.NullPointerException e){
				System.err.println("Top speed cannot be set!");{
				}
			}
		
	}

	public void setBoth (double newSpeed){ //Makes both motors go. Might be better to use tankDrive.
		setRight (newSpeed);
		setLeft (-newSpeed);
	}

	public void testRight() { //Tests if the right motor works
		setRight(.1);
	}
	public void testLeft() {//Tests if the left motor works
		setLeft(-.1);
	}

}
