package org.usfirst.frc.team7154.robotSubsystems;

import org.usfirst.frc.team7154.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class KGyro {
	 private  Gyro gyro = null;
	 private static KGyro kGyro;
	    public static KGyro getInstance() {	//Here to make sure that there is only one of this
	        if (kGyro == null) {
	        	kGyro = new KGyro();
	        }
	            return kGyro;
	        
	    }
	    
	private KGyro() {
		gyro = new AnalogGyro(RobotMap.KGYRO_PORT);
	}
	public double getAngle() {
        return gyro.getAngle();
	}

	 public double getSimplestAngle(){
	        double x = getAngle();
	        while (x>180){
	            x -= 360;
	        }
	        while (x<-180){
	            x += 360;
	        }
	        
	        return x;
	    }

}
