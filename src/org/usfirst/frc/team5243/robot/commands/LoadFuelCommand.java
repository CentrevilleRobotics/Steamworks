package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.LoadingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadFuelCommand extends Command {
	private LoadingSubsystem loadingSubsystem;
	private ClimbSubsystem climbSubsystem;
    double starttime;
	public LoadFuelCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	loadingSubsystem = Robot.loadingSubsystem;
    	climbSubsystem = Robot.climbSubsystem;
    	requires(loadingSubsystem);
    	requires(climbSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	starttime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(elapsedTime() < 7000){
    		loadingSubsystem.setLoadMotors(1);
//    	}else{
//    		loadingSubsystem.setLiftMotor(1);
//    		loadingSubsystem.setLoadMotor(0);
//    	}
    }
//    private double elapsedTime(){
//    	return Math.abs(starttime - System.currentTimeMillis());
//    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return elapsedTime() > 10000;
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//loadingSubsystem.setLoadMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	loadingSubsystem.setLoadMotors(0);
    }
}
