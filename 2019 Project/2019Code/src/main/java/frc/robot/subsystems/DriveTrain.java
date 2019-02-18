/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Public Variables
  public Spark leftMotor1 = new Spark(RobotMap.LEFT_MOTOR_PORT_1);
  public Spark leftMotor2 = new Spark(RobotMap.LEFT_MOTOR_PORT_2);
  public Spark rightMotor1 = new Spark(RobotMap.RIGHT_MOTOR_PORT_1);
  public Spark rightMotor2 = new Spark(RobotMap.RIGHT_MOTOR_PORT_2);

  public SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftMotor1, leftMotor2);
  public SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMotor1, rightMotor2);

  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  // Public methods
  public void manualDrive(double leftSpeed, double rightSpeed){
    double speedMultiplier = RobotMap.SPEED_SETTINGS[RobotMap.speedSettingsIndex];
    leftSpeed *= speedMultiplier;
    rightSpeed *= speedMultiplier;

    drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualDrive());
  }
}
