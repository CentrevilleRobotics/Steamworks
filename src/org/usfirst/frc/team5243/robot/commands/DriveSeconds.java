package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveSeconds extends Command {

	double time;
	
	boolean finished;
	
	DriveSubsystem driveSubsystem;
	
    public DriveSeconds(double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = seconds;
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.setAllMotors(0.5);
    	Timer.delay(time);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.setAllMotors(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
