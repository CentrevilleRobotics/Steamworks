package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.LoadFuelCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoadingClimbingSubsystem extends Subsystem {
    

	//declaration of motors
	//LIFT MOTOR IS THE SAME AS CLIMB MOTOR
	private CANTalon loadMotor;
	private CANTalon liftMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//constructor and inversion of necessary motors
	public LoadingClimbingSubsystem(){
		loadMotor = new CANTalon(RobotMap.loadMotor);
		liftMotor = new CANTalon(RobotMap.liftMotor);
		loadMotor.setInverted(true);
		liftMotor.setInverted(true);
	}
	
	//sets speed of intake and conveyor belt motors
	public void setLoadMotors(double speed){
		loadMotor.set(speed);
		liftMotor.set(speed);
	}
	
	//sets speed of intake motor
	public void setLoadMotor(double speed) {
		loadMotor.set(speed);
	}
	
	//sets speed of conveyor belt motor
	public void setLiftMotor(double speed) {
		liftMotor.set(speed);
	}
	
	//returns speed of conveyor belt motor
	public double getLiftSpeed() {
		return liftMotor.getSpeed();
	}
	
    //returns speed of intake motor
    public double getLoadSpeed() {
    	return loadMotor.getSpeed();
    }
    
	//Method that would always run if not empty
    public void initDefaultCommand() {
    	setDefaultCommand(new LoadFuelCommand());
    }
   
}

