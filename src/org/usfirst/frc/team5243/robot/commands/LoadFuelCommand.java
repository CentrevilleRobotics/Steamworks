package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.subsystems.LoadingClimbingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadFuelCommand extends Command {
	//declaration of variables/required subsystems
	private LoadingClimbingSubsystem loadingClimbingSubsystem;
    
	public LoadFuelCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	loadingClimbingSubsystem = Robot.loadingSubsystem;
    	requires(loadingClimbingSubsystem);
    }

    // Called just before this Command runs the first time
	protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
   	//sets load and lift motors powered on
	protected void execute() {
		if (RobotMap.Loading) {
			loadingClimbingSubsystem.setLoadMotor(.5);
	    	loadingClimbingSubsystem.setLiftMotor(.6);
		}
		else {
			loadingClimbingSubsystem.setLoadMotor(0.0);
			loadingClimbingSubsystem.setLiftMotor(0.0);
		}
	}
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    //turns off motors
    protected void end() {
    	loadingClimbingSubsystem.setLoadMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    //turns off motors
    protected void interrupted() {
    	loadingClimbingSubsystem.setLoadMotors(0);
    }
}
