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
		ultrasonicBack = new Ultrasonic(2, 3);
		ultrasonicFront.setAutomaticMode(true);
		ultrasonicBack.setAutomaticMode(true);
	
	}
	
	//returns front ultrasonic sensor
	public Ultrasonic getFrontUltra(){
		return ultrasonicFront;
	}
	
	//returns back ultrasonic sensor
	public Ultrasonic getBackUltra(){
		return ultrasonicBack;
	}
	
	//returns average distance over a certain time
	public double getUltraSample(Ultrasonic ultra, int sampleCount){
		double total = 0;
		for(int i=0;i<sampleCount;i++){
			total += ultra.getRangeInches();
		}
		return total/sampleCount;
	}
	//Initializes ultrasonics by setting automatic mode 
	//Automatic mode allows all sensors to go one at a time
	public void robotInit() {
		ultrasonicFront.setAutomaticMode(true);
		ultrasonicBack.setAutomaticMode(true);
	}

	//Returns the range in inches from the front ultrasonic sensors
	public double getUltrasonicFrontValue() {
		//return getUltraSample(ultrasonicFront,10);
		return ultrasonicFront.getRangeInches();
	}

	//Returns the range in inches from the back ultrasonic sensors
	public double getUltrasonicBackValue() {
		//return getUltraSample(ultrasonicBack,5);
		return ultrasonicBack.getRangeInches();
	}

	public void initDefaultCommand() {

	}
}