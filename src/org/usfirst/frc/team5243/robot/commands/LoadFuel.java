package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.LoadingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadFuel extends Command {

	private LoadingSubsystem loadingSubsystem;
	private double speed; 
	
    public LoadFuel(double loadSpeed) {
    	loadingSubsystem = Robot.loadingSubsystem;
    	requires(loadingSubsystem);
    	speed = loadSpeed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	loadingSubsystem.setLoadSpeed(speed*Robot.oi.getRightStick().getZ());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	loadingSubsystem.setLoadSpeed(0.0);
    }
}
