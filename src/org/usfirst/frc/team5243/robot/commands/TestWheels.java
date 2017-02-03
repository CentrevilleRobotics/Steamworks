package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestWheels extends Command {
	private String name;
	private double speed;
	private DriveSubsystem driveSubsystem;
	
    public TestWheels(String s, double motorSpeed) {       	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    	name = s;
    	speed = motorSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (name.equals("frontLeft")){
    		driveSubsystem.getFrontLeft().set(speed);
    	}
    	if (name.equals("backLeft")){
    		driveSubsystem.getBackLeft().set(speed);    		
    	}
    	if (name.equals("frontRight")){
    		driveSubsystem.getFrontRight().set(speed);    		
    	}
    	if (name.equals("backRight")){
    		driveSubsystem.getBackRight().set(speed);
    	}
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
    	if (name.equals("frontLeft")){
    		driveSubsystem.getFrontLeft().set(0.0);
    	}
    	if (name.equals("backLeft")){
    		driveSubsystem.getBackLeft().set(0.0);    		
    	}
    	if (name.equals("frontRight")){
    		driveSubsystem.getFrontRight().set(0.0);    		
    	}
    	if (name.equals("backRight")){
    		driveSubsystem.getBackRight().set(0.0);
    	}
    }
}
