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
	
	Servo gearDoor;
	public boolean open = false;
	public GearSubsystem(){
		gearDoor = new Servo(RobotMap.gearDoorServo);
	}
	public void setAngle(double angle){
		gearDoor.setAngle(angle);
	}
	public void openDoor(){
		gearDoor.setAngle(180);
	}
	public void closeDoor(){
		gearDoor.setAngle(45);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Servo getServo() {
    	return this.gearDoor;
    }
    
    public void toggleDoor() {
    	open = !open;
    	if(open){
    		openDoor();
    	}else{
    		closeDoor();
    	}
    }
}