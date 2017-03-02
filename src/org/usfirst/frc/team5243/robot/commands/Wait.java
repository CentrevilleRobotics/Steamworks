package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	
	private long seconds;

    public Wait(long seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.seconds = seconds;
    }

    // Called just before this Command runs the first time
    //multiplies seconds by 1000
    protected void initialize() {
    	seconds = seconds*1000;
    }

    // Called repeatedly when this Command is scheduled to run
    //dave would kill me if he saw this but he won't so it's all good
    //waits for number of seconds specified
    protected void execute() {
    	try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    //stops when wait has been completed
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
