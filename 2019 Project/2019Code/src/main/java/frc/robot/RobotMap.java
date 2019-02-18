/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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

  public static final int LEFT_MOTOR_PORT_1 = 3;  //Left rear motor
  public static final int LEFT_MOTOR_PORT_2 = 2;  //Left front motor
  public static final int RIGHT_MOTOR_PORT_1 = 1; //Right rear motor
  public static final int RIGHT_MOTOR_PORT_2 = 0; //Right front motor

  public static final int RIGHT_INTAKE_1 = 4;
  public static final int LEFT_INTAKE_1 = 5;
  public static final int EJECT_MOTOR_1 = 6; //Ball catcher

  public static final int DOUBLE_SOLENOID_PORT_1 = 0; //Solenoid for the big piston
  public static final int DOUBLE_SOLENOID_PORT_2 = 1; //Solenoid for the small pistons

  public static final int CONTROLLER_PORT = 0;

  public static final double[] SPEED_SETTINGS = {0.125, 0.25, 0.5, 0.75, 1};
  public static int speedSettingsIndex = SPEED_SETTINGS.length-1;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
