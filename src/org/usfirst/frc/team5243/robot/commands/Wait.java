package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	
	private double seconds;
	private double startTime;

    public Wait(double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.seconds = seconds * 1000;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(startTime - System.currentTimeMillis()) > seconds;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
