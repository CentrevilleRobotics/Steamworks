package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class GearSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//initializing variables
	DoubleSolenoid gearDoor;
	Solenoid light;
	Compressor airCompressor;
	
	//constructor
	public GearSubsystem(){
		gearDoor = new DoubleSolenoid(RobotMap.solenoidPort1, RobotMap.solenoidPort2);
		light = new Solenoid(RobotMap.light);
		airCompressor = new Compressor(RobotMap.compressor);
		
		//gearDoor.set(Value.kReverse);
		//light.set(false);
	}
	
	public void extendPiston(){
		gearDoor.set(Value.kReverse);
		RobotMap.gearDoorExtended=true;
		light.set(true);
	}
	
	public void retractPiston() {
		gearDoor.set(Value.kForward);
		RobotMap.gearDoorExtended=false;
		light.set(false);
	}
	
	//sets angle of gear door actuator which behaves in code like a servo
	public void toggleDoor(){
			if(gearDoor.get().equals(Value.kForward)){
				gearDoor.set(Value.kReverse);
				light.set(false);
			}
			else {
				gearDoor.set(Value.kForward);
				light.set(true);
			}
	}
	public void enableCompressor(){
		airCompressor.start();
	}
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public Value getSolenoidStatus() {
		// TODO Auto-generated method stub
		return gearDoor.get();
	}	
    
}