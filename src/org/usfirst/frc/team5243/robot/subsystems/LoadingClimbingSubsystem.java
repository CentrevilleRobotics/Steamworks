package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoadingClimbingSubsystem extends Subsystem {
    
	//Declares two CANTalon motors called loadMotor and liftMotor
	private CANTalon loadMotor;
	private CANTalon liftMotor;
	
	//Constructor that initializes the two motors and makes them spin inwards
	public LoadingClimbingSubsystem(){
		loadMotor = new CANTalon(RobotMap.loadMotor);
		liftMotor = new CANTalon(RobotMap.liftMotor);
		loadMotor.setInverted(true);
		liftMotor.setInverted(true);
	}
	
	//Method that sets the two motors to a specific speed
	public void setLoadMotors(double speed){
		loadMotor.set(speed);
		liftMotor.set(speed);
	}
	
	//Method that sets the loadMotor to a specific speed
	public void setLoadMotor(double speed) {
		loadMotor.set(speed);
	}
	
	//Method that sets the liftMotor to a specific speed
	public void setLiftMotor(double speed) {
		liftMotor.set(speed);
	}
	
	//Method that returns the speed of the liftMotor
	public double getLiftSpeed() {
		return liftMotor.getSpeed();
	}
	
    //Method that returns the speed of the loadMotor
    public double getLoadSpeed() {
    	return loadMotor.getSpeed();
    }
    
	//Method that would always run if not empty
    public void initDefaultCommand() {
    }
   
}

