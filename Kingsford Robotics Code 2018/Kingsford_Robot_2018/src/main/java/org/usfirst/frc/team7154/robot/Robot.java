/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7154.robot;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team7154.robotCommands.Auton;
import org.usfirst.frc.team7154.robotCommands.SpinCauseBored;
import org.usfirst.frc.team7154.robotSubsystems.Drivetrain;
import org.usfirst.frc.team7154.robotSubsystems.KController;
import org.usfirst.frc.team7154.robotSubsystems.KCubeIntake;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	KController cont;
	KCubeIntake kC;
	Drivetrain dt;	
	Auton auto;	
	SpinCauseBored spinThisThing;

	@Override
	public void robotInit() {
		try {
			dt = Drivetrain.getInstance();					//The First Thing that you notice will be the
			auto = Auton.getInstance();						//getInstances. They return a new object with all
			spinThisThing = SpinCauseBored.getInstance();	//necessary bits initialized to the ports as set
			cont = KController.getInstance();				//in RobotMap
			kC = KCubeIntake.getInstance();
		}catch(java.lang.NullPointerException e) {
			System.err.println(e);
		}
		
	}


	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit (){
		try {        
			Auton.doAutonomous();							//Auton is done within a command.
		}catch(java.lang.NullPointerException e){			//It is currently a placeholder mostly
			System.err.println("Failed to run autonomous");
		}

	}		
	
	@Override
	public void autonomousPeriodic() {
		
	}
	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		dt.periodic();				//Runs the drivetrain code.
		kC.periodic();				//Runs the cubeIntake code.
//		System.out.println(dt.encode());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testInit () {
		try {
			dt.testLeft();						//Makes sure that the left motor works
			dt.testRight();						//Makes sure that the right motor works
			TimeUnit.SECONDS.sleep(1);
			dt.setBoth(0);
		}catch(java.lang.NullPointerException | InterruptedException e) {
			System.err.println("Null pointer!");
		}
		System.out.println(dt.encode());		//Prints out encoder numbers for calebration.
	}
	@Override
	public void testPeriodic() {
	

	}
}