package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class GearSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//initializing variables
	Solenoid gearDoor;
	Compressor airCompressor;
	
	//constructor
	public GearSubsystem(){
		gearDoor = new Solenoid(RobotMap.gearSolenoid);
		airCompressor = new Compressor(RobotMap.compressor);
	}
	
	//sets angle of gear door actuator which behaves in code like a servo
	public void toggleDoor(){
		gearDoor.set(!gearDoor.get());
	}
	public void enableCompressor(){
		airCompressor.start();
	}
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public boolean getSolenoidStatus() {
		// TODO Auto-generated method stub
		return gearDoor.get();
	}	
    
}