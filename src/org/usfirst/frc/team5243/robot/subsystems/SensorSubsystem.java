package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class SensorSubsystem extends Subsystem {

	//Declares two ultrasonic variables called ultrasonicFront and ultrasonicBack
	private Ultrasonic ultrasonicFront;
	private Ultrasonic ultrasonicBack;
	
	//Sets ping channel to 0 and echo channel to 1 for both ultrasonics
	public SensorSubsystem() {
		ultrasonicFront = new Ultrasonic(0, 1);
		ultrasonicBack = new Ultrasonic(0, 1);
	}

	//Initializes ultrasonics by setting automatic mode 
	//Automatic mode allows all sensors to go one at a time
	public void robotInit() {
		ultrasonicFront.setAutomaticMode(true);
		ultrasonicBack.setAutomaticMode(true);
	}

	//Returns the range in inches from the front ultrasonic sensors
	public double getUltrasonicFrontValue() {
		return ultrasonicFront.getRangeInches();
	}

	//Returns the range in inches from the back ultrasonic sensors
	public double getUltrasonicBackValue() {
		return ultrasonicBack.getRangeInches();
	}

	public void initDefaultCommand() {

	}
}