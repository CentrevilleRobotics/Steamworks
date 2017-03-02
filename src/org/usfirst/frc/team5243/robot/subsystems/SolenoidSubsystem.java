package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidSubsystem extends Subsystem {

    //declaration of light solenoid
	Solenoid greenLight;
	
	//constructor
	public SolenoidSubsystem(){
		greenLight = new Solenoid(RobotMap.solenoid);
	}
	
	//turns on green light
	public void turnOn(){
		greenLight.set(true);
	}
	

	//turns off green light
	public void turnOff(){
		greenLight.set(false);
	}
	
	//returns greenLight
	public Solenoid getSolenoid(){
		return greenLight;
	}
	
	//sets solenoid to on or off
	public void setSolenoid(boolean on){
		greenLight.set(on);
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

