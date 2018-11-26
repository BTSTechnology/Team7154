package org.usfirst.frc.team7154.robotSubsystems;

import org.usfirst.frc.team7154.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain {
	private static Drivetrain driveTrain = null;
	private KController Controller;	
	private SpeedController right1;
	private SpeedController right2;
	private SpeedControllerGroup LeftCont;
	private SpeedController left1;
	private SpeedController left2;
	private SpeedControllerGroup RightCont;
	private final String invertDriveDS = "Inverted Drive?";
	boolean isTrue;
	private KEncoder LeftEncoder;
	private KEncoder RightEncoder;
	public static Drivetrain getInstance() { //Returns current Drivetrain if there isn't one or makes a new one if there isn't
		if (driveTrain==null) {
			driveTrain = new Drivetrain();
		}

		return driveTrain;
	}

	public Drivetrain(KController Controller){

		this.Controller = Controller;                 		//Makes local controller refer to the robot's controller.
		SmartDashboard.putBoolean(invertDriveDS, true);	//This was originally done to make sure that there was only
		//one controller object.
	}
	public Drivetrain() {
		this.Controller = KController.getInstance();
		right1 = new Spark(RobotMap.RIGHT_MOTOR1);
		right2 = new Spark(RobotMap.RIGHT_MOTOR2);
		left1 = new Spark(RobotMap.LEFT_MOTOR1);
		left2 = new Spark(RobotMap.LEFT_MOTOR2);
		LeftCont = new SpeedControllerGroup(left1, left2);
		RightCont = new SpeedControllerGroup(right1, right2);
		LeftEncoder = KEncoder.getInstance(RobotMap.MOTOR_ENCODERLEFT,true);
		RightEncoder = KEncoder.getInstance(RobotMap.MOTOR_ENCODERRIGHT,false);

	}

	public void periodic() {
		contDrive();
	}
	public void contDrive(){            	//Gets and sets speeds to y coordinate of respective stick.
		Controller.periodic();
		setLeft(Controller.KGetYL());			
		setRight(Controller.KGetYR());
		if(Controller.KGetYL() == 0 && Controller.KGetYR() == 0) {
			if(Controller.DriveStraight()) setBoth(RobotMap.SPEED_SETTINGS[Controller.getSpeed()]);
			else if(Controller.DriveStraightBack()) setBoth(-RobotMap.SPEED_SETTINGS[Controller.getSpeed()]);
			else setBoth(0);
		}
	}
	public void setLeft(double newSpeed) {
		//inverts the output of the motor given that the inverted speed is checked out
		SmartDashboard.getBoolean(invertDriveDS, isTrue);
		try {
			if (isTrue){
				LeftCont.set(newSpeed);
			}else{
				LeftCont.set(-newSpeed);
			}

		}catch(java.lang.NullPointerException e){
			System.err.println("Left speed cannot be set!");{

			}
		}
	}
	public void setRight(double newSpeed) {
		//inverts the output of the motor given that the inverted speed is checked out
		SmartDashboard.getBoolean(invertDriveDS, isTrue);
		try {
			if (isTrue){
				RightCont.set(-newSpeed);
			}else{
				RightCont.set(newSpeed);
			}

		}catch(java.lang.NullPointerException e){
			System.err.println("Right speed cannot be set!");{

			}
		}
	}
	public String encode() {

		return RightEncoder.getDistance() + " " + LeftEncoder.getDistance();
	}
	public void setBoth (double newSpeed){ //Makes both wheel motors go. Might be better to use tankDrive.
		setRight (newSpeed);
		setLeft (newSpeed);
	}

	public void testRight() { //Tests if the right motor works
		setRight(0.4);
	}
	public void testLeft() {//Tests if the left motor works
		setLeft(0.4);
	}



}
