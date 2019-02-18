/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;

/**
 * An example command.  You can replace me with your own command.
 */
public class PneumaticControl extends Command {
  public PneumaticControl() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.pneumatics);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.oi.controller.getBButtonPressed()){
      Robot.pneumatics.out(1);
    }else if(Robot.oi.controller.getBButtonReleased()){
      Robot.pneumatics.in(1);
    }

    if(Robot.oi.controller.getYButtonPressed()){
      Robot.pneumatics.out(2);
    }else if(Robot.oi.controller.getYButtonReleased()){
      Robot.pneumatics.in(2);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
