/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7154.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// PWM
	public static final int  RIGHT_MOTOR_PORT1 = 0;
    public static final int RIGHT_MOTOR_PORT2 = 1;
    public static final int LEFT_MOTOR_PORT1 = 2;
    public static final int LEFT_MOTOR_PORT2 = 3;
    
    /*
     * 
    public static final int KGYRO_PORT = 1;
    public static final int KCONTROLLER_PORT = 0;
    public static final int LEFT_CLAW = 4;
    public static final int RIGHT_CLAW = 5;
    public static final int KTHROWSPARK = 6;
    
    public static final double[] SPEED_SETTINGS = {1,.75,.5,.25,.125};
    
    */
    
    // DIO
    
    // USB
	public static final int CONTROLLER_PORT = 0;
	
	//CONSTANTS
	public static final double SPEED_SCALER = 0.5;
}
