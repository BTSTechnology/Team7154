package org.usfirst.frc.team7154.robot.commands;

import org.usfirst.frc.team7154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualDrive_Command extends Command {

	public double speed, rotation;
	
    public ManualDrive_Command() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly(every 10 ms) when this Command is scheduled to run
    protected void execute() {
    	speed = -Robot.oi.stick.getY();
    	rotation = Robot.oi.stick.getX();
    	Robot.driveTrain.manualDriveArcade(speed, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
