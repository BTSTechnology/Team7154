/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;

/**
 * An example command.  You can replace me with your own command.
 */
public class ManualDrive extends Command {
  public ManualDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }

  public void increaseSpeed(){
    if(RobotMap.speedSettingsIndex != RobotMap.SPEED_SETTINGS.length-1){
      RobotMap.speedSettingsIndex++;
    }
  }

  public void decreaseSpeed(){
    if(RobotMap.speedSettingsIndex != 0){
      RobotMap.speedSettingsIndex--;
    }
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.oi.controller.getBumperPressed(Hand.kRight)){
      increaseSpeed();
    }else if(Robot.oi.controller.getBumperPressed(Hand.kLeft)){
      decreaseSpeed();
    }

    double left = -Robot.oi.controller.getY(Hand.kLeft);
    if(Math.abs(left) < OI.DEADZONE_VALUE){
      left = 0;
    }
    double right = -Robot.oi.controller.getX(Hand.kRight);
    if(Math.abs(right) < OI.DEADZONE_VALUE){
      right = 0;
    }

    Robot.driveTrain.manualDrive(left, right);
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
