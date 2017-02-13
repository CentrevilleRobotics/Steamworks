package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorSubsystem extends Subsystem {
    
	private Ultrasonic ultrasonicFront;
	private Ultrasonic ultrasonicBack;

	public SensorSubsystem(){
		ultrasonicFront = new Ultrasonic(1,1);
		ultrasonicBack = new Ultrasonic(1,1);
	}
	public void robotInit(){
		ultrasonicFront.setAutomaticMode(true);
		ultrasonicBack.setAutomaticMode(true);
	}
	public double ultrasonicSampleFront(){
		return ultrasonicFront.getRangeInches();
	}

	public double ultrasonicSampleBack(){
		return ultrasonicBack.getRangeInches();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}