package org.usfirst.frc.team7154.robotSubsystems;

import org.usfirst.frc.team7154.robot.RobotMap;

import edu.wpi.first.wpilibj.XboxController;

public class KController extends XboxController {
	private static KController rj = null;
	private static double reduct = 4;
	private static int speed = 1;
	public static KController getInstance() {	//Here to make sure that there is only one of this
		if (rj == null) {
			rj = new KController(RobotMap.KCONTROLLER_PORT);
			return rj;
		}
		else {
			return rj;
		}
	}

	private final double deadzone =.15;   //makes sure that the controller is not too sensitive
	public KController (int channel){
		super (channel);

	}
	public double KGetYL(){
		double y = super.getY(Hand.kLeft);
		if (Math.abs(y) < deadzone){
			y=0;
		}
		else{
			y =y*Math.pow(Math.abs(y),reduct)*RobotMap.SPEED_SETTINGS[getSpeed()];  //This just makes speed increase by joystick quadratic rather than linear I think.
		}
		return y;
	}
	
	public double KGetYR(){
		double y = super.getY(Hand.kRight);
		if (Math.abs(y) < deadzone){
			y=0;
		}
		else{
			y =y*Math.pow(Math.abs(y),reduct)*RobotMap.SPEED_SETTINGS[getSpeed()]; //This just makes speed increase by joystick quadratic rather than linear I think.
		}
		return y;
	}
	public boolean KLaunch() {
		return super.getBumper(Hand.kLeft);

	}
	public boolean KInput() {
		return super.getBumper(Hand.kRight);


	}
	public boolean DriveStraight() {
		return super.getXButton();

	}
	public boolean DriveStraightBack() {
		return super.getBButton();

	}
	public void periodic() {
		this.Faster();
		this.Slower();
		
	}
	public void Faster() {
		if(super.getYButtonPressed() == true) if(getSpeed() >1)setSpeed(getSpeed() - 1);

	}
	public void Slower() {
		if(super.getAButtonPressed() == true) if(getSpeed()<RobotMap.SPEED_SETTINGS.length-1) setSpeed(getSpeed() + 1);
	}
	public double Thrower() {			//Down -- Left
		double y = super.getTriggerAxis(Hand.kLeft);
		if (Math.abs(y) < deadzone){
			y=0;
		}
		else{
			y =y*Math.pow(Math.abs(y),reduct)*RobotMap.SPEED_SETTINGS[getSpeed()];  //This just makes speed increase by joystick quadratic rather than linear I think.
		}
		return y;
	}
	public double Reset() {				//Up -- Right
		double y = super.getTriggerAxis(Hand.kRight);
		if (Math.abs(y) < deadzone){
			y=0;
		}
		else{
			y =y*Math.pow(Math.abs(y),reduct)*RobotMap.SPEED_SETTINGS[getSpeed()];  //This just makes speed increase by joystick quadratic rather than linear I think.
		}
		return y;

	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		KController.speed = speed;
	}
}
