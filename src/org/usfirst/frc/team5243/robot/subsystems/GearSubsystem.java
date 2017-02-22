package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSubsystem extends Subsystem {   
	
	//Declares the actuator in a variable called gearDoor, as well as a boolean
	Servo gearDoor;
	public boolean open = false;
	
	//Constructor that initializes the gearDoor as a new servo from RobotMap
	public GearSubsystem(){
		gearDoor = new Servo(RobotMap.gearDoorServo);
	}
	
	//Method that sets the actuator to a certain angle
	public void setAngle(double angle){
		gearDoor.setAngle(angle);
	}
	
	//Method that gets the actuator's angle
	public double getAngle() {
		return gearDoor.getAngle();
	}
	
	//Method that sets the actuator angle to 180 degrees
	public void openDoor(){
		gearDoor.setAngle(180);
	}
	
	//Method that sets the actuator angle to 45 degrees 
	public void closeDoor(){
		gearDoor.setAngle(45);
	}
	
	//Method that would always run if not empty
    public void initDefaultCommand() {
    }
    
    //Method that returns the gearDoor
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