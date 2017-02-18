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
	Solenoid greenLight;
	public SolenoidSubsystem(){
		greenLight = new Solenoid(RobotMap.solenoid);
	}
	public void turnOn(){
		greenLight.set(true);
	}
	public void turnOff(){
		greenLight.set(false);
	}
	public Solenoid getSolenoid(){
		return greenLight;
	}
	public void setSolenoid(boolean solenoid){
		greenLight.set(solenoid);
	}
	public boolean getSolenoidStatus(){
		return greenLight.get();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

