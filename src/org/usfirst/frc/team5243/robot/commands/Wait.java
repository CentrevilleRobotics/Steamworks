package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

//import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	
	private double seconds;
	private double starttime;
    public Wait(double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.seconds = seconds;
    	requires(Robot.driveSubsystem);
    	requires(Robot.gearSubsystem);
    	requires(Robot.loadingSubsystem);
    	requires(Robot.sensorSubsystem);
    	requires(Robot.visionSubsystem);
    }

    // Called just before this Command runs the first time
    
    protected void initialize() {
    	setTimeout(seconds);
    	starttime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    
    //waits for number of seconds specified
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    //stops when wait has been completed
    protected boolean isFinished() {
    	return Math.abs(starttime - System.currentTimeMillis())>(1000*seconds);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
