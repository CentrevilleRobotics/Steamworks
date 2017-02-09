package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.LoadingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadFuelCommand extends Command {
	
	//attributes
	private LoadingSubsystem loadingSubsystem;
	private double startTime;
	
	//constructor
    public LoadFuelCommand() {
    	loadingSubsystem = Robot.loadingSubsystem;
    	requires(loadingSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    //Called just before this Command runs the first time
    //initializes startTime
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }
 
    //Called repeatedly when this Command is scheduled to run
    /* 
     * If time between the start time and the current time is less that 8 seconds,
     * the motor speed for the loading motor and the lift motor will stay as 1. 
     * After 8 seconds, the loading motor will be set to 0, but the lift motor 
     * will continue.
     */
    protected void execute() {
    	if (getRunningTime() < 8000) {
    		loadingSubsystem.setLiftMotor(1);
    		loadingSubsystem.setLoadMotor(1);
    	}else{
    		loadingSubsystem.setLoadMotor(0);
    	}
    }
    
    //Make this return true when this Command no longer needs to run execute()
    //returns true if time is greater than 10 seconds
    //returns false if time is less than or equal to 10 seconds
    protected boolean isFinished() {
    	return getRunningTime()>10000;
    }
    
    //Returns the running time 
    public double getRunningTime(){
    	return Math.abs(startTime - System.currentTimeMillis());
    }
    
    //Called once after isFinished returns true
    protected void end() {
    	loadingSubsystem.setLoadMotors(0);
    }

    //Called when another command which requires one or more of the same
    //subsystems is scheduled to run
    protected void interrupted() {
    
    }
}
