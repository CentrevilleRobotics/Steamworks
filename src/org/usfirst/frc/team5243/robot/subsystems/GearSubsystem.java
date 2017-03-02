package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class GearSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//initializing variables
	Servo gearDoor;
	public boolean open = false;
	
	//constructor
	public GearSubsystem(){
		gearDoor = new Servo(RobotMap.gearDoorServo);
	}
	
	//sets angle of gear door actuator which behaves in code like a servo
	public void setAngle(double angle){
		gearDoor.setAngle(angle);
	}
	
	//returns angle of gear door actuator
	public double getAngle() {
		return gearDoor.getAngle();
	}
	
	//fully extends gear door actuator
	public void openDoor(){
		gearDoor.setAngle(180);
	}
	
	//fully retracts gear door actuator
	public void closeDoor(){
		gearDoor.setAngle(45);
	}
	
    public void initDefaultCommand() {
    }
    
    //returns gear actuator
    public Servo getServo() {
    	return this.gearDoor;
    }
    
    //Method that opens the door if closed and closes the door if opened
    public void toggleDoor() {
    	open = !open;
    	if(open){
    		openDoor();
    	}else{
    		closeDoor();
    	}
    }
}