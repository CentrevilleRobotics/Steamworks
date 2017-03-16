package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.ClimbCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbingSubsystem extends Subsystem {
    

	//declaration of motors
	//LIFT MOTOR IS THE SAME AS CLIMB MOTOR
	//private CANTalon loadMotor;
	private CANTalon climbMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//constructor and inversion of necessary motors
	public ClimbingSubsystem(){
		//loadMotor = new CANTalon(RobotMap.loadMotor);
		climbMotor = new CANTalon(RobotMap.liftMotor);
		//loadMotor.setInverted(true);
		climbMotor.setInverted(true);
	}
	
	//sets speed of intake and conveyor belt motors
	/*public void setLoadMotors(double speed){
		loadMotor.set(speed);
		liftMotor.set(speed);
	}*/
	
	//sets speed of intake motor
	public void setLoadMotor(double speed) {
		//loadMotor.set(speed);
	}
	
	//sets speed of conveyor belt motor
	public void setClimbMotor(double speed) {
		climbMotor.set(speed);
	}
	
	//returns speed of conveyor belt motor
	public double getClimbSpeed() {
		return climbMotor.getSpeed();
	}
	
    //returns speed of intake motor
    /*public double getLoadSpeed() {
    	return loadMotor.getSpeed();
    }*/
    
	//Method that would always run if not empty
    public void initDefaultCommand() {

    }
   
}

