package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StrafeCommand extends Command {
	DriveSubsystem driveSubsystem;
	double distance;
	boolean isRight;
    public StrafeCommand(boolean isRight, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.distance = distance;
    	this.isRight = isRight;
    	
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isRight) {
    		driveSubsystem.strafeRight(.75);
    	}
    	else {
    		driveSubsystem.strafeLeft(.75);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.sensorSubsystem.getFrontUltra().getRangeInches() - distance) < 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.setAllMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
