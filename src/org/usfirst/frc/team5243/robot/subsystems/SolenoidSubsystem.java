package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//declares new Solenoid called greenLight
	Solenoid greenLight;
	
	//constructor for SolenoidSubsystem, initializes greenLight 
	public SolenoidSubsystem(){
		greenLight = new Solenoid(RobotMap.solenoid);
	}
	
	//turns on greenLight by setting it to true
	public void turnOn(){
		greenLight.set(true);
	}
	
	//turns off greenLight by setting it to false
	public void turnOff(){
		greenLight.set(false);
	}
	
	//returns greenLight
	public Solenoid getSolenoid(){
		return greenLight;
	}
	
	//sets greenLight to boolean solenoid
	public void setSolenoid(boolean solenoid){
		greenLight.set(solenoid);
	}
	
	//returns status of greenLight (on or off)
	public boolean getSolenoidStatus(){
		return greenLight.get();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

