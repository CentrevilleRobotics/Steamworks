package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	
	private long seconds;
	private boolean finished;
	
    public Wait(long seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.seconds = seconds;
    	requires(Robot.driveSubsystem);
    	requires(Robot.gearSubsystem);
    	requires(Robot.leftShootingSubsystem);
    	requires(Robot.loadingSubsystem);
    	requires(Robot.rightShootingSubsystem);
    	requires(Robot.sensorSubsystem);
    	requires(Robot.solenoidSubsystem);
    	requires(Robot.visionSubsystem);
    }

    // Called just before this Command runs the first time
    //multiplies seconds by 1000
    protected void initialize() {
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    //dave would kill me if he saw this but he won't so it's all good
    //waits for number of seconds specified
    protected void execute() {
    	Timer.delay(seconds);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    //stops when wait has been completed
    protected boolean isFinished() {
    	return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
