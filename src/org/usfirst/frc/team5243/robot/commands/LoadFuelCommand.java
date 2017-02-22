package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.LoadingClimbingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadFuelCommand extends Command {
	private LoadingClimbingSubsystem loadingClimbingSubsystem;
    double starttime;
	public LoadFuelCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	loadingClimbingSubsystem = Robot.loadingSubsystem;
    	requires(loadingClimbingSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	starttime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		loadingClimbingSubsystem.setLoadMotor(.5);
    		loadingClimbingSubsystem.setLiftMotor(-.5*Robot.oi.getLeftStick().getRawAxis(3)+.25);
    }
    private double elapsedTime(){
    	return Math.abs(starttime - System.currentTimeMillis());
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elapsedTime() > 10000;
    }

    // Called once after isFinished returns true
    protected void end() {
    	loadingClimbingSubsystem.setLoadMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
