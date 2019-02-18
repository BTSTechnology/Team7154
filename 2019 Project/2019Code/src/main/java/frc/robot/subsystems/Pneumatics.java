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
public class Pneumatics extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Public Variables
  public DoubleSolenoid solenoid_1 = new DoubleSolenoid(RobotMap.SOLENOID_PORT_1);
  public DoubleSolenoid solenoid_2 = new DubleSolenoid(RobotMap.SOLENOID_PORT_2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new PneumaticControl());
  }

  public void out(int n) {
    if(n == 1){
      solenoid_1.set(Solenoid.Value.kForward);
    }else{
      solenoid_2.set(Solenoid.Value.kForward);
    }
  }

  public void in(int n) {
    if(n == 1){
      solenoid_1.set(Solenoid.Value.kReverse);
    }else{
      solenoid_2.set(Solenoid.Value.kReverse);
    }
 }
}
