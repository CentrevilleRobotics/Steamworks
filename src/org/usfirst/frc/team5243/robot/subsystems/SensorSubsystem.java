package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class SensorSubsystem extends Subsystem {

	//Declares two ultrasonic variables called ultrasonicFront and ultrasonicBack
	private Ultrasonic ultrasonicFront;
	private Ultrasonic ultrasonicBack;
	private Relay lightFront;
	private Relay lightBack;
	
	//Sets ping channel to 0 and echo channel to 1 for both ultrasonics
	public SensorSubsystem() {
		ultrasonicFront = new Ultrasonic(2, 3);
		ultrasonicBack = new Ultrasonic(0, 1);
		ultrasonicFront.setAutomaticMode(true);
		ultrasonicBack.setAutomaticMode(true);
		lightFront = new Relay(RobotMap.lightFront);
		lightBack = new Relay(RobotMap.lightBack);
	
	}
	
	public Relay getFrontLight(){
		return lightFront;
	}
	
	public Relay getBackLight(){
		return lightBack;
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
		//return getUltraSample(ultrasonicFront,5);
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