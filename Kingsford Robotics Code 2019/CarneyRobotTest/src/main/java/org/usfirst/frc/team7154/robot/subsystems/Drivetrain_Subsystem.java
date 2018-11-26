package org.usfirst.frc.team7154.robot.subsystems;

import org.usfirst.frc.team7154.robot.RobotMap;
import org.usfirst.frc.team7154.robot.commands.ManualDrive_Command;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain_Subsystem extends Subsystem {

    // instantiate new motor controller objects
	public Spark leftMotor1 = new Spark(RobotMap.LEFT_MOTOR_PORT1);
	public Spark leftMotor2 = new Spark(RobotMap.LEFT_MOTOR_PORT2);
	public Spark rightMotor1 = new Spark(RobotMap.RIGHT_MOTOR_PORT1);
	public Spark rightMotor2 = new Spark(RobotMap.RIGHT_MOTOR_PORT2);
	
	//instantiate new SpeedControllerGroup objects for left and right side
	public SpeedControllerGroup leftSpeedControllerGroup = new SpeedControllerGroup(leftMotor1, leftMotor2);
	public SpeedControllerGroup rightSpeedControllerGroup = new SpeedControllerGroup(rightMotor1, rightMotor2);

	// instantiate a new DifferentialDrive object
	public DifferentialDrive drive = new DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup);
	
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	public void manualDriveTank(double leftSpeed, double rightSpeed) {
		drive.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void manualDriveArcade(double speed, double rotation) {
		
		speed *= RobotMap.SPEED_SCALER;
		rotation *= RobotMap.SPEED_SCALER;
		
		drive.arcadeDrive(speed, rotation);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualDrive_Command());
    	
    	
    }
}

